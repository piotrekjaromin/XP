package pl.edu.agh.xp.companies;

/**
 * Created by Pawel on 2017-04-20
 */
public class CompaniesController {

    private CompaniesRepository companyRepository;
    private CompaniesView view;

    public CompaniesController() {
        this.companyRepository = new CompaniesRepositoryImpl();
        this.view = new CompaniesView();
    }

    public CompaniesController(CompaniesRepository companyRepository, CompaniesView view) {
        this.companyRepository = companyRepository;
        this.view = view;
    }

    public void start() {
        view.showCompanies(companyRepository.getCompanies());
    }
}
