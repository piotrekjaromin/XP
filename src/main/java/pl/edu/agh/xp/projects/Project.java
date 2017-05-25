package pl.edu.agh.xp.projects;

/**
 * Created by SB on 2017-05-04.
 */
public class Project {

    private String id;
    private Integer companyId;
    private String name;
    private float workedDays;

    public Project(String id, Integer companyId, String name, float workedDays) {
        this.id = id;
        this.companyId = companyId;
        this.name = name;
        this.workedDays = workedDays;
    }

    public String getId() {
        return id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public String getName() {
        return name;
    }

    public float getWorkedDays() {
        return workedDays;
    }
}
