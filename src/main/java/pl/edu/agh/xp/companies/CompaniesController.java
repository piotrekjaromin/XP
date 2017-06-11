package pl.edu.agh.xp.companies;

import pl.edu.agh.xp.Controller;
import pl.edu.agh.xp.MenuController;

import javax.naming.ldap.Control;
import java.util.List;

/**
 * Created by Pawel on 2017-04-20
 */
public class CompaniesController implements Controller {

    private CompaniesRepository companyRepository;
    private CompaniesView view;

    private MenuController menuController;

    public CompaniesController(CompaniesRepository companyRepository, CompaniesView view) {
        this.companyRepository = companyRepository;
        this.view = view;
    }

    public void initialize(MenuController menuController) {
        this.menuController = menuController;
    }

    @Override
    public void display() {
        List<Company> listOfCompanies = companyRepository.getCompanies();
        view.showCompanies(listOfCompanies);
        int choice = view.chooseCompany();
        view.chosenCompany(String.valueOf(choice));

        if (menuController != null) {
            menuController.showProjectsView(choice);
        }
    }
}
