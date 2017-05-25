package pl.edu.agh.xp.projects;

import pl.edu.agh.xp.MenuManager;

/**
 * Created by SB on 2017-05-04
 */
public class ProjectController {

    private ProjectRepository projectRepository;
    private ProjectView projectView;

    private MenuManager menuManager;

    public ProjectController(ProjectRepository projectRepository, ProjectView projectView) {
        this.projectRepository = projectRepository;
        this.projectView = projectView;
    }

    public void setMenuManager(MenuManager menuManager) {
        this.menuManager = menuManager;
    }

    public void loadData(String companyId) {
        projectView.displayProject(projectRepository.getProjectsByCompany(companyId));

        String selectedId = projectView.getUserSelection();
        if (menuManager != null) {
            menuManager.onProjectChosen(selectedId);
        }
    }
}
