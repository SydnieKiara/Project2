package quadtree;

/**
 * Abstract Node class representing a node in a quadtree.
 * This class provides the structure for five key operations.
 */
public abstract class Node {
    /**
     * Inserts a rectangle into the node.
     * @param rect the rectangle to insert
     */
    public abstract void insert(Rectangle rect);

    /**
     * Deletes a rectangle from the node.
     * @param rect the rectangle to delete
     */
    public abstract void delete(Rectangle rect);

    /**
     * Finds a rectangle in the node.
     * @param rect the rectangle to find
     * @return true if the rectangle is found, false otherwise
     */
    public abstract boolean find(Rectangle rect);

    /**
     * Outputs the contents of the quadtree.
     */
    public abstract void dump();

    /**
     * Updates a rectangle within the node by removing the old rectangle
     * and inserting the updated one.
     * @param oldRect the original rectangle
     * @param newRect the updated rectangle
     */
    public abstract void update(Rectangle oldRect, Rectangle newRect);
}

