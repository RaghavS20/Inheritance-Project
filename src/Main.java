import java.util.Scanner;

public class Main{
  public static void main(String[] args){
    Scanner s1 = new Scanner(System.in);
    //creates a new scanner
    System.out.println("Hello, and welcome to your life simulator! ");
    System.out.println("Type 'exit' to stop playing");
    System.out.println("Please enter a name.");
    //welcomes the player and tells them to enter a name

    String name = s1.nextLine();
    Player player = new Player(name);
    //makes the player's name whatever they previously inputed
    if(name.equals("exit")){
      System.out.println("Thank you for playing");
      System.exit(0);
    }
    while(name != "exit"){

      System.out.println("Hello " + player.getName() + ", you are " + player.getAge() + " and you have $" + player.getMoney() + " You have just graduated High School!");
      System.out.println("Before we start, please read this important information:");
      System.out.println("You goal is to make $10000 to gaurantee retirment.");
      System.out.println("You must do this by maintaining good health, not stressing, and paying attention to your hunger level.");
      System.out.println("Health ranges from 0-100, where 100 is full health");
      System.out.println("Stress ranges from 0-100, where 0 is no stress, and 100 is too much stress.");
      System.out.println("Hunger ranges from 0-100, where 100 means that you are not hungry.");
      System.out.println("Unfortuanetly, you don't know how to cook, so you will have to buy food every day.");
      System.out.println("You can't let your stress be more than 100 or you will give up on life.");
      System.out.println("Make sure to pay attention to your health and don't lose all your money!");

      if(name.equals("exit")){
        System.out.println("Thank you for playing");
        System.exit(0);
      }
      while(player.getHealth() > 0 && player.getMoney()>0 && player.getHunger()>0 &&player.getstress()<100){
        //while the player is alive they will continue through this loop
        // every loop is a day and starts with saying so
        if(player.getMoney()>=10000){
          System.out.println("Congradulations! you have made " + player.getMoney() + " and you can now enjoy your retirement");
          System.exit(0);
        }
        System.out.println("It is a new day! ");
        //player.min
        if(((player.getJob()).getSalary()) <= 0){
          System.out.println("Would you like to...");
          System.out.println("[0] Check your stats");
          System.out.println("[1] Look for a job");
          System.out.println("[2] Look into going to college");
        
          String ans = s1.nextLine();
          if(ans.equals("exit")){
            System.out.println("Thank you for playing.");
            System.exit(0);
          }
          if(ans.length() != 1){
            System.out.println("I'm sorry, please choose just one number.");
          }
          else if(ans.equals("0")){
            System.out.println("You lose 5 health everytime you check stats.");
            player.minushealth(5);
            player.checkStats();

          }
          else if(ans.equals("1")){
            lookForJob(player);
          }

          else if(ans.equals("2")){
            lookforcollege(player);
          }
          else{
            System.out.println("Please type in one of the numbers in the options given");
          }
        }

        if(((player.getJob()).getSalary()) > 0){
          System.out.println("Would you like to...");
          System.out.println("[1] Check you stats");
          System.out.println("[2] Go to work");
          System.out.println("[3] Eat food");
          System.out.println("[4] Look for job");
          System.out.println("[5] Study and attend college");
          String ans = s1.nextLine();
          if(ans.equals("exit")){
            System.out.println("Thank you for playing.");
            System.exit(0);
          }
          if(ans.equals("1")){
            System.out.println("You lose 5 health everytime you check stats.");
            player.minushealth(5);
            player.checkStats();
            
          }
          if(ans.equals("2")){
            player.getJob().goToWork(player);
            player.minusHunger(10);
            player.addHunger(20);
          }
          if(ans.equals("3")){
            System.out.println("Would you like a low or high quality meal?");
            System.out.println("[1] $100 High quality");
            System.out.println("[2] $ 25 low quality");
            String ans1 = s1.nextLine();
            if(ans1.equals("1")){
              int rand = (int)(Math.random()*10+10);
              player.subtractmoney(100.00);
              System.out.println("Your meal was so luxurious that your stress reduced by " + rand);
              System.out.println("Your health increased by 20");
              player.addHunger(20);
              player.addhealth(20);
              player.reduceStress(rand);
            }
            if(ans1.equals("2")){
              int rand = (int)(Math.random()*10+1);
              System.out.println("I wonder if your meal actually tastes good.");
              System.out.println(("Your hunger increased by 5."));
              player.addHunger(5);
              if(rand<3){
                System.out.println("Your meal uspet your stomach.");
                System.out.println("You lost 10 health");
                player.minushealth(10);
              }
            }
            
          }
          if(ans.equals("4")){
            lookForJob(player);
          }
          if(ans.equals("5")){
            lookforcollege(player);
          }
          else{
            System.out.println("Please type in one of the numbers in the options given");
          }
        }
      }
      if(player.getMoney()>=10000){
        System.out.println("Congradulations! you have made " + player.getMoney() + " and you can now enjoy your retirement");
        System.exit(0);
      }
      if(player.getHunger()<=0){
        System.out.println("You died of hunger");
        System.out.println("Thank you for playing");
        System.exit(0);
      }
      if(player.getHealth()<=0){
        System.out.println("You lost all your health");
        System.out.println("Thank you for playing");
        System.exit(0);
      } 
      if(player.getMoney()<=0.0){
        System.out.println("You are bankrupt");
        System.out.println("Thank you for playing");
        System.exit(0);
      }
      if(player.getstress()>=100){
        System.out.println("You gave up on life because you were too stressed with it.");
        System.out.println("Thank you for playing");
        System.exit(0);
      }
    }
    
  
    
    
  }
  // public static void goToWork(Player player){
  //   //this method will have the player go to work
  //   player.addmoney(player.getJob().getSalary());
  //   System.out.println("Your total salary is " + player.getMoney()+ " after today's work.");
  //   System.out.println("Your fatigue from work increased your stress by " + player.getJob().getStress());
  //   player.applyStress(player.getJob().getStress());
  // }

