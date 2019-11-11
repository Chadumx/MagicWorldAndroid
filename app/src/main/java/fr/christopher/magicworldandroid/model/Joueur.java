package fr.christopher.magicworldandroid.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Determine la classe du personnage.
 */
public class Joueur implements Parcelable {

    private Personnage classe;
    private int niveau, force, agilite, intelligence, vitallite;

    public Joueur(Parcel in) {
        niveau = in.readInt();
        force = in.readInt();
        agilite = in.readInt();
        intelligence = in.readInt();
        vitallite = in.readInt();
    }

    public static final Creator<Joueur> CREATOR = new Creator<Joueur>() {
        @Override
        public Joueur createFromParcel(Parcel in) {
            return new Joueur(in);
        }

        @Override
        public Joueur[] newArray(int size) {
            return new Joueur[size];
        }
    };

    /**
     * Permet de choisir la classe du personange.
     */
    public Joueur choix(int choix) {

            switch (choix){
                case 1 : this.classe = new Guerrier(niveau, force, agilite, intelligence, vitallite);
                    break;
                case 2 : this.classe = new Rodeur(niveau, force, agilite, intelligence, vitallite);
                    break;
                case 3 : this.classe = new Mage(niveau, force, agilite, intelligence, vitallite);
                    break;
            }

        return this;
    }

    /**
     * Permet de retourne la classe du personnage.
     * @return retourne la classe du personnage.
     */
    public Personnage getClasse() {
        return classe;
    }

    public Joueur setVitalite (int val ){
        this.classe.setVitalite(val);

        return this;
    }

    public Joueur setAttaqueBasique(Joueur defenseur){
        this.classe.attaqueBasique(defenseur);

        return this;
    }

    public Joueur setAttaqueSpecial(Joueur defenseur){
        this.classe.attaqueSpecial(defenseur);

        return this;
    }

    public int getVitalite(){
        return this.classe.getVitalite();
    }

    public void setClasse(Personnage classe) {
        this.classe = classe;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(niveau);
        dest.writeInt(force);
        dest.writeInt(agilite);
        dest.writeInt(intelligence);
        dest.writeInt(vitallite);
    }
}