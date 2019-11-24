package fr.christopher.magicworldandroid.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import fr.christopher.magicworldandroid.R;
import fr.christopher.magicworldandroid.model.Joueur;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PersonnageActivity extends AppCompatActivity {

    private EditText niveauPersonnage;
    private EditText forcePersonnage;
    private EditText agilitePersonnage;
    private EditText intelligencePersonnage;
    private TextView attributsPersonnage;
    private Button creationPersonnage;
    private ConstraintLayout root1;
    private Joueur joueur;
    private int choixClasse;
    private int niveau, force, agilite, intelligence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personnage);

        niveauPersonnage = findViewById(R.id.niveau_personnage);
        forcePersonnage = findViewById(R.id.force_personnage);
        agilitePersonnage = findViewById(R.id.agilite_personnage);
        intelligencePersonnage = findViewById(R.id.intelligence_personnage);
        attributsPersonnage = findViewById(R.id.attributs_personnage);
        creationPersonnage = findViewById(R.id.creation_personnage);
        root1 = findViewById(R.id.root1);

        joueur = getIntent().getParcelableExtra(MainActivity.EXTRA_JOUEUR);
        choixClasse = getIntent().getIntExtra(JoueurActivity.CHOIXCLASSE, 0);
        String nomJoueur = getString(R.string.nom_joueur, joueur.getNumeroJoueur());
        attributsPersonnage.setText(nomJoueur);

        definitionBackground(choixClasse);

        creationPersonnage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (testValeur()) {

                    retourDeDonner();

                }
            }
        });
    }

    public void definitionBackground(int choixClasse){

        switch (choixClasse) {
            case 1:
                root1.setBackgroundResource(R.drawable.guerrier);
                break;
            case 2:
                root1.setBackgroundResource(R.drawable.mage);
                break;
            case 3:
                root1.setBackgroundResource(R.drawable.rodeur);
                break;
        }
    }

    public boolean testValeur(){

        try {

            niveau = Integer.parseInt(niveauPersonnage.getText().toString());
            force = Integer.parseInt(forcePersonnage.getText().toString());
            agilite = Integer.parseInt(agilitePersonnage.getText().toString());
            intelligence = Integer.parseInt(intelligencePersonnage.getText().toString());

        } catch (java.lang.NumberFormatException exception){

            Toast.makeText(this, "Erreur, veuillez renseigner tout les champs", Toast.LENGTH_LONG)
                    .show();
            return false;
        }

        if (niveau < 1 || niveau > 100) {

            Toast.makeText(this, "Erreur, le niveau doit être compris entre 1 et 100 !", Toast.LENGTH_LONG)
                    .show();

        } else if ((force + agilite + intelligence) != niveau) {

            Toast.makeText(this, "Erreur, la somme de tous les attributs ne doit pas depasser le niveau du personnage !", Toast.LENGTH_LONG)
                    .show();

        } else if ((niveau >= 1 && niveau <= 100) && ((force + agilite + intelligence) == niveau)){

            joueur.creation(niveau, force, agilite, intelligence);

            return true;

        }
        return false;
    }

    public void retourDeDonner(){

        Intent renvoie2 = new Intent();
        renvoie2.putExtra(MainActivity.EXTRA_JOUEUR, joueur);
        setResult(Activity.RESULT_OK, renvoie2);
        PersonnageActivity.this.finish();
    }
}
