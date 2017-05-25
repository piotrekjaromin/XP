package pl.edu.agh.xp.files;


import org.apache.commons.csv.CSVRecord;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileManagerTests {

    private FileManagerInterface fileManager;

    @Before
    public void setUp() {
        fileManager = new FileManagerImpl();
    }

    @Test
    public void testReadFile() {
        // given
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("sample-companies.csv").getFile());
        String path = file.getAbsolutePath();

        // when
        List<CSVRecord> csvRecords = fileManager.readCsvFile(path, FilesConfig.COMPANIES_FILE_HEADERS);

        // then
        assertEquals("File should contain 3 lines", 3, csvRecords.size());

        assertEquals("First line should have ID=1", "1", csvRecords.get(0).get(FilesConfig.COMPANIES_FILE_HEADERS[0]));
        assertEquals("First line should have CompanyName='Company no 1'",
                "Company no 1", csvRecords.get(0).get(FilesConfig.COMPANIES_FILE_HEADERS[1]));

        assertEquals("Second line should have ID=2", "2", csvRecords.get(1).get(FilesConfig.COMPANIES_FILE_HEADERS[0]));
        assertEquals("Second line should have CompanyName='Company no 2'",
                "Company no 2", csvRecords.get(1).get(FilesConfig.COMPANIES_FILE_HEADERS[1]));

        assertEquals("Third line should have ID=3", "3", csvRecords.get(2).get(FilesConfig.COMPANIES_FILE_HEADERS[0]));
        assertEquals("Third line should have CompanyName='Company no 3'",
                "Company no 3", csvRecords.get(2).get(FilesConfig.COMPANIES_FILE_HEADERS[1]));
    }

    @Test
    public void testWriteFile() throws IOException {
        // given
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("sample-companies.txt").getFile());
        String path = file.getAbsolutePath();
       new FileManagerImpl().writeLine("4,Company no 4", path);
    }


}
