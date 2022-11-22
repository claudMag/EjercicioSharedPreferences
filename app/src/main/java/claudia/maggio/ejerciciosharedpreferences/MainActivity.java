package claudia.maggio.ejerciciosharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText txtEmail;
    private EditText txtPassword;
    private Button btnLogin;

    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializaVariables();

        if (logeado()){
            mostrarActividadBienvenida();
            //para que no vuelva a la pagina de login si le da al boton de atras
            finish();
        }


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String correo = txtEmail.getText().toString();
                String password = txtPassword.getText().toString();

                //mejor comprobacion de email y password --> equalesIgnoreCase(1234)..

                if (!correo.isEmpty() && !password.isEmpty()){
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean(Constantes.LOGGED, true);
                    editor.apply();

                    mostrarActividadBienvenida();
                    finish();
                }
            }
        });


    }

    private void mostrarActividadBienvenida() {
        Intent intent = new Intent(this, BienvenidaActivity.class);
        startActivity(intent);
    }

    private boolean logeado() {

        boolean logged = sharedPreferences.getBoolean(Constantes.LOGGED, false);

        if (logged){
            return true;
        }

        return false;
    }

    private void inicializaVariables() {
        txtEmail = findViewById(R.id.txtCorreoMain);
        txtPassword = findViewById(R.id.txtPasswordMain);
        btnLogin = findViewById(R.id.btnLoginMain);

        sharedPreferences = getSharedPreferences(Constantes.LOGIN, MODE_PRIVATE);
    }
}