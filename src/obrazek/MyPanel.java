package obrazek;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;

public class MyPanel extends JPanel implements MouseListener{
    MySnowBall[] snow;
    ArrayList< HearthSquere> squers;
    
    Timer clock, clockHearth;
    TimerTask task, taskHearth;
    
    Color colorBackground,
          border = Color.BLACK,
          inSide = Color.RED,
          accent = Color.WHITE;
    
    int type,
        size = 40;
        
    boolean hearthDraw;
    
    Color getColor( int ColorNumber){
        switch( ColorNumber){
            default:
                return Color.BLUE;
            case 0:
                return Color.BLUE;
            case 1: 
                return Color.CYAN;
            case 2:
                return Color.MAGENTA;
            case 3:
                return Color.ORANGE;
            case 4:
                return Color.PINK;
            case 5:
                return Color.RED;
            case 6:
                return Color.YELLOW;
            case 7:
                return Color.GREEN;
        }
    }
    
    Color RandColor(){
        return this.getColor( new Random().nextInt(8));
    }
    
    public MyPanel() {
        super();
        this.colorBackground = Color.BLACK;
        this.snow = new MySnowBall[ 300];
        this.squers = new ArrayList<>();
        this.type = 0;
        this.hearthDraw = true;
        
        setPreferredSize( new Dimension( 640, 640));
        setBackground( colorBackground);
        
        addMouseListener(this);
        
        this.clockHearth = new Timer(true);
        this.taskHearth = new TimerTask() {
            @Override
            public void run() {
                for( int f = 0; f < snow.length; ++f){
                    hearthDraw = true;
                }
            }
        };
        
        this.clock = new Timer(true);
        this.task = new TimerTask() {
            @Override
            public void run() {
                for( int f = 0; f < snow.length; ++f){
                    snow[ f].UpDate(); 
                    repaint();
                }
            }
        };

        int[][] hearthInSquere = {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 3, 3, 3, 0, 0, 0, 0, 3, 3, 3, 0, 0, 0 },
            { 0, 0, 3, 3, 3, 3, 3, 0, 0, 3, 3, 3, 3, 3, 0, 0 },
            { 0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0 },
            { 0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0 },
            { 0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0 },
            { 0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0 },
            { 0, 0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0 },
            { 0, 0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0 },
            { 0, 0, 0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0 },
            { 0, 0, 0, 0, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };
                
        for( int f = 0; f < hearthInSquere.length; ++f){
           for( int g = 0; g < hearthInSquere[f].length; ++g){
               switch (hearthInSquere[f][g]){
                   case 1:
                       this.squers.add( new HearthSquere( this.border, size*g, size*f, size));
                       break;
                   case 2:
                       this.squers.add( new HearthSquere( this.accent, size*g, size*f, size));
                       break;
                   case 3:
                       this.squers.add( new HearthSquere( this.inSide, size*g, size*f, size, true));
                       break;
                   default:
                       break;
               }
           }
        }
        
        for( int f = 0; f < this.snow.length; ++f){
            this.snow[ f] = new MySnowBall();
        }
        
        clock.scheduleAtFixedRate( task, 500, 50);
        clockHearth.scheduleAtFixedRate( taskHearth, 1000, 450);
        
        setVisible( true);
    }
    
    @Override
    public void paintComponent( Graphics g){
        super.paintComponent( g);
        Graphics2D g2d = ( Graphics2D)g;
        this.inSide = RandColor();
        
        if( hearthDraw){
            switch( this.type){
                case 0:
                    break;
                    
                case 1:
                    for( HearthSquere f : this.squers){
                        f.setColorInside( this.inSide);
                        f.draw(g);
                    }
                    break;    
                
                case 2:
                    for( HearthSquere f : this.squers){
                        f.setColorInside( RandColor());
                        f.draw(g);
                    }
                    break;
            }
            this.hearthDraw = false;
        }
        else if( this.type != 0){
            for( HearthSquere f : this.squers){
                f.draw(g);
            }
        }
        
        for( int f = 0; f < this.snow.length; ++f){
            this.snow[ f].draw( g2d);
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        if( me.getButton() == 1 && this.type < 2)
            this.type++;
        
        else if( me.getButton() == 3 && this.type > 0)
            this.type--;
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
   
}
