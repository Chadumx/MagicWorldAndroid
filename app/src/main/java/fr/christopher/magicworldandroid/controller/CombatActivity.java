package fr.christopher.magicworldandroid.controller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import fr.christopher.magicworldandroid.R;
import fr.christopher.magicworldandroid.model.Joueur;

import android.content.DialogInterface;
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
    private Joueur temp;
    private ConstraintLayout root2;

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
        root2 = findViewById(R.id.root2);

        attributionBackground();

        joueur1 = getIntent().getParcelableExtra(MainActivity.EXTRA_JOUEUR1);
        joueur2 = getIntent().getParcelableExtra(MainActivity.EXTRA_JOUEUR2);

        String nbrJoueur = getString(R.string.nom_joueur, joueur1.getNumeroJoueur());
        nomJoueur.setText(nbrJoueur);

        joueur1Vitalite.setText("joueur 1 " + joueur1.getClasse().getVitalite());
        joueur2Vitalite.setText("joueur 2 " + joueur2.getClasse().getVitalite());

        attaquant = joueur1;
        defenseur = joueur2;

        choixAttaque.setText("Joueur 1 a vous d'attaquer !");
        attaqueBasique.setText("attaqueBasique");
        attaqueSpeciale.setText("attaque special");

        attaqueBasique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                attaquant.setAttaqueBasique(defenseur);

                changementAttaquant(attaquant, defenseur);
                testMort();
                modificationMessage(defenseur);
            }
        });

        attaqueSpeciale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                attaquant.setAttaqueSpecial(defenseur);

                changementAttaquant(attaquant, defenseur);
                testMort();
                modificationMessage(defenseur);
            }
        });
    }

    public void attributionBackground(){

        int nbr = new Random().nextInt(2);

        switch (nbr){
            case 0 : root2.setBackgroundResource(R.drawable.arene01);
                break;
            case 1 : root2.setBackgroundResource(R.drawable.arene02);
                break;
            case 2 : root2.setBackgroundResource(R.drawable.arene03);
        }
    }

    public void testMort(){

        if (attaquant.getVitalite() <= 0 && defenseur.getVitalite() <= 0){
            finPartie();
        }
    }

    public  void finPartie(){

        String message = null;

        if (joueur1.getVitalite() <= 0){
            message = "Joueur 1, vous avez perdu !";
        } else if (joueur2.getVitalite() <= 0){
            message = "Joueur 2, vous avez perdu !";
        }

        AlertDialog.Builder finPartie = new AlertDialog.Builder(this);

        finPartie.setTitle("Fin de partie")
                .setMessage(message)
                .setPositiveButton("Recommencez", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .create()
                .show();
    }

    public void changementAttaquant(Joueur attaquant, Joueur defenseur){

        temp = attaquant;
        attaquant = defenseur;
        defenseur = temp;

    }

    public void modificationMessage(Joueur defenseur){

        choixAttaque.setText("Joueur " + defenseur.getNumeroJoueur() + " a vous d'attaquez !");
        attaqueBasique.setText(defenseur.getClasse().nomAttaqueBasique());
        attaqueSpeciale.setText(defenseur.getClasse().nomAttaqueSpecial());
        joueur1Vitalite.setText("joueur 1 " + joueur1.getClasse().getVitalite());
        joueur2Vitalite.setText("joueur 2 " + joueur2.getClasse().getVitalite());

    }
}