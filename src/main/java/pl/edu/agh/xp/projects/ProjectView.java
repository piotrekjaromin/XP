package pl.edu.agh.xp.projects;

import java.util.List;
import java.util.Scanner;

/**
 * Created by SB on 2017-05-04
 */
public class ProjectView {

    private ProjectController projectController;
    private List<Project> projectList;

    private Scanner scanner;

    public ProjectView() {
        scanner = new Scanner(System.in);
    }

    public ProjectView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayProject(List<Project> projectList) {
        this.projectList = projectList;

        System.out.println("\nProjekty: ");
        projectList.stream().forEach(project -> System.out.println("Id: " + project.getId() + ", Nazwa projektu: " + project.getName()));

        // musi tak byc, bo czekanie na wejscie w kontrolerze dziala tylko w przypadku aplikacji konsolowej, albo jakbysmy mieli to jakos reaktywnie zrobione
        // ale nie mamy, takze widok musi powiadamiac kontroler jak uzytkownik wykona jakas akcje
        waitForUserInteraction();
    }

    private void waitForUserInteraction() {
        System.out.println("Wybierz projekt po ID (0 by wrócić): ");

        int userInput = readUserInput();
        while (userInput > projectList.size() || userInput < 0) {
            System.out.println("Błąd wczytywania");
            userInput = readUserInput();
        }

        handleUserInput(userInput);
    }

    private void handleUserInput(int userInput) {
        if (userInput == 0) {
            projectController.onBackPressed();
        } else {
            Project chosenProject = projectList.get(userInput - 1);
            System.out.println("Wybrano: " + chosenProject.getName());
            projectController.onProjectSelected(chosenProject.getId());
        }
    }

    private int readUserInput() {
        return scanner.nextInt();
    }


    public void setProjectController(ProjectController projectController) {
        this.projectController = projectController;
    }
}
