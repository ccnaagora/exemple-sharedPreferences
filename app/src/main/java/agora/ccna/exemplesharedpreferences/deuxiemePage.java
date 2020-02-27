package agora.ccna.exemplesharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class deuxiemePage extends AppCompatActivity {

    TextView tv;
    Button bretour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deuxieme_page);
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
        //instanciation du texview et affichage du sharedpreferences pour vérification
        tv = findViewById(R.id.textView);
        tv.setText("");
        //récupération des valeurs du sharedPreferences
        SharedPreferences shp = getSharedPreferences(MainActivity.prefs , 0);
        tv.append(shp.getString(MainActivity.keyNom , "----------")+"\n\r");
        tv.append(shp.getString(MainActivity.keyPass , "***********")+"\n\r");
        tv.append(shp.getString(MainActivity.keyIp , "xxx.xxx.xxx.xxx")+"\n\r");
        bretour = findViewById(R.id.bretour);
        bretour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
