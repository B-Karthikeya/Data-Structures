import java.util.*;
public class BFS {
    int[][] graph;
    int nodes;
    Listnode front;
    Listnode rear;
    BFS(int n ){
        this.graph = new int[n][n];
        this.nodes = n;
        this.front = null;
        this.rear = null;
    }

    public class Listnode{
        int data ;
        Listnode next;
        Listnode(int d ){
            this.data = d;
            this.next = null;
        }
    }

    public void enqueue(int v){
        if(front == null){
            rear = new Listnode(v);
            front = rear;
        }
        else {
            Listnode node = new Listnode(v);
            rear.next = node;
            rear = rear.next;
        }

    }

    public int dequeue(){
        int res = -1;
        if(front == null){
            rear = null;
            System.out.println("Queue is Empty");
        }
        else{
            res = front.data;
            front = front.next;
        }
        return res;
    }
    public boolean isEmpty(){
        return front == null;
    }

    public int peek(){
        return front.data;
    }

    public void addEdge(int u , int v){
        graph[u][v] = 1 ;
        graph[v][u] = 1 ;

    }

    public void display(){
        System.out.println("\nGRAPH :");
        for(int i = 0 ;i< nodes ;i++){
            for(int j = 0 ;j<nodes;j++){
                System.out.print(graph[i][j]+ "\t");
            }
            System.out.println();
        }
    }

    public void breadthFirstSearch(){
        System.out.print("BREADTH FIRST SEARCH :");
        int[] visited = new int[nodes];
        visited[0] = 1 ;
        enqueue(0);
        while(!isEmpty())
        {
            int p = dequeue();
            for(int i = 0 ;i<nodes;i++){
                if(graph[p][i] > 0 && visited[i] == 0 ){
                    System.out.print("(" + p + "," + i +")"+ "\t");
                    enqueue(i);
                
                    visited[i] = 1 ;
                }
            }

        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("enter no of vertices  : ");
        int nodes = in.nextInt();
        BFS bfs = new BFS(nodes);
        System.out.print("enter no of edges  : ");
        int n = in.nextInt();
        String str ;
        String[] edges;
        for(int i = 0 ; i<n ; i++ ){
            System.out.print("enter the edge " + i + " :");
            str = in.next();
            edges = str.split(",", 2);
            int u = Integer.parseInt(edges[0]);
            int v = Integer.parseInt(edges[1]);
            bfs.addEdge(u,v);
        }

        bfs.breadthFirstSearch();
        bfs.display();
    }
}
