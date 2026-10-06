package drawing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import drawing.geo.Circle2D;
import drawing.geo.GeoShapeable;
import drawing.geo.Point2D;
import drawing.geo.Rect2D;

/**
 * This class represents a collection of GUI_Shape.
 * DrawingApp: you should implement this class!
 * @author I2CS
 *
 */
public class ShapeCollection implements ShapeCollectionInterface{
    private ArrayList<GUIShapeable> _shapes;
    
    
    
    public ShapeCollection() {
        _shapes = new ArrayList<GUIShapeable>();
        
    }
    @Override
    public GUIShapeable get(int i) {
        return _shapes.get(i);
    }

    @Override
    public int size() {
        return _shapes.size();
    }

    @Override
    public GUIShapeable removeElementAt(int i) {
        
        GUIShapeable g = this._shapes.get(i);
        this._shapes.remove(i);
        return g;
        
    }

    @Override
    public void addAt(GUIShapeable s, int i) {
        
        this._shapes.add(i, s);
            
    }
    @Override
    public void add(GUIShapeable s) {
        if(s!=null && s.getShape()!=null) {
            _shapes.add(s);
        }
    }
    @Override
    public ShapeCollectionInterface copy() {
        
        ShapeCollection s = new ShapeCollection();
        for(int i=0;i<this.size();i++) {
            s.add(this.get(i).copy());
        }
        return s;
      
    }

    @Override
    public void sort(Comparator<GUIShapeable> comp) {
       
        this._shapes.sort(comp);
        
    }

    @Override
    public void removeAll() {
        
    	this._shapes.clear();
 
    }
@Override
public void save(String file_path) {
	try {
		FileWriter file_Write = new FileWriter(file_path);
		for(int i = 0; i<_shapes.size(); i++) {
			file_Write.write((_shapes.get(i).toString()+ "\n")); // Every shape with its components will be written as a string in a new line in the file. 
		}	
		file_Write.close();
	}
	catch(IOException e) {
		e.printStackTrace();
	}      
}   

@Override
public void load(String file) {
 
	try {
	
		FileReader reader = new FileReader(file); 
		BufferedReader bufferedReader = new BufferedReader(reader); 

		
		String lineFromString;
		while ((lineFromString = bufferedReader.readLine()) != null) {
			_shapes.add(new GUIShape(lineFromString)); // need a converter to add to shapes.
		}

		
		bufferedReader.close();
	}
	catch (IOException e) {
		e.printStackTrace();
	}
}
    @Override
    public Rect2D getBoundingBox() {
        Rect2D ans = null;
        Point2D p1, p2;
        Point2D [] points;
        double minX=0, minY=0, maxX=0, maxY=0;
        if(_shapes.size()>0) { 
                maxX = _shapes.get(0).getShape().getPoints()[0].x();
                maxY = _shapes.get(0).getShape().getPoints()[0].y();
                minX = _shapes.get(0).getShape().getPoints()[0].x();
                minY = _shapes.get(0).getShape().getPoints()[0].y();
            for (int i = 0; i<_shapes.size(); i++) {
            GeoShapeable shape = _shapes.get(i).getShape();
            points = _shapes.get(i).getShape().getPoints();    
            if (shape instanceof Circle2D) {// In the case of a circle we have to find the edge point of each side of the circle which will determine the min and max points of the circle.
                Circle2D circ = (Circle2D) shape;// The circle is the only shape that doesn't have specific points. In order to determine- we must find them individually. 
                points = circ.getPoints();
                maxX = Math.max (maxX, points[0].x()+ circ.getRadius());
                maxY = Math.max (maxY, points[0].y()+ circ.getRadius());
                minX = Math.min(minX ,points[0].x()-circ.getRadius());
                minY = Math.min(minY ,points[0].y()-circ.getRadius());
            }     
            else for (int j = 0; j< points.length; j++) {
                maxX = Math.max (maxX, points[j].x());
                maxY = Math.max (maxY, points[j].y());
                minX = Math.min(minX ,points[j].x());
                minY = Math.min(minY ,points[j].y());
            }
        }
        
        p1 = new Point2D (minX, minY);
        p2= new Point2D (maxX, maxY);
        ans =  new Rect2D (p1, p2);
        }
        return ans;
    }
    @Override
    public String toString() {
        String ans = "";
        for(int i=0;i<size();i=i+1) {
            ans += this.get(i);
        }
        return ans;
    }
    

}