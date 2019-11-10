package fr.christopher.magicworldandroid.Controller;

import androidx.appcompat.app.AppCompatActivity;
import fr.christopher.magicworldandroid.R;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button boutonDemarrer;
    private Button joueur1;
    private Button joueur2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       joueur1 = (Button) findViewById(R.id.joueur_1);
       joueur2 = (Button) findViewById(R.id.joueur_2);
       boutonDemarrer = (Button) findViewById(R.id.bouton_demarrer);

        joueur2.setEnabled(false);
        boutonDemarrer.setEnabled(false);

        joueur1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The user just clicked
            }
        });

        joueur2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The user just clicked
            }
        });

        boutonDemarrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The user just clicked
            }
        });

    }
}
