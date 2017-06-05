package pl.edu.agh.xp;


public class Main {

    public static void main(String[] args) {
        MenuController menuController = new MenuController(new ControllersProvider());
        menuController.showCompaniesView();
    }
}
