package fr.christopher.magicworldandroid.controller;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import fr.christopher.magicworldandroid.model.Joueur;
import fr.christopher.magicworldandroid.R;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
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

                personnageActivityIntent.putExtra("joueur", joueur);

                startActivityForResult(personnageActivityIntent, 1);

            }
        });

        rodeur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                joueur.choix(2);

                Intent personnageActivityIntent = new Intent(JoueurActivity.this, PersonnageActivity.class);

                personnageActivityIntent.putExtra("joueur", joueur);

                startActivityForResult(personnageActivityIntent, 2);

            }
        });

        mage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                joueur.choix(3);

                Intent personnageActivityIntent = new Intent(JoueurActivity.this, PersonnageActivity.class);

                personnageActivityIntent.putExtra("joueur", joueur);

                startActivityForResult(personnageActivityIntent, 3);

            }
        });

        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            switch (requestCode){
                case 1 : //action apres avoir fini la recuperation du joueur.
                    break;
                case 2 : //action apres avoir fini la recuperation du joueur.
                    break;
                case 3 : //action apres avoir fini la recuperation du joueur.
                    break;
            }

        }

    }
}
