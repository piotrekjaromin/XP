package pl.edu.agh.xp.companies;

import java.util.List;

/**
 * Created by SB on 2017-05-04
 */
public interface CompaniesRepository {

    List<Company> getCompanies();
    Company getCompanyById(Integer id);
}
