package Persoane;

import Buletin.FereastraBuletine;
import Cerere.ColectieCereri;
import Cerere.FereastraCerereNoua;
import Cerere.FereastraCereri;
import Cerere.FereastraStergereCerere;
import Fisa.FereastraFise;
import Fisa.FereastraFisaNoua;
import Fisa.FereastraStergereFisa;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class FereastraMedic extends JFrame{
    private GestorEvenimenteM e;
    JButton b, b1, b2, b3, b4, b5, b6;

    public FereastraMedic(){

        super("Fereastra Medic");


        JPanel p = new JPanel(new GridLayout(2,2,10,10));
        p.setBackground(Color.BLUE);
        e = new GestorEvenimenteM();

        b = new JButton("Adauga cerere");
        b.addActionListener(e);
        p.add(b);

        b1 = new JButton("Afiseaza cereri");
        b1.addActionListener(e);
        p.add(b1);

        b2 = new JButton("Sterge o cerere");
        b2.addActionListener(e);
        p.add(b2);

        b5 = new JButton("Afiseaza buletine");
        b5.addActionListener(e);
        p.add(b5);

        b4 = new JButton("Adauga fisa");
        b4.addActionListener(e);
        p.add(b4);

        b3 = new JButton("Afiseaza fise");
        b3.addActionListener(e);
        p.add(b3);

        b6 = new JButton("Sterge o fisa");
        b6.addActionListener(e);
        p.add(b6);

        add(p);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    private class GestorEvenimenteM implements ActionListener {
        private JFrame f;

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == b) {
                f = new FereastraCerereNoua();
                f.pack();
                f.setVisible(true);
            } else if (e.getSource() == b1) {
                f = new FereastraCereri();
                f.setVisible(true);
            } else if (e.getSource() == b2) {
                f = new FereastraStergereCerere();
                f.setSize(600, 600);
                f.setVisible(true);

            } else if (e.getSource() == b4) {
                f = new FereastraFisaNoua();
                f.setVisible(true);
                f.setSize(600, 600);
            } else if (e.getSource() == b5) {
                f = new FereastraBuletine();
                f.setVisible(true);
                f.setSize(600, 600);
            } else if (e.getSource() == b3) {
                f = new FereastraFise();
                f.setVisible(true);
                f.setSize(600, 600);}
            else if(e.getSource() == b6){
                f = new FereastraStergereFisa();
                f.setVisible(true);
                f.setSize(600, 600);
            }
             else {
                ColectieCereri co = ColectieCereri.getInstanta();
                co.salveaza();
            }
        }
    }

}

