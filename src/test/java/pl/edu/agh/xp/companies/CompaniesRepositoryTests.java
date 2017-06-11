package pl.edu.agh.xp.companies;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import pl.edu.agh.xp.files.FileManagerImpl;
import pl.edu.agh.xp.files.FilesConfig;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;

@RunWith(MockitoJUnitRunner.class)
public class CompaniesRepositoryTests {

    @Mock
    private FileManagerImpl fileManager;

    private CompaniesRepository companiesRepository;

    @Before
    public void setUp() {
        this.companiesRepository = new CompaniesRepositoryImpl(fileManager);
    }

    @Test
    public void testGetCompanies() {
        // given
        List<CSVRecord> records = getSampleCompaniesRecords();
        Mockito.when(fileManager.readCsvFile(anyString(),
                eq(FilesConfig.COMPANIES_FILE_HEADERS[0]),
                eq(FilesConfig.COMPANIES_FILE_HEADERS[1]))).thenReturn(records);

        // when
        List<Company> companies = companiesRepository.getCompanies();

        // then
        assertEquals(3, companies.size());
        assertEquals(Integer.valueOf(1), companies.get(0).getId());
        assertEquals("Company no 1", companies.get(0).getName());
        assertEquals(Integer.valueOf(2), companies.get(1).getId());
        assertEquals("Company no 2", companies.get(1).getName());
        assertEquals(Integer.valueOf(3), companies.get(2).getId());
        assertEquals("Company no 3", companies.get(2).getName());
    }

    private List<CSVRecord> getSampleCompaniesRecords() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("sample-companies-to-read.csv").getFile());
        String path = file.getAbsolutePath();
        List<CSVRecord> recordsList = null;
        try (Reader in = new FileReader(path)) {
            Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader(FilesConfig.COMPANIES_FILE_HEADERS).parse(in);
            recordsList = new ArrayList<>();
            Iterator<CSVRecord> it = records.iterator();
            it.next(); // skip headers
            while (it.hasNext()) {
                recordsList.add(it.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return recordsList;
    }
}
