package com.example.login;

import android.os.StrictMode;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class clsConexionPG {
    Connection conexion = null;

    public Connection conexionBD() {
        try{
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/LoginDB", "postgres", "admin");

            if (conexion != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }

        }catch (SQLException e) {
        System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }catch (Exception e){
            System.err.println("Error Conexion: "+ e.toString());
        }
        return conexion;
    }

    protected void cerrar_conexion(Connection con) throws Exception{
        con.close();
    }
}