  public static void lookForJob(Player player){
    //This is the code you call upon when the player decides they want to look for a job
    Scanner lookForJob = new Scanner(System.in);
    //creates a new scanner  
    String ans = lookForJob.nextLine();;
    //creates a new String
    

    if(((player.getJob()).getSalary()) > 0){
      //if the player currently has a job that pays:
      System.out.println("You seem to already be working as a " + (player.getJob().getName()) + ". Would you like to quit?");
      //it asks the player if they want to quit
      System.out.println("[1] Yes");
      System.out.println("[2] No");
      System.out.println("[3] Check Salary, Stress, and hours");

       
      boolean choose = true;
      //this boolean will allow this loop to run until a valid answer is inputed
      while(choose){
        ans = lookForJob.nextLine();
        //uses the scanner to change the value of the premade string
        while(ans.length()>1 || ans.length()<1){
          //if the player inputs more or less than 1 character they will reach this line
          //will exist in all methods that require user input
          System.out.println("Please only type one number. Would you like to");
          System.out.println("[1] Yes");
          System.out.println("[2] No");
          System.out.println("[3] Check Salary, Stress, and hours"); 
        }
        if(ans.equals("1")){
          //if the player chooses option 1, they will complete the quit method in the player class
          player.getJob().quit();
          lookForJob(player);
          choose= false;
          //ends the loop because the player has chosen a valid answer;        
        }
        else if(ans.equals("2")){
          //if the player chooses option 2 the loop ends because they cannot get a second job
          System.out.println("Ok, just continue your life.");
          choose = false;
          
        }
        else if(ans.equals("3")){
          System.out.println("You lose 5 health everytime you check stats.");
            player.minushealth(5);
            player.checkStats();
            choose = false;
        }
        else{
          System.out.println("Please type in one of the numbers in the options given");
        }
      }
    } 
    
    else{
        boolean choose = true;
        while(choose){
          System.out.println("Try your best surviving with these jobs");
          System.out.println("Since these are jobs that don't require education, they will have a lower salary");
          System.out.println("Would you like to be:");
          System.out.println("[1] Cleaner");
          System.out.println("[2] Gardener");
          System.out.println("[3] Firefighter");
          System.out.println("[4] Flight attendant");
          System.out.println("[5] Contruction Worker");
          ans = lookForJob.nextLine();
          while(ans.length()>1 || ans.length()<1){
            System.out.println("Please only type one number. Would you like to");
            System.out.println("Would you like to be a:");
            System.out.println("[1] Cleaner");
            System.out.println("[2] Gardener");
            System.out.println("[3] Firefighter");
            System.out.println("[4] Flight attendant");
            System.out.println("[5] Contruction Worker");
          }
          if(ans.equals("1")){
            System.out.println("You now earn $150 per day as a cleaner!");
            Jobs cleaner = new Jobs(150.00, 30, 8,"cleaner");
            player.setjob(cleaner);
            choose = false;
          }
          if(ans.equals("2")){
            System.out.println("You now earn $200 per day as a gardener!");
            Jobs gardener = new Jobs(200.00, 10, 6, "gardener");
            player.setjob(gardener);
            choose=false;
          }
          if(ans.equals("3")){
            System.out.println("You now earn $250 per day as a firefighter!");
            Jobs firefighter = new Firefighter(250, 32, 12, "firefighter", false);
            player.setjob(firefighter);
            choose = false;
          }
          if(ans.equals("4")){
            System.out.println("You now work for programming airlines.");
            System.out.println("This is a special airline where flight attendants are paid a random amount of money every day.");
            System.out.println("This ranges from $100 to $400");
            Jobs flightattendant = new Jobs(100, 5, 7, "flightattendant");
            player.setjob(flightattendant);
            choose = false;
          }
          if(ans.equals("5")){
            System.out.println("You now earn $150 per day as a construction worker!");
            Jobs constructionworker = new Jobs(150, 30, 10, "contructionwworker");
            player.setjob(constructionworker); 
            choose = false;
          }
          else{
            System.out.println("Please type in one of the numbers in the options given");
          }
        }
    }
        

        
  }

