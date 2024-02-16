package Ex3;

import java.io.*;
class Personne implements Serializable{

private int age;
private String nom;

    Personne(int age,String nom){
        this.age=age;
        this.nom=nom;
    }

    public int Getage(){
        return age;
    }

    public String Getnom(){
        return nom;
    }
}
