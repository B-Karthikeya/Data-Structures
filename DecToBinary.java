import java.util.*;
public class DecToBinary {
    class Node{
        String num;
        Node next;

        Node (String x){
            this.num = x;
            this.next = null;
        }
    }
    Node front = null;
    Node rear = null;

    public void enqueue(String str){
        Node temp = new Node(str);
        if(rear == null){
            rear = temp;
            front = temp;
        }
        else {
            rear.next =temp;
            rear = temp;
        }
    }

    public String deqeue(){
        String str ;
        if(front == null) return "-1";
        else
        {
            str = front.num;
            front = front.next;
            if(front == null) rear = null;
        }
        return str;
    } 

    public void convertBinary(int n){
        System.out.print("Binary numbers : \n0 -> 0\n");
        enqueue("1");
        for(int i =1;i<=n;i++){
            String k = deqeue();
            System.out.print(i + "->"+k +"\n");
            enqueue(k+"0");
            enqueue(k+"1");
        }

    }

    public static void main(String[] args){
        DecToBinary l = new DecToBinary();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = in.nextInt();
                l.convertBinary(n);
    }
    
}
