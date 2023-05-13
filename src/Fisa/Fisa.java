package Fisa;


public class Fisa<CompareTo> implements Comparable<Fisa>{

    private String nume,prenume, datan, cnp, varsta, sex, adresa, datar, rez1, rez2, tr;

    public Fisa(String nume, String prenume, String datan, String cnp, String varsta, String sex, String adresa, String datar, String rez1, String rez2, String tr) {
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
        this.tr = tr;
    }

    public String getNume(){
        return nume + " " + prenume;
    }

    public String getcnp() {return cnp;}

    public String toString(){
        return nume + " " + prenume + "_" + datan + "_" + cnp + "_" + varsta + "_" + sex + "_" + adresa + "_" + datar + "_" + rez1 + "_" + rez2 + "_" + tr;
    }

    public int compareTo(Fisa fi){
        return (nume+" "+prenume).compareTo(fi.getNume());
    }


}

