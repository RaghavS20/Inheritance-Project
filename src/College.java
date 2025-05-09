public class College{
    private double cost;
    private int years;
    private String major;
    private boolean isIV;
    

    public College(double cost, int years, String major, boolean isIV){
      this.cost = cost;
      this.years = years;
      this.major = major;
      this.isIV = isIV;
    }
    
    public String getMajor(){
      return major;
    }
    
  }