package fr.christopher.magicworldandroid.Model.joueur;

import java.util.Scanner;

/**
 *definie la methode des differentes attaques de la classe guerriers.
 */
public class Guerrier extends Personnage {
    /**
     * Permet de definir les attributs de la classe guerrier.
     * @param joueurName donne le nom du joueur.
     */
    public Guerrier(String joueurName, Scanner clavier) {
        super(joueurName, clavier);
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

        System.out.printf("%s utilise %s et inflige %s dommages\n", this.player, "coup d'épée", this.force);
        System.out.printf("%s perd %s points de vie\n", defenseur.getPlayerName(), this.force);
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

        System.out.printf("%s utilise %s et inflige %s de dommages\n", this.player, "coup de rage", (this.force * 2));
        System.out.printf("%s perd %s point de vie\n", defenseur.getPlayerName(), (this.force * 2));
        System.out.printf("%s perd %s points de vie\n", this.player, (this.force / 2));
    }
}