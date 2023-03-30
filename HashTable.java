import java.util.*;

public class HashTable {
    private HashNode[] buckets;
    private int numOfBuckets;
    private int size;

    private HashTable(int capacity){
        this.numOfBuckets = capacity;
        buckets = new HashNode[capacity];
    }

    public class HashNode{
        private int key;
        private String value;
        private HashNode next;

        HashNode(int key , String value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public int getBucketIndex(int key){
        return key%numOfBuckets;
    }

    public void put(int key , String value){
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];

        while(head != null){
            if(head.key == key){
                head.value = value;
                return ;
            }
            head = head.next;
        }
        size++;

        head = buckets[bucketIndex];

        HashNode node = new HashNode(key, value);
        node.next = head;
        buckets[bucketIndex] = node;
    }

    public void displayHashTable(){
        System.out.println("HASH TABLE : ");
        for(int i = 0 ;i<numOfBuckets;i++){
            System.out.print(i + "=> ");
            HashNode head = buckets[i];
            while(head != null ) {
                System.out.print("(" + head.key + "," + head.value + ")" + "->");
                head = head.next;
            }
            System.out.println();
        }
    }

    public String get(int key){
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];

        while(head!=null){
            if(head.key == key){
                System.out.println("key : "+ head.key + ", value : " + head.value);
                return head.value;
            }
            head = head.next;
        }

        System.out.println("key not found");
        return null;
    }

    public String remove(int key){
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        HashNode previous = null;
        
        while(head != null){
            if(head.key == key) break;
            previous = head;
            head = head.next;
        }

        if(head == null) return null;
        size--;
        if(previous != null) previous.next = head.next;
        else buckets[bucketIndex] = head.next;
        return head.value;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("enter the capacity of hashTable : ");
        int capacity = in.nextInt();
        HashTable tb = new HashTable(capacity);

        System.out.print("enter the no of key-pair values : ");
        int n = in.nextInt();

        for(int i = 0 ;i<n;i++){
            System.out.print("enter the key : ");
        int key = in.nextInt();
        System.out.print("enter the value : ");
        String value = in.next();
        tb.put(key,value);
        }

        tb.displayHashTable();
        System.out.print("enter the key to delete : ");
        n = in.nextInt();
        tb.remove(n);
        tb.displayHashTable();

    }
    
}
