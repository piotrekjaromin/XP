package pl.edu.agh.xp;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by SB on 2017-05-25
 */
public class MenuController {

    private final ControllersProvider controllerProvider;

    private ArrayDeque<Controller> controllers;

    public MenuController(ControllersProvider controllersProvider) {
        this.controllerProvider = controllersProvider;
        this.controllers = new ArrayDeque<>();
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
