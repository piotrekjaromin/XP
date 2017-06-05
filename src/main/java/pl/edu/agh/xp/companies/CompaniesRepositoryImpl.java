package pl.edu.agh.xp.companies;

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
 * Created by SB on 2017-05-04.
 */
public class CompaniesRepositoryImpl implements CompaniesRepository {

    private FileManagerInterface fileManager;

    public CompaniesRepositoryImpl(FileManagerInterface fileManager) {
        this.fileManager = fileManager;
    }

    public List<Company> getCompanies() {
        String path = getAbsFilepath();
        if (path != null) {
            List<CSVRecord> csvRecords = fileManager.readCsvFile(path, FilesConfig.COMPANIES_FILE_HEADERS);
            return parseCsvToCompanies(csvRecords);
        }

        return Collections.emptyList();
    }

    public Company getCompanyById(Integer id) {
        return new Company(1, "not implemented.");
    }

    private List<Company> parseCsvToCompanies(List<CSVRecord> csvRecords) {
        List<Company> parsedCompanies = new ArrayList<>();
        for (CSVRecord csvRecord : csvRecords) {
            Integer id = Integer.valueOf(csvRecord.get(0));
            String name = csvRecord.get(1);

            parsedCompanies.add(new Company(id, name));
        }

        return parsedCompanies;
    }

    private String getAbsFilepath() {
        URL fileResourceUrl = getClass().getClassLoader().getResource(FilesConfig.COMPANIES_DB);
        if (fileResourceUrl != null) {
            return new File(fileResourceUrl.getFile()).getAbsolutePath();
        }
        System.out.println("Coulnd not find resource: " + FilesConfig.COMPANIES_DB);
        return null;
    }
}
