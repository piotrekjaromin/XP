package pl.edu.agh.xp.projects;

import org.apache.commons.csv.CSVRecord;
import pl.edu.agh.xp.files.FileManagerInterface;
import pl.edu.agh.xp.files.FilesConfig;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by SB on 2017-05-04
 */
public class ProjectRepositoryImpl implements ProjectRepository {

    private FileManagerInterface fileManager;

    public ProjectRepositoryImpl(FileManagerInterface fileManager) {
        this.fileManager = fileManager;
    }

    public List<Project> getProjectsByCompany(Integer companyId) {
        String path = getAbsFilepath();
        if (path != null) {
            List<CSVRecord> csvRecords = fileManager.readCsvFile(path, FilesConfig.PROJECTS_FILE_HEADERS);
            return parseCsvToProjects(csvRecords);
        }

        return Collections.emptyList();
    }

    public void updateProject(Project project) {
        // TODO: 2017-05-04
    }

    private List<Project> parseCsvToProjects(List<CSVRecord> csvRecords) {
        List<Project> parsedProjects = new ArrayList<>();
        for (CSVRecord csvRecord : csvRecords) {
            String id = csvRecord.get(0);
            String name = csvRecord.get(1);
            Integer companyId = Integer.valueOf(csvRecord.get(2));

            parsedProjects.add(new Project(id, companyId, name, 0));
        }

        return parsedProjects;
    }

    private String getAbsFilepath() {
        URL fileResourceUrl = getClass().getClassLoader().getResource(FilesConfig.PROJECTS_DB);
        if (fileResourceUrl != null) {
            return new File(fileResourceUrl.getFile()).getAbsolutePath();
        }
        System.out.println("Coulnd not find resource: " + FilesConfig.PROJECTS_DB);
        return null;
    }
}
