package pl.edu.agh.xp.files;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


public class FileManagerImpl implements FileManagerInterface {

    private String[] fileLines;

    @Override
    public List<CSVRecord> readCsvFile(String filePath, String... headers) {
        Iterable<CSVRecord> records = null;
        try {
            Reader in = new FileReader(filePath);
            records = CSVFormat.EXCEL.withHeader(headers).parse(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<CSVRecord> recordsList = new ArrayList<>();
        if (records != null) {
            Iterator<CSVRecord> it = records.iterator();
            if (headers.length > 0) {
                it.next(); // skip headers
            }
            while (it.hasNext()) {
                recordsList.add(it.next());
            }
        }
        return recordsList;
    }


    @Override
    public void writeLine(String line) {

    }

    @Override
    public void updateLine(int lineNumber, String line) {

    }
}
