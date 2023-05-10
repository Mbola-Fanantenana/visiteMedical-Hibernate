/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

/**
 *
 * @author learning
 */
public class Medecin {
    
    private int idMedecin;
    private String codeMed;
    private String nom; 
    private String prenom;
    private String grade;
    

public Medecin () {}

public Medecin (int idMedecin ,String codeMed, String nom, String prenom, String grade) {
    super();
    this.idMedecin = idMedecin;
    this.codeMed = codeMed;
    this.nom = nom;
    this.prenom = prenom;
    this.grade = grade;
}

public int getIdMedecin() {
    return idMedecin;
}

public void setIdMedecin(int idMedecin) {
    this.idMedecin = idMedecin;
}

public String getCodeMed() {
    return codeMed;
}

public void setCodeMed(String codeMed) {
    this.codeMed = codeMed;
}

public String getNom() {
    return nom;
}

public void setNom(String nom) {
    this.nom = nom;
}

public String getPrenom() {
    return prenom;
}

public void setPrenom(String prenom) {
    this.prenom = prenom;
}

public String getGrade() {
    return grade;
}

public void setGrade(String grade) {
    this.grade = grade;
}

@Override
public String toString() {
    return "Medecin [idMedecin=" + idMedecin + " , codeMed=" + codeMed + ", nom=" + nom + ", prenom=" + prenom + ", grade=" + grade + "]";
}

}


