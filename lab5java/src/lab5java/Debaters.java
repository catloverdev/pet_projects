package lab5java;
import java.util.ArrayList;
import java.util.Random;

public class Debaters extends Thread {
    private final String[] pathT = new String[]{"суше","воде","воздуху"};
    public Debaters (String name) {
       super(name);
    }
    public void run() {
    String nameT = getName();
    long timeout = 0;
    System.out.println(nameT + " выбирает маршрут");
    try {
    switch (nameT) {
    case "Первый путешественник": timeout = 1_000;
    case "Второй путешественник": timeout = 1_000;
    case "Третий путешественник": timeout = 1_000;
    default: timeout = 0; break;
    }
 Thread.sleep(timeout);
 Random r = new Random();
 String path = pathT[r.nextInt(3)];
 System.out.println(nameT + " выбрал путь по " + path);
 } catch (InterruptedException e) {
 e.printStackTrace();
 }
 }
}
