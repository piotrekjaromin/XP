package pl.edu.agh.xp.companies;

import java.util.Arrays;
import java.util.List;

/**
 * Created by SB on 2017-05-04.
 */
public class CompaniesRepositoryImpl implements CompaniesRepository {

    public List<Company> getCompanies() {
        return Arrays.asList(new Company("1", "firma1"), new Company("2", "firma2"));
    }

    public Company getCompany(String id) {
        return null;
    }

    public void updateCompany(Company company) {

    }

    public void removeCompany(Company company) {

    }
}
