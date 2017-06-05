package pl.edu.agh.xp;

import pl.edu.agh.xp.companies.CompaniesController;
import pl.edu.agh.xp.companies.CompaniesRepositoryImpl;
import pl.edu.agh.xp.companies.CompaniesView;
import pl.edu.agh.xp.files.FileManagerImpl;
import pl.edu.agh.xp.projects.ProjectController;
import pl.edu.agh.xp.projects.ProjectRepositoryImpl;
import pl.edu.agh.xp.projects.ProjectView;

/**
 * Created by SB on 2017-05-25.
 */
public class ControllersProvider {

    public Controller createCompanyController(MenuController menuController) {
        CompaniesController companiesController = new CompaniesController(new CompaniesRepositoryImpl(new FileManagerImpl()), new CompaniesView());
        companiesController.initialize(menuController);

        return companiesController;
    }

    public Controller createProjectController(Integer companyId, MenuController menuController) {
        ProjectController projectController = new ProjectController(new ProjectRepositoryImpl(new FileManagerImpl()), new ProjectView());
        projectController.initialize(companyId, menuController);

        return projectController;
    }

    public Controller createTimetableController(String projectId, MenuController menuController) {
        return null;
    }
}
