package pl.edu.agh.xp.companies;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Pawel on 2017-04-20
 */
public class CompaniesView {

    private Scanner scanner;

    public CompaniesView() {
        scanner = new Scanner(System.in);
    }

    public CompaniesView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void showCompanies(List<Company> companies) {
        System.out.println();
        companies.stream().forEach(company -> System.out.println("Company | id: " + company.getId() + ", name: " + company.getName()));
    }

    public int chooseCompany() {
        System.out.println("Wybierz firmę");
        return scanner.nextInt();
    }

    public void chosenCompany(String name) {
        System.out.println("Wybrałeś " + name);
    }
}
