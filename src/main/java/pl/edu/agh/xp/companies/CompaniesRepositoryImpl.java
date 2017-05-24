package pl.edu.agh.xp.companies;

import java.util.Arrays;
import java.util.List;

/**
 * Created by SB on 2017-05-04.
 */
public class CompaniesRepositoryImpl implements CompaniesRepository {

    private List<Company> companies = Arrays.asList(new Company(1, "firma1"), new Company(2, "firma2"));

    public List<Company> getCompanies()
    {
        return companies;
    }

    public Company getCompanyById(Integer id)
    {
        for (int i = 0; i < companies.size(); i++) {
            if (companies.get(i).getId().equals(id)) {
                return companies.get(i);
            }
        }
        return null;
    }
}
