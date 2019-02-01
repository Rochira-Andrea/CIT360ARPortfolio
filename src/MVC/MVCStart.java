package MVC;

import java.util.ArrayList;

public class MVCStart {

    public static void planetDB(){

        // welcome message
        System.out.println("\nThis program is based on the Model-View-Control pattern");

        // a little pause to give time for reading
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Thread doesn't want to sleep");
        }

        // recall information from data source
        ArrayList<Planet> planetModel = planetsList();

        // create a view to display information on screen
        PlanetView view = new PlanetView();

        // pass the model information and the view to the control class
        PlanetControl control = new PlanetControl(planetModel, view);

        // invoke the control method and display the records in the data source
        control.getList();

        // Exiting
        System.out.println("\nGoing back to the selection menu...");

    }

    private static ArrayList<Planet> planetsList(){
        // create a data source
        ArrayList<Planet> Planets = new ArrayList<>();
        Planets.add(new Planet("Mercury",false,0));
        Planets.add(new Planet("Venus",false,0));
        Planets.add(new Planet("Mars",false,2));
        Planets.add(new Planet("Earth",true,1));
        Planets.add(new Planet("Jupiter",false,79));
        Planets.add(new Planet("Saturn",false,62));
        Planets.add(new Planet("Uranus",false,27));
        Planets.add(new Planet("Neptune",false,14));

        return Planets;
    }
}
