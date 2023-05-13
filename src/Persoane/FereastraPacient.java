package Persoane;

import Fisa.ColectieFise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FereastraPacient extends JFrame{

    private GestorEvenimenteP e;
    private JTextField t;
    private JButton b, cancel;
    private JTextArea ta;

    public FereastraPacient(){

        super("Fereastra Pacient");

        JPanel p = new JPanel(new GridLayout(2,1,10,10));
        p.setBackground(Color.BLUE);
        e = new GestorEvenimenteP();

        t = new JTextField(20);
        p.add(t);

        ta=new JTextArea(20,50);
        p.add(ta);

        b = new JButton("Afiseaza fisa medicala");
        b.addActionListener(e);
        p.add(b);

        cancel = new JButton("Cancel");
        cancel.addActionListener(e);
        p.add(cancel);

        add(p);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private class GestorEvenimenteP implements ActionListener{

        private ColectieFise c;

        GestorEvenimenteP(){
            c = ColectieFise.getInstanta();
        }

        public void actionPerformed(ActionEvent e){
            if(e.getSource() == b){
                ta.setText(c.cautaFisa(t.getText()));
                t.setText("");
            }
            else
                FereastraPacient.this.dispose();
        }
    }

}
