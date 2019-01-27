package MVC;

import java.util.ArrayList;

public class PlanetControl {

    // attributes
    private ArrayList<Planet> planetModel;
    private PlanetView view;


    // constructor
    public PlanetControl(ArrayList<Planet> planetModel, PlanetView view) {
        this.planetModel = planetModel;
        this.view = view;
    }

    // get the list of planets
    public void getList(){
        for(Planet p : planetModel){
              view.displayPlanetInfo(p.getName(),p.isAbitable(),p.getNumOfMoons());
        }
    }

}
