package fr.christopher.magicworldandroid.controller;

import androidx.appcompat.app.AppCompatActivity;
import fr.christopher.magicworldandroid.R;
import fr.christopher.magicworldandroid.model.Joueur;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CombatActivity extends AppCompatActivity {

    private TextView choixAttaque;
    private Button attaqueBasique;
    private Button attaqueSpeciale;
    private TextView resultatAttaque;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combat);

        choixAttaque = (TextView) findViewById(R.id.texte_choix_attaque);
        attaqueBasique = (Button) findViewById(R.id.attaque_basique);
        attaqueSpeciale = (Button) findViewById(R.id.attaque_speciale);
        resultatAttaque = (TextView) findViewById(R.id.resultat_attaque);

        final Joueur joueur1 = getIntent().getParcelableExtra("joueur1");
        final Joueur joueur2 = getIntent().getParcelableExtra("joueur2");

        Joueur attaquant = joueur1;
        Joueur defenseur = joueur2;
        Joueur temp;

        choixAttaque.setText("Joueur 1 a vous d'attaquer !");

        attaqueBasique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                attaquant.setAttaqueBasique(defenseur);

                temp = attaquant;
                attaquant = defenseur;
                defenseur = temp;

                choixAttaque.setText("Joueur 2 a vous d'attaquez !");
            }
        });

        attaqueSpeciale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                attaquant.setAttaqueSpecial(defenseur);

                temp = attaquant;
                attaquant = defenseur;
                defenseur = temp;

                choixAttaque.setText("Joueur 2 a vous d'attaquez !");
            }
        });
    }
}
