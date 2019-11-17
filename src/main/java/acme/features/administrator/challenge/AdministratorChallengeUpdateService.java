
package acme.features.administrator.challenge;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.challenges.Challenge;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorChallengeUpdateService implements AbstractUpdateService<Administrator, Challenge> {

	//Internal state --------------------------------------------------

	@Autowired
	AdministratorChallengeRepository repository;


	//AbstractListService<Authenticated, Announcement> interface ------

	@Override
	public boolean authorise(final Request<Challenge> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Challenge> request, final Challenge entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "description", "goalGold", "goalSilver", "goalBronze", "rewardGold", "rewardSilver", "rewardBronze");
	}

	@Override
	public Challenge findOne(final Request<Challenge> request) {
		assert request != null;

		Challenge result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;

	}

	@Override
	public void validate(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (!errors.hasErrors("deadline")) {
			Date currentDate = new Date(System.currentTimeMillis());
			errors.state(request, entity.getDeadline().after(currentDate), "deadline", "administrator.challenge.form.error.deadline");
		}

		if (!errors.hasErrors("goldEUR")) {
			errors.state(request, entity.getRewardGold().getCurrency().equals("EUR") || entity.getRewardGold().getCurrency().equals("€"), "goldEUR", "administrator.challenge.form.error.goldEUR");
		}

		if (!errors.hasErrors("silverEUR")) {
			errors.state(request, entity.getRewardSilver().getCurrency().equals("EUR") || entity.getRewardSilver().getCurrency().equals("€"), "silverEUR", "administrator.challenge.form.error.silverEUR");
		}

		if (!errors.hasErrors("bronzeEUR")) {
			errors.state(request, entity.getRewardBronze().getCurrency().equals("EUR") || entity.getRewardBronze().getCurrency().equals("€"), "bronzeEUR", "administrator.challenge.form.error.bronzeEUR");
		}
	}

	@Override
	public void update(final Request<Challenge> request, final Challenge entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
