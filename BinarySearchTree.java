import java.util.*;
public class BinarySearchTree {
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
        if(element == -2 || element == -1) return ;
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
        System.out.print("\nBINARY TREE : ");
        front = rear = new List(root);
        while(front != null){
            System.out.print(front.node.data + " ");
            if(front.node.left != null) {
                rear.next = new List(front.node.left);
                rear = rear.next;
            }
            else if(front.node.right!=null)System.out.print(" L-NULL ");
            if(front.node.right != null) {
                rear.next = new List(front.node.right);
                rear = rear.next;
            }
            else if(front.node.left!=null) System.out.print(" R-NULL ");
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
    public TreeNode insert(TreeNode root, int value){
        if(root == null) {
            root = new TreeNode(value);
            return root;
        }
        else if(value < root.data){
        root.left = insert(root.left , value);
        }
        else if(value > root.data){
            root.right = insert(root.right,value);
        }
        else{
            System.out.println("element " + value + " already exists in the BST");
        }
        return root;
    }


    public void createBST2(){
        Scanner in = new Scanner(System.in);
        System.out.print("n-1 -> to STOP\n");
        int element ;
        System.out.print("Enter the element :");
        element = in.nextInt();
        while(element != -1){
            root = insert(root,element);
            System.out.print("Enter the element :");
        element = in.nextInt();
        }
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        } else if (key < root.data) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.data) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode minNode = findMinNode(root.right);
                root.data = minNode.data;
                root.right = deleteNode(root.right, root.data);
            }
        }
        return root;
    }
    
    private TreeNode findMinNode(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        // bst.createTree();
        bst.createBST2();
        bst.displayTree(bst.root);
        System.out.print("\npre order traversal : "  );
        bst.preOrder(bst.root);
        System.out.print("\npost order traversal : " );
        bst.postOrder(bst.root);
        System.out.print("\nin order traversal : " );
        bst.inOrder(bst.root);
        System.out.print("\nenter the element  to be deleted :");
        int element = in.nextInt();
        bst.deleteNode(bst.root, element);
        bst.displayTree(bst.root);
        System.out.print("\nenter the element to search :");
        element = in.nextInt();
        System.out.println(bst.searchInBSTiterative(bst.root, element));
        



    }

}
