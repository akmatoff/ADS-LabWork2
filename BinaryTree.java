// Class containing left and right child of current node and key value
class Node {
    int key; // A key for a Node
    String data; // Data in the Node
    Node left, right; // Left and right children of node

    // Constructor for Node
    public Node(int key, String data) {
        key = this.key;
        data = this.data; 
        left = right = null; // Initializing variables
    }

}

// Introducing a Binary Tree
public class BinaryTree {
    // Root of the Binary Tree
    Node root;

    // Constructor for an empty Tree
    BinaryTree() {
        root = null;
    }

    // A method that calls insertRec()
    public void insert(int key, String data) {
        root = insertRec(root, key, data);
    }

    // Method for inserting a new Node
    Node insertRec(Node node, int key, String data) {
        Node newNode = new Node(key, data); // Create a new instance of Node
        newNode.key = key; // Insert key 
        newNode.data = data; // Insert data

        // If the tree is empty, return a new node
        if (node == null) return newNode;

        if (key < node.key) node.left = insertRec(node.left, key, data); // If the given key is less than root's key
        if (key > node.key) node.right = insertRec(node.right, key, data); // If the given key is more than root's key

        // Return the Node pointer
        return node;
    }

    // A method to search a given key in a BST
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
        return current; // Return the found element
    }

    public void inorder() {
        inorderRec(root);
    }

    public void inorderRec(Node node) {
        if (node != null) {
            inorderRec(node.left); // Recursive call
            System.out.println(node.key); // Print key of the Node
            inorderRec(node.right); 
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
        tree.insert(6, "Ruby"); 
        tree.insert(8, "C++");
        tree.insert(1, "JavaScript");
        tree.insert(9, "C");

        tree.inorder();

        tree.search(5);
        tree.search(7);
        tree.search(1);
        tree.search(11);
    }
}