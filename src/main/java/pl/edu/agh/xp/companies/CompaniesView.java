package pl.edu.agh.xp.companies;

import java.util.List;

/**
 * Created by Pawel on 2017-04-20
 */
public class CompaniesView {

    public CompaniesView() {
    }

    public void showCompanies(List<Company> companies) {
        companies.stream().forEach(company -> System.out.println("Company | id: " + company.getId() + ", name: " + company.getName()));
    }
}
