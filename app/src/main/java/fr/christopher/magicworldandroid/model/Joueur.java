package fr.christopher.magicworldandroid.model;

import android.os.Parcel;
import android.os.Parcelable;

import fr.christopher.magicworldandroid.R;

/**
 * Determine la classe du personnage.
 */
public abstract class Joueur implements Parcelable {

    public abstract String getType();

    public abstract void attaqueBasique(Joueur defenseur);

    public abstract void attaqueSpecial(Joueur defenseur);

    public abstract String nomAttaqueBasique();

    public abstract String nomAttaqueSpecial();

    public abstract String messageCombats();

    public abstract String messageResumerResultats(String attaque, Joueur defenseur);

    protected int numeroJoueur, niveau, force, agilite, intelligence, vitalite;

    public Joueur(int numeroJoueur, int niveau, int force, int agilite, int intelligence) {

        this.numeroJoueur = numeroJoueur;
        this.niveau = niveau;
        this.force = force;
        this.agilite = agilite;
        this.intelligence = intelligence;
        this.vitalite = niveau * 5;
    }

    protected Joueur(Parcel in){
        this.numeroJoueur = in.readInt();
        this.niveau = in.readInt();
        this.force = in.readInt();
        this.agilite = in.readInt();
        this.intelligence = in.readInt();
        this.vitalite = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(numeroJoueur);
        dest.writeInt(niveau);
        dest.writeInt(force);
        dest.writeInt(agilite);
        dest.writeInt(intelligence);
        dest.writeInt(vitalite);
    }

    public int getNiveau() {
        return niveau;
    }

    public int getForce() {
        return force;
    }

    public int getAgilite() {
        return agilite;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getNumeroJoueur() {
        return numeroJoueur;
    }

    public int getVitalite() {
        return vitalite;
    }

    public void setVitalite(int vitalite) {
        this.vitalite = vitalite;
    }

}
