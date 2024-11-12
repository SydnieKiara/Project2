package quadtree;

import java.util.ArrayList;
import java.util.List;

/**
 * LeafNode class representing a leaf in the quadtree. Stores rectangles up to a capacity limit.
 * If the capacity is exceeded, the node splits and becomes an InternalNode.
 */
public class LeafNode extends Node {
    private List<Rectangle> rectangles;
    private static final int CAPACITY = 5; // Max rectangles before splitting
    private double minX, minY, maxX, maxY; // Bounds for the node

    /**
     * Constructs a LeafNode with specified bounds.
     *
     * @param minX The minimum x-coordinate of the node.
     * @param minY The minimum y-coordinate of the node.
     * @param maxX The maximum x-coordinate of the node.
     * @param maxY The maximum y-coordinate of the node.
     */
    public LeafNode(double minX, double minY, double maxX, double maxY) {
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
        this.rectangles = new ArrayList<>();
    }

    @Override
    public void insert(Rectangle rect) {
        if (rectangles.size() < CAPACITY) {
            rectangles.add(rect);
        } else {
            // Split into an InternalNode when capacity is reached
            InternalNode internalNode = new InternalNode((minX + maxX) / 2, (minY + maxY) / 2);
            for (Rectangle r : rectangles) {
                internalNode.insert(r);
            }
            internalNode.insert(rect);
            // In a complete implementation, replace this node in the parent structure with internalNode.
        }
    }

    @Override
    public void delete(Rectangle rect) {
        rectangles.remove(rect);
    }

    @Override
    public boolean find(Rectangle rect) {
        return rectangles.contains(rect);
    }

    @Override
    public void dump() {
        System.out.println("Leaf Node with rectangles:");
        for (Rectangle rect : rectangles) {
            System.out.println(rect);
        }
    }

    @Override
    public void update(Rectangle oldRect, Rectangle newRect) {
        delete(oldRect);
        insert(newRect);
    }
}
