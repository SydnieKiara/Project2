package quadtree.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import quadtree.*;

public class QuadtreeTest {

    private InternalNode rootNode;
    private Rectangle rect1;
    private Rectangle rect2;

    @BeforeEach
    public void setUp() {
        // Set up the initial conditions before each test
        rootNode = new InternalNode();  // Use the default constructor
        rect1 = new Rectangle(-10, 10, 5, 5);  // Rectangle in the top-left quadrant
        rect2 = new Rectangle(10, -10, 5, 5); // Rectangle in the bottom-right quadrant
    }

    @Test
    public void testInsert() {
        rootNode.insert(rect1);
        rootNode.insert(rect2);
        
        // Verify that the rectangles are in the tree
        assertTrue(rootNode.find(rect1), "Rect1 should be found in the tree.");
        assertTrue(rootNode.find(rect2), "Rect2 should be found in the tree.");
    }

    @Test
    public void testDelete() {
        rootNode.insert(rect1);
        rootNode.insert(rect2);
        
        // Delete rect1 and verify it's no longer in the tree
        rootNode.delete(rect1);
        assertFalse(rootNode.find(rect1), "Rect1 should not be found in the tree after deletion.");
    }

    @Test
    public void testUpdate() {
        rootNode.insert(rect1);
        
        Rectangle updatedRect = new Rectangle(-10, 10, 10, 10); // Updated rectangle with new dimensions
        rootNode.update(rect1, updatedRect);
        
        // Verify the old rectangle is no longer in the tree, and the updated rectangle is present
        assertFalse(rootNode.find(rect1), "Old rectangle should not be found after update.");
        assertTrue(rootNode.find(updatedRect), "Updated rectangle should be found in the tree.");
    }

    @Test
    public void testDump() {
        rootNode.insert(rect1);
        rootNode.insert(rect2);
        
        // Just check that no exception is thrown and the dump runs
        rootNode.dump();  // This should print the tree structure to the console
    }
    
    @Test
    public void testContains() {
        // Test the contains method of the Rectangle class
        Rectangle rect3 = new Rectangle(0, 0, 10, 10);  // Larger rectangle
        Rectangle rect4 = new Rectangle(1, 1, 2, 2);   // Smaller rectangle inside rect3
        
        assertTrue(rect3.contains(rect4), "rect3 should contain rect4.");
        assertFalse(rect4.contains(rect3), "rect4 should not contain rect3.");
    }
}
