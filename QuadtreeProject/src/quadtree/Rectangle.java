package quadtree;

/**
 * Represents a rectangle with a position and dimensions.
 */
public class Rectangle {
    private float x, y, length, width;

    public Rectangle(float x, float y, float length, float width) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.width = width;
    }

    /**
     * Checks if this rectangle contains a point.
     * @param px X-coordinate of the point.
     * @param py Y-coordinate of the point.
     * @return True if the point is inside the rectangle, false otherwise.
     */
    public boolean contains(float px, float py) {
        return (px >= x && px <= x + length && py >= y && py <= y + width);
    }

    @Override
    public String toString() {
        return "Rectangle at (" + x + ", " + y + "): " + length + "x" + width;
    }
}

