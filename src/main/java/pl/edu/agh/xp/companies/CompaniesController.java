package pl.edu.agh.xp.companies;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Pawel on 2017-04-20
 */
public class CompaniesController {

    private CompaniesRepository companyRepository;
    private CompaniesView view;

    public CompaniesController() {
        this.companyRepository = new CompaniesRepositoryImpl();
        this.view = new CompaniesView();
    }

    public CompaniesController(CompaniesRepository companyRepository, CompaniesView view) {
        this.companyRepository = companyRepository;
        this.view = view;
    }

    public void start() {
        List<Company> listOfCompanies = companyRepository.getCompanies();
        view.showCompanies(listOfCompanies);
        int choice = view.chooseCompany();
        view.chosenCompany(getCompanyNameById(choice));

    }

    public String getCompanyNameById(int choice) {
        return companyRepository.getCompanyById(choice).getName();
    }
}
