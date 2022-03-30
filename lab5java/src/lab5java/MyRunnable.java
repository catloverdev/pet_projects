package lab5java;
public class MyRunnable implements Runnable {
    public void run() {
        long sum=0;
        for (int i=0; i<1000; i++){
            sum+=i;}
        System.out.println(sum);
    }
}
