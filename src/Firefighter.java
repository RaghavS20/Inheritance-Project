public class Firefighter extends Jobs {
    private boolean isfire;

    public Firefighter(double salary, int stress, int hours, String name, boolean isfire){
        super(salary,stress,hours,name);
        this.isfire = isfire;
    }

    public boolean getisfire(){
        return isfire;
    }
    public void savehouse(){
        int rand = (int) (Math.random()*10 + 1);
        if(rand<4){
            System.out.println("You saved people from the burning house!");
            System.out.println("Your salary is raised by $100!");
            salary += 100;
        }
        else{
            System.out.println("You failed to put out the burning house and save the people");
            System.out.println("Your salary is reduced by $100");
            salary-=100;
        }
    }

    public void goToWork(Player player){
        //this method will have the player go to work
        int rand = (int)(Math.random()*10+1);
        if(rand<3){
          isfire = true;
        }
        if(isfire){
            System.out.println("fire!");
            savehouse();
        }
        player.addmoney(player.getJob().getSalary());
        System.out.println("Your new salary is: " + player.getJob().getSalary());
        System.out.println("Your total money is " + player.getMoney()+ " after today's work.");
        System.out.println("Your fatigue from work increased your stress by " + player.getJob().getStress());
        player.applyStress(player.getJob().getStress());
    }
}
