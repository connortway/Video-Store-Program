public class Movies implements Comparable<Movies>{
  String barCode;
  String title;
  Customer owner;
  boolean avaliable;


  public Movies(String barCode, String title){
    this.barCode = barCode;
    this.title = title;
    this.owner = null;
    this.avaliable = true;
  }

  

  public int compareTo(Movies other) {
      return this.title.compareToIgnoreCase(other.title);
  }


  public String toString(){
    return barCode + " " + title;
  }

  public String getTitle(){
    return title;
  }

  public String getBarCode(){
    return barCode;
  }
  //testing stuff
  public Customer getCustomer(){
    return owner;

  }
}