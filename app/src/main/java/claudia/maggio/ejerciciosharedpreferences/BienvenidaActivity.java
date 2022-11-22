package claudia.maggio.ejerciciosharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BienvenidaActivity extends AppCompatActivity {

    private Button btnEliminar;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);

        sharedPreferences = getSharedPreferences(Constantes.LOGIN, MODE_PRIVATE);

        btnEliminar = findViewById(R.id.btnQuitarPersistenciaBienvenida);

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                //tengo que hacer un startactivity porque en el main sieempre he hecho un finish
                startActivity(new Intent(BienvenidaActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}