/*
Within Java, threads are a powerful tool. The best description that I found was - rocesses are instances of programs which typically run independent to each other, e.g. if you start a java program the operating system spawns a new process which runs in parallel to other programs. Inside those processes we can utilize threads to execute code concurrently, so we can make the most out of the available cores of the CPU.

A lot of this is coming from the tutorial found here - https://winterbe.com/posts/2015/04/07/java8-concurrency-tutorial-thread-executor-examples/ 

This is a pretty neat example of how to concurrently run threads, and implements the java.util.concurrent packages. 

Also, since we're playing with atomic integers, I found a great Oracle resource found here - https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/atomic/AtomicInteger.html on most of their methods and classes that I can use alongside the atomicinteger package.

Let me know if this works for you!

This program that uses Threads, runnables, and executors as well as a random integer class in order to pull in appropriate values and count them in for loops. I tried to use the most up to date information I could find on the subject matter, and I have represented it here.

*/
import java.util.Random;
import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors; 
import java.util.concurrent.atomic.AtomicInteger;


//I simply took the atomicinteger commands found within the example, and repurposed them to a similar effect, but it creates a different output and has an overall different function than found within the actual application.
public class TRE{ 
    
    private static AtomicInteger atomInt = new AtomicInteger(); 
    public static class RunCommand implements Runnable {
    public int valuation = 0;

    // This is a basic way to create a three simple thread using "implements Runnable" class method and passing it to a constructor of the thread class
    public RunCommand() {
    }

    public void run() {  
        System.out.println(Thread.currentThread().getName()+ "FULL STEAM AHEAD"); 
        Random randO = new Random();
        int rando_int = randO.nextInt(10);
        for (int i = 0; i <= rando_int; i++) {
            product = atomInt.incrementAndGet(); 
            holdThread(); 
        }

        //This area is for the printing out of our products
        System.out.println("Product named" + Thread.currentThread().getName() + " = " + product);
        System.out.println(Thread.currentThread().getName()+ "FULL Stopped!");
    }  
     
    //Since the system is marked in ms, we'll stop the system for 1 second, or Thread.sleep(1000).
    private void holdThread() {  
        try {  
            Thread.sleep(1000);  
        } 
        catch (InterruptedException e) { 
            e.printStackTrace(); 
        }  
    }     
}

    public static void main(String[] args) {  
        ExecutorService exesauce = Executors.newFixedThreadPool(12); //creates a pool of 12 threads  
        int threadZ = 0; 

        //Here we plan on creating a simple for loop that creates new execute and runnable methods in order to properly
        for (int i = 0; i < 10; i++) {  
            Runnable runCom = new RunCommand(); 
            exesauce.execute(runCom); 
            threadZ++; 
          }  

        exesauce.shutdown();         
        while (!exesauce.isTerminated()) {   }  
  
       //Here we want to output the amount of threads
        System.out.println("Finished!");  
        System.out.println("Total Threads: " + threadZ);
    }
}
