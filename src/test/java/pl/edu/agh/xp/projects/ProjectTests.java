package pl.edu.agh.xp.projects;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProjectTests {

    @Test
    public void testIfProjectIsCreated() {
        Project testProject = new Project("1", 1, "ProjectName", 2);
        assertEquals("1", testProject.getId());
        assertEquals(Integer.valueOf(1), testProject.getCompanyId());
        assertEquals("ProjectName", testProject.getName());
        assertEquals(Float.valueOf(2), (Float) testProject.getWorkedDays());
    }

}
