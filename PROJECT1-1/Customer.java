public class Customer implements Comparable<Customer>{
  String phoneNumber;
  String fname;
  String lname;
  Movies[] owned;
  int movieCount;


  public Customer(String phoneNumber, String fname, String lname){
    this.phoneNumber = phoneNumber;
    this.fname = fname;
    this.lname = lname;
    this.owned = new Movies[4];
    this.movieCount = 0;
  }

  public int compareTo(Customer other){
    return this.phoneNumber.compareTo(other.phoneNumber);
  }

  public String toString() {
    return phoneNumber + " " + fname + " " + lname;
  }

  public String getPhoneNumber(){
    return phoneNumber;
  }

  //testing stuff
  public Movies getOwned(int i){
   return owned[i];
  }
}