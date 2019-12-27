package fr.christopher.magicworldandroid.model;

import android.os.Parcel;
import android.os.Parcelable;

import fr.christopher.magicworldandroid.MagicWorldApplication;
import fr.christopher.magicworldandroid.R;

/**
 *definie la methode des differentes attaques de la classe mage.
 */
public class Mage extends Joueur {

    private MagicWorldApplication texte = new MagicWorldApplication().getInstance();

    public final int VITALITE = this.vitalite;

    /**
     * constructeur de la classe Personnage.
     *
     * @param niveau
     * @param force
     * @param agilite
     * @param intelligence
     */
    public Mage(int numeroJoueur, int niveau, int force, int agilite, int intelligence) {
        super(numeroJoueur, niveau, force, agilite, intelligence);
    }

    public Mage(Parcel in) {
        super(in);
    }

    public static final Parcelable.Creator<Mage> CREATOR = new Creator<Mage>() {
        @Override
        public Mage createFromParcel(Parcel in) {
            return new Mage(in);
        }

        @Override
        public Mage[] newArray(int size) {
            return new Mage[size];
        }
    };

    /**
     * permet de retourne le nom de la classe mage.
     * @return le nom de la classse mage.
     */
    @Override
    public String getType() {
        return texte.getString(R.string.mage);
    }

    /**
     * definie l'attaque basique de la classe mage.
     * @param defenseur donne les attributs du defenseur.
     */
    @Override
    public void attaqueBasique(Joueur defenseur) {

        int vitalite = defenseur.getVitalite() - this.intelligence;
        defenseur.setVitalite(vitalite);
    }

    /**
     * definie l'attaque speciale de la classe mage.
     * @param defenseur donne les attributs du defenseur.
     */
    @Override
    public void attaqueSpecial(Joueur defenseur) {

        int temp = this.vitalite;
        this.vitalite += this.intelligence * 2;

        if (this.vitalite > VITALITE){
            this.vitalite = VITALITE;
        }

        int gainVitalite = this.vitalite - temp;

    }

    @Override
    public String nomAttaqueBasique() {
        return texte.getString(R.string.basique_mage);
    }

    @Override
    public String nomAttaqueSpecial() {
        return texte.getString(R.string.special_mage);
    }

    @Override
    public String messageCombats() {
        return texte.getString(R.string.message_combats_mage, texte.getString(R.string.adjectif_mage));
    }

    @Override
    public String messageResumerResultats(String attaque, Joueur defenseur) {

        String message = null;

        if (attaque == texte.getString(R.string.basique_mage)){

            message = texte.getString(R.string.resumer_combats_basique,
                            texte.getString(R.string.joueur),
                            numeroJoueur,
                            texte.getString(R.string.adjectif_mage),
                            texte.getString(R.string.basique_mage),
                            texte.getString(R.string.joueur),
                            defenseur.getNumeroJoueur(),
                            getIntelligence()
            );

        } else if (attaque == texte.getString(R.string.special_mage)){
            message = texte.getString(R.string.resumer_combats_mage_special,
                texte.getString(R.string.joueur),
                            numeroJoueur,
                            texte.getString(R.string.adjectif_mage),
                            texte.getString(R.string.special_mage),
                            texte.getString(R.string.joueur),
                            numeroJoueur,
                            VITALITE - vitalite
            );
        }
        return message;
    }
}