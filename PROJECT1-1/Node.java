public class Node<T>{
  public T data;
  public Node<T> next;
  public Node<T> left;
  public Node<T> right;

   public Node(T data){
    this.data = data;
    this.next = null;
    this.left = null;
    this.right = null;
  }
}