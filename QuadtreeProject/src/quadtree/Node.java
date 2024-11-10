package quadtree;

/**
 * Abstract base class for nodes in the Quadtree.
 * Contains abstract methods that must be implemented by all subclasses.
 */
public abstract class Node {
    
    /**
     * Inserts a rectangle into the node.
     * @param rect The rectangle to insert.
     * @return boolean indicating success of the insertion.
     */
    public abstract boolean insert(Rectangle rect);
    
    /**
     * Deletes a rectangle at a specified position.
     * @param x X-coordinate of the rectangle's position.
     * @param y Y-coordinate of the rectangle's position.
     * @return boolean indicating success of the deletion.
     */
    public abstract boolean delete(float x, float y);
    
    /**
     * Finds a rectangle at a specified position.
     * @param x X-coordinate of the rectangle's position.
     * @param y Y-coordinate of the rectangle's position.
     * @return Rectangle if found, null otherwise.
     */
    public abstract Rectangle find(float x, float y);
    
    /**
     * Updates the dimensions of a rectangle at a specified position.
     * @param x X-coordinate of the rectangle's position.
     * @param y Y-coordinate of the rectangle's position.
     * @param newLength New length for the rectangle.
     * @param newWidth New width for the rectangle.
     * @return boolean indicating success of the update.
     */
    public abstract boolean update(float x, float y, float newLength, float newWidth);
    
    /**
     * Dumps the structure of the node and its children (if any).
     * @param level The level of the node within the tree structure.
     */
    public abstract void dump(int level);
}
