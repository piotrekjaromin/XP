package pl.edu.agh.xp.projects;


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
public class ProjectRepositoryTests {

    private ProjectRepository projectRepository;

    @Mock
    private FileManagerImpl fileManager;

    @Before
    public void setUp() {
        projectRepository = new ProjectRepositoryImpl(fileManager);
    }

    @Test
    public void testGetProjectsByCompany() {
        // given
        List<CSVRecord> records = getSampleProjectRecords();
        Mockito.when(fileManager.readCsvFile(anyString(),
                eq(FilesConfig.PROJECTS_FILE_HEADERS[0]),
                eq(FilesConfig.PROJECTS_FILE_HEADERS[1]),
                eq(FilesConfig.PROJECTS_FILE_HEADERS[2]))).thenReturn(records);

        // when
        List<Project> projectsByCompany = projectRepository.getProjectsByCompany(1);

        // then
        assertEquals(2,projectsByCompany.size());
        assertEquals("1",projectsByCompany.get(0).getId());
        assertEquals("Project One",projectsByCompany.get(0).getName());
        assertEquals(Integer.valueOf(1),projectsByCompany.get(0).getCompanyId());
        assertEquals("2",projectsByCompany.get(1).getId());
        assertEquals("Project Two",projectsByCompany.get(1).getName());
        assertEquals(Integer.valueOf(1),projectsByCompany.get(1).getCompanyId());
    }

    private List<CSVRecord> getSampleProjectRecords() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("sample-projects.csv").getFile());
        String path = file.getAbsolutePath();
        List<CSVRecord> recordsList = null;
        try (Reader in = new FileReader(path)) {
            Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader(FilesConfig.PROJECTS_FILE_HEADERS).parse(in);
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
