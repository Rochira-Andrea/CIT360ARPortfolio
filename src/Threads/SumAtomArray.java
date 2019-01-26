package Threads;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class SumAtomArray {

    // empty constructor
    SumAtomArray(){
    }

    private int sum;

    synchronized Integer sumArray() {

        sum = 0;

        // initialize an atomic array of Integers
        AtomicIntegerArray atomIntArray = new AtomicIntegerArray(5);
        atomIntArray.set(0,1);
        atomIntArray.set(1,2);
        atomIntArray.set(2,3);
        atomIntArray.set(3,4);
        atomIntArray.set(4,5);

        // iterate through the atomic array and sum up its values

        for (int i = 0; i<atomIntArray.length(); i++) {
            sum += atomIntArray.get(i);
                System.out.println("Running total for " + Thread.currentThread().getName() + " is " + sum);
        }

        return sum;
    }
}
