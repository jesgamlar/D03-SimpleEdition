
package acme.features.administrator.investorRecordsDashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.form.InvestorsChart;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorInvestorRecordsDashboardChartService implements AbstractShowService<Administrator, InvestorsChart> {

	//Internal state --------------------------------------------------

	@Autowired
	AdministratorInvestorRecordsDashboardRepository repository;


	//AbstractListService<Administrator, InvestorsRecords> interface ------

	@Override
	public boolean authorise(final Request<InvestorsChart> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<InvestorsChart> request, final InvestorsChart formObject, final Model model) {
		assert request != null;
		assert formObject != null;
		assert model != null;

		request.unbind(formObject, model, "sectors", "investorsBySector");
	}

	@Override
	public InvestorsChart findOne(final Request<InvestorsChart> request) {
		assert request != null;

		InvestorsChart result = new InvestorsChart();

		result.setInvestorsBySector(this.repository.groupSectors());
		result.setSectors(this.repository.sectors());

		return result;
	}

}
