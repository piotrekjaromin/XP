package pl.edu.agh.xp;

import pl.edu.agh.xp.companies.CompaniesController;
import pl.edu.agh.xp.projects.ProjectController;

/**
 * Created by SB on 2017-05-25.
 */
public class MenuManager {

    private CompaniesController companiesController;
    private ProjectController projectController;

    public MenuManager(CompaniesController companiesController, ProjectController projectController) {
        this.companiesController = companiesController;
        this.projectController = projectController;
    }

    public void start() {
        companiesController.start();
    }

    public void onCompanyChosen(String companyId) {
        projectController.setMenuManager(this);
        projectController.loadData(companyId);
    }

    public void onProjectChosen(String projectId) {
        System.out.println("Wybrano projekt: " + projectId);
    }
}
