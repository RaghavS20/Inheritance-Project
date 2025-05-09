import java.util.ArrayList;

public class Player{
  private int health;
  private int stress;
  private int sleep;
  private int hunger;
  private int age;
  private String name;
  private double money;
  private Jobs job;
  private College college;
  private boolean c;
  

  
  public Player(String name){
    health = 100;
    stress = 0;
    sleep = 100;
    hunger = 100;
    age = 18;
    //creates the player with full stats and 18 years old
    this.name = name;
    money = Math.random()*(10000);
    //starts the payer off with any amount of money from 0-10000
    job = new Jobs();
    //creates a new job with its defualt stats
  }
  
  
  public String getMajor(){ 
    if(c){
      return null;
    }

    else{
      return college.getMajor();
    }
  }
  public int getstress(){
    return stress;
  }

  public int getHunger(){
    return hunger;
  }

  public Jobs getJob(){
    return job;
  }
  
  public String getName(){
    return name;
  }
  
  public int getAge(){
    return age;
  }
  
  public int getHealth(){
    return health;
  }
  
  public double getMoney(){
    double mon = roundMon(money);
    return mon;
  }
  public void setjob(Jobs j){
    job = j;
  }
  
  public void minusHunger(int h){
    hunger = hunger - h;
    if(hunger<0){
      hunger = 0;
    }
  }

  public void addHunger(int h){
    hunger += h;
    if(hunger>100){
      hunger = 100;
    }
  }

  public void addmoney(double m){
    money += m;
  }

  public void subtractmoney(double m){
    money-=m;
  }

  public void minushealth(int h){
    health -= h;
    if(health<0){
      health = 0;
    }
  } 

  public void addhealth(int h){
    health += h;
    if(health>=100){
      health = 100;
    }
  }
  public void checkStats(){
    if(stress<0){
      stress=0;
    }
    if(hunger>100){
      hunger=100;
    }
    System.out.println(name + "'s Stats");
    System.out.println("Health: " + health + "%");
    System.out.println("Stress: " + stress + "%");
    System.out.println("Sleep: " + sleep + "%");
    System.out.println("Hunger: " + hunger + "%");
    System.out.println("Age: " + age + " years old");
    System.out.println("Money: $" + (int)money);
  }
  
  public void checkBalance(){
    double mon = roundMon(money);
    System.out.println("You have " + mon + "$");
  }
  
  public void applyStress(int st){
    stress = stress+st;
  }

  public void reduceStress(int st){
    stress -=st;
  }
  
  public void pay(int m){
    money = money+m;
  }

  public void setage(int a){
    age = a;
  }
  
  public void eat(Food food){
    String f = food.getName();
    int v = food.getValue();
    System.out.println("You ate" + f);
    hunger = hunger + v;
    System.out.println("Your hunger is now at " + hunger + "%");
  }
  
  public double roundMon(double q){
    int m = (int)(q * 1000);
    double nM = (double)(m/1000);
    return nM;
  }
}