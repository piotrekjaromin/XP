package pl.edu.agh.xp.files;

public class FilesConfig {

    public static final String PROJECTS_DB = "sample-projects.csv";
    public static final String COMPANIES_DB = "sample-companies.csv";

    public static String[] COMPANIES_FILE_HEADERS = new String[]{"Id","CompanyName"};
    public static String[] PROJECTS_FILE_HEADERS = new String[]{"Id", "ProjectName", "CompanyId"};
}
