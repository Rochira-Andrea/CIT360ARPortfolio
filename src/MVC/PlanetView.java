package MVC;


public class PlanetView {

    public void displayPlanetInfo(String name, boolean habitable, int moons){
        System.out.println("\n-----------------------------\n"
                          +"Planet Name: " + name + "\n"
                          +"Habitable: " + habitable + "\n"
                          +"Number of moons: " + moons + "\n"
                          +"-----------------------------");
    }

}
