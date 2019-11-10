/*
 * AdministratorUserAccountRepository.java
 *
 * Copyright (c) 2019 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.administrator.investorRecordsDashboard;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorInvestorRecordsDashboardRepository extends AbstractRepository {

	@Query("select  sector from InvestorRecord group by sector order by sector asc")
	Collection<String> sectors();

	@Query("select count(sector) from InvestorRecord group by sector order by sector asc")
	ArrayList<Integer> groupSectors();

}
