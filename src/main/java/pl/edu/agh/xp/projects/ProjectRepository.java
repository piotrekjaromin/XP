package pl.edu.agh.xp.projects;

import java.util.List;

/**
 * Created by SB on 2017-05-04.
 */
public interface ProjectRepository {

    List<Project> getProjectsByCompany(Integer companyId);
    void updateProject(Project project);
}
