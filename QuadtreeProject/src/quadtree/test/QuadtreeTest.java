package quadtree.test;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import quadtree.InternalNode;
import quadtree.LeafNode;
import quadtree.Node;
import quadtree.Rectangle;

public class QuadtreeTest {
    
    private Node rootNode;
    private Rectangle rect1;
    private Rectangle rect2;
    private Rectangle rect3;

    @BeforeEach
    public void setUp() {
        // Set up the initial quadtree structure and sample rectangles for each test
        rootNode = new InternalNode(0, 0);  // Create a root InternalNode centered at (0,0)
        rect1 = new Rectangle(-10, 10, 5, 5);  // Rectangle in the top-left quadrant
        rect2 = new Rectangle(10, -10, 5, 5);  // Rectangle in the bottom-right quadrant
        rect3 = new Rectangle(0, 0, 5, 5);     // Rectangle that overlaps quadrants
    }

    @Test
    public void testInsert() {
        // Insert rectangles into the quadtree and verify they are found
        rootNode.insert(rect1);
        rootNode.insert(rect2);

        assertTrue(rootNode.find(rect1), "Rect1 should be found in the quadtree after insertion.");
        assertTrue(rootNode.find(rect2), "Rect2 should be found in the quadtree after insertion.");
    }

    @Test
    public void testDelete() {
        // Insert, delete, and verify that rectangles are removed
        rootNode.insert(rect1);
        rootNode.insert(rect2);
        
        rootNode.delete(rect1);
        assertFalse(rootNode.find(rect1), "Rect1 should not be found in the quadtree after deletion.");
        assertTrue(rootNode.find(rect2), "Rect2 should still be found in the quadtree after deleting Rect1.");
    }

    @Test
    public void testUpdate() {
        // Insert, update, and verify the rectangle is replaced
        rootNode.insert(rect1);

        Rectangle updatedRect = new Rectangle(-10, 10, 10, 10); // Rectangle with new dimensions
        rootNode.update(rect1, updatedRect);
        
        assertFalse(rootNode.find(rect1), "Old rectangle should not be found after update.");
        assertTrue(rootNode.find(updatedRect), "Updated rectangle should be found in the quadtree.");
    }

    @Test
    public void testDump() {
        // Insert rectangles and test dump output visually (manually verify)
        rootNode.insert(rect1);
        rootNode.insert(rect2);

        System.out.println("Dumping quadtree:");
        rootNode.dump();  // This should print the structure of the quadtree
    }
    
    @Test
    public void testContains() {
        // Test containment logic in the Rectangle class
        Rectangle outerRect = new Rectangle(-10, -10, 20, 20);
        Rectangle innerRect = new Rectangle(-5, -5, 5, 5);

        assertTrue(outerRect.contains(innerRect), "OuterRect should contain InnerRect.");
        assertFalse(innerRect.contains(outerRect), "InnerRect should not contain OuterRect.");
    }

    @Test
    public void testLeafNodeFunctionality() {
        // Create a LeafNode and test its methods independently
        LeafNode leaf = new LeafNode(3, 6, 7, 6);
        leaf.insert(rect1);
        
        assertTrue(leaf.find(rect1), "LeafNode should contain Rect1 after insertion.");
        
        leaf.delete(rect1);
        assertFalse(leaf.find(rect1), "LeafNode should not contain Rect1 after deletion.");
    }

    @Test
    public void testBoundaryInsertion() {
        // Test inserting a rectangle that overlaps quadrant boundaries
        rootNode.insert(rect3);
        assertTrue(rootNode.find(rect3), "Rect3 should be found in the quadtree, despite boundary overlap.");
    }
}
