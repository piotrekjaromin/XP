package pl.edu.agh.xp;


import pl.edu.agh.xp.companies.CompaniesController;
import pl.edu.agh.xp.companies.CompaniesRepositoryImpl;
import pl.edu.agh.xp.companies.CompaniesView;
import pl.edu.agh.xp.projects.ProjectController;
import pl.edu.agh.xp.projects.ProjectRepositoryImpl;
import pl.edu.agh.xp.projects.ProjectView;

public class Main {

    public static void main(String[] args) {
        MenuManager menuManager = new MenuManager(
                new CompaniesController(new CompaniesRepositoryImpl(), new CompaniesView()),
                new ProjectController(new ProjectRepositoryImpl(), new ProjectView())
        );
        menuManager.start();
    }
}
