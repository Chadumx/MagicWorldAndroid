package fr.christopher.magicworldandroid.controller;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import fr.christopher.magicworldandroid.model.Joueur;
import fr.christopher.magicworldandroid.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class JoueurActivity extends AppCompatActivity {

    private Button guerrier;
    private Button rodeur;
    private Button mage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joueur);

        guerrier = (Button) findViewById(R.id.guerrier);
        rodeur = (Button) findViewById(R.id.rodeur);
        mage = (Button) findViewById(R.id.mage);

        Joueur joueur = getIntent().getParcelableExtra("joueur");

        guerrier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                joueur.choix(1);

                Intent personnageActivityIntent = new Intent(JoueurActivity.this, PersonnageActivity.class);
                startActivity(personnageActivityIntent);

            }
        });

        rodeur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                joueur.choix(2);

                Intent personnageActivityIntent = new Intent(JoueurActivity.this, PersonnageActivity.class);
                startActivity(personnageActivityIntent);

            }
        });

        mage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                joueur.choix(3);

                Intent personnageActivityIntent = new Intent(JoueurActivity.this, PersonnageActivity.class);
                startActivity(personnageActivityIntent);

            }
        });

        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == 1){
                //action apres avoir fini la recuperation du joueur.
            } else if (requestCode == 2) {

            }
        }

    }
}
