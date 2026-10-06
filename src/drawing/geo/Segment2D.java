package drawing.geo;
import drawing.DrawingConstants;

/**
 * This class represents a 2D segment on the plane, 
 * DrawingApp: you should implement this class!
 * @author I2CS
 *
 */
public class Segment2D implements GeoShapeable{

	private Point2D firstP;
	private Point2D secondP;
	
	
	// Constructor
	public Segment2D(Point2D firstP,Point2D secondP ) {
		this.firstP = new Point2D(firstP);
		this.secondP = new Point2D(secondP);
	}
	@Override
	// Every point that is not on the line - the sum of the distance to the two points 
	//will be greater then the straight line. 
	//The sum of every two lines in a triangle are bigger than than the third.
	public boolean contains(Point2D ot) {
		return ot.distance(firstP)+ot.distance(secondP) - firstP.distance(secondP)<= DrawingConstants.EPS1;
	}
	
	public String toString() {
		return this.firstP.toString() + "," + this.secondP.toString();
	}
	
	@Override
	public double area() {
		return 0;
	}

	@Override
	public double perimeter() {// Double the length of the distance between the two points.
		double length = firstP.distance(secondP);
		return 2*length;
	}

	@Override
	public void move(Point2D vec) {
		this.firstP.move(vec);
		this.secondP.move(vec);
	}

	@Override
	public GeoShapeable copy() {
		return new Segment2D(firstP, secondP);
	}

	@Override
    public void scale(Point2D center, double ratio) {
        this.firstP.scale(center, ratio);
        this.secondP.scale(center, ratio);
    }

    @Override
    public void rotate(Point2D center, double angleDegrees) {
        this.firstP.rotate(center, angleDegrees);
        this.secondP.rotate(center, angleDegrees);
    }


	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[2];
		ans[0] = new Point2D(this.firstP);
		ans [1] = new Point2D(this.secondP); 
		return ans;
	}
	
}