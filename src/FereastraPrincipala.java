import Persoane.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;


public class FereastraPrincipala extends JFrame{

    private GestorEvenimenteFP g;
    private JButton login;
    private JLabel l, l1, l2;
    private JTextField np, cod;

    public FereastraPrincipala(){
        super("Fise Medicale");
        JPanel p = new JPanel();
        g = new GestorEvenimenteFP();

        p.setBackground(Color.PINK);

        p.setLayout(new GridLayout(6, 1, 10, 10));

        l = new JLabel("Logati-va cu NumePrenume si cod:");
        l.setFont(new Font("Serif", Font.BOLD,25));
        p.add(l);

        l1 = new JLabel("Introduceti NumePrenume:");
        l1.setFont(new Font("Serif", Font.PLAIN,20));
        p.add(l1);
        np = new JTextField(50);
        p.add(np);

        l2 = new JLabel("Introduceti codul:");
        l2.setFont(new Font("Serif", Font.PLAIN,20));
        p.add(l2);
        cod = new JTextField( 10);
        p.add(cod);

        login = new JButton("LOGIN");
        login.addActionListener(g);
        p.add(login);

        add(p);
    }

    private class GestorEvenimenteFP implements ActionListener {

        private JFrame f;

        public void actionPerformed(ActionEvent e) {
            File fi = new File("medici.txt");
            File a = new File("asistenti.txt");
            File ch = new File("chimisti.txt");
            File pa = new File("pacienti.txt");

            String k = np.getText();
            String k1 = cod.getText();

            if (fi.exists()) {
                try {
                    Scanner br = new Scanner(new File("medici.txt"));
                    while (br.hasNextLine()) {
                        String s = br.nextLine();
                        String[] sArray = s.split(",");

                        if (k.equals(sArray[0]) && k1.equals(sArray[1])) {
                            f = new FereastraMedic();
                            f.setSize(600, 300);
                            f.setVisible(true);
                            FereastraPrincipala.this.dispose();
                        }
                    }
                    np.setText("");
                    cod.setText("");
                    br.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            } else System.out.println("Nu exista fisierul");

            if (a.exists()) {
                try {
                    Scanner br = new Scanner(new File("asistenti.txt"));
                    while (br.hasNextLine()) {
                        String s = br.nextLine();
                        String[] sArray = s.split(",");

                        if (k.equals(sArray[0]) && k1.equals(sArray[1])) {
                            f = new FereastraAsistent();
                            f.setSize(600, 300);
                            f.setVisible(true);
                            FereastraPrincipala.this.dispose();
                        }
                    }
                    np.setText("");
                    cod.setText("");
                    br.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            } else System.out.println("Nu exista fisierul");

            if (ch.exists()) {
                try {
                    Scanner br = new Scanner(new File("chimisti.txt"));
                    while (br.hasNextLine()) {
                        String s = br.nextLine();
                        String[] sArray = s.split(",");

                        if (k.equals(sArray[0]) && k1.equals(sArray[1])) {
                            f = new FereastraChimist();
                            f.setSize(600, 300);
                            f.setVisible(true);
                            FereastraPrincipala.this.dispose();
                        }
                    }
                    np.setText("");
                    cod.setText("");
                    br.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            } else System.out.println("Nu exista fisierul");

            if (pa.exists()) {
                try {
                    Scanner br = new Scanner(new File("pacienti.txt"));
                    while (br.hasNextLine()) {
                        String s = br.nextLine();
                        String[] sArray = s.split(",");

                        if (k.equals(sArray[0]) && k1.equals(sArray[1])) {
                            f = new FereastraPacient();
                            f.setSize(600, 300);
                            f.setVisible(true);
                            FereastraPrincipala.this.dispose();
                        }
                    }
                    np.setText("");
                    cod.setText("");
                    br.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            } else System.out.println("Nu exista fisierul");
        }
    }

    public static void main(String[] args){
        JFrame w = new FereastraPrincipala();
        w.setSize(600, 500);
        w.setLocation(300, 300);
        w.setVisible(true);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
