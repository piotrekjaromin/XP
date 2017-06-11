package pl.edu.agh.xp.projects;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import pl.edu.agh.xp.MenuController;

import java.util.Collections;
import java.util.List;

/**
 * Created by malgo on 08.06.17.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProjectsControllerTest {

    @Mock
    ProjectRepository projectRepository;

    @Mock ProjectView projectView;

    @Mock
    MenuController menuController;

    ProjectController projectController;

    @Before
    public void setUp() {
        projectController = new ProjectController(projectRepository, projectView);
    }


    @Test
    public void doesInitialize_Test() {
        projectController.initialize(1, menuController);

        Mockito.verify(projectView).setProjectController(projectController);
    }

    @Test
    public void doesDisplay_Test() {
        List<Project> projectList = Collections.emptyList();
        Mockito.when(projectRepository.getProjectsByCompany(1)).thenReturn(projectList);

        projectController.initialize(1, menuController);
        projectController.display();

        Mockito.verify(projectView).displayProject(projectList);
    }

    @Test
    public void doesRouteToMenuController_Test() {
        String projectId = "1";
        projectController.initialize(1, menuController);

        projectController.onProjectSelected(projectId);

        Mockito.verify(menuController).showProjectTimetable(projectId);

        projectController.onBackPressed();

        Mockito.verify(menuController).back();
    }
}
