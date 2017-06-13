package pl.edu.agh.xp.timer;

import pl.edu.agh.xp.files.FileManagerInterface;
import pl.edu.agh.xp.files.FilesConfig;

import java.io.IOException;


public class HoursRepository {

    private FileManagerInterface fileManager;
    private String sampleFilePath = "/Users/beata/Documents/IntelliJ-workspace/timemanager/src/main/resources/";

    public HoursRepository(FileManagerInterface fileManager) {
        this.fileManager = fileManager;
    }

    public void updateHours(int projectId, String hoursString) {
        try {
            fileManager.writeLine(projectId + "," + hoursString, sampleFilePath+FilesConfig.HOURS_DB);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
