package quadtree;

import java.util.ArrayList;

/**
 * Represents a leaf node in the Quadtree.
 * Stores rectangles and splits into an InternalNode if it exceeds capacity.
 */
public class LeafNode extends Node {
    private ArrayList<Rectangle> rectangles;
    private static final int MAX_CAPACITY = 5;

    public LeafNode() {
        rectangles = new ArrayList<>();
    }

    @Override
    public boolean insert(Rectangle rect) {
        if (rectangles.size() < MAX_CAPACITY) {
            rectangles.add(rect);
            return true;
        } else {
            // Logic to convert to an internal node if MAX_CAPACITY is exceeded
            return false;
        }
    }

    @Override
    public boolean delete(float x, float y) {
        // Logic to delete a rectangle based on x and y coordinates
        return false;
    }

    @Override
    public Rectangle find(float x, float y) {
        // Logic to find a rectangle based on x and y coordinates
        return null;
    }

    @Override
    public boolean update(float x, float y, float newLength, float newWidth) {
        // Logic to update rectangle dimensions if found at x, y
        return false;
    }

    @Override
    public void dump(int level) {
        System.out.println("Leaf Node at level " + level + " with rectangles:");
        for (Rectangle rect : rectangles) {
            System.out.println(" " + rect);
        }
    }
}

