package obrazek;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;
import java.util.Random;

public class MySnowBall{
    final int WEIGHT = 680,
              HEIGHT = 600,
              MARGIN = 10,
              LINEWEIGHT = 2,
              LINEHEIGHT = 10,
              LINEMAXYSPAWN = 100,
              LINEMAXZSPAWN = 3,
              GRAVITYSPEED = -5;
    
    int x,
        y,
        z,
        gravity;

    public MySnowBall( int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
        this.gravity = ( this.z*this.GRAVITYSPEED)/10;
        
    }
    
    public MySnowBall(){
        this.x = new Random().nextInt( this.WEIGHT) + this.MARGIN;
        this.y = HEIGHT - new Random().nextInt( this.HEIGHT);
        this.z = new Random().nextInt( this.LINEMAXZSPAWN) + 1;
        this.gravity = GRAVITYSPEED*z;
    }
        
    void Reset(){
        this.x = new Random().nextInt( this.WEIGHT) + this.MARGIN;
        this.y = 800;
        this.z = new Random().nextInt( this.LINEMAXZSPAWN) + 1;
        this.gravity = GRAVITYSPEED*z;
    }
        
    public void UpDate(){
        if( this.y - this.LINEHEIGHT > 0){
            this.y += this.gravity;
        }
        else 
            this.Reset();
    }
    
    public void draw( Graphics g){
        Graphics2D g2d = ( Graphics2D)g;

        g2d.fillRect( this.x, this.y, this.LINEWEIGHT, this.LINEHEIGHT - ( ( this.z*this.LINEHEIGHT)/10));
    }    
}
