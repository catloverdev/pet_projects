package scienist;
import java.util.ArrayList;
public class main {
        public static void main(String[] args) {
        // TODO code application logic here
        Scienist[] mas = new Scienist[11];
        mas[0]= new Engineer(30000,2);
        mas[1] = new Engineer(30000,2);
        mas[2] = new Engineer(30000,2);
        mas[3] = new Engineer(28000,1);
        mas[4] = new Engineer(32000,4);
        mas[5] = new SeniorScienist(40000,6);
        mas[6] = new SeniorScienist(38000,4);
        mas[7] = new JuniorScienist(31000,1);
        mas[8] = new JuniorScienist(32000,2);
        mas[9] = new JuniorScienist(33000,3);
        mas[10] = new JuniorScienist(34000,4);
//        mas[1].hire();
//        mas[1].getStatus();
//        mas[1].changePosition("ассистент");
//        mas[1].changeSalary(15000);
//        mas[1].getPosition();
//        mas[1].getSalary();
        Scienist[] sciarr = new Scienist[9];
        //проверка на уникальность 
        //с занесением уникальных объектов 
        //в отдельный массив
        ArrayList scientlist = new ArrayList();
        for(int i=0;i<10;i++)
        {
            boolean check = false;
            for(Object j:scientlist)    
                if(mas[i].equals(j)){
                    check=true;
                    break;
                }
            if(!check)
                scientlist.add(mas[i]);
        }
        for(Object j:scientlist)
        {
            Scienist d = (Scienist)j;
            d.toString();
            d.allowance();
            System.out.println(d.toString());
        }
        
    }
}
