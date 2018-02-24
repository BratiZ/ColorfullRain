package obrazek;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;

public class MyFrame extends JFrame{

    MySnowBall SnowBalls;
    MySnowBall SnowBalls1;
    MyPanel panel;
    
    public MyFrame() throws HeadlessException, InterruptedException {
        super("Rain and hearth");
        setSize( 640, 640);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground( Color.WHITE);
        setLayout( new FlowLayout());
        setResizable( false);
        this.panel = new MyPanel();
        add( this.panel);

        
        
        setVisible( true);
    }
    
    
    
}