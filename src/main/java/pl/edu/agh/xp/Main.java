package pl.edu.agh.xp;


import pl.edu.agh.xp.companies.CompaniesController;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CompaniesController companies = new CompaniesController();
        companies.start();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz firm1ę");
        int choice = scanner.nextInt();
        String name = companies.getCompanyNameById(choice);
        System.out.printf("Wybrałeś: " + name);
    }
}
