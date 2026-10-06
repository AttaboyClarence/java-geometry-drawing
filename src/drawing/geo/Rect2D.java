package drawing.geo;

/**
 * This class represents a 2D rectangle (NOT necessarily axis parallel - this shape can be rotated!)
 * DrawingApp: you should implement this class!
 * @author I2CS
 *
 */
public class Rect2D implements GeoShapeable {
	private Point2D _topRight;
	private Point2D _lowRight;
	private Point2D _topLeft;
	private Point2D _lowLeft;
	
	// Constructor
	public Rect2D(Point2D p1, Point2D p2){
		
			this._topRight= new Point2D (Math.max(p1.x(),p2.x()),Math.max(p1.y(),p2.y()));
			this._lowRight = new Point2D (Math.max(p1.x(),p2.x()),Math.min(p1.y(),p2.y()));
			this._topLeft = new Point2D(Math.min(p1.x(),p2.x()),Math.max(p1.y(),p2.y()));
			this._lowLeft = new Point2D (Math.min(p1.x(),p2.x()),Math.min(p1.y(),p2.y()));
			
	
	}
	
	@Override
	public boolean contains(Point2D ot) {
		// Each point that is between the two points'- on both length and width- is in the area of the rectangle.
		return ((ot.x()>=this._topLeft.x()) && (ot.x() <= this._topRight.x()) && ot.y()<=this._topLeft.y() && (ot.y() >= this._lowRight.y()));
	}
	
	public String toString() {			//1)_LowLeft, 2) LowRight 3) Top Right 4) top left.	
		//GUIShape,16776960,true,2,Rect2D,3.0,4.0,6.0,4.0,6.0,8.0,3.0,8.0
		return _lowLeft.toString() + "," + _lowRight.toString()+ "," + _topRight.toString() + "," + _topLeft.toString();
	}
	
	@Override
	public double area() {
		// To find the area we must multiply the width and length of the rectangle.
		double width = this._topRight.x()-this._topLeft.x();
	    double length =this._topRight.y()-this._lowRight.y();
		return width*length;
	}

	@Override
	public double perimeter() {
		double width = this._topRight.x()-this._topLeft.x();
		double length = this._topRight.y()-this._lowLeft.y();
		return 2*width+ 2*length;
	}

	@Override
	public void move(Point2D vec) {
		_topRight.move(vec);
		_lowRight.move(vec);
		_topLeft.move(vec);
		_lowLeft.move(vec);
	
	}

	@Override
    public GeoShapeable copy() {
        Rect2D r = new Rect2D (this._topRight, this._lowLeft);
        r._lowLeft = new Point2D(this._lowLeft);
        r._lowRight = new Point2D(this._lowRight);
        r._topLeft = new Point2D(this._topLeft);
        r._topRight = new Point2D(this._topRight);
        
        return r;
	}

	 @Override
	    public void scale(Point2D center, double ratio) {
	        this._topRight.scale(center, ratio);
	        this._lowLeft.scale(center, ratio);
	        this._lowRight.scale(center, ratio);
	        this._topLeft.scale(center, ratio);
	    }

	    @Override
	    public void rotate(Point2D center, double angleDegrees) {
	        this._topLeft.rotate(center,angleDegrees);
	        this._topRight.rotate(center, angleDegrees);
	        this._lowLeft.rotate(center, angleDegrees);
	        this._lowRight.rotate(center, angleDegrees);
	    }
	    

	@Override
	public Point2D[] getPoints() {
		Point2D [] arr = new Point2D[2];
		arr[0] = this._lowLeft;
		arr[1] = this._topRight;
		return arr;
	}
	public double[] getx() {//// For the drawing with the polygon method.
    double[] arr = new double[4];
    arr[0] = this._lowLeft.x();
    arr[1] = this._topLeft.x();
    arr[2] = this._topRight.x();
    arr[3] = this._lowRight.x();
    
    return arr;

}

	public double[] gety() { // For the drawing with the polygon method.
    double[] arr = new double[4];
    arr[0] = this._lowLeft.y();
    arr[1] = this._topLeft.y();
    arr[2] = this._topRight.y();
    arr[3] = this._lowRight.y();
    
    return arr;

}
}