package Persoane;

import Buletin.Buletin;
import Buletin.ColectieBuletine;
import Buletin.FereastraBuletinNou;
import Buletin.FereastraBuletine;
import Cerere.Cerere;
import Cerere.ColectieCereriRezolvate;
import Cerere.FereastraCereriRezolvate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class FereastraChimist extends JFrame{

    private GestorEvenimenteC a;
    JButton b,b1, b2;

    public FereastraChimist(){

        super("Fereastra Chimist");
        a = new GestorEvenimenteC();

        JPanel p = new JPanel(new GridLayout(1,1,10,10));
        p.setBackground(Color.blue);


        b = new JButton("Afiseaza lista:");
        b.addActionListener(a);
        p.add(b);

        b1 = new JButton("Adauga un buletin:");
        b1.addActionListener(a);
        p.add(b1);

        b2 = new JButton("Afiseaza buletinele");
        b2.addActionListener(a);
        p.add(b2);

        add(p);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    private class GestorEvenimenteC implements ActionListener {

        JFrame f;
        ColectieBuletine cb;

        GestorEvenimenteC(){
            cb = ColectieBuletine.getInstanta(); cb.salveazaB();}
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == b1){
                f = new FereastraBuletinNou();
                f.setVisible(true);
                f.setSize(400,600);
            }
            if(e.getSource() == b){
                f = new FereastraCereriRezolvate();
                f.setVisible(true);
                f.setSize(200,200);
            }
            if(e.getSource() == b2){
                f = new FereastraBuletine();
                f.setVisible(true);
                f.setSize(600,600);
            }
        }
    }

}
