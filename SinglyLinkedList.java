import java.util.*;
public class SinglyLinkedList{
    private ListNode head ;

    public static class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int d)
        {
            this.data = d;
            this.next = null;
        }
    }

    public void display(){
        System.out.print("linked list : ");
        ListNode current = head;
        while(current!=null)
        {
            System.out.print(current.data+"-->");
            current = current.next;
        }
        System.out.print("null\n");
    }
    public int length(ListNode head){
        int i=0;
        while(head!=null)
        {
            i++;
            head = head.next;
        }
        return i;
    }
    public ListNode createList(){
            System.out.print("enter the no of elements :");
            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();
            System.out.print("enter the element :");
            int d = scan.nextInt();
            ListNode head = new ListNode(d);
            ListNode ptr = head;
            for(int i =0 ;i<n-1;i++)
            {
                System.out.print("enter the element :");
                int k = scan.nextInt();
                ListNode node = new ListNode(k);
                ptr.next = node ;
                ptr = ptr.next;
            }
            return head;
        }

    public ListNode insertNode(ListNode head)
    {
        int l = length(head);
        System.out.print("Enter the index :");
        Scanner scan = new Scanner(System.in);
        int ind = scan.nextInt();
        System.out.print("Enter the element :");
        int element = scan.nextInt();

        if(ind == 0 ){
            ListNode node = new ListNode(element);
            node.next = head;
            return node;
        }
        else if (ind<l){
            ListNode ptr = head;
            for (int i=0;i<ind-1;i++)
            {
                ptr = ptr.next;
            }
            ListNode node = new ListNode(element);
            node.next = ptr.next;
            ptr.next = node;
            return head;
        }
        else if(ind == l){
            ListNode ptr = head;
            while(ptr.next != null)
            {
                ptr = ptr.next;
            }
            ListNode node = new ListNode(element);
            ptr.next = node;
            return head;
        }   
    else {
        System.out.println("cannot insert at given index");
        return head;
    }

    }

    public ListNode deleteNode(ListNode head){
        int l = length(head);
        System.out.print("Enter the index :");
        Scanner scan = new Scanner(System.in);
        int ind = scan.nextInt();
        

        if (ind == 0)
        {
            ListNode node = head.next;
            head = null;
            return node;
        }
        else if(ind<l-1){
            ListNode ptr1=head,ptr2 = head.next;
            for(int i =0;i<ind-1;i++)
            {
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
            ptr1.next=ptr2.next;
            ptr2=null;
            return head;
        }
        else if(ind==l-1)
        {
            ListNode ptr1=head,ptr2 = head.next;
            while(ptr2.next != null){
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
            ptr1.next = null;
            ptr2 = null;
            return head;
        }
        else {
            System.out.println("Element do not exist at specified index");
            return head;
        }
    }

    public ListNode reverseList(ListNode head){
        ListNode prev = null,current = head,nextnode = head.next;
        while (nextnode != null){
            nextnode = nextnode.next;
            current.next = prev;
            prev = current;
            current = nextnode;
        }
        return prev;
    }
    
    
    public static void main(String [] args)
    {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = sll.createList();
        sll.display();
        // sll.head = sll.insertNode(sll.head);
        // sll.display();
        // sll.head = sll.deleteNode(sll.head);
        // sll.display();
        sll.deleteNode(sll.head);
        System.out.print("elements after deletion :");
        sll.display();
        sll.head = sll.reverseList(sll.head);
        sll.display();
        System.out.println("length of the linked list = "+sll.length(sll.head));
        


    
    }
}