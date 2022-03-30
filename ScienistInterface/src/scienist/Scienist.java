package scienist;
public interface Scienist {
//    int salary;
//    int seniority;
//    private String position;
//    private String status;
//    Scienist(int salary, int seniority)
//    {
//        this.salary=salary;
//        this.seniority=seniority;
//    }
    public void getSalary();
    public void getSeniority();
    public void getPosition();
    public void getStatus();
    public void setSalary(int salary);
    public void setSeniority(int seniority);
    public void allowance();
    public void hire();
    public void fire();
    public void changePosition(String position);
    public void changeSalary(int salary);
     @Override
 public boolean equals(Object o);
    @Override
 public String toString();
 
}
