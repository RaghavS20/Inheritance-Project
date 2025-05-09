public class Doctor extends Jobs{
    
    private boolean emergency;

    public Doctor(double salary, int stress, int hours, String name, boolean emergency){
        super(salary,stress,hours,name);
        this.emergency = emergency;
    }

    public void goToWork(Player player){
        //this method will have the player go to work
        int rand = (int)(Math.random()*10+1);
        if(rand<3){
            emergency = true;
        }
        if(emergency==true){
            System.out.println("Emergency!!!!");
            savepatient();
        }
        player.addmoney(player.getJob().getSalary());
        System.out.println("Your new salary is: " + player.getJob().getSalary());
        System.out.println("Your total money is " + player.getMoney()+ " after today's work.");
        System.out.println("Your fatigue from work increased your stress by " + player.getJob().getStress());
        player.applyStress(player.getJob().getStress());
    }
    public boolean getemergency(){
        return emergency;
    }

    public void savepatient(){
        int rand = (int) (Math.random()*10 + 1);
        if(rand<4){
            System.out.println("You saved a patient!");
            System.out.println("Your salary is raised by $100!");
            salary += 100;
        }
        else{
            System.out.println("You failed to save a patient");
            System.out.println("Your salary is reduced by $100");
            salary-=100;
        }
    }

    //try overriding this method
    public void workHard(){
        preformance += 10;
        if(preformance >= 100){
          System.out.println("You get a raise by 3%");
          salary += (salary/100) * 3;
          preformance = 20;
        }
      }
}
