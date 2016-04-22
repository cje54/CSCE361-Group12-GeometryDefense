package geometrydefense.geometrydefense;

import android.graphics.Rect;

/**
 * Created by Jon on 4/16/2016.
 */
public class PlacementSquare {
    private Rect r;
    private boolean placeable;
    private int x;
    private int y;

    public PlacementSquare(int x, int y, int width, int height, boolean placeable) {
        this.r = new Rect(x, y, width, height);
        this.placeable = placeable;
    }

    public void setPlaceable(boolean b){
        placeable = b;
    }

    public int getX(){
        return x;
    }

    public int getY() { return y; }

    public Rect getRectangle(){
        return r;
    }

    public boolean getPlaceable(){
        return placeable;
    }

}
