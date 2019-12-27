package fr.christopher.magicworldandroid.controller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import fr.christopher.magicworldandroid.R;
import fr.christopher.magicworldandroid.model.Joueur;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class CombatActivity extends AppCompatActivity {

    private TextView choixAttaque;
    private TextView joueur1Vitalite;
    private TextView joueur2Vitalite;
    private TextView nomJoueur;
    private Button attaqueBasique;
    private Button attaqueSpeciale;
    private Joueur joueur1;
    private Joueur joueur2;
    private Joueur attaquant;
    private Joueur defenseur;
    private ConstraintLayout root1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combat);

        choixAttaque = findViewById(R.id.texte_choix_attaque);
        attaqueBasique = findViewById(R.id.attaque_basique);
        attaqueSpeciale = findViewById(R.id.attaque_speciale);
        joueur1Vitalite = findViewById(R.id.joueur1_vitalite);
        joueur2Vitalite = findViewById(R.id.joueur2_vitalite);
        nomJoueur = findViewById(R.id.joueur_choix_attaque);
        root1 = findViewById(R.id.root1);

        joueur1 = getIntent().getParcelableExtra(MainActivity.EXTRA_JOUEUR1);
        joueur2 = getIntent().getParcelableExtra(MainActivity.EXTRA_JOUEUR2);

        attaquant = joueur1;
        defenseur = joueur2;

        attributionBackground();
        afficheVitalite();
        modificationMessage();

        attaqueBasique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                attaquant.attaqueBasique(defenseur);

                afficheMessageCombats(attaquant.nomAttaqueBasique());

                testMort();
            }
        });

        attaqueSpeciale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                attaquant.attaqueSpecial(defenseur);

                afficheMessageCombats(attaquant.nomAttaqueSpecial());

                testMort();
            }
        });
    }

    public void attributionBackground(){

        int nbr = new Random().nextInt(2);

        switch (nbr){
            case 0 : root1.setBackgroundResource(R.drawable.arene01);
                break;
            case 1 : root1.setBackgroundResource(R.drawable.arene02);
                break;
            case 2 : root1.setBackgroundResource(R.drawable.arene03);
        }
    }

    public void testMort(){

        if (attaquant.getVitalite() <= 0 || defenseur.getVitalite() <= 0){
            finPartie();
        } else {
            changementAttaquant();
            modificationMessage();
        }
    }

    public  void finPartie(){

        String message = null;

        if (joueur1.getVitalite() <= 0){
            message = getString(R.string.mort_joueur, 1);
        } else if (joueur2.getVitalite() <= 0){
            message = getString(R.string.mort_joueur, 2);
        }

        AlertDialog.Builder finPartie = new AlertDialog.Builder(this);

        finPartie.setTitle(R.string.fin_partie)
                .setMessage(message)
                .setPositiveButton(R.string.Recommencez, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent newGames = new Intent(CombatActivity.this, MainActivity.class);
                        startActivity(newGames);
                        finishAffinity();
                    }
                })
                .create()
                .show();
    }

    public void changementAttaquant(){

        Joueur temp = attaquant;
        attaquant = defenseur;
        defenseur = temp;

    }

    public void modificationMessage(){

        String nbrJoueur = getString(R.string.nom_joueur, attaquant.getNumeroJoueur());
        nomJoueur.setText(nbrJoueur);
        choixAttaque.setText(getString(R.string.attaque));
        attaqueBasique.setText(attaquant.nomAttaqueBasique());
        attaqueSpeciale.setText(attaquant.nomAttaqueSpecial());
        afficheVitalite();
    }

    public void afficheVitalite(){

        joueur1Vitalite.setText(getString(R.string.joueur1_vie, joueur1.getVitalite()));
        joueur2Vitalite.setText(getString(R.string.joueur2_vie, joueur2.getVitalite()));
    }

    public void afficheMessageCombats(String attaque){

        AlertDialog.Builder messageCombats = new AlertDialog.Builder(this);

        messageCombats.setTitle(attaquant.messageCombats())
                .setMessage(attaquant.messageResumerResultats(attaque, defenseur))
                .setPositiveButton(R.string.joueur_attaque_suivante, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create()
                .show();
    }
}