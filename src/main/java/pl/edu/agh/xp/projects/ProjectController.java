package pl.edu.agh.xp.projects;

import pl.edu.agh.xp.Controller;
import pl.edu.agh.xp.MenuController;

/**
 * Created by SB on 2017-05-04
 */
public class ProjectController implements Controller {

    private ProjectRepository projectRepository;
    private ProjectView projectView;

    private MenuController menuController;
    private Integer companyId;

    public ProjectController(ProjectRepository projectRepository, ProjectView projectView) {
        this.projectRepository = projectRepository;
        this.projectView = projectView;
    }

    public void initialize(Integer companyId, MenuController menuController) {
        this.menuController = menuController;
        this.companyId = companyId;

        this.projectView.setProjectController(this);
    }

    @Override
    public void display() {
        projectView.displayProject(projectRepository.getProjectsByCompany(companyId));
    }

    public void onProjectSelected(String projectId) {
        menuController.showProjectTimetable(projectId);
    }

    public void onBackPressed() {
        menuController.back();
    }
}
