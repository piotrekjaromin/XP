package pl.edu.agh.xp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.edu.agh.xp.companies.CompaniesController;
import pl.edu.agh.xp.projects.ProjectController;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class ControllersProviderTests {

    @Mock
    private MenuController menuController;

    private ControllersProvider controllersProvider;

    @Before
    public void setUp() {
        this.controllersProvider = new ControllersProvider();
    }

    @Test
    public void shouldCreateCompanyController() {
        Controller companyController = this.controllersProvider.createCompanyController(this.menuController);
        assertTrue(companyController instanceof CompaniesController);
    }

    @Test
    public void shouldCreateProjectController() {
        Controller projectController = this.controllersProvider.createProjectController(1,this.menuController);
        assertTrue(projectController instanceof ProjectController);
    }
}
