/* Point.java
 * Author:  William Craycroft
 * Module:  11
 * Project: Lab 11
 * Description: This class stores the x and y coordinates of a 2-dimensional point.
 *
 *      Instance variables:
 *          mX (int) - x-coordinate
 *          mY (int) - y-coordinate
 *
 *      Methods:
 *          Constructors
 *              Default constructor sets coordinates to (0,0)
 *              Parameterized constructor taking in x and y values
 *          setters and getters for both instance variables
 *          toString() - Returns a string representation of the Point
 *          equals(Object) - Returns true if both x and y values are equal
 */

public class Point {

    private int mX;     // x-coordinate
    private int mY;     // y-coordinate

    // Creates a new Point object given their x and y coordinates
    public Point(int x, int y) {
        setX(x);
        setY(y);
    }

    // Creates a default point at (0,0)
    public Point() {
        setX(0);
        setY(0);
    }

    // Getters and Setters
    public int getX() {
        return mX;
    }

    public void setX(int x) {
        mX = x;
    }

    public int getY() {
        return mY;
    }

    public void setY(int y) {
        mY = y;
    }

    // Returns a string representation of the Point
    public String toString() {
        return "Point{" +
                "x=" + mX +
                ", y=" + mY +
                '}';
    }

    // Returns true if both x and y values are equal
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return mX == point.mX &&
                mY == point.mY;
    }
}
