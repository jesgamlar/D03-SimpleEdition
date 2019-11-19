package acme.features.administrator.requestEntity;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



import acme.entities.requestEntity.requestEntity;

import acme.framework.components.Errors;

import acme.framework.components.Model;

import acme.framework.components.Request;

import acme.framework.entities.Administrator;

import acme.framework.services.AbstractCreateService;



@Service

public class AdministratorRequestEntityrCreateService implements AbstractCreateService<Administrator, requestEntity> {



	@Autowired

	AdministratorRequestEntityRepository repository;





	@Override

	public boolean authorise(final Request<RequestEntity> request) {

		assert request != null;



		return true;

	}



	@Override

	public void bind(final Request<RequestEntity> request, final RequestEntity entity, final Errors errors) {

		assert request != null;

		assert entity != null;

		assert errors != null;



		request.bind(entity, errors, "incorporated");

	}



	@Override

	public void unbind(final Request<RequestEntity> request, final RequestEntity entity, final Model model) {

		assert request != null;

		assert entity != null;

		assert model != null;



		request.unbind(entity, model, "title", "moment", "deadline", "text", "rewardMin", "rewardMax", "ticker");

	}



	@Override

	public RequestEntity instantiate(final Request<RequestEntity> request) {

		RequestEntity result;



		result = new RequestEntity();



		return result;

	}



	@Override

	public void validate(final Request<Offer> request, final Offer entity, final Errors errors) {

		assert request != null;

		assert entity != null;

		assert errors != null;

	}



	@Override

	public void create(final Request<Offer> request, final Offer entity) {

		this.repository.save(entity);

	}



}