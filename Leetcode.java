import java.util.*;
public class Leetcode {
    
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
    public void reorderList() {
        ListNode ptr = head.next ;
        ListNode tail = new ListNode(head.data);
        while(ptr!= null)
        {
            ListNode node = new ListNode(ptr.data);
            node.next = tail;
            tail = node ;
            ptr = ptr.next;
        }
        ptr = head.next.next;
        ListNode res = new ListNode(0);
        ListNode ans = res;
        while(ptr!=null && ptr.next != null){
            res.next = head;
            head = head.next;
            res = res.next;
            res.next = tail;
            tail = tail.next;
            res = res.next;
            ptr = ptr.next.next;
        }
        if(ptr == null) 
        {
            res.next = head;
            res = res.next;
            res.next = tail;
            res = res.next;
            res.next = null;
        }
        else {
            res.next = head;
            head = head.next;
            res = res.next;
            res.next = tail;
            tail = tail.next;
            res = res.next;
            res.next = head;
            res = res.next;
            res.next = null;
        }
        head = ans.next;
        
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

        public static void main(String [] args){
            Leetcode sll = new Leetcode();
            sll.head = sll.createList();
            sll.reorderList();
            sll.display();
        }
    }

