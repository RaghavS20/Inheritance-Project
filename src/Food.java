public class Food{
  private int value;
  private String name;
  
  public Food(String name, int value){
    this.value = value;
    this.name = name;
  }
  
  public int getValue(){
    return value;
  }
  
  public String getName(){
    return name;
  }
}