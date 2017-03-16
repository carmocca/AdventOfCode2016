/*	REQUIRES STRAIGHT POINTS
*
*/
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int value) {
        x = value;
    }

    public void setY(int value) {
        y = value;
    }

    /*	Distance between two points
    */
    public int distanceTo(Point point) {
        return Math.abs(x - point.getX()) + Math.abs(y - point.getY());
    }

    /* Checks if the point is between the segment
    *  that is made between the 2 arguments
    */
    public boolean isBetween(Point a, Point b) {
        if (this.distanceTo(a) == 0 || this.distanceTo(b) == 0)
            return false;
        else
            return this.distanceTo(a) + this.distanceTo(b) == a.distanceTo(b);
    }

    public String toString() {
        return "(X:" + x + ", Y:" + y + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Point point = (Point) obj;
        if (this.x != point.getX()) {
            return false;
        }
        return this.y == point.getY();
    }
}
