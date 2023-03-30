import java.util.*;
public class AVLTree {
    TreeNode root = null;
    List front = null;
    List rear = null;
    public class TreeNode{
        int data;
        int height;
        TreeNode left;
        TreeNode right;

        TreeNode(int n){
            this.data = n;
            this.height = 1;
            this.left = null;
            this.right = null;
        }
    }
    public class List{
        TreeNode node;
        List next;

        List(TreeNode node){
            this.node = node;
            this.next = null;
        }
    }

    int getHeight(TreeNode node){
        if(node == null) return 0;
        return node.height;
    }

    int max(int a , int b){
        return ((a>b)?a:b) ;
    }

    TreeNode rightRotate(TreeNode y){
    TreeNode x = y.left;
    TreeNode t2 = x.right;

    x.right = y;
    y.left = t2;

    y.height = max(getHeight(y.left), getHeight(y.right)) + 1;
    x.height = max(getHeight(x.left), getHeight(x.right)) + 1;

    return x;
    }

    TreeNode leftRotate(TreeNode x){
        TreeNode y = x.right;
        TreeNode t2 = y.left;

        y.left = x;
        x.right = t2;

        y.height = max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = max(getHeight(x.left), getHeight(x.right)) + 1;

    return y;
    }

    int getBalance(TreeNode N){
        if(N == null) return 0 ;
        return getHeight(N.left) - getHeight(N.right);
    }

    TreeNode insert(TreeNode node , int key){
        if(node == null)  return (new TreeNode(key));
        if(key < node.data) node.left = insert(node.left, key);
        else if(key > node.data) node.right  = insert(node.right, key);
        else 
        {System.out.println(key + " element already exists in tree");
        return node;
        }   

        node.height = 1 + max(getHeight(node.left),getHeight(node.right));
        int balance = getBalance(node);

        if(balance > 1 && key < node.left.data) return rightRotate(node);

        if(balance > 1 && key > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if(balance < -1 && key > node.right.data) return leftRotate(node);

        if(balance < -1 && key < node.right.data){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;

    }

    public void preOrder(TreeNode root){
        if(root == null) return ;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public void postOrder(TreeNode root){
        if(root == null) return ;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
    public void inOrder(TreeNode root){
        if(root == null) return ;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void displayTree2(TreeNode root){
        System.out.print("BINARY TREE : ");
        front = rear = new List(root);
        while(front != null){
            System.out.print(front.node.data + " ");
            if(front.node.left != null) {
                rear.next = new List(front.node.left);
                rear = rear.next;
            }
            else System.out.print(" NULL ");
            if(front.node.right != null) {
                rear.next = new List(front.node.right);
                rear = rear.next;
            }
            else System.out.print(" NULL ");
            front = front.next;
        }
    
    }

    public static void main(String[] args){
        AVLTree avl = new AVLTree();

        Scanner in = new Scanner(System.in);
        // System.out.print("\nEnter the elements levle wise\n-1 -> to STOP\n");
        int element ;
        System.out.print("Enter the element :");
        element = in.nextInt();
        while(element != -1){
            avl.root = avl.insert(avl.root,element);
            System.out.print("Enter the element :");
        element = in.nextInt();
    }

    System.out.print("\npre order : ");
    avl.preOrder(avl.root);
    System.out.print("\npost order : ");
    avl.postOrder(avl.root);
    System.out.print("\nin order : ");
    avl.inOrder(avl.root);
    avl.displayTree2(avl.root);


}
}
