package pl.edu.agh.xp.projects;

/**
 * Created by SB on 2017-05-04.
 */
public class Project {

    private String id;
    private String companyId;
    private String name;
    private float workedDays;

    public Project(String id, String companyId, String name, float workedDays) {
        this.id = id;
        this.companyId = companyId;
        this.name = name;
        this.workedDays = workedDays;
    }

    public String getId() {
        return id;
    }

    public String getCompanyId() {
        return companyId;
    }

    public String getName() {
        return name;
    }

    public float getWorkedDays() {
        return workedDays;
    }
}
