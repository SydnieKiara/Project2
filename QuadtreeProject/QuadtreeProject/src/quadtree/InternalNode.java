package quadtree;

/**
 * InternalNode class representing an internal node in the quadtree.
 * This node contains references to four child nodes representing the four quadrants.
 */
public class InternalNode extends Node {
    private Node topLeft, topRight, bottomLeft, bottomRight;
    private double centerX, centerY;

    /**
     * Constructs an InternalNode at the given center point.
     *
     * @param centerX The x-coordinate of the node's center.
     * @param centerY The y-coordinate of the node's center.
     */
    public InternalNode(double centerX, double centerY) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.topLeft = new LeafNode(centerX - 50, centerY + 50, centerX, centerY);
        this.topRight = new LeafNode(centerX, centerY + 50, centerX + 50, centerY);
        this.bottomLeft = new LeafNode(centerX - 50, centerY, centerX, centerY - 50);
        this.bottomRight = new LeafNode(centerX, centerY, centerX + 50, centerY - 50);
    }

    @Override
    public void insert(Rectangle rect) {
        // Determine which quadrant the rectangle belongs to and insert recursively
        if (isInTopLeft(rect)) {
            topLeft.insert(rect);
        } else if (isInTopRight(rect)) {
            topRight.insert(rect);
        } else if (isInBottomLeft(rect)) {
            bottomLeft.insert(rect);
        } else if (isInBottomRight(rect)) {  // Added this line
            bottomRight.insert(rect);
        }
    }


    private boolean isInTopLeft(Rectangle rect) {
        return rect.getX() + rect.getWidth() <= centerX && rect.getY() >= centerY;
    }

    private boolean isInTopRight(Rectangle rect) {
        return rect.getX() >= centerX && rect.getY() >= centerY;
    }

    private boolean isInBottomLeft(Rectangle rect) {
        return rect.getX() + rect.getWidth() <= centerX && rect.getY() + rect.getHeight() <= centerY;
    }

    private boolean isInBottomRight(Rectangle rect) {
        return rect.getX() >= centerX && rect.getY() + rect.getHeight() <= centerY;
    }

    @Override
    public void delete(Rectangle rect) {
        if (topLeft.find(rect)) topLeft.delete(rect);
        else if (topRight.find(rect)) topRight.delete(rect);
        else if (bottomLeft.find(rect)) bottomLeft.delete(rect);
        else bottomRight.delete(rect);
    }

    @Override
    public boolean find(Rectangle rect) {
        return topLeft.find(rect) || topRight.find(rect) || bottomLeft.find(rect) || bottomRight.find(rect);
    }

    @Override
    public void dump() {
        System.out.println("Internal Node:");
        topLeft.dump();
        topRight.dump();
        bottomLeft.dump();
        bottomRight.dump();
    }

    @Override
    public void update(Rectangle oldRect, Rectangle newRect) {
        delete(oldRect);
        insert(newRect);
    }
}

