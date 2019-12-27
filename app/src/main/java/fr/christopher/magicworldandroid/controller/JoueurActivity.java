package fr.christopher.magicworldandroid.controller;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import fr.christopher.magicworldandroid.R;
import fr.christopher.magicworldandroid.model.Guerrier;
import fr.christopher.magicworldandroid.model.Joueur;
import fr.christopher.magicworldandroid.model.Mage;
import fr.christopher.magicworldandroid.model.Rodeur;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class JoueurActivity extends AppCompatActivity {

    private TextView classePersonnage;
    private TextView personnage;

    private Button guerrier;
    private Button rodeur;
    private Button mage;
    private Button creationPersonnage;

    private EditText niveauPersonnage;
    private EditText forcePersonnage;
    private EditText agilitePersonnage;
    private EditText intelligencePersonnage;

    private ConstraintLayout root;

    private Joueur joueur;

    private int choix, numeroJoueur, niveau, force, agilite, intelligence;

    private String classe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joueur);

        classePersonnage = findViewById(R.id.classe_personnage_joueur);
        personnage = findViewById(R.id.personnage);

        guerrier = findViewById(R.id.guerrier);
        rodeur = findViewById(R.id.rodeur);
        mage = findViewById(R.id.mage);

        niveauPersonnage = findViewById(R.id.niveau_personnage);
        forcePersonnage = findViewById(R.id.force_personnage);
        agilitePersonnage = findViewById(R.id.agilite_personnage);
        intelligencePersonnage = findViewById(R.id.intelligence_personnage);

        creationPersonnage = findViewById(R.id.creation_personnage);

        root = findViewById(R.id.root);

        numeroJoueur = getIntent().getIntExtra(MainActivity.NUMERO_JOUEUR,0);
        String nomJoueur = getString(R.string.nom_joueur, numeroJoueur);
        classePersonnage.setText(nomJoueur);

        activationChamps(false, false);

        guerrier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                choix = 1;
                definitionBackground(choix);
                activationChamps(true, true);
            }
        });

        rodeur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                choix = 2;
                definitionBackground(choix);
                activationChamps(true, true);
            }
        });

        mage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                choix = 3;
                definitionBackground(choix);
                activationChamps(true, true);
            }
        });

        creationPersonnage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (testValeur()) {

                    AlertDialog.Builder messageCombats = new AlertDialog.Builder(JoueurActivity.this);

                    messageCombats.setTitle(R.string.description_choix_personnage)
                            .setMessage(getString(R.string.caracteristique_personnage,
                                                        getString(R.string.joueur),
                                                        numeroJoueur,
                                                        classe,
                                                        getString(R.string.niveau),
                                                        niveau,
                                                        getString(R.string.force),
                                                        force,
                                                        getString(R.string.agilite),
                                                        agilite,
                                                        getString(R.string.intelligence),
                                                        intelligence
                            ))
                            .setPositiveButton(R.string.creation_personnage_suivante, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    retourDeDonner(joueur);
                                }
                            })
                            .create()
                            .show();
                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK){

            Joueur joueur = data.getParcelableExtra(MainActivity.EXTRA_JOUEUR);
            retourDeDonner(joueur);

        }
    }

    public void activationChamps(boolean interaction, boolean visibiliter){

        niveauPersonnage.setEnabled(interaction);
        forcePersonnage.setEnabled(interaction);
        agilitePersonnage.setEnabled(interaction);
        intelligencePersonnage.setEnabled(interaction);
        creationPersonnage.setEnabled(interaction);

        if (visibiliter == true){

            personnage.setVisibility(View.VISIBLE);
            niveauPersonnage.setVisibility(View.VISIBLE);
            forcePersonnage.setVisibility(View.VISIBLE);
            agilitePersonnage.setVisibility(View.VISIBLE);
            intelligencePersonnage.setVisibility(View.VISIBLE);
            creationPersonnage.setVisibility(View.VISIBLE);

        }
    }

    public boolean testValeur(){

        try {

            niveau = Integer.parseInt(niveauPersonnage.getText().toString());
            force = Integer.parseInt(forcePersonnage.getText().toString());
            agilite = Integer.parseInt(agilitePersonnage.getText().toString());
            intelligence = Integer.parseInt(intelligencePersonnage.getText().toString());

        } catch (java.lang.NumberFormatException exception){

            Toast.makeText(this, R.string.erreur_champs, Toast.LENGTH_LONG)
                    .show();
            return false;
        }

        if (niveau < 1 || niveau > 100) {

            Toast.makeText(this, R.string.erreur_nombre, Toast.LENGTH_LONG)
                    .show();

        } else if ((force + agilite + intelligence) != niveau) {

            Toast.makeText(this, R.string.erreur_attribut, Toast.LENGTH_LONG)
                    .show();

        } else if ((niveau >= 1 && niveau <= 100) && ((force + agilite + intelligence) == niveau)){

            switch (choix) {
                case 1:
                    joueur = new Guerrier(numeroJoueur, niveau, force, agilite, intelligence);
                    classe = getString(R.string.guerrier1);
                    break;
                case 2:
                    joueur = new Rodeur(numeroJoueur, niveau, force, agilite, intelligence);
                    classe = getString(R.string.rodeur1);
                    break;
                case 3:
                    joueur = new Mage(numeroJoueur, niveau, force, agilite, intelligence);
                    classe = getString(R.string.mage1);
                    break;
            }
            return true;

        }
        return false;
    }

    public void definitionBackground(int choix){

        switch (choix) {
            case 1:
                root.setBackgroundResource(R.drawable.guerrier);
                break;
            case 2:
                root.setBackgroundResource(R.drawable.rodeur);
                break;
            case 3:
                root.setBackgroundResource(R.drawable.mage);
                break;
        }
    }

    public void retourDeDonner(Joueur joueur){

        Intent renvoie = new Intent();
        renvoie.putExtra(MainActivity.EXTRA_JOUEUR, joueur);
        setResult(Activity.RESULT_OK, renvoie);
        JoueurActivity.this.finish();
    }
}
