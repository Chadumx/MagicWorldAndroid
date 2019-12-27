package fr.christopher.magicworldandroid.model;

import android.os.Parcel;
import android.os.Parcelable;

import fr.christopher.magicworldandroid.MagicWorldApplication;
import fr.christopher.magicworldandroid.R;

/**
 *definie la methode des differentes attaques de la classe rodeur.
 */
public class Rodeur extends Joueur {

    private MagicWorldApplication texte = new MagicWorldApplication().getInstance();

    /**
     * constructeur de la classe Personnage.
     *
     * @param niveau
     * @param force
     * @param agilite
     * @param intelligence
     */
    public Rodeur(int numeroJoueur, int niveau, int force, int agilite, int intelligence) {
        super(numeroJoueur, niveau, force, agilite, intelligence);
    }

    public Rodeur(Parcel in) {
        super(in);
    }

    public static final Parcelable.Creator<Rodeur> CREATOR = new Creator<Rodeur>() {
        @Override
        public Rodeur createFromParcel(Parcel in) {
            return new Rodeur(in);
        }

        @Override
        public Rodeur[] newArray(int size) {
            return new Rodeur[size];
        }
    };


    /**
     *permet de retourner le nom de la classe rodeur.
     * @return le nom de la classe rodeur.
     */
    @Override
    public String getType() {
        return texte.getString(R.string.rodeur);
    }

    /**
     *definie l'attause basique de la classe rodeur.
     * @param defenseur donne les attributs du defenseur.
     */
    @Override
    public void attaqueBasique(Joueur defenseur) {

        int vitalite = defenseur.getVitalite() - this.agilite;
        defenseur.setVitalite(vitalite);

    }

    /**
     * defini l'attaque speciale de la classe rodeur.
     * @param defenseur donne les attributs du defenseur.
     */
    @Override
    public void attaqueSpecial(Joueur defenseur) {

        int temp = this.agilite;
        this.agilite += this.niveau / 2;
        int gainAgilite = this.agilite - temp;

    }

    @Override
    public String nomAttaqueBasique() {
        return texte.getString(R.string.basique_rodeur);
    }

    @Override
    public String nomAttaqueSpecial() {
        return texte.getString(R.string.special_rodeur);
    }

    @Override
    public String messageCombats() {
        return texte.getString(R.string.message_combats_rodeur, texte.getString(R.string.adjectif_rodeur));
    }

    @Override
    public String messageResumerResultats(String attaque, Joueur defenseur) {

        String message = null;

        if (attaque == texte.getString(R.string.basique_rodeur)){

            message =   texte.getString(R.string.resumer_combats_basique,
                            texte.getString(R.string.joueur),
                            numeroJoueur,
                            texte.getString(R.string.adjectif_rodeur),
                            texte.getString(R.string.basique_rodeur),
                            texte.getString(R.string.joueur),
                            defenseur.getNumeroJoueur(),
                            getAgilite()
            );

        } else if (attaque == MagicWorldApplication.getInstance().getString(R.string.special_rodeur)){
            message = texte.getString(R.string.resumer_combats_rodeur_special,
                texte.getString(R.string.joueur),
                            numeroJoueur,
                            texte.getString(R.string.adjectif_guerrier),
                            texte.getString(R.string.special_rodeur),
                            texte.getString(R.string.joueur),
                            numeroJoueur,
                            getNiveau() / 2
            );
        }
        return message;
    }
}