package obrazek;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;

public class MyPanel extends JPanel implements MouseListener{
    MySnowBall[] snow;
    Timer clock;
    TimerTask task;
    Color colorUp,
          colorDown,
          colorBackground;
    
    Color getColor( int ColorNumber){
        System.out.println("Col: " + ColorNumber);
        switch(ColorNumber){
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
    
    public MyPanel() {
        super();
        this.colorUp = Color.YELLOW;
        this.colorDown = Color.RED;
        this.colorBackground = Color.BLACK;
        
        setPreferredSize( new Dimension( 700, 600));
        setBackground( colorBackground);
        
        addMouseListener( this);
        
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
        
        this.snow = new MySnowBall[ 400];
        
        for( int f = 0; f < this.snow.length; ++f){
            this.snow[ f] = new MySnowBall();
        }
        
        clock.scheduleAtFixedRate( task, 500, 50);
        
        setVisible( true);
    }
    
    @Override
    public void paintComponent( Graphics g){
        super.paintComponent( g);
        Graphics2D g2d = ( Graphics2D)g;
        
        g2d.setPaint( new GradientPaint( 0 , 0, colorUp, 0, 500, colorDown));
        
        for( int f = 0; f < this.snow.length; ++f){
            this.snow[ f].draw( g2d);
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        switch ( me.getButton()) {
            case 1:
                colorUp = RandColor();
                break;
            case 2:
                colorBackground = RandColor();
                setBackground( colorBackground);
                break;
            case 3:
                colorDown = RandColor();
                break;
            default:
                break;
        }
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
