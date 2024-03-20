class BinaryTree<T extends Comparable<T>>{
  Node<T> root;

  public BinaryTree(){
    this.root = null;
  }

 
    public void insert(T data){
    Node<T> newNode = new Node<>(data);

    if (root == null) {
      root = newNode;
      return;
    }

    Node<T> current = root;
    while (true) {
      //should we go left?
      if (data.compareTo(current.data) <= 0) {
       //yes, but doest it end there?
        if (current.left == null){
          current.left = newNode;
          return;
        }
        current = current.left;
      }
      //go right
      else {
        //is the right a dead end?
        if (current.right == null){
          current.right = newNode;
          return;
        }
          current = current.right;
      }

    }//end while

  }
    public Node find(T search){
      return find(root,search);

  }

  private Node find(Node<T> current, T search){
      if(current == null || current.data.equals(search)){
        return current;
      }

      if(search.compareTo(current.data) < 0){
        return find(current.left, search);
      }else{
        return find(current.right, search);
      }
  }



  public void printInOrder(){
    printInOrder(root);
  }

  public void printInOrder(Node<T> n){
    if (n == null) return;
    printInOrder(n.left);
    System.out.println(n.data);
    printInOrder(n.right);
  }
  
 
  public Node findMin(Node<T> n){
    if (n.left == null) return n;
    return findMin(n.left);   
  }

 
  public void remove(T data) {
    Node<T> removing = new Node<T>(data);
    this.root = remove(this.root, removing);
  }

  public Node remove(Node<T> current, Node<T> removing){
    if (removing.data.compareTo(current.data) < 0){
      current.left = remove(current.left, removing);
    }
    else if (removing.data.compareTo(current.data) > 0) {
      current.right = remove(current.right, removing);
    } else{
      // 2 children
      if (current.left != null && current.right != null){
        Node<T> min = findMin(current.right);
        current.data = min.data;
        current.right = remove(current.right, min);
      }
        //1 left child
      else if (current.left != null){
        current = current.left;
      }
        //1 right child
      else if (current.right != null){
        current = current.right;
      }
        //no children
      else {
        current = null;
      }
    }

    return current;
  }

  public T findPhoneNumber(String phoneNumber) {
      return findPhoneNumber(root, phoneNumber);
  }

  private T findPhoneNumber(Node<T> root, String phoneNumber) {
      if (root == null || ((Customer) root.data).getPhoneNumber().equals(phoneNumber)) {
          return (root != null) ? root.data : null;
      }

      int comparison = phoneNumber.compareTo(((Customer) root.data).getPhoneNumber());

      if (comparison < 0) {
          return findPhoneNumber(root.left, phoneNumber);
      } else {
          return findPhoneNumber(root.right, phoneNumber);
      }
  }

  public T findTitle(String title) {
      return findTitle(root, title);
  }

  private T findTitle(Node<T> root, String title) {
      if (root == null || ((Movies) root.data).getTitle().equals(title)) {
          return (root != null) ? root.data : null;
      }

      int comparison = title.compareTo(((Movies) root.data).getTitle());

      if (comparison < 0) {
          return findTitle(root.left, title);
      } else {
          return findTitle(root.right, title);
      }
  }
  

}