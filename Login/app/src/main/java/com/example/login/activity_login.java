package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.CallableStatement;
import java.sql.Types;

public class activity_login extends AppCompatActivity {

    private static clsConexionPG con = new clsConexionPG();
    Variables_Globales va = Variables_Globales.getInstance();

    Button btniniciar;
    EditText txtusuario, txtclave;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btniniciar = findViewById(R.id.submit);
        txtusuario = findViewById(R.id.textEmail);
        txtclave = findViewById(R.id.textPassword);

        btniniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Inicio_Sesion(txtusuario.getText().toString(),txtclave.getText().toString());
            }
        });
//        btniniciar.setOnClickListener (v -> Inicio_Sesion(txtusuario.getText().toString(),txtclave.getText().toString()));
    }

    public void Inicio_Sesion(String usuario, String clave){
        try{
            String storeProcedureCall = "{CALL login(?,?,?,?,?,?,?)}";
            CallableStatement cStmt = con.conexionBD().prepareCall(storeProcedureCall);
            cStmt.setString(1, usuario);
            cStmt.setString(2, clave);
            cStmt.registerOutParameter(3, Types.VARCHAR);
            cStmt.registerOutParameter(4, Types.VARCHAR);
            cStmt.registerOutParameter(5, Types.VARCHAR);
            cStmt.registerOutParameter(6, Types.INTEGER);
            cStmt.registerOutParameter(7, Types.VARCHAR);

            cStmt.executeUpdate();
            String _email = cStmt.getString(1);
            String _name = cStmt.getString(3);
            String _phone = cStmt.getString(4);
            String _address = cStmt.getString(5);
            Integer _userid = cStmt.getInt(6);
            String _response = cStmt.getString(7);

            if (_response.equals("OK")){
                va.set_codigousuario(_userid);
                va.set_nombre(_name);
                va.set_direccion(_address);
                va.set_telefono(_phone);
                va.set_email(_email);

                Intent menu=new Intent(this,activity_menu.class);
                startActivity(menu);
            }else {
                Toast.makeText(getApplicationContext(), _response, Toast.LENGTH_SHORT).show();
            }

        }catch (Exception e){
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
