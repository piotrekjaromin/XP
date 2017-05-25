package pl.edu.agh.xp.files;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


public class FileManagerImpl implements FileManagerInterface {

    private String[] fileLines;

    @Override
    public List<CSVRecord> readCsvFile(String filePath, String... headers) {
        try (Reader in = new FileReader(filePath)) {
            Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader(headers).parse(in);

            List<CSVRecord> recordsList = new ArrayList<>();
            Iterator<CSVRecord> it = records.iterator();
            if (headers.length > 0) {
                it.next(); // skip headers
            }
            while (it.hasNext()) {
                recordsList.add(it.next());
            }

            return recordsList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void writeLine(String line, String fileName) throws IOException {

        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(fileName, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (bufferedWriter != null) {
                bufferedWriter.close();
            }

            if (fileWriter != null) {
                fileWriter.close();
            }

        }

    }

    @Override
    public void updateLine(int lineNumber, String line) {

    }
}
