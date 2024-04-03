/**
 * Dibujo
 */
import java.awt.*;
import java.awt.geom.*;

public class Dibujo extends Frame {

    public Dibujo() {               //  Constructor
        super("Área de Dibujo");
    }   

    public boolean handleEvent(Event e) {
        if(e.id == Event.WINDOW_DESTROY) {
            hide();
            dispose();
            return true;
        }
        return super.handleEvent(e);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g; 
        g2d.setBackground(getForeground());

    }
    
    public static void main(String[] args) {
        Dibujo dibujo = new Dibujo();

        dibujo.resize(400, 400);        //  Deprecado
        dibujo.show();                               //  Deprecado
    }

}