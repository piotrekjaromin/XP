package pl.edu.agh.xp.files;

import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.util.List;

public interface FileManagerInterface {

    List<CSVRecord> readCsvFile(String filePath, String... headers);
    void writeLine(String line, String fileName) throws IOException;

}
