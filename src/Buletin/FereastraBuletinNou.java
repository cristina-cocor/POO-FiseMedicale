package Buletin;

import Cerere.FereastraCerereNoua;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FereastraBuletinNou extends JFrame {

    private GestorEvenimenteB e;
    private JTextField fn, fp, fdn, fc, fv, fs, fa, fdr, fr1, fr2;
    private JButton add, cancel;

    public FereastraBuletinNou(){
        super("Adauga buletin nou");
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(11, 1,10,10));
        p.setBackground(Color.CYAN);

        e = new GestorEvenimenteB();

        p.add((new JLabel("Nume:")));
        fn = new JTextField(20);
        p.add(fn);

        p.add((new JLabel("Prenume:")));
        fp = new JTextField(20);
        p.add(fp);

        p.add((new JLabel("Data nasterii:")));
        fdn = new JTextField(20);
        p.add(fdn);

        p.add((new JLabel("CNP:")));
        fc = new JTextField(20);
        p.add(fc);

        p.add((new JLabel("Varsta:")));
        fv = new JTextField(20);
        p.add(fv);

        p.add((new JLabel("Sex(F/M):")));
        fs = new JTextField(1);
        p.add(fs);

        p.add((new JLabel("Adresa:")));
        fa = new JTextField(20);
        p.add(fa);

        p.add((new JLabel("Data recoltarii:")));
        fdr = new JTextField(20);
        p.add(fdr);

        p.add((new JLabel("Rezultat analiza 1:")));
        fr1 = new JTextField(20);
        p.add(fr1);

        p.add((new JLabel("Rezultat analiza 2:")));
        fr2 = new JTextField(20);
        p.add(fr2);

        add(p);

        p = new JPanel();

        add=new JButton("Adauga");
        add.addActionListener(e);
        p.add(add);

        cancel=new JButton("Cancel");
        cancel.addActionListener(e);
        p.add(cancel);

        add(p, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    private class  GestorEvenimenteB implements ActionListener{

        private ColectieBuletine bu;

        private GestorEvenimenteB(){
            bu = ColectieBuletine.getInstanta();
        }

        public void actionPerformed(ActionEvent e){
            if(e.getSource() == add){
                bu.adaugaBuletin(fn.getText(), fp.getText(), fdn.getText(), fc.getText(), fv.getText(), fs.getText(), fa.getText(), fdr.getText(), fr1.getText(), fr2.getText());
                ColectieBuletine bb = ColectieBuletine.getInstanta();
                bb.salveazaB();
            }
            else FereastraBuletinNou.this.dispose();
        }
    }

}
