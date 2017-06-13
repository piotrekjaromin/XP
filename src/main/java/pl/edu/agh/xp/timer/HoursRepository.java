package pl.edu.agh.xp.timer;

import pl.edu.agh.xp.files.FileManagerInterface;
import pl.edu.agh.xp.files.FilesConfig;

import java.io.IOException;


public class HoursRepository {

    private FileManagerInterface fileManager;

    public HoursRepository(FileManagerInterface fileManager) {
        this.fileManager = fileManager;
    }

    public void updateHours(int projectId, String hoursString) {
        try {
            fileManager.writeLine(projectId + "," + hoursString, FilesConfig.HOURS_DB);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
