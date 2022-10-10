package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class activity_menu extends AppCompatActivity {
    Variables_Globales va = Variables_Globales.getInstance();

    TextView txtnombre, txtdireccion, txttelefono, txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        txtnombre = findViewById(R.id.textNombre);
        txtdireccion = findViewById(R.id.textDireccion);
        txttelefono = findViewById(R.id.textTelefono);
        txtEmail = findViewById(R.id.textEmail2);

        if (va.get_codigousuario() != 0) {
            txtnombre.setText(va.get_nombre().toString());
            txtdireccion.setText(va.get_direccion().toString());
            txttelefono.setText(va.get_telefono().toString());
            txtEmail.setText(va.get_email().toString());
        }
    }
}