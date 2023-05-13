package Buletin;

public class Buletin<CompareTo> implements Comparable<Buletin>{

    private String nume,prenume, datan, cnp, varsta, sex, adresa, datar, rez1, rez2, tr;

    public Buletin(String nume, String prenume, String datan, String cnp, String varsta, String sex, String adresa, String datar, String rez1, String rez2) {
        this.nume = nume;
        this.prenume = prenume;
        this.datan = datan;
        this.cnp = cnp;
        this.varsta = varsta;
        this.sex = sex;
        this.adresa = adresa;
        this.datar = datar;
        this.rez1 = rez1;
        this.rez2 = rez2;
    }

    public String getNume(){
        return nume + " " + prenume;
    }

    public String toString(){
        return nume + " " + prenume + "_" + datan + "_" + cnp + "_" + varsta + "_" + sex + "_" + adresa + "_" + datar + "_" + rez1 + "_" + rez2 ;
    }

    public int compareTo(Buletin b){
        return (nume+" "+prenume).compareTo(b.getNume());
    }
}
