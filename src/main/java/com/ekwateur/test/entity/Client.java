package com.ekwateur.test.entity;

public class Client {
    private String clientReference;
    private String siret;
    private String raisonSociale;
    private long chiffreDaffaire;
    private String civilite;
    private String firstName;
    private String lastName;
    private boolean isPro;

    public Client(String clientReference, String siret, String raisonSociale, String chiffreDaffaire, String civilite, String firstName, String lastName) {
        this.clientReference = clientReference.trim();
        this.siret = siret.trim();
        this.raisonSociale = raisonSociale.trim();
        chiffreDaffaire = chiffreDaffaire.trim();
        if (chiffreDaffaire != null && !chiffreDaffaire.isEmpty()) {
            this.chiffreDaffaire = Long.parseLong(chiffreDaffaire.trim());
        } else {
            this.chiffreDaffaire = 0;
        }
        this.civilite = civilite.trim();
        this.firstName = firstName.trim();
        this.lastName = lastName.trim();
        this.isPro = this.siret != null && !this.siret.isEmpty();
    }

    public Client() {

    }

    public String getClientReference() {
        return clientReference;
    }

    public void setClientReference(String clientReference) {
        this.clientReference = clientReference;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public long getChiffreDaffaire() {
        return chiffreDaffaire;
    }

    public void setChiffreDaffaire(long chiffreDaffaire) {
        this.chiffreDaffaire = chiffreDaffaire;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isPro() {
        return isPro;
    }

    public String toString() {
        if (this.isPro) {
            return this.raisonSociale + "\nSiret n°" + this.siret + "\nCA " + this.chiffreDaffaire + "€";
        } else {
            return this.civilite + " " + this.lastName + " " + this.firstName;
        }
    }
}
