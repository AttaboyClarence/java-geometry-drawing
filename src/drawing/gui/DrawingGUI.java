package drawing.gui;

import drawing.ShapeCollectionInterface;

/**
 * This interface represents a simple GUI drawer which uses StdDraw to draw a gui_shape_collection. 
 *  DrawingApp: you should NOT change this interface!
 * @author boaz.benmoshe
 */
public interface DrawingGUI {
	/**
	 * Updates the collection of shapes to g.
	 * @param g
	 */
	public void init(ShapeCollectionInterface g);
	/**
	 * Returns the collection of shapes.
	 * @return
	 */
	public ShapeCollectionInterface getShape_Collection();
	/**
	 * Shows the GUI window with the collection of shapes.
	 */
	public void show();
	/**
	 * Returns a String containing all the toString (of each shape in the collection).
	 * Note: each toString is ended with a new line (println like).
	 * @return
	 */
	public String getInfo();
}
