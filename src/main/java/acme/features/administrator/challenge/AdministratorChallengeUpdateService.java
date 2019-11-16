
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

		Date currentDate = new Date();
		assert entity.getDeadline().after(currentDate);

		assert entity.getRewardGold().getAmount() >= 0;
		assert entity.getRewardSilver().getAmount() >= 0;
		assert entity.getRewardBronze().getAmount() >= 0;

		assert entity.getRewardGold().getCurrency().equals("EUR") || entity.getRewardGold().getCurrency().equals("€");
		assert entity.getRewardSilver().getCurrency().equals("EUR") || entity.getRewardSilver().getCurrency().equals("€");
		assert entity.getRewardBronze().getCurrency().equals("EUR") || entity.getRewardBronze().getCurrency().equals("€");
	}

	@Override
	public void update(final Request<Challenge> request, final Challenge entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
