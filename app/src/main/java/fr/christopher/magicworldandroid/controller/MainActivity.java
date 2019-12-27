package fr.christopher.magicworldandroid.controller;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import fr.christopher.magicworldandroid.R;
import fr.christopher.magicworldandroid.model.Joueur;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button boutonDemarrer;
    private Button joueur01;
    private Button joueur02;

    private Joueur joueur1;
    private Joueur joueur2;

    private TextView actionJoueur;
    private TextView actionAFaire;

    public static final String EXTRA_JOUEUR = "joueur";
    public static final String EXTRA_JOUEUR1 = "joueur1";
    public static final String EXTRA_JOUEUR2 = "joueur2";
    public static final String NUMERO_JOUEUR = "numeroJoueur";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       boutonDemarrer = findViewById(R.id.bouton_demarrer);
       joueur01 = findViewById(R.id.joueur_1);
       joueur02 = findViewById(R.id.joueur_2);

       actionJoueur = findViewById(R.id.action_joueur);
       actionAFaire = findViewById(R.id.action_a_faire);

       String nomJoueur = getString(R.string.nom_joueur, 1);
       actionJoueur.setText(nomJoueur);

        joueur02.setEnabled(false);
        boutonDemarrer.setEnabled(false);

        joueur01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent joueurActivityIntent = new Intent(MainActivity.this, JoueurActivity.class);

                joueurActivityIntent.putExtra(EXTRA_JOUEUR, 1);
                joueurActivityIntent.putExtra(NUMERO_JOUEUR, 1);
                startActivityForResult(joueurActivityIntent, 1);

            }
        });

        joueur02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent joueurActivityIntent = new Intent(MainActivity.this, JoueurActivity.class);

                joueurActivityIntent.putExtra(EXTRA_JOUEUR, 2);
                joueurActivityIntent.putExtra(NUMERO_JOUEUR, 2);
                startActivityForResult(joueurActivityIntent, 2);

            }
        });

        boutonDemarrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent combatActivityIntent = new Intent(MainActivity.this, CombatActivity.class);

                combatActivityIntent.putExtra(EXTRA_JOUEUR1, joueur1);
                combatActivityIntent.putExtra(EXTRA_JOUEUR2, joueur2);
                startActivity(combatActivityIntent);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {

            switch (requestCode) {
                case 1:
                    joueur1 = data.getParcelableExtra(EXTRA_JOUEUR);
                    Log.e("MainActivity", joueur1.getVitalite() + "");
                    String nomJoueur = getString(R.string.nom_joueur, 2);
                    actionJoueur.setText(nomJoueur);
                    joueur02.setEnabled(true);
                    break;
                case 2:
                    joueur2 = data.getParcelableExtra(EXTRA_JOUEUR);
                    actionJoueur.setText(getString(R.string.combattants));
                    actionAFaire.setText(getString(R.string.debut_combat));
                    boutonDemarrer.setEnabled(true);
                    break;
            }
        }
    }
}
