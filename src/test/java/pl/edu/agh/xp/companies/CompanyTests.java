package pl.edu.agh.xp.companies;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CompanyTests {

    @Test
    public void testIfCompanyIsCreated() {
        Company company = new Company(1,"CompanyName");
        assertEquals(Integer.valueOf(1), company.getId());
        assertEquals("CompanyName", company.getName());
    }

    @Test
    public void testSettingValues() {
        Company company = new Company(1,"CompanyName");
        company.setId(2);
        company.setName("NewName");
        assertEquals(Integer.valueOf(2), company.getId());
        assertEquals("NewName", company.getName());
    }
}
