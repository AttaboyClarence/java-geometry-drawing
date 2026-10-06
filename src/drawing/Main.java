package drawing;
import java.awt.Color;

import drawing.geo.Circle2D;
import drawing.geo.Point2D;
import drawing.gui.DrawingApp;
/**
 * A very simple main class for basic code for DrawingApp
 * 
 * t2: output:
 * GUIShape,0,true,1,Circle2D,3.0,4.0, 2.0
 * GUIShape,255,false,2,Circle2D,6.0,8.0, 4.0
 * 
 * @author boaz.ben-moshe
 *
 */
public class Main {

	public static void main(String[] args) {
		t2();
		
		
	}
	// Minimal empty frame (no shapes)
	public static void t1() {
		DrawingApp ex4 = DrawingApp.getInstance();
		ex4.show();
	} 
	// Two simple circles
	public static void t2() {
		DrawingApp ex4 = DrawingApp.getInstance();
		ShapeCollectionInterface shapes = ex4.getShape_Collection();
		Point2D p1 = new Point2D(3,4);
		Point2D p2 = new Point2D(6,8);
		Circle2D c1 = new Circle2D(p1,2);
		Circle2D c2 = new Circle2D(p2,4);
		GUIShapeable gs1 = new GUIShape(c1, true, Color.black, 1);
		GUIShapeable gs2 = new GUIShape(c2, false, Color.blue, 2);
		shapes.add(gs1);
		shapes.add(gs2);
		ex4.show();
		System.out.print(ex4.getInfo());
	}
	// Loads a file from file 'sample_drawing.txt' (Circles only).
	public static void t3() {
		DrawingApp ex4 = DrawingApp.getInstance();
		ShapeCollectionInterface shapes = ex4.getShape_Collection();
		String file = "sample_drawing.txt"; 
		shapes.load(file);
		ex4.init(shapes);
		ex4.show();
	}

}
