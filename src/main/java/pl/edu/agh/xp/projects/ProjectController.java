package pl.edu.agh.xp.projects;

/**
 * Created by SB on 2017-05-04
 */
public class ProjectController {

    private ProjectRepository projectRepository;
    private ProjectView projectView;

    public ProjectController(ProjectRepository projectRepository, ProjectView projectView) {
        this.projectRepository = projectRepository;
        this.projectView = projectView;
    }

    public void loadData(String companyId) {
        projectView.displayProject(projectRepository.getProjectsByCompany(companyId));

        String selectedId = projectView.getUserSelection();
    }
}
