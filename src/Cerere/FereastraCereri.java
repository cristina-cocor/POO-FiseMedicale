package Cerere;

import Cerere.ColectieCereri;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;


public class FereastraCereri extends JFrame{
    private JTextArea ta;
    private ColectieCereri at;
    public FereastraCereri(){
        super ("Colectie cereri");
        add(new JLabel("Toate cererile:"), BorderLayout.NORTH);
        ta=new JTextArea(20,200);
        at=ColectieCereri.getInstanta();
        ta.setText(at.getCereri());
        ta.setEnabled(false);
        add(ta);
        setSize(500,300);
        setLocation(300,300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
