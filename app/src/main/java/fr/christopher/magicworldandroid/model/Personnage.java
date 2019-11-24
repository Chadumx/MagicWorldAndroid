package fr.christopher.magicworldandroid.model;

/**
 * definie la valeur des attributs des differentes classes.
 */
public abstract class Personnage {

    public abstract String getType();
    public abstract void attaqueBasique(Joueur defenseur);
    public abstract void attaqueSpecial(Joueur defenseur);
    public abstract String nomAttaqueBasique();
    public abstract String nomAttaqueSpecial();

    protected int niveau, force, agilite, intelligence, vitalite;

    /**
     *constructeur de la classe Personnage.
     */


    public Personnage(int niveau, int force, int agilite, int intelligence, int vitallite) {

        this.niveau = niveau;
        this.force = force;
        this.agilite = agilite;
        this.intelligence = intelligence;
        this.vitalite = vitallite;

        this.vitalite = this.niveau * 5;
    }


    /**
     * transmet la valeur de la vitalite du joueur.
     * @return la valeur de la vitalite.
     */
    public int getVitalite() {
        return vitalite;
    }

    /**
     * permet de redefinie la vitalite du joueur.
     * @param vitalite definie la vitalite du joueur
     * @return la valeur modifier de la vitalite
     */
    public Personnage setVitalite(int vitalite) {
        this.vitalite = vitalite;
        return this;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public void setAgilite(int agilite) {
        this.agilite = agilite;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getForce() {
        return force;
    }

    public int getAgilite() {
        return agilite;
    }

    public int getNiveau() {
        return niveau;
    }

    public int getIntelligence() {
        return intelligence;
    }

}