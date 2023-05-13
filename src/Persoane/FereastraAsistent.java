package Persoane;

import Cerere.ColectieCereri;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FereastraAsistent extends JFrame{

    private GestorEvenimenteA e;
    JButton b, b1;
    JTextField t;
    JTextArea ta;

    public FereastraAsistent(){

        super("Fereastra Asistent");

        JPanel p = new JPanel(new GridLayout(2,1,10,10));
        p.setBackground(Color.blue);
        e = new GestorEvenimenteA();

        t = new JTextField(30);
        p.add(t);

        ta=new JTextArea(20,50);
        p.add(ta);

        b1 = new JButton("Cauta");
        b1.addActionListener(e);
        p.add(b1);

        b = new JButton("Adauga");
        b.addActionListener(e);
        p.add(b);

        add(p);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private class GestorEvenimenteA implements ActionListener {

        private JFrame f;
        private ColectieCereri c;

        GestorEvenimenteA() {
            c = ColectieCereri.getInstanta();
        }

        public void actionPerformed(ActionEvent e) {


            if (e.getSource() == b1) {
                ta.setText(c.cautaCerere(t.getText()));
                t.setText("");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Cererea nu exista in colectie", "Alert", JOptionPane.ERROR_MESSAGE);
            }
            if (e.getSource() == b) {
                c.salveazaCerereRezolvata(t.getText());
                JOptionPane.showMessageDialog(null, "Cererea rezolvata a fost adaugata", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Cererea exista deja in colectie", "Alert", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

}
