package obrazek;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class HearthSquere{
    Color color = Color.WHITE;
    int x = 0,
        y = 0,
        size = 40;
    
    boolean inSide;
    
    public HearthSquere() {
        super();
    }
    
    public HearthSquere( Color color, int x, int y, int size, boolean inSide){
        super();
        this.color = color;
        this.x = x;
        this.y = y;
        this.size = size;
        this.inSide = inSide;
    }
    
    public HearthSquere( Color color, int x, int y, int size){
        super();
        this.color = color;
        this.x = x;
        this.y = y;
        this.size = size;
        this.inSide = false;
    }
    
    void setColorInside( Color color){
        if( this.inSide)
            this.color = color;
    }
    
    void draw( Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        
        g2d.setColor( this.color);
        g2d.fillRect( this.x, this.y, this.size, this.size);
    }
}
