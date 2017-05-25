package pl.edu.agh.xp.companies;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Pawel on 2017-04-20
 */
public class CompaniesView {

    public CompaniesView() {
    }

    public void showCompanies(List<Company> companies) {
        System.out.println();
        companies.stream().forEach(company -> System.out.println("Company | id: " + company.getId() + ", name: " + company.getName()));
    }

    public int chooseCompany() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz firmę");
        return scanner.nextInt();
    }

    public void chosenCompany(String name) {
        System.out.println("Wybrałeś " + name);
    }
}
