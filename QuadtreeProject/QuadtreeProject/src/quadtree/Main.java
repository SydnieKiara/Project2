package quadtree;

public class Main {
    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(10, 10, 30, 30);
        Rectangle rect2 = new Rectangle(20, 20, 15, 15);
        
        LeafNode leaf = new LeafNode(0, 0, 0, 0);
        leaf.insert(rect1);
        leaf.insert(rect2);

        System.out.println("Dumping Leaf Node:");
        leaf.dump();

        System.out.println("Finding rect2: " + leaf.find(rect2));
        
        // More tests and operations
    }
}
