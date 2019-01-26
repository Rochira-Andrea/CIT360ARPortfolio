package Threads;

public class Runny implements Runnable {

    // declare an empty thread
    Thread thrd;

    /*
    SumArray will be static so that there’s one
    instance shared between the threads
    */
    private static SumAtomArray sa = new SumAtomArray();


    // Construct a new thread and start it right away
    Runny(String name) {
        thrd = new Thread(this, name);
    }

    // begin execution of new thread
    @Override
    public void run() {

        int answer;

        // what thread is starting
        System.out.println(thrd.getName() + " is starting.\n");

        // call for synchronized method
        answer = sa.sumArray();

        // display the sum
        System.out.println("Sum for "+ thrd.getName() + " is " + answer + "\n");

        System.out.println(thrd.getName() + " terminating.\n");
    }
}
