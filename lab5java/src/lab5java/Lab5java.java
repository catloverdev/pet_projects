package lab5java;

public class Lab5java {
    static {
    System.out.println("Начало спора");}
        
    public static void main(String[] args) {
        Debaters t1 = new Debaters("Первый путешественник");
        Debaters t2 = new Debaters("Второй путешественник");
        Debaters t3 = new Debaters("Третий путешественник");
        t1.start();
        t2.start();
        t3.start();
        try {
        t1.join();
        // поток main остановлен до окончания работы потока t1
        } catch (InterruptedException e) {
        e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
        // имя текущего потока
 }
}
