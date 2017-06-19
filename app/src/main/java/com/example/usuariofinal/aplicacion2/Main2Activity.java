package com.example.usuariofinal.aplicacion2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.Manifest;
import android.content.pm.PackageManager;

public class Main2Activity extends AppCompatActivity {

  //  private Button btnMarcar;
    private EditText ncelular;    //lo declaro afuera del onCreate para poder utilizarlo desde MarcarLlamada

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle parametros = getIntent().getExtras();  			// accede a todos los extras utilizados y declarados en el Intent
        String usuario = parametros.getString("sesion_usuario");   //obtengo el usuario, queda guardado en session_usuario

        TextView saludo_usuario = (TextView) findViewById(R.id.saludo_usuario); //obteng el control del textview para poder editarlo por codigo
        String formaSaludo = "Bievenido "+usuario;                              //creo un string porque no puedo concatenar directamente en TextView
        saludo_usuario.setText(formaSaludo);                                    // Muestro por pantalla

        Button  btnMarcar = (Button) findViewById(R.id.btnMarcar);          //instancion btnMarcar declarado en el xml para poder utilizarlo por codigo
        ncelular = (EditText) findViewById(R.id.ncelular);

        btnMarcar.setOnClickListener(new View.OnClickListener(){            //Si btnMarcar es precionado
            @Override
            public void onClick(View v) {
                marcarLlamada(v);                                           //llama al metodo marcarLlamada
            }
        });

        Button btnFinalizar = (Button) findViewById(R.id.btnFinalizar);
        btnFinalizar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finalizaractividad(v);
            }
        });

    }

    public void marcarLlamada(View v) {                             //
        String numero = ncelular.getText().toString();              // Guarda en un string el numero del edittext
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + numero));    //llama al ACTION_CALL con el numero
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) { ///si no tiene permiso la aplicacion para llamar...
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;                                                                                                            //finaliza
        }
        startActivity(intent);                                                                                                  //realiza la llamada
    }

    public void finalizaractividad(View v){
        finish();
    }
}



