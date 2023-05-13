package Fisa;

import Buletin.Buletin;
import Cerere.Cerere;

import javax.swing.*;
import java.io.*;
import java.util.Iterator;
import java.util.TreeSet;

public class ColectieFise {

    private TreeSet<Fisa> ts;
    private BufferedReader br;
    private PrintWriter pw;
    private String l;
    private Fisa fisa;
    private static ColectieFise cf;

    private ColectieFise(){

        File f = new File("fise.txt");
        ts = new TreeSet<>();
        Fisa fi = null;

        if(f.exists()){
            try{
                br = new BufferedReader(new FileReader(f));
                while((l=br.readLine())!=null){
                    String[] s = l.split("_");
                    String[] s1 = s[0].split(" ");
                    fi = new Fisa(s1[0], s1[1], s[1], s[2], s[3], s[4], s[5], s[6], s[7], s[8], s[9]);
                    ts.add(fi);
                }

            }catch (IOException ioe) {ioe.printStackTrace();}
        }else System.out.println("Fisierul nu exista");
    }

    public void adaugaFisa(String nume, String prenume, String datan, String cnp, String varsta, String sex, String adresa, String datar, String rez1, String rez2, String tr){
        fisa=new Fisa(nume, prenume, datan, cnp, varsta, sex, adresa, datar, rez1, rez2, tr);
        if (ts.contains(fisa)) {
            JOptionPane.showMessageDialog(null, "Buletinul exista deja in colectie", "Alert",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        ts.add(fisa);
        JOptionPane.showMessageDialog(null, "A fost adaugat un buletin nou", "Information",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void stergeFisa(String nume){
        Iterator<Fisa> it=ts.iterator();
        while (it.hasNext()){
            if(nume.equalsIgnoreCase(it.next().getNume())) {
                it.remove();
                JOptionPane.showMessageDialog(null, "Fisa a fost stearsa din colectia de fise", "Information", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Fisa nu se gaseste in colectia de fise", "Alert", JOptionPane.ERROR_MESSAGE);
    }


    public String cautaFisa(String cnp){
        for(Fisa f: ts) if(cnp.equals(f.getcnp())) return f.toString();
        return "nu exista nicio fisa cu cnp-ul "+ cnp;
    }

    public String getFise(){
        StringBuffer rez=new StringBuffer();
        Iterator<Fisa> it=ts.iterator();
        while (it.hasNext()) rez.append(it.next().toString()+"\n");
        return rez.toString();
    }

    public void salveazaF(){
        try{
            pw=new PrintWriter(new FileWriter("fise.txt"));
            for(Fisa fi:ts) pw.println(fi);
            pw.close();
        }catch(IOException e){e.printStackTrace();}
    }

    public static ColectieFise getInstanta(){ if (cf==null) cf=new ColectieFise();
        return cf;
    }

}
