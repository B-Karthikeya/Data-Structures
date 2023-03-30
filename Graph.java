import java.util.*;

public class Graph {
    int[][] adjMatrix;
    int nodes;
    Graph(int nodes){
        this.adjMatrix = new int[nodes][nodes];
        this.nodes = nodes;
    }

    public void addEdge(int u , int v){
        adjMatrix[u][v] = 1 ;
        adjMatrix[v][u] = 1 ;

    }

    public void display(){
        System.out.println("GRAPH :");
        for(int i = 0 ;i< nodes ;i++){
            for(int j = 0 ;j<nodes;j++){
                System.out.print(adjMatrix[i][j]+ "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] main){
        Scanner in = new Scanner(System.in);
        System.out.print("enter the no of nodes : ");
        int n = in.nextInt();
        Graph g = new Graph(n);

        System.out.print("enter the no of edges :");
        n = in.nextInt();
        String str ;
        String[] edges;

        for(int i = 0 ;i<n;i++){
            System.out.print("enter the edge " + i + " :");
            str = in.next();
            edges = str.split(",", 2);
            int u = Integer.parseInt(edges[0]);
            int v = Integer.parseInt(edges[1]);
            g.addEdge(u,v);
        }

        g.display();
        g.breadthFirstSearch();
    }
}
