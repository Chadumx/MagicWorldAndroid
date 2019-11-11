package fr.christopher.magicworldandroid.model;

/**
 *definie la methode des differentes attaques de la classe guerriers.
 */
public class Guerrier extends Personnage {
    /**
     * constructeur de la classe Personnage.
     *
     * @param niveau
     * @param force
     * @param agilite
     * @param intelligence
     * @param vitallite
     */
    public Guerrier(int niveau, int force, int agilite, int intelligence, int vitallite) {
        super(niveau, force, agilite, intelligence, vitallite);
    }

    /**
     *permet de retourner le nom de la classe guerriers.
     * @return le nom de la classe guerriers.
     */
    @Override
    public String getType() {
        return "Guerrier";
    }

    /**
     *definie l'attaque basique de la classe guerriers.
     * @param defenseur donne les attributs du joueur en defense.
     */
    @Override
    public void attaqueBasique(Joueur defenseur) {

        int vitalite = defenseur.getVitalite() - this.force;
        defenseur.setVitalite(vitalite);

    }

    /**
     * definie l'attaque speciale de la classe guerriers.
     * @param defenseur donne les attributs du joueur en defense.
     */
    @Override
    public void attaqueSpecial(Joueur defenseur) {

        int vitalite = defenseur.getVitalite() - (this.force * 2);
        defenseur.setVitalite(vitalite);

        this.vitalite -= (this.force / 2);

    }
}