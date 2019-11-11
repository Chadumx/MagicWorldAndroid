package fr.christopher.magicworldandroid;
/**
import fr.christopher.magicworldandroid.Model.combat.Combats;
import fr.christopher.magicworldandroid.Model.Joueur;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

class CombatsTest {

    Joueur getGuerrier(){
        System.setIn(new ByteArrayInputStream("1 100 100 0 0".getBytes()));
        return (new Joueur())
                .setClavier(new Scanner(System.in))
                .choix()
                ;
    }

    Joueur getRodeur(){
        System.setIn(new ByteArrayInputStream("2 100 0 100 0".getBytes()));
        return (new Joueur())
                .setClavier(new Scanner(System.in))
                .choix()
                ;
    }

    Joueur getMage(){
        System.setIn(new ByteArrayInputStream("3 100 0 0 100".getBytes()));
        return (new Joueur())
                .setClavier(new Scanner(System.in))
                .choix()
                ;
    }
    /**
     * test d'une attaque basique.
     */
/**
    @Test
    void testAttaqueBasique(){

        Joueur attaquant = getRodeur();
        Joueur defenseur = getMage();

        System.setIn(new ByteArrayInputStream("1".getBytes()));
        Combats combat1 = new Combats();

        combat1.setClavier(new Scanner(System.in))
                .attaque(attaquant, defenseur)
        ;

        assertEquals(defenseur.getClasse().getVitalite(), 400);

    }

    /**
     * test de l'attaque speciale de la classe Guerrier.
     */
/**
    @Test
    void testAttaqueSpecialeGuerrier() {

        Joueur attaquant = getGuerrier();
        Joueur defenseur = getMage();

        System.setIn(new ByteArrayInputStream("2".getBytes()));
        Combats combat1 = new Combats();

        combat1.setClavier(new Scanner(System.in))
                .attaque(attaquant, defenseur)
        ;

        assertEquals(attaquant.getClasse().getVitalite(), 450);
        assertEquals(defenseur.getClasse().getVitalite(), 300);

    }

    /**
     * test de l'attaque speciale de la classe Rodeur.
     */
/**
    @Test
    void testAttaqueSpecialeRodeur() {


        Joueur attaquant = getRodeur();

        System.setIn(new ByteArrayInputStream("2".getBytes()));
        Combats combat1 = new Combats();

        combat1.setClavier(new Scanner(System.in))
                .attaque(attaquant, null)
        ;

        assertEquals(attaquant.getClasse().getAgilite(), 150);

    }

    /**
     * test de l'attaque speciale de la classe Mage.
     */
/**
    @Test
    void testAttaqueSpecialeMage() {


        Joueur attaquant = getMage();

        System.setIn(new ByteArrayInputStream("2".getBytes()));
        Combats combat1 = new Combats();

        combat1.setClavier(new Scanner(System.in))
                .attaque(attaquant, null)
        ;

        assertEquals(attaquant.getClasse().getVitalite(), 500);

    }
}*/