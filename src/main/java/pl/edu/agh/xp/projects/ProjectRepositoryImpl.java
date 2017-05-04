package pl.edu.agh.xp.projects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by SB on 2017-05-04.
 */
public class ProjectRepositoryImpl implements ProjectRepository {

    public List<Project> getProjectsByCompany(String companyId) {
        return Arrays.asList(
                new Project("123", "1", "Truskawka", 10),
                new Project("333", "2", "Malina", 12),
                new Project("234", "2", "Koktajl", 7)
        );
    }

    public void updateProject(Project project) {
        // TODO: 2017-05-04
    }
}
