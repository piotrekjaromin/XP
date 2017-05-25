package pl.edu.agh.xp.companies;

import pl.edu.agh.xp.MenuManager;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Pawel on 2017-04-20
 */
public class CompaniesController {

    private CompaniesRepository companyRepository;
    private CompaniesView view;

    private MenuManager menuManager;

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

        if (menuManager != null) {
            menuManager.onCompanyChosen(choice);
        }
    }

    public String getCompanyNameById(int choice) {
        return companyRepository.getCompanyById(choice).getName();
    }

    public void setMenuManager(MenuManager menuManager) {
        this.menuManager = menuManager;
    }
}
