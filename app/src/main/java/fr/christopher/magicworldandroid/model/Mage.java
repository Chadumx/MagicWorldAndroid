package fr.christopher.magicworldandroid.model;

/**
 *definie la methode des differentes attaques de la classe mage.
 */
public class Mage extends Personnage {

    public final int VITALITE = this.vitalite;

    /**
     * constructeur de la classe Personnage.
     *
     * @param niveau
     * @param force
     * @param agilite
     * @param intelligence
     * @param vitallite
     */
    public Mage(int niveau, int force, int agilite, int intelligence, int vitallite) {
        super(niveau, force, agilite, intelligence, vitallite);
    }


    /**
     * permet de retourne le nom de la classe mage.
     * @return le nom de la classse mage.
     */
    @Override
    public String getType() {
        return "Mage";
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
}