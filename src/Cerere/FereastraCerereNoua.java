package Cerere;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FereastraCerereNoua extends JFrame {

    private GestorEvenimenteFCN g;
    private JTextField fnume, fprenume, fadresa, fdatan, fcnp,fsex;
    private JButton add, cancel;

    public FereastraCerereNoua(){
        super("Adauga cerere noua");
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(6,1,10,10));
        p.setBackground(Color.CYAN);

        p.add(new JLabel("Nume: "));
        fnume=new JTextField(10);
        p.add(fnume);

        p.add(new JLabel("Prenume: "));
        fprenume=new JTextField(10);
        p.add(fprenume);

        p.add(new JLabel("Adresa: "));
        fadresa=new JTextField(30);
        p.add(fadresa);

        p.add(new JLabel("Data nasterii: "));
        fdatan=new JTextField(10);
        p.add(fdatan);

        p.add(new JLabel("CNP: "));
        fcnp=new JTextField(13);
        p.add(fcnp);

        p.add(new JLabel("Sex(F/M): "));
        fsex=new JTextField(1);
        p.add(fsex);

        add(p);

        g=new GestorEvenimenteFCN();
        p=new JPanel();
        add=new JButton("Adauga");
        add.addActionListener(g);
        p.add(add);

        cancel=new JButton("Cancel");
        cancel.addActionListener(g);
        p.add(cancel);

        add(p,BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }


    private class GestorEvenimenteFCN implements ActionListener{

        private ColectieCereri c;
        private JFrame f;
        GestorEvenimenteFCN(){
            c = ColectieCereri.getInstanta();
        }
        public void actionPerformed(ActionEvent e){
            if(e.getSource()== add) {
                c.adaugaCerere(fnume.getText(), fprenume.getText(), fadresa.getText(), fdatan.getText(), fcnp.getText(), fsex.getText());
                ColectieCereri co = ColectieCereri.getInstanta();
                co.salveaza();
            }
            else FereastraCerereNoua.this.dispose();

        }
    }

}