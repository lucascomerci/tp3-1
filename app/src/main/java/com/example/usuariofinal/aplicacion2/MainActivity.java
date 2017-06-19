package com.example.usuariofinal.aplicacion2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLogin = (Button) findViewById(R.id.btnLogin);          //busco en R el id btnlogin del xml para utilizarlo con codigo y lo llamo igual
        final EditText usuario = (EditText) findViewById(R.id.usuario);  // se debe castear, en este caso EditText
        final EditText pass = (EditText) findViewById(R.id.pass);        // lo mismo con el password

        btnLogin.setOnClickListener(new View.OnClickListener() {          // si el boton btnLogin es precionado...
            @Override
            public void onClick(View v) {
                if ((usuario.getText().toString().equals("ites")) && (pass.getText().toString().equals("1234"))){   //si user es ites y contraseña 1234
                    toastLogueoCorrecto(1);  //mostrar toast login correcto
                    abriractividad(v,usuario.getText().toString());       //llamo al metodo abriractividad, le paso como parametro el string del usuario
                }else {
                    toastLogueoCorrecto(0); //muestro mensaje de error
                    usuario.setText("");    // limpio text ingresado por el usuario
                    pass.setText("");      //lompio contraseña
                }
            }
      });
}


    public void toastLogueoCorrecto(int n){  //funcion para mostrar toast de logueo
        if (n==0) Toast.makeText(this, "Error. Intente de nuevo", Toast.LENGTH_LONG).show(); //logueo incorrecto
        else Toast.makeText(this, "Login correcto...", Toast.LENGTH_SHORT).show();  //logue correcto
    }

    public void abriractividad(View v, String s){  // me manda a la otra actividad Main2Activity
        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra("sesion_usuario",s);  // agrego una variable de session, que es el nombre de usuario
        startActivity(i);                 //startttt

    }

    public void activity_main2(View view) {
    }
}
