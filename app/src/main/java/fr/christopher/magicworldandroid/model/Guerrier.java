package fr.christopher.magicworldandroid.model;

import android.os.Parcel;
import android.os.Parcelable;

import fr.christopher.magicworldandroid.MagicWorldApplication;
import fr.christopher.magicworldandroid.R;

import static fr.christopher.magicworldandroid.R.string.adjectif_guerrier;

/**
 *definie la methode des differentes attaques de la classe guerriers.
 */
public class Guerrier extends Joueur {

    private MagicWorldApplication texte = new MagicWorldApplication().getInstance();

    public Guerrier(int numeroJoueur, int niveau, int force, int agilite, int intelligence) {
        super(numeroJoueur, niveau, force, agilite, intelligence);
    }

    public Guerrier(Parcel in) {
        super(in);
    }

    public static final Parcelable.Creator<Guerrier> CREATOR = new Creator<Guerrier>() {
        @Override
        public Guerrier createFromParcel(Parcel in) {
            return new Guerrier(in);
        }

        @Override
        public Guerrier[] newArray(int size) {
            return new Guerrier[size];
        }
    };

    /**
     *permet de retourner le nom de la classe guerriers.
     * @return le nom de la classe guerriers.
     */
    @Override
    public String getType() {
        return texte.getString(R.string.guerrier);
    }

    /**
     *definie l'attaque basique de la classe guerriers.
     * @param defenseur donne les attributs du joueur en defense.
     */
    @Override
    public void attaqueBasique(Joueur defenseur) {

        defenseur.setVitalite(defenseur.getVitalite() - this.force);
    }

    /**
     * definie l'attaque speciale de la classe guerriers.
     * @param defenseur donne les attributs du joueur en defense.
     */
    @Override
    public void attaqueSpecial(Joueur defenseur) {

        defenseur.setVitalite(defenseur.getVitalite() - (this.force * 2));

        this.vitalite -= (this.force / 2);
    }

    @Override
    public String nomAttaqueBasique() {
        return texte.getString(R.string.basique_guerrier);
    }

    @Override
    public String nomAttaqueSpecial() {
        return texte.getString(R.string.special_guerrier);
    }

    @Override
    public String messageCombats() {
        return texte.getString(R.string.message_combats_guerrier, texte.getString(adjectif_guerrier));
    }

    @Override
    public String messageResumerResultats(String attaque, Joueur defenseur) {

        String message = null;

        if (attaque == texte.getString(R.string.basique_guerrier)){

            message =   texte.getString(R.string.resumer_combats_basique,
                            texte.getString(R.string.joueur),
                            numeroJoueur,
                            texte.getString(R.string.adjectif_guerrier),
                            texte.getString(R.string.basique_guerrier),
                            texte.getString(R.string.joueur),
                            defenseur.getNumeroJoueur(),
                            getForce()
            );

        } else if (attaque == texte.getString(R.string.special_guerrier)){
            message = texte.getString(R.string.resumer_combats_guerrier_special,
                texte.getString(R.string.joueur),
                            numeroJoueur,
                            texte.getString(adjectif_guerrier),
                            texte.getString(R.string.special_guerrier),
                            texte.getString(R.string.joueur),
                            numeroJoueur,
                            getForce() / 2,
                            texte.getString(R.string.joueur),
                            defenseur.getNumeroJoueur(),
                            getForce() * 2
            );
        }
        return message;
    }
}