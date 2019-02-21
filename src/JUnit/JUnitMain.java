package JUnit;

import java.util.Random;

public class JUnitMain {

    // this method picks up a random integer between the range provided
    public static int getRandomValue(int lowValue, int highValue){

        Random randValue = new Random();

        if( lowValue < 0 || highValue < 0 ) {
            return -1;
        }

        if( highValue <= lowValue ){
            return -2;
        }

        if ( highValue == Integer.MAX_VALUE){
            return -3;
        }

        return randValue.nextInt(highValue + 1 - lowValue) + lowValue;
    }


}
