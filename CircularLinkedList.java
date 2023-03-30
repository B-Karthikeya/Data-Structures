import java.util.*;
public class CircularLinkedList {
    
    Node head = null ;
    public class  Node{
        int data ;
        Node next = null;
    
        public Node(int d )
        {
            this.data = d;
        }
    
    }
    public void display(){
        System.out.print("linked list : ");
        Node current = head;
        do{
            System.out.print(current.data+"-->");
            current = current.next;
        }
        
        while(current!=head);

        System.out.print("head\n");
    }

    public int length(){
        Node current = head;
        int i=0;
        do{
            i++;
            current = current.next;
        }
        while(current!=head);
        return i;
    }

    public Node createList(){
        System.out.print("Enter the number of elements :");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.print("enter the element :");
        int k = scan.nextInt();
            Node head = new Node(k);
            Node ptr = head;
        for (int i = 0;i<n-1;i++)
        {
            System.out.print("Enter the element :");
            int d = scan.nextInt();
            Node newnode = new Node(d);
            ptr.next = newnode;
            ptr = ptr.next;
        }
        ptr.next = head;
        return head;
    }
public static void main(String[] args) {
    CircularLinkedList cll = new CircularLinkedList();
    cll.head = cll.createList();
    cll.display();
    System.out.println("length of the list = "+cll.length());


}
}

