package Threads;


import java.util.concurrent.*;

public class Executy {

    public static void entryPoint(){

        // welcome message
        System.out.println("\nThis program implements a pool of two threads.\n"
                          +"The threads access synchronously a method that initializes\n"
                          +"an array of type AtomicIntegerArray and sums up its values.\n");

        // a little pause to give time for reading
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            System.out.println("Thread doesn't want to sleep");
        }

        // create an executor that implements a pool of max 2 threads
        ExecutorService ES = Executors.newFixedThreadPool(2);

        // create two runnable objects
        Runny runThreadOne = new Runny("Thread #1");
        Runny runThreadTwo = new Runny("Thread #2");

        // pass the Runnable objects to the executor and start running their tasks
        ES.execute(runThreadOne);
        ES.execute(runThreadTwo);

        // Implement Future & anonimous Callable to retrieve feedback
        Future<String> future = ES.submit(new Callable<String>() {
            @Override
            public String call() {
                return "Feedback from Callable";
            }
        });

        //  if no exception is raised, then tasks executed successfully
        try {
            // Wait for the tasks to finish executing
            System.out.println(future.get()+" - All tasks completed: "+ future.isDone()+"\n");
        } catch(ExecutionException e) {
            System.out.println("Something went wrong while executing the task");
        } catch(InterruptedException e) {
            System.out.println("Thread running the task was interrupted");
        }

        // stop the executor and gracefully terminate the program
        ES.shutdown();

        System.out.println("Going back to selection menu...\n");
    }
}
