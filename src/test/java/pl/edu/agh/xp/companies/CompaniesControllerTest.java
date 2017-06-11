package pl.edu.agh.xp.companies;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by SB on 2017-04-20
 */
public class CompaniesControllerTest {

    private class MockCompaniesRepository implements CompaniesRepository {

        @Override
        public List<Company> getCompanies() {
            return Arrays.asList(new Company(56, "dsds"), new Company(78, "koko"));
        }

        @Override
        public Company getCompanyById(Integer id)
        {
            return null;
        }
    }

    private class MockCompaniesView extends CompaniesView {

        boolean companiesShown = false;

        @Override
        public void showCompanies(List<Company> companies) {
            companiesShown = true;
        }
    }

    // @Test
    public void showCompaniesTest() {
        MockCompaniesView view = new MockCompaniesView();
        CompaniesController controller = new CompaniesController(new MockCompaniesRepository(), view);
        controller.display();

        Assert.assertTrue(view.companiesShown);

    }


}
