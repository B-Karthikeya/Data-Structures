import java.util.*;
public class DoublyLinkedList {
    Node head ;
   
    public class Node {
        int data;
        Node prev = null;
        Node next  = null;
       
        public Node(int d )
        {
            this.data = d;
        }
    }
    public void display(){
        System.out.print("linked list : ");
        Node current = head;
        while(current!=null)
        {
            System.out.print(current.data+"-->");
            current = current.next;
        }
        System.out.print("null\n");
    }
   
    public int length(Node head){
        Node current = head;
        int i=0;
        while(current != null)
        {
            i++;
            current = current.next;
           
        }
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
            newnode.prev = ptr;
            ptr = ptr.next;
        }
        return head;
    }
   
    public void addElements(){
        Node ptr = head ;
        while(ptr.next != null)
        {
            ptr = ptr.next;
        }
        System.out.print("Enter the number of elements :");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0;i<n;i++)
        {
            System.out.print("Enter the element :");
            int d = scan.nextInt();
            Node newnode = new Node(d);
            ptr.next = newnode;
            newnode.prev = ptr;
            ptr = ptr.next;
        }
       
    }
   
    public void insertNode(){
        int l = length(head);
        System.out.print("Enter the index of elements :");
        Scanner scan = new Scanner(System.in);
        int ind = scan.nextInt();
        Node ptr = head;
        if (ind == 0){
        System.out.print("Enter the elements :");
        int element = scan.nextInt();
            Node newnode = new Node(element);
            head.prev = newnode;
            newnode.next = head;
            head = newnode;
        }
        else if (ind < l){
            System.out.print("Enter the elements :");
            int element = scan.nextInt();
            Node newnode = new Node(element);
            for (int i=0;i<ind-1;i++)
            {
                ptr = ptr.next;
            }
            ptr.next.prev = newnode;
            newnode.next =ptr.next;
            ptr.next = newnode;
            newnode.prev = ptr;
        }
       
        else if (ind == l)
        {
            System.out.print("Enter the elements :");
            int element = scan.nextInt();
            Node newnode = new Node(element);
            while(ptr.next !=null)
            {
                ptr = ptr.next;
            }
            ptr.next = newnode;
            newnode.prev = ptr;
        }
        else{
            System.out.println("list out of index");
        }
       
    }
   
    public void deleteNode()
    {
        int l = length(head);
        System.out.print("Enter the index of elements :");
        Scanner scan = new Scanner(System.in);
        int ind = scan.nextInt();
        Node ptr = head;
        if (ind == 0){
            head = head.next;
            head.prev = null;
            ptr = null;
        }
        else if (ind < l-1){
            for (int i=0;i<ind-1;i++)
            {
                ptr = ptr.next;
            }
            Node del = ptr.next;
            ptr.next = ptr.next.next;
            ptr.next.prev = ptr;
            del = null;
        }
        else  if(ind == l-1){
            while(ptr.next.next != null){
                ptr = ptr.next;
            }
            Node del = ptr.next;
            del = null;
            ptr.next = null;
        }
        else{
            System.out.println("list out of index");
        }
       
    }

    public void reverseList(){
        Node temp = null;
        Node current = head;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
 
        if (temp != null) {
            head = temp.prev;
        }
    }

    public void midElement(){
        Node slowptr=head,fastptr=head;
        int i = 0;
        while(fastptr != null && fastptr.next != null){
            slowptr = slowptr.next;
            fastptr = fastptr.next.next;
            i++;
        }
        System.out.println("mid element :"+slowptr.data + "\tindex : "+i);
    }
    public void nthNodeFromEnd(){
        Node refptr = head,mainptr = head;
        System.out.print("Enter the index from end :");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i = 0;i<n;i++){
            refptr = refptr.next;
        }
        while(refptr!=null){
            refptr = refptr.next;
            mainptr = mainptr.next;
        }
        System.out.println(n+"th element from end : "+mainptr.data);
    }
    public void find(){
        Node ptr = head ;
        System.out.print("Enter the element to find :");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        boolean find = false;
        int i = 0;
        while (ptr!=null && i<50)
        {
            if (ptr.data == n){
                find = true;
                break;
            }
            i++;
            ptr = ptr.next;
            }
            if (find){
                System.out.println("element found at index :"+i);
            }
            else {
                System.out.println("Element not found");
            }
        }

        public void removeElement(){
        Node ptr = head ;
        System.out.print("Enter the element to delete :");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        boolean remove = false;
        while(ptr!=null){
            if(ptr.data == n)
            {
                Node remnode = ptr;
                ptr.prev.next = ptr.next;
                remnode = null;
                remove = true;
                break;
            }
            ptr = ptr.next;
        }
        if (remove){
            System.out.println("element removed succesfully");
        }
        else {
            System.out.println("Element not found");
        }
    }
    
   
public static void main(String[] args) {
    DoublyLinkedList dll = new DoublyLinkedList();
    System.out.print("OPERATIONAL CODES :\n1 : create new list\n2 : display list\n3 : length of the list\n4 : add elements to the list\n5 : insert node\n6 : delete node\n7 : reverse list \n8 : mid element \n9 : find nth node from end\n10 : find element \n11 : remove element\n0 : EXIT  \n");
    System.out.print("Enter the operational code :");
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();

        while(n!=0){
            switch(n){
                case 1 : dll.head = dll.createList();break;
                case 2 : dll.display();break;
                case 3 : System.out.println("length of the list = "+dll.length(dll.head));break;
                case 4 : dll.addElements();break;
                case 5 : dll.insertNode();break;
                case 6 : dll.deleteNode();break;
                case 7 : dll.reverseList();break;
                case 8 : dll.midElement();break;
                case 9 : dll.nthNodeFromEnd();break;
                case 10 : dll.find();break;
                case 11 : dll.removeElement();break;
                default : System.out.println("operational code not found");break;
            }

            System.out.print("Enter the operational code :");
            n = scan.nextInt();
        }
   
}
}


