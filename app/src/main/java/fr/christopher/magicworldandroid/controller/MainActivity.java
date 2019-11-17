package fr.christopher.magicworldandroid.controller;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import fr.christopher.magicworldandroid.model.Joueur;
import fr.christopher.magicworldandroid.R;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button boutonDemarrer;
    private Button joueur01;
    private Button joueur02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       joueur01 = (Button) findViewById(R.id.joueur_1);
       joueur02 = (Button) findViewById(R.id.joueur_2);
       boutonDemarrer = (Button) findViewById(R.id.bouton_demarrer);

        joueur02.setEnabled(false);
        boutonDemarrer.setEnabled(false);

        joueur01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent joueurActivityIntent = new Intent(MainActivity.this, JoueurActivity.class);

                Joueur joueur1 = new Joueur();
                joueurActivityIntent.putExtra("joueur", joueur1);
                startActivityForResult(joueurActivityIntent, 1);

            }
        });

        joueur02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent joueurActivityIntent = new Intent(MainActivity.this, JoueurActivity.class);

                Joueur joueur2 = new Joueur();
                joueurActivityIntent.putExtra("joueur", joueur2);
                startActivityForResult(joueurActivityIntent, 2);

            }
        });

        boutonDemarrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent combatActivityIntent = new Intent(MainActivity.this, CombatActivity.class);

                combatActivityIntent.putExtra("joueur1", this.joueur1);
                combatActivityIntent.putExtra("joueur2", this.joueur2);
                startActivity(combatActivityIntent);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 1 : Joueur joueur1 = data.getIntExtra(, null);
                     joueur02.setEnabled(true);
                break;
            case 2 : Joueur joueur2 = data.getIntExtra(, null);
                     boutonDemarrer.setEnabled(true);
                break;
        }
    }
}
