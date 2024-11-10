package quadtree;

/**
 * The main Quadtree class that manages the root node and operations.
 */
public class Quadtree {
    private Node root;

    public Quadtree() {
        root = new LeafNode();
    }

    /**
     * Inserts a rectangle into the quadtree.
     * @param rect The rectangle to insert.
     */
    public void insert(Rectangle rect) {
        if (!root.insert(rect)) {
            // Handle logic if root needs to transition to InternalNode
        }
    }

    /**
     * Finds a rectangle at the specified coordinates.
     * @param x X-coordinate.
     * @param y Y-coordinate.
     * @return The rectangle if found, null otherwise.
     */
    public Rectangle find(float x, float y) {
        return root.find(x, y);
    }

    /**
     * Deletes a rectangle at the specified coordinates.
     * @param x X-coordinate.
     * @param y Y-coordinate.
     */
    public void delete(float x, float y) {
        if (!root.delete(x, y)) {
            System.out.println("Nothing to delete at (" + x + ", " + y + ")");
        }
    }

    /**
     * Updates a rectangle's dimensions at the specified coordinates.
     * @param x X-coordinate.
     * @param y Y-coordinate.
     * @param newLength New length of the rectangle.
     * @param newWidth New width of the rectangle.
     */
    public void update(float x, float y, float newLength, float newWidth) {
        if (!root.update(x, y, newLength, newWidth)) {
            System.out.println("Nothing to update at (" + x + ", " + y + ")");
        }
    }

    /**
     * Dumps the entire quadtree structure.
     */
    public void dump() {
        root.dump(0);
    }
}
