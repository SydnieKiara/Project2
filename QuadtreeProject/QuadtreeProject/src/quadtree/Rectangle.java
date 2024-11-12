package quadtree;

/**
 * Represents a rectangle with a position (x, y) and dimensions (width, height).
 * Provides methods to retrieve properties and check containment of other rectangles.
 */
public class Rectangle {
    private double x, y, width, height;

    /**
     * Constructs a Rectangle with specified position and dimensions.
     *
     * @param x The x-coordinate of the rectangle.
     * @param y The y-coordinate of the rectangle.
     * @param width The width of the rectangle.
     * @param height The height of the rectangle.
     */
    public Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public double getWidth() { return width; }
    public double getHeight() { return height; }

    /**
     * Checks if this rectangle fully contains another rectangle.
     *
     * @param other The rectangle to check for containment.
     * @return True if this rectangle contains the other rectangle; false otherwise.
     */
    public boolean contains(Rectangle other) {
        return other.getX() >= this.x &&
               other.getY() >= this.y &&
               other.getX() + other.getWidth() <= this.x + this.width &&
               other.getY() + other.getHeight() <= this.y + this.height;
    }
}