  public static void lookforcollege(Player player){
    Scanner lookforcollege = new Scanner(System.in);
    String ans = "";
    //Asks the user the options
    System.out.println("Would you like to go to college for 4 or 6-8 years?");
    System.out.println("[1] $2000 4 years");
    System.out.println("[2] $5000 6-8 years");
    
    boolean choose = true; 
    boolean exit = false;
    if(ans.equals("exit")){
      System.out.println("Thank you for playing.");
      exit = true;
      System.exit(0);
    }
    
    while(choose && !exit){
      ans = lookforcollege.nextLine();
      if(ans.equals("exit")){
        System.out.println("Thank you for playing.");
        System.exit(0);
      }
      while(ans.length()>1 || ans.length()<1){
        System.out.println("Please only type one number. Would you like to");
        System.out.println("Would you like to go to college for 4 or 6-8 years?");
        System.out.println("[1] $2000 4 years");
        System.out.println("[2] $5000 8-10 years");
        System.out.println("[3] I don't have the money");
      }
      if(ans.equals("1")){
        if(player.getMoney()<2001){
          System.out.println("You can't afford a college education.");
          System.out.println("Would you like to look for job that doesn't require going to college?");
          System.out.println("[1] Yes");
          System.out.println("[2] No");
          ans = lookforcollege.nextLine();
          if(ans.equals("1")){
            lookForJob(player);
            break;
          }
          if(ans.equals("2")){
            choose = false;
            break;
          }
          if(ans.equals("exit")){
            System.out.println("Thank you for playing.");
            System.exit(0);
          }
          else{
            System.out.println("Please type in one of the numbers in the options given");
          }

        }
        if(choose){
          System.out.println("Congradulations! You have just finished 4 years of college.");
          player.subtractmoney(2000);
          int newage= player.getAge()+4;
          player.setage(newage); 
          System.out.println("You are now " + newage + " years old.");
          System.out.println("Would you like to be:");
          System.out.println("[1] Software Developer");
          System.out.println("[2] Biology Teacher");
          while(ans.length()>1 || ans.length()<1){
            System.out.println("Please only type one number. Would you like to be:");
            System.out.println("[1] Software Developer");
            System.out.println("[2] Biology Teacher");
          }
          ans = lookforcollege.nextLine();
          if(ans.equals("1")){
            System.out.println("You now earn $350 per day as a Software Developer!");
            Jobs softwaredeveloper = new Jobs(350.00, 20, 8, "Software Developer");
            player.setjob(softwaredeveloper);
            choose = false;
          }
          if(ans.equals("2")){
            System.out.println("You now earn $250 per day as a Biology Teacher!");
            Jobs bioteacher = new Jobs(300.00,30,6,"Biology Teacher");
            player.setjob(bioteacher);
            choose = false;
          }
          if(ans.equals("exit")){
            System.out.println("Thank you for playing");
            System.exit(0);
          }
          else{
            System.out.println("Please type in one of the numbers in the options given");
          }
        }
      }
      
      else if(ans.equals("2")){
        if(player.getMoney()<5001){
          System.out.println("You can't afford 8-10 years of college education.");
          System.out.println("Would you like to look for job that doesn't require going to college?");
          System.out.println("[1] Yes");
          System.out.println("[2] No");
          System.out.println("[3] Try 4 years of college for $2000");
          ans = lookforcollege.nextLine();
          if(ans.equals("1")){
            lookForJob(player);
            break;
          }
          if(ans.equals("2")){
            choose = false;
          }
          if(ans.equals("exit")){
            System.out.println("Thank you for playing");
            System.exit(0);
          }
          if(ans.equals("3")){
            
            if(player.getMoney()<2001){
              System.out.println("You can't afford a college education.");
              System.out.println("Would you like to look for job that doesn't require going to college?");
              System.out.println("[1] Yes");
              System.out.println("[2] No");
              ans = lookforcollege.nextLine();
              if(ans.equals("1")){
                lookForJob(player);
                break;
              }
              if(ans.equals("2")){
                choose = false;
                break;
              }
              if(ans.equals("exit")){
                System.out.println("Thank you for playing.");
                System.exit(0);
              }
              else{
                System.out.println("Please type in one of the numbers in the options given");
              }
            }
            int newage= player.getAge()+4;
            System.out.println("Congradulations! You have just finished 4 years of college.");
            player.subtractmoney(2000);
            player.setage(newage);
            System.out.println("You are now " + newage + " years old.");
            System.out.println("Would you like to be:");
            System.out.println("[1] Software Developer");
            System.out.println("[2] Biology Teacher");
            while(ans.length()>1 || ans.length()<1){
              System.out.println("Please only type one number. Would you like to be:");
              System.out.println("[1] Software Developer");
              System.out.println("[2] Biology Teacher");
            }
            ans = lookforcollege.nextLine();
            if(ans.equals("1")){
              System.out.println("You now earn $350 per day as a Software Developer!");
              Jobs softwaredeveloper = new Jobs(350.00, 20, 8, "Software Developer");
              player.setjob(softwaredeveloper);
              choose = false;
            }
            if(ans.equals("2")){
                System.out.println("You now earn $250 per day as a Biology Teacher!");
                Jobs bioteacher = new Jobs(250.00,30,6,"Biology Teacher");
                player.setjob(bioteacher);
                choose = false;
            }
          }
          else{
            System.out.println("Please type in one of the numbers in the options given");
          }
        }
        if(choose){
          int rand = (int)(Math.random()*3)+8;
          for(int i=8;i<11;i++){
            if(i==rand){
              int newage = i+player.getAge();
              player.setage(newage);
              System.out.println("You are now " + newage + " years old.");
            }
          }
          System.out.println("Congradualtions! You have just finished " + rand + " years of college.");
          player.subtractmoney(5000);
          System.out.println("Would you like to be:");
          System.out.println("[1] Doctor");
          System.out.println("[2] Lawyer");
          while(ans.length()>1 || ans.length()<1){
            System.out.println("Please only type one number. Would you like to be:");
            System.out.println("[1] Doctor");
            System.out.println("[2] Lawyer");
          }
          ans = lookforcollege.nextLine();
          if(ans.equals("1")){
            System.out.println("You now earn $1000 per day");
            Jobs doctor = new Doctor(1000, 30, 7, "doctor", false);
            player.setjob(doctor);
            choose = false;
          }
          if(ans.equals("exit")){
            System.out.println("Thank you for playing");
            System.exit(0);
          }
          if(ans.equals("2")){
            System.out.println("You now earn $600 per day");
            Jobs lawyer = new Jobs(600, 20, 8, "lawyer");
            player.setjob(lawyer);
            choose = false;
          }
  
        }
      }
      else if(ans.equals("3")){
        System.out.println("Try to make enough money to get a college education.");
        choose=false;
      }

      else{
        if(choose = false){
          System.out.println("Please type in one of the numbers in the options given");
        }
      }
    
    }

    if(exit){
      System.out.println("Thank you for playing.");
      System.exit(0);
    }
    
    
  }
}







