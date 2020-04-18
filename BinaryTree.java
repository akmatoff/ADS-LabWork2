// Class containing left and right child of current node and key value
class Node {
    // Key for a node
    int key;
    String data;
    Node left, right; // Left and right children of node

    public Node(int key, String data) {
        key = this.key;
        data = this.data; 
        left = right = null;
    }

}

// Introducing a Binary Tree
public class BinaryTree {
    // Root of the Binary Tree
    Node root;

    // Constructors
    BinaryTree(int key, String data) {
        root = new Node(key, data);
    }

    BinaryTree() {
        root = null;
    }

    public void insert(int key, String data) {
        root = insertRec(root, key, data);
    }

    Node insertRec(Node root, int key, String data) {
        Node newNode = new Node(key, data); // Create a new instance of Node
        newNode.key = key; // Insert key 
        newNode.data = data; // Insert data

        if (root == null) root = newNode; // If the tree is empty

        if (key < root.key) root.left = insertRec(root.left, key, data); // If the given key is less than root's key
        else if (key > root.key) root.right = insertRec(root.right, key, data); // If the given key is more than root's key

        // Return the Node pointer
        return root;
    }

    // A function to search a given key in a BST
    public Node search(int key) {
        Node current = root; // Start from the root

        while (current.key != key) {
            // If root in null or key is in root
            if (root == null || root.key == key) return root;

            // if the current key is greater than the given key
            if (current.key > key) current = current.left; // Go left

            // if the current key is less than the given key
            if (current.key < key) current = current.right; // Go right

            if (current == null) {
                System.out.println("Элемент не найден!");
                return null;
            }
        } 

        System.out.println("Вы искали элемент " + current.data + "?");
        return current; // Return the element
    }

    public void inorder() {
        inorderRec(root);
    }

    public void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left); // Recursive call
            System.out.println(root.key); // Print key of the Node
            inorderRec(root.right); 
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(); // New instance of Binary Tree

        tree.insert(10, "PHP");
        tree.insert(5, "Brainfuck");   
        tree.insert(3, "Dart"); 
        tree.insert(2, "Python"); 
        tree.insert(4, "Java"); 
        tree.insert(7, "C#"); 
        tree.insert(6, "Ruby On Rails"); 
        tree.insert(8, "C++");
        tree.insert(1, "JavaScript");
        tree.insert(9, "C");

        tree.inorder();

        tree.search(5);
        
    }
}