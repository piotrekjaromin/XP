package pl.edu.agh.xp.acceptance;

import org.junit.Assert;
import org.junit.Test;
import pl.edu.agh.xp.Controller;
import pl.edu.agh.xp.ControllersProvider;
import pl.edu.agh.xp.MenuController;
import pl.edu.agh.xp.companies.CompaniesController;
import pl.edu.agh.xp.companies.CompaniesRepositoryImpl;
import pl.edu.agh.xp.companies.CompaniesView;
import pl.edu.agh.xp.files.FileManagerImpl;
import pl.edu.agh.xp.projects.ProjectController;
import pl.edu.agh.xp.projects.ProjectRepositoryImpl;
import pl.edu.agh.xp.projects.ProjectView;
import pl.edu.agh.xp.projects.ProjectsControllerTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by SB on 2017-06-12.
 */
public class DisplayAcceptanceTest {

    @Test
    public void doesDisplayCompaniesOnStartup_Test() {
        Scanner scanner = new Scanner("1");
        ByteArrayOutputStream output = setUpCapturingOutput();

        CompaniesController companiesController = new CompaniesController(new CompaniesRepositoryImpl(new FileManagerImpl()), new CompaniesView(scanner));
        companiesController.initialize(null);
        companiesController.display();

        Assert.assertTrue(output.toString().contains("Company | id: 1, name: Company no 1\r\n" +
                "Company | id: 2, name: Company no 2\r\n" +
                "Company | id: 3, name: Company no 3\r\n"));
    }

    @Test
    public void doesShowProperProjectsForCompany_Test() {
        Scanner scanner = new Scanner("1\n1\n");
        ByteArrayOutputStream output = setUpCapturingOutput();

        MenuController menuController = new MenuController(new MockInOutControllerProvider(scanner));
        menuController.showCompaniesView();

        Assert.assertTrue(output.toString().contains("Name: Project One, Id: 1\r\n" +
                "Name: Project Two, Id: 2\r\n"));
    }

    @Test
    public void doesNotAcceptWrongNumbers_Test() {
        Scanner scanner = new Scanner("-1\n1\n");
        ByteArrayOutputStream output = setUpCapturingOutput();

        ProjectController projectController = new ProjectController(new ProjectRepositoryImpl(new FileManagerImpl()), new ProjectView(scanner));
        projectController.initialize(1, null);
        projectController.display();

        Assert.assertTrue(output.toString().contains("Błąd wczytywania"));
    }

    private ByteArrayOutputStream setUpCapturingOutput() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);

        System.setOut(ps);
        return baos;
    }

    class MockInOutControllerProvider extends ControllersProvider {

        private Scanner scanner;

        public MockInOutControllerProvider(Scanner scanner) {
            this.scanner = scanner;
        }

        @Override
        public Controller createCompanyController(MenuController menuController) {
            CompaniesController companiesController = new CompaniesController(new CompaniesRepositoryImpl(new FileManagerImpl()), new CompaniesView(scanner));
            companiesController.initialize(menuController);

            return companiesController;
        }

        @Override
        public Controller createProjectController(Integer companyId, MenuController menuController) {
            ProjectController projectController = new ProjectController(new ProjectRepositoryImpl(new FileManagerImpl()), new ProjectView(scanner));
            projectController.initialize(companyId, menuController);

            return projectController;
        }
    }
}
