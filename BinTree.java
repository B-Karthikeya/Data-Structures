import java.util.*;
public class BinTree {
    TreeNode root = null;
    List front = null;
    List rear = null;
    public class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int n){
            this.data = n;
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
    public void createTree(){
        System.out.println("\nEnter the elements levle wise\n-1 -> to skip the node\n-2 -> to end the tree");
        int element;
        System.out.print("Enter the root element :");
        Scanner in = new Scanner(System.in);
        element = in.nextInt();
        root = new TreeNode(element);
        front = rear = new List(root);
        System.out.print("Enter the  element :");
        element = in.nextInt();
        while(element != -2 && front != null){
            if(element == -1) front.node.left = null;
            else{
                TreeNode node = new TreeNode(element);
                front.node.left = node;
                List lnode = new List(node);
                rear.next = lnode;
                rear = rear.next;
            }
            // System.out.print("second input\n");
            System.out.print("Enter the  element :");
            Scanner in2 = new Scanner(System.in);
                    element = in2.nextInt();
            if(element == -2) break;
            else if(element == -1)front.node.right = null;
            else{
                TreeNode node = new TreeNode(element);
                front.node.right = node;
                List rnode = new List(node);
                rear.next = rnode;
                rear = rear.next;
            }
            front = front.next;
            System.out.print("Enter the  element :");
        element = in.nextInt();
        
            
        }
        if(front == null) System.out.println("\n****Binary Tree completed****");
    }

    public void displayTree(TreeNode root){
        System.out.print("BINARY TREE : ");
        front = rear = new List(root);
        while(front != null){
            System.out.print(front.node.data + " ");
            if(front.node.left != null) {
                rear.next = new List(front.node.left);
                rear = rear.next;
            }
            // else System.out.print(" NULL ");
            if(front.node.right != null) {
                rear.next = new List(front.node.right);
                rear = rear.next;
            }
            // else System.out.print(" NULL ");
            front = front.next;
        }
    
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

    public int findMax(TreeNode root){
        if(root == null ) return Integer.MIN_VALUE;
        int result = root.data;
        int left = findMax(root.left);
        int right = findMax(root.right);
        if(left > result ) result = left;
        if(right > result) result = right;

        return result;
    }
    public boolean isBST(TreeNode root){
        boolean lnode =  true;
        boolean rnode = true;
        if(root == null) return true;
        else {
            if(root.left != null){
                lnode = root.left.data < root.data && isBST(root.left);

            }
            if(root.right != null) lnode = root.right.data > root.data && isBST(root.right);
        }
        return lnode && rnode;
    }

    public boolean searchInBSTrec(TreeNode root, int key){
        if(root == null) return false;
        else if(root.data == key) return true;
        else if(key < root.data ) return searchInBSTrec(root.left, key);
        else return searchInBSTrec(root.right, key);
    }

    public int searchInBSTiterative(TreeNode root , int key){
        int level = 0;
        while(root != null){
            if(root.data == key ) return level;
            else if(root.data > key) root = root.left;
            else root = root.right;
            level++;
        }
        return -1;
    }

    public static void main(String[] args){
        BinTree bintree = new BinTree();
        bintree.createTree();
        bintree.displayTree(bintree.root);
        System.out.print("\npreorder : ");
        bintree.preOrder(bintree.root);
        System.out.print("\npostorder : ");
        bintree.postOrder(bintree.root);
        System.out.print("\ninorder : ");
        bintree.inOrder(bintree.root);
        System.out.println("\nMax element in tree : " + bintree.findMax(bintree.root));
        System.out.println("Binary search tree : "+ bintree.isBST(bintree.root));
        Scanner in = new Scanner(System.in);
        System.out.print("enter the element to search :");
        int key = in.nextInt();
        System.out.println("search element :" + bintree.searchInBSTrec(bintree.root, key));
        System.out.println("search element level : " + bintree.searchInBSTiterative(bintree.root, key));


    }
}
