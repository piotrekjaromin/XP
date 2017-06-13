package pl.edu.agh.xp;

import com.apple.eio.FileManager;
import pl.edu.agh.xp.files.FileManagerImpl;
import pl.edu.agh.xp.timer.HoursRepository;
import pl.edu.agh.xp.timer.TimerController;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Created by SB on 2017-05-25
 */
public class MenuController {

    private final ControllersProvider controllerProvider;

    private ArrayDeque<Controller> controllers;
    private Scanner scanner;
    private TimerController timerController;
    private int chosenProject;

    public MenuController(ControllersProvider controllersProvider) {
        this.controllerProvider = controllersProvider;
        this.controllers = new ArrayDeque<>();
        this.scanner = new Scanner(System.in);
    }

    public MenuController(ControllersProvider controllersProvider, Scanner scanner) {
        this.controllerProvider = controllersProvider;
        this.controllers = new ArrayDeque<>();
        this.scanner = scanner;
    }

    public void showCompaniesView() {
        Controller controller = controllerProvider.createCompanyController(this);

        controllers.push(controller);
        controller.display();
    }

    public void showProjectsView(Integer companyId) {
        Controller controller = controllerProvider.createProjectController(companyId, this);

        controllers.push(controller);
        controller.display();
    }

    public void showProjectTimetable(String projectId) {
        System.out.println("Wybrano projekt: " + projectId);
        this.chosenProject = Integer.valueOf(projectId);
        System.out.println("Aby rozpocząć monitorowanie pracy wybierz 1 \n Aby zakończyć działanie aplikacjiwybierz 2");
        int userInput = readUserInput();
        while (userInput != 1 && userInput != 2) {
            System.out.println("Zły wybór - wybierz ponownie");
            userInput = readUserInput();
        }
        if(userInput == 1) {
            timerController = new TimerController();
            timerController.startMonitoringTime();
            timeIsMonitoring();
        }
    }

    public void timeIsMonitoring() {
        System.out.println("Jeżeli chcesz zakończyć monitrowanie wybierz 3");
        int userInput = readUserInput();
        while (userInput != 3) {
            System.out.println("Zły wybór - wybierz ponownie");
            userInput = readUserInput();
        }
        long sec = timerController.stopMonitoringTime();
        String time = timerController.formTime(sec);
        System.out.println("Przepracowano " + time + " minut");

        HoursRepository hoursRepository = new HoursRepository(new FileManagerImpl());
        hoursRepository.updateHours(this.chosenProject, time);
    }

    private int readUserInput() {
        return scanner.nextInt();
    }

    public void back() {
        if (controllers.size() > 1) {
            controllers.pop();
            controllers.peek().display();
        } else {
            System.out.println("Nie mozna wrocic");
        }
    }
}
