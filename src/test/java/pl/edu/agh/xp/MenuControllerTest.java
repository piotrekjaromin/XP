package pl.edu.agh.xp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by malgo on 08.06.17.
 */

@RunWith(MockitoJUnitRunner.class)
public class MenuControllerTest {

    @Mock ControllersProvider controllersProvider;

    private MenuController menuController;

    @Before
    public void setUp() {
        menuController = new MenuController(controllersProvider);
    }

    @Test
    public void doesAddToStack_Test() {
        Controller companiesController = Mockito.mock(Controller.class);
        Mockito.when(controllersProvider.createCompanyController(menuController)).thenReturn(companiesController);

        menuController.showCompaniesView();

        Mockito.verify(companiesController).display();
    }

    @Test
    public void doesShowProjectView_Test() {
        Controller companiesController = Mockito.mock(Controller.class);
        Mockito.when(controllersProvider.createProjectController(1, menuController)).thenReturn(companiesController);

        menuController.showProjectsView(1);

        Mockito.verify(companiesController).display();
    }

    @Test
    public void doesShowProjectTimetable_Test() {
        menuController.showProjectTimetable("1");

        Assert.assertTrue(true);
    }

    @Test
    public void doesNotBackIfNotPossible_Test() {
        Controller companiesController = Mockito.mock(Controller.class);
        Mockito.when(controllersProvider.createProjectController(1, menuController)).thenReturn(companiesController);

        menuController.showProjectsView(1);
        menuController.back();

        Mockito.verify(companiesController, Mockito.times(1)).display();
    }

    @Test
    public void doesBackProperly_Test() {
        Controller companiesController = Mockito.mock(Controller.class);
        Controller projectsController = Mockito.mock(Controller.class);

        Mockito.when(controllersProvider.createProjectController(1, menuController)).thenReturn(projectsController);
        Mockito.when(controllersProvider.createCompanyController(menuController)).thenReturn(companiesController);

        menuController.showCompaniesView();
        menuController.showProjectsView(1);

        menuController.back();

        Mockito.verify(projectsController, Mockito.times(1)).display();
        Mockito.verify(companiesController, Mockito.times(2)).display();
    }
}
