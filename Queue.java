import java.util.Scanner;
public class Queue{
    Node front = null ;
    Node rear = null ;
    int length = 0;
    public class Node{
        int data;
        Node next;

        Node (int n)
        {
            this.data = n;
            this.next = null;
        }
    }

    public void enqueue(){
        System.out.print("Enter the element :");
            Scanner in = new Scanner(System.in);
            int element = in.nextInt();
            Node temp = new Node(element);

        if(rear == null){
            rear = temp;
            front = temp;
            length++;
        }
        else{
            rear.next = temp;
            rear = rear.next;
            length++;
        }
    }
    public int dequeue(){
        int a=-1;
        if(front == null) System.out.println("QUEUE IS EMPTY");
        else{
            a = front.data;
            front = front.next;
            if(front == null) rear = null;
            length--;
            System.out.println("dequeued element :"+a);
        }
        return a ;
    }
    public void display(){
        if(front == null) System.out.println("QUEUE IS EMPTY");
    else{
        Node temp = front;
        System.out.print("QUEUE : ");
        while(temp!= null) {
            System.out.print(temp.data + "\t");
            temp = temp.next;
        }
        System.out.println();
    }
    }
    public void getLength(){
        System.out.println("Length of queue : "+length);
    }

    public static void main(String[] args){
        Queue q = new Queue();
        System.out.print("OPERATIONAL CODES : \n1-ENQUEUE\n2-DEQUEUE\n3-DISPLAY\n4-LENGTH\n0-EXIT\n");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the operational code :");
        int choice = in.nextInt();
        while(choice!=0){
            // System.out.println("enter of while loop");
            switch(choice){
                case 1 : q.enqueue(); break;
                case 2 : q.dequeue();break;
                case 3 : q.display();break;
                case 4 : q.getLength();break;
            }
            // Scanner in = new Scanner(System.in);
        System.out.print("Enter the operational code :");
        choice = in.nextInt();

        }
        
    }

}