package Buletin;

import Buletin.ColectieBuletine;
import javax.swing.*;
import java.awt.*;

public class FereastraBuletine extends JFrame {

    private JTextArea ta;
    private ColectieBuletine at;
    public FereastraBuletine(){
        super ("Colectie buletine");
        add(new JLabel("Toate buletinele:"), BorderLayout.NORTH);
        ta=new JTextArea(20,200);
        at=ColectieBuletine.getInstanta();
        ta.setText(at.getBuletine());
        ta.setEnabled(false);
        add(ta);
        setSize(500,300);
        setLocation(300,300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
