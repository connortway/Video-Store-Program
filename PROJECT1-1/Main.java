import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    BinaryTree<Customer> ct = new BinaryTree<>();

    ct.insert(new Customer("9145336697", "Jonnie", "Appleseed"));
    ct.insert(new Customer("9145336698", "Jonnie", "Appleseed"));
    ct.insert(new Customer("9145336699", "Jonnie", "Appleseed"));
    ct.insert(new Customer("9145336691", "Jonnie", "Appleseed"));
    ct.insert(new Customer("9145336692", "Jonnie", "Appleseed"));

    BinaryTree<Movies> mt = new BinaryTree<>();
    mt.insert(new Movies("086162113031", "Star Wars"));
    mt.insert(new Movies("086162113032", "Clone Wars"));
    mt.insert(new Movies("086162113033", "Luke Wars"));
    mt.insert(new Movies("086162113034", "The Wars"));

    //ct.printInOrder();
    //mt.printInOrder();

    Scanner scanner = new Scanner(System.in);

    while(true){
      System.out.println("1. Rent a movie.");
      System.out.println("2. Return movie.");
      System.out.println("3. Lookup movie by title.");
      System.out.println("4. Make an account");
      System.out.println("5. Exit");
      System.out.println("6. Add a Video");
      System.out.println("Enter your choice:");
      

      int choice = scanner.nextInt();
      scanner.nextLine();
     

      switch (choice) {
        case 1:
          rentMovie(ct, mt, scanner);
          break;
        case 2:
          returnMovie(ct, mt, scanner);
          break;
        case 3:
          lookupMovieByTitle(mt, scanner);
          break;
        case 4:
          makeAccount(ct, scanner);
          break;
        case 5:
          System.out.println("Exiting...");
          scanner.close();
          System.exit(0);
          break;
        case 6:
          addMovie(mt, scanner);
          System.out.println("Movie added");
          break;
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    }
  }

      private static void rentMovie(BinaryTree<Customer> ct, BinaryTree<Movies> mt, Scanner scanner) {
        System.out.print("Enter your phone number: ");
        String phoneNumber = scanner.nextLine();
        Customer customerNode =(Customer) ct.findPhoneNumber(phoneNumber);
    
        if (customerNode != null) {
          Customer customer = customerNode;
          if (customer.movieCount < 3){
            
              System.out.print("Enter the title of the movie you want to rent: ");
              String title = scanner.nextLine();
              Movies movieNode = (Movies) mt.findTitle(title);
    
              if (movieNode != null) {
                Movies movie = movieNode;
                movie.owner = customer;
                movie.avaliable = false;
                customer.movieCount++;
                customer.owned[customer.movieCount] = movie;
                
                
                System.out.println("Movie rented successfully!");
              } else{
                System.out.println("Movie not avaliable");
              }
                
            } else {
              System.out.println("Customer has more that 3 movies out. Return some before renting more");
            }
        } else {
          System.out.println("Customer not found, Create a new account");
        }
    } 
    


  private static void returnMovie(BinaryTree<Customer> ct, BinaryTree<Movies> mt, Scanner scanner) {
    System.out.print("Enter your phone number: ");
    String phoneNumber = scanner.nextLine();
    Customer customerNode =(Customer) ct.findPhoneNumber(phoneNumber);

    if(customerNode != null){
      Customer customer = customerNode;
      System.out.println("What movie is being returned");
     
      String movieTitle = scanner.nextLine();
      Movies movieNode = (Movies) mt.findTitle(movieTitle);
      Movies movie = movieNode;
      if (movie.avaliable == false){
        customer.owned[customer.movieCount] = null;
        customer.movieCount--;
        movie.owner = null;
        movie.avaliable = true;
        System.out.println("Movie returned");
      }else{
        System.out.println("Customer Doesnt own this movie");
      }
    
    }else{
      System.out.println("Customer not found.");
      
    }
  }

  private static void lookupMovieByTitle(BinaryTree<Movies> mt,  Scanner scanner) {
    System.out.println("Enter the title of the movie:");
    
    String title = scanner.nextLine();
    Movies movieNode = (Movies) mt.findTitle(title);
    Movies movie = movieNode;
    System.out.println("Movie owner: " + movie.owner);

    
  }

  private static void makeAccount(BinaryTree<Customer> ct, Scanner scanner) {
    System.out.println("Enter your phone number:");
    String phoneNumber = scanner.nextLine();
    Node<Customer> customerNode = ct.find(new Customer(phoneNumber, "", ""));
    System.out.println("Found customer: " + customerNode);
    
      if(customerNode == null){
        System.out.println("Enter your first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter your last name:");
        String lastName = scanner.nextLine();

        Customer newCustomer = new Customer(phoneNumber, firstName, lastName);
        ct.insert(newCustomer);
        System.out.println("Account created successfully!");
      }
  }

  public static void addMovie(BinaryTree<Movies> mt, Scanner scanner){
    System.out.println("Enter barcode");
    String barCode = scanner.nextLine();
    System.out.println("Enter Title");
    String title = scanner.nextLine();
    mt.insert(new Movies(barCode, title));
  }
}