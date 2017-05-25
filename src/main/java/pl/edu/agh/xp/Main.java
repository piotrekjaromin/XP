package pl.edu.agh.xp;


import pl.edu.agh.xp.companies.CompaniesController;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CompaniesController companies = new CompaniesController();
        companies.start();
    }
}
