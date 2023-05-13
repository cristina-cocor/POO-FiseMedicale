package Fisa;

import Cerere.ColectieCereri;
import Cerere.FereastraStergereCerere;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FereastraStergereFisa extends JFrame {

    private GestorEvenimenteFF ec;
    private JTextField t;
    private JButton ok, c;

    public FereastraStergereFisa(){
        super ("Sterge o fisa");
        JPanel p=new JPanel();
        p.setBackground(Color.lightGray);
        p.add(new JLabel("Introduceti nume si prenume"));
        t=new JTextField(10);
        p.add(t);
        add(p);
        p=new JPanel();
        ec=new GestorEvenimenteFF();
        ok=new JButton("OK");
        ok.addActionListener(ec);
        p.add(ok);
        c=new JButton("Cancel");
        c.addActionListener(ec);
        p.add(c);
        add(p, BorderLayout.SOUTH);
        setSize(300,100);
        setLocation(300,300);
    }
    private class GestorEvenimenteFF implements ActionListener {
        private ColectieFise at;
        GestorEvenimenteFF(){ at=ColectieFise.getInstanta(); }
        public void actionPerformed(ActionEvent e){
            if (e.getSource()==ok) {
                at.stergeFisa(t.getText());
                t.setText("");
                ColectieFise co = ColectieFise.getInstanta();
                co.salveazaF();
            }
            else FereastraStergereFisa.this.dispose();
        } }
}

