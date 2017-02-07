package Day01;

/*	REQUIRES STRAIGHT LINES (no slope)
*/
public class Line {
	private Point a, b;
	
	public Line (Point a, Point b){
		this.a = a;
		this.b = b;
	}
	
	public Point getA(){
		return a;
	}

	public Point getB(){
		return b;
	}

	public void setA(Point point){
		a = point;
	}

	public void setB(Point point){
		b = point;
	}
	
	/*	Returns null if they dont intersect
	*/
	public Point intersects(Line line) {
		int x1 = a.getX(),
			y1 = a.getY(),
			x2 = b.getX(),
			y2 = b.getY();

		int x3 = line.getA().getX(),
			y3 = line.getA().getY(),
			x4 = line.getB().getX(),
			y4 = line.getB().getY();

		int denominator = (x1-x2)*(y3 - y4)-(y1 - y2)*(x3 - x4);
		if (denominator == 0) return null;
		
		int x = ((x1*y2 - y1*x2)*(x3 - x4) - (x1 - x2)*(x3*y4 - y3*x4))/(denominator);
		int y = ((x1*y2 - y1*x2)*(y3 - y4) - (y1 - y2)*(x3*y4 - y3*x4))/(denominator);
		Point res = new Point(x,y);

		// Needed so continuous lines dont intersect
		if (res.equals(a) || res.equals(b) || res.equals(line.getA()) || res.equals(line.getB()))
			return null;
		if (res.isBetween(a, b) && res.isBetween(line.getA(), line.getB()))
			return res;
		return null;
	}

	public String toString() {
		return "A = " + a.toString() + " B = " + b.toString();
	}
}
