package obrazek;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class MySnowBall{
    final int WEIGHT = 600,
              HEIGHT = 640,
              MARGIN = 10,
              LINEWEIGHT = 3,
              LINEHEIGHT = 15,
              LINEMAXYSPAWN = 567,
              LINEMAXZSPAWN = 5,
              GRAVITYSPEED = 10;
    
    Color color;
    
    int x,
        y,
        z,
        gravity;

    public MySnowBall( int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;this.gravity = GRAVITYSPEED*z;
        
    }
    
    public MySnowBall(){
        this.x = new Random().nextInt( this.WEIGHT) + this.MARGIN;
        this.y = new Random().nextInt( this.LINEMAXYSPAWN);
        this.z = new Random().nextInt( this.LINEMAXZSPAWN);
        this.gravity = this.GRAVITYSPEED - z;
        this.color = RandColor();
    }
        
    void Reset(){
        this.x = new Random().nextInt( this.WEIGHT) + this.MARGIN;
        this.y = 0;
        this.z = new Random().nextInt( this.LINEMAXZSPAWN);
        this.gravity = this.GRAVITYSPEED - z;
        this.color = RandColor();
    }
        
    public void UpDate(){
        if( this.y + this.LINEHEIGHT < this.HEIGHT){
            this.y += this.gravity;
            
            if( this.y%50 == 0){
                this.color = RandColor();
            }
        }
        else 
            this.Reset();
    }
    
    Color getColor( int ColorNumber){
        switch( ColorNumber){
            default:
                return Color.WHITE;
            case 0:
                return Color.WHITE;
            case 1:
                return Color.BLACK;
            case 2:
                return Color.BLUE;
            case 3: 
                return Color.CYAN;
            case 4:
                return Color.DARK_GRAY;
            case 5:
                return Color.GRAY;
            case 6:
                return Color.LIGHT_GRAY;
            case 7:
                return Color.MAGENTA;
            case 8:
                return Color.ORANGE;
            case 9:
                return Color.PINK;
            case 10:
                return Color.RED;
            case 11:
                return Color.YELLOW;
            case 12:
                return Color.GREEN;
        }
    }
    
    Color RandColor(){
        return this.getColor( new Random().nextInt(13));
    }
    
    public void draw( Graphics g){
        Graphics2D g2d = ( Graphics2D)g;
                
        g2d.setColor( color );
        
        if( this.y + this.LINEHEIGHT+30 < this.HEIGHT)
            g2d.fillRect( this.x, this.y, this.LINEWEIGHT, this.LINEHEIGHT - ( ( (this.z)*this.LINEHEIGHT)/10));
        else
            g2d.drawOval(x-5, y-1, this.LINEHEIGHT - ( ( (this.z)*this.LINEHEIGHT)/10)+1, this.LINEHEIGHT - ( ( (this.z)*this.LINEHEIGHT)/10)+1);
    }    
}
