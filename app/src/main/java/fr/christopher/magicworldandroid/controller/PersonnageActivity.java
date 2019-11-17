package fr.christopher.magicworldandroid.controller;

import androidx.appcompat.app.AppCompatActivity;
import fr.christopher.magicworldandroid.R;
import fr.christopher.magicworldandroid.model.Joueur;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PersonnageActivity extends AppCompatActivity {

    private EditText niveauPersonnage;
    private EditText forcePersonnage;
    private EditText agilitePersonnage;
    private EditText intelligencePersonnage;
    private Button creationPersonnage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personnage);

        niveauPersonnage = (EditText) findViewById(R.id.niveau_personnage);
        forcePersonnage = (EditText) findViewById(R.id.force_personnage);
        agilitePersonnage = (EditText) findViewById(R.id.agilite_personnage);
        intelligencePersonnage = (EditText) findViewById(R.id.intelligence_personnage);
        creationPersonnage = (Button) findViewById(R.id.creation_personnage);

        creationPersonnage.setEnabled(false);

        Joueur joueur = getIntent().getParcelableExtra("joueur");

        creationPersonnage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                PersonnageActivity.this.finish();

            }
        });

    }
}
