package pl.edu.agh.xp.fixtures;

import org.apache.commons.csv.CSVRecord;
import pl.edu.agh.xp.files.FileManagerImpl;
import pl.edu.agh.xp.files.FileManagerInterface;
import pl.edu.agh.xp.files.FilesConfig;

import java.util.List;

public class FileManagerFixture {

    private String filePath;
    private String fileType; // COMPANIES OR PROJECTS

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String validateReadFile() {
        FileManagerInterface fileManager = new FileManagerImpl();
        List<CSVRecord> records;
        StringBuilder builder = new StringBuilder();
        if (this.fileType.equals("COMPANIES")) {
            records = fileManager.readCsvFile(this.filePath, FilesConfig.COMPANIES_FILE_HEADERS);
            if(records == null) {
                return "Error";
            }
            records.forEach(record ->
                    builder.append(record.get(FilesConfig.COMPANIES_FILE_HEADERS[0]))
                            .append(",")
                            .append(record.get(FilesConfig.COMPANIES_FILE_HEADERS[1]))
                            .append("&"));
        } else {
            records = fileManager.readCsvFile(this.filePath, FilesConfig.PROJECTS_FILE_HEADERS);
            records.forEach(record ->
                    builder.append(record.get(FilesConfig.PROJECTS_FILE_HEADERS[0]))
                            .append(",")
                            .append(record.get(FilesConfig.PROJECTS_FILE_HEADERS[1]))
                            .append(",")
                            .append(record.get(FilesConfig.PROJECTS_FILE_HEADERS[2]))
                            .append("&"));
        }
        return builder.toString();
    }

}
