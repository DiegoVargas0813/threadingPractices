import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AWTDrawingApp extends Frame {
    private int lastX, lastY;

    public AWTDrawingApp() {
        setTitle("AWT Drawing App");
        setSize(600, 400);
        
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e) {
                lastX = e.getX();
                lastY = e.getY();

                Graphics g = getGraphics();

                g.setColor(Color.BLUE);

                g.drawLine(lastX, lastY, e.getX(), e.getY());
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            //Method to handle the Mouse Dragged Event
            public void mouseDragged(MouseEvent e) {
            //Get the graphics context from the frame
            Graphics g = getGraphics();
            //Set the color of the graphic context to BLUE
            g.setColor(Color.BLUE);
            //Draw a lanie from the former X,Y to the new X,Y coordenates
            g.drawLine(lastX, lastY, e.getX(), e.getY());
            //Set the former X to the new X
            lastX = e.getX();
            //Set the former Y to the new Y
            lastY = e.getY();
            }
        });

        
        // Window listener to close the app
        addWindowListener(new WindowAdapter() {
            //Method to handle the Window Clossing Event
            public void windowClosing(WindowEvent e) {
                //Close the Frame
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        //Create the Frame object
        AWTDrawingApp app = new AWTDrawingApp();
        //Set it visible (Open the Frame)
        app.setVisible(true);
    }
    
}
