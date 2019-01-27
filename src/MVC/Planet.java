package MVC;

public class Planet {

    // class attributes
    private String name;
    private boolean habitable;
    private int numOfMoons;

    // empty constructor
    public Planet(){
    }

    // overloaded constructor
    public Planet(String name, boolean abitable, int numOfMoons) {
        this.name = name;
        this.habitable = abitable;
        this.numOfMoons = numOfMoons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAbitable() {
        return habitable;
    }

    public void setAbitable(boolean abitable) {
        this.habitable = abitable;
    }

    public int getNumOfMoons() {
        return numOfMoons;
    }

    public void setNumOfMoons(int numOfMoons) {
        this.numOfMoons = numOfMoons;
    }
}
