package agora.ccna.exemplesharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //variable pour l'ensemble des données à stocker dans le sharedpreferences
    public static String prefs = "PREFERENCES";
    //clés pour chaque données
    public static String keyNom = "NOM";
    public static String keyPass = "PASS";
    public static String keyIp = "IP";

    private EditText ednom,edpass, edip;
    Button bstop,bintent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //instanciation des widget edittext
        ednom = findViewById(R.id.ednom);
        edpass = findViewById(R.id.edpass);
        edip = findViewById(R.id.edip);
        //récupération des shared. s'il est vide, on applique les valeurs par défaut (2ème argument)
        SharedPreferences shp = getSharedPreferences(prefs , 0);
        ednom.setText(shp.getString(keyNom , "Simplet"));
        edpass.setText(shp.getString(keyPass , "simplet"));
        edip.setText(shp.getString(keyIp , "172.20.1.1"));
        //instanciation des boutons pour:
        //      fermer l'appli et vérifer que els sharedpreferences seront bien réappliqués lors de la réouverture.
        //      démarrer une intent qui récupère et affiche les sharedPreferences
        bstop = findViewById(R.id.bstop);
        bstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mise à jour des valeurs en fonction des edittext
                enregistre();
                finish();
            }
        });
        bintent = findViewById(R.id.bintent);
        bintent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enregistre();
                Intent it = new Intent(MainActivity.this , deuxiemePage.class);
                startActivity(it);
            }
        });
    }
    //méthode d'enregistrement des nouvelles valeurs dans le sharedPreferences
    public void enregistre(){
        SharedPreferences shp = getSharedPreferences(prefs , 0);
        SharedPreferences.Editor editor = shp.edit();
        editor.putString(keyNom, ednom.getText().toString());
        editor.putString(keyPass, edpass.getText().toString());
        editor.putString(keyIp, edip.getText().toString());
        //enregistrement des nouvelles valeurs dans le sharedpreferences
        editor.commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
