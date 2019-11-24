package fr.christopher.magicworldandroid.controller;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import fr.christopher.magicworldandroid.model.Joueur;
import fr.christopher.magicworldandroid.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class JoueurActivity extends AppCompatActivity {

    private Button guerrier;
    private Button rodeur;
    private Button mage;
    private TextView classePersonnage;
    private Joueur joueur;
    private int choixClasse;
    public static final String CHOIXCLASSE = "creation";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joueur);

        guerrier = findViewById(R.id.guerrier);
        rodeur = findViewById(R.id.rodeur);
        mage = findViewById(R.id.mage);
        classePersonnage = findViewById(R.id.classe_personnage_joueur);

        joueur = getIntent().getParcelableExtra(MainActivity.EXTRA_JOUEUR);
        String nomJoueur = getString(R.string.nom_joueur, joueur.getNumeroJoueur());
        classePersonnage.setText(nomJoueur);


        guerrier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                choixClasse = 1;
                joueur.setChoix(choixClasse);
                envoiDeDonner(choixClasse);
            }
        });

        rodeur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                choixClasse = 2;
                joueur.setChoix(choixClasse);
                envoiDeDonner(choixClasse);
            }
        });

        mage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                choixClasse = 3;
                joueur.setChoix(choixClasse);
                envoiDeDonner(choixClasse);

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK){

            joueur = data.getParcelableExtra(MainActivity.EXTRA_JOUEUR);
            retourDeDonner();

        }
    }

    public void envoiDeDonner(int choixClasse){

        Intent personnageActivityIntent = new Intent(JoueurActivity.this, PersonnageActivity.class);
        personnageActivityIntent.putExtra(MainActivity.EXTRA_JOUEUR, joueur);
        personnageActivityIntent.putExtra(CHOIXCLASSE, choixClasse);
        startActivityForResult(personnageActivityIntent, choixClasse);
    }

    public void retourDeDonner(){

        Intent renvoie1 = new Intent();
        renvoie1.putExtra(MainActivity.EXTRA_JOUEUR, joueur);
        setResult(Activity.RESULT_OK, renvoie1);
        JoueurActivity.this.finish();
    }
}
