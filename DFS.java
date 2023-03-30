import java.util.*;
public class DFS {
    int[] stack;
    int top;
    int nodes;
    int[][] graph;
    DFS(int n ){
        this.top = -1;
        this.nodes = n;
        this.stack = new int[2*n];
        this.graph = new int[n][n];
    }


    public void push(int x){
        top++;
        stack[top] = x;
    }

    public int pop(){
        int x = stack[top];
        top--;
        return x;
    }

    public boolean isEmpty(){
        return top == -1;
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

    public void depthFirstSearch(){
        System.out.println("\nDEPTH FIRST SEARCH : ");
        int[] visited = new int[nodes];
        push(0);
        visited[0] = 1;
        while(!isEmpty()){
            int p = pop();
            visited[p] = 1 ;
            for(int i =0;i<nodes;i++){
                if(graph[p][i] > 0 && visited[i] == 0){
                    push(i);
                    System.out.print("(" + p + "," + i +")"+ "\t");
                    // visited[i] = 1;
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("enter no of vertices  : ");
        int nodes = in.nextInt();
        DFS dfs = new DFS(nodes);
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
            dfs.addEdge(u,v);
        }

        dfs.depthFirstSearch();
        dfs.display();
    }
}
