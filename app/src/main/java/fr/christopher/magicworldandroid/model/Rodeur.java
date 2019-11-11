package fr.christopher.magicworldandroid.model;

/**
 *definie la methode des differentes attaques de la classe rodeur.
 */
public class Rodeur extends Personnage {

    /**
     * constructeur de la classe Personnage.
     *
     * @param niveau
     * @param force
     * @param agilite
     * @param intelligence
     * @param vitallite
     */
    public Rodeur(int niveau, int force, int agilite, int intelligence, int vitallite) {
        super(niveau, force, agilite, intelligence, vitallite);
    }

    /**
     *permet de retourner le nom de la classe rodeur.
     * @return le nom de la classe rodeur.
     */
    @Override
    public String getType() {
        return "Rôdeur";
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
}