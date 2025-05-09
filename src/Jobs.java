public class Jobs{
  protected String name;
  protected double salary;
  protected int stress;
  protected int hours;
  protected int preformance; 
  
  public Jobs(){
    salary = 0;
    hours = 0; 
    name = "Unemployed";
  }
  
  public Jobs(double salary, int stress, int hours, String name){
    this.salary = salary;
    this.stress = stress;
    this.hours = hours;
    this.name = name;
    preformance = 20;
  }
  public void goToWork(Player player){
    //this method will have the player go to work
    int rand = (int)(Math.random()*300 + 100);
    if(player.getJob().getName().equals("flightattendant")){
      player.addmoney(rand);
      System.out.println("$" + rand +" is your salaray for today.");
    }
    else{
      player.addmoney(player.getJob().getSalary());
    }
    System.out.println("Your total salary is " + player.getMoney()+ " after today's work.");
    System.out.println("Your fatigue from work increased your stress by " + player.getJob().getStress());
    player.applyStress(player.getJob().getStress());
  }
  
  public void workHard(){
    preformance += 10;
    if(preformance >= 100){
      System.out.println("You get a raise by 3%");
      salary += (salary/100) * 3;
      preformance = 20;
    }
  }
  
  public void quit(){
    preformance = 0;
    salary = 0;
    stress = 0;
    hours = 0;
    name = "unemployed";
  }
  
  public double getSalary(){
    return salary;
  }
  
  public String getName(){
    return name;
  }
  
  public int getStress(){
    return stress;
  }
  
  public int gethours(){
    return hours;
  }
  
  public void raise(){
    //gives the player a raise by 1$
    salary += 1.0;
  }
  
  public void budgetCuts(){
    //removes 0.50$ from the players salary
    salary -= 0.5;
  }
  public String toString(){
    String greeting = ("I hope you are having a great day!");
    return greeting;
  }
  
  
}