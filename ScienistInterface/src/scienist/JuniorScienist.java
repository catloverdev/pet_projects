package scienist;
public class JuniorScienist implements Scienist {
    private double x;
    int salary;
    int seniority;
    private String position;
    private String status;
    JuniorScienist(int salary, int seniority)
    {
        this.salary=salary;
        this.seniority=seniority;
    }
    public void getSalary()
    {
        System.out.println("Salary: "+salary);
    }
    public void getSeniority()
    {
        System.out.println("Seniority: "+seniority);
    }
    public void getPosition()
    {
        System.out.println("Position: "+position);
    }
    public void getStatus()
    {
        System.out.println("Status: "+status);
    }
    public void setSalary(int salary)
    {
        this.salary=salary;
    }
    public void setSeniority(int seniority)
    {
        this.seniority=seniority;
    }
    public void hire()
    {
        this.status = "нанят";
    }
    public void fire()
    {
        this.status = "уволен";
    }
    public void changePosition(String position)
    {
        this.position = position;
    }
    public void changeSalary(int salary)
    {
        this.salary = salary;
    }
    //@Override
 public boolean equals(Object o)
 {
    boolean result =false;
   //сравниваем только объекты типа MyDate.
    if(o!=null && o instanceof JuniorScienist)
    { JuniorScienist d=(JuniorScienist)o; //Явное приведение типов
    if ((seniority==d.seniority)&&(salary==d.salary))
    result=true;
    }
    return result;
  }
    //@Override
    public void allowance()
    {
        this.x=salary*(1+seniority*0.02);
    }
     //@Override
 public String toString()
 {
     return "Мл.н.сотрудник "+"Ставка "+salary+" "+"+ Надбавки: "+(x-salary);
 }
}
