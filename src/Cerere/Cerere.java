package Cerere;

public class Cerere  implements Comparable<Cerere> {
    private String nume, prenume, adresa, dataNastere, CNP, sex;

    public Cerere(String nume, String prenume, String adresa, String dataNastere, String CNP, String sex){
        this.nume = nume;
        this.prenume = prenume;
        this.adresa = adresa;
        this.dataNastere = dataNastere;
        this.CNP = CNP;
        this.sex = sex;
    }

    public String getNume(){
        return nume + " " + prenume;
    }

    public String toString(){
        return nume+" "+prenume+"_"+adresa+"_"+dataNastere+"_"+CNP+"_"+sex;
    }

    public int compareTo(Cerere c){
        return (nume + " " + prenume).compareTo(c.getNume());
    }
}
