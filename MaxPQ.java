import java.util.*;
public class MaxPQ {
    Integer[] heap;
    int n ;
    public MaxPQ(int capacity){
        heap = new Integer[capacity+1];
        n = 0;
    }
    public boolean isEmpty(){
        return n == 0;
    }

    public int size(){
        return n;
    }

    public void insert(int x ){
        if(n == heap.length -1) resize(2*heap.length);
        n++;
        heap[n] = x ;
        swim(n);
    }

    public void swim(int k ){
        while(k>1 && heap[k/2] < heap[k]){
            int temp = heap[k];
            heap[k] = heap[k/2];
            heap[k/2] = temp;
            k=k/2;
        }
    }

    public int deleteMax(){
        int max = heap[1];
        swap(1,n);
        n--;
        sink(1);
        heap[n+1] = null;
        if(n>0 && (n == (heap.length -1)/4)){
            resize(heap.length/2);
        }
        return max;
    }
    
    public void swap(int a , int b ){
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    private void sink(int k){
        while(2*k <= n){
            int j = 2*k;
            if(j < n && heap[j] < heap[j+1]){
                j++;
            }

            if(heap[k] >= heap[j]) break;

            swap(k,j);
        k = j;
        }
    }
    public void display(){
        System.out.print("elements : ");
        for(int i = 1 ;i<= n;i++){
            System.out.print(heap[i] + ",");
        }
    }

    private void resize(int n) {
        // int[] res = new int[n];
        heap = Arrays.copyOf(heap,n);
    }

    public static void main(String[] args){
        System.out.print("enter the capacity :");
        Scanner in = new Scanner(System.in);
        int cap = in.nextInt();
        MaxPQ pq = new MaxPQ(cap);
        System.out.print("enter the element :");
        int element = in.nextInt();

        while(element != -1){
            pq.insert(element);
            System.out.print("enter the element :");
            element = in.nextInt();
        }
        pq.display();
        
        pq.deleteMax();
        pq.deleteMax();
        pq.deleteMax();
        
        pq.display();
    }
}
