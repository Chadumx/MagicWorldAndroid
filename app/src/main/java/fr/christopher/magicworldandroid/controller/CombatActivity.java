package fr.christopher.magicworldandroid.controller;

import androidx.appcompat.app.AppCompatActivity;
import fr.christopher.magicworldandroid.R;

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

        // TODO recuper le joueur 1 et joueur 2.
        // TODO definir le joueur 1 en attaquant et le joueur 2 en defenseur.
        // TODO afficher que c'est au joueur 1 d'attaquer.

        attaqueBasique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO excuter la attaque basique de l'attaquant sur le defenseur.
                // TODO inverser les role de l'attaquant et du defenseur.
                // TODO afficher au nouveau attaquant d'attaquer.
            }
        });

        attaqueSpeciale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO excuter la attaque speciale de l'attaquant sur le defenseur.
                // TODO inverser les role de l'attaquant et du defenseur.
                // TODO afficher au nouveau attaquant d'attaquer.
            }
        });
    }
}
