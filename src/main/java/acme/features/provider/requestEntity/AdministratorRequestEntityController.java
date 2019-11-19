
package acme.features.administrator.requestEntity;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.requestEntity.RequestEntity;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/request-entity")
public class AuthenticatedRequestEntityController extends AbstractController<Administrator, RequestEntity> {

	//Internal state -------------------------------------------

	@Autowired
	private AdministratorRequestEntityListService	listService;

	@Autowired
	private AdministratorRequestEntityShowService	showService;


	//Constructors ---------------------------------------------

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
