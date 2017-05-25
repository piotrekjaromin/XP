package pl.edu.agh.xp.projects;

import java.util.List;
import java.util.Scanner;

/**
 * Created by SB on 2017-05-04
 */
public class ProjectView {

    private List<Project> projectList;

    public void displayProject(List<Project> projectList) {
        this.projectList = projectList;

        System.out.println("Projects: ");
        projectList.stream().forEach(project -> System.out.println("Name: " + project.getName() + ", Id: " + project.getId()));
    }

    public String getUserSelection() {
        System.out.println("Wybierz projekt: ");

        int chosenProjectNo = readUserInput();
        while (chosenProjectNo > projectList.size() || chosenProjectNo < 0) {
            System.out.println("Nie ma takiego projektu.");
            chosenProjectNo = readUserInput();
        }

        return projectList.get(chosenProjectNo - 1).getId();
    }

    private int readUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
