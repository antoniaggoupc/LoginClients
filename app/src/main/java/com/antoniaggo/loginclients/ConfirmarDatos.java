package com.antoniaggo.loginclients;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;


public class ConfirmarDatos extends AppCompatActivity implements
        View.OnClickListener{

    private TextInputEditText tietNombreConfirmarDatos;
    private TextInputEditText tietFechaConfirmarDatos;
    private TextInputEditText tietTelefonoConfirmarDatos;
    private TextInputEditText tietEmailConfirmarDatos;
    private TextInputEditText tietDescripcionContactoConfirmarDatos;

    private Button btn_editarConfirmarDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        // Recogemos los extras que nos envía la Activity MainActivity.class
        Bundle parametros = getIntent().getExtras();
        // getString(getResources().getString(R.string.pnombre)) equivale a poner pnombre que está en strings.xml
        String nombre = parametros.getString(getResources().getString(R.string.pnombre));
        String fecha = parametros.getString(getResources().getString(R.string.pfecha));
        String telefono = parametros.getString(getResources().getString(R.string.ptelefono));
        String email = parametros.getString(getResources().getString(R.string.pemail));
        String descripcionContacto = parametros.getString(getResources().getString(R.string.pdescripcion));

        tietNombreConfirmarDatos = findViewById(R.id.tietNombreConfirmarDatos);
        tietFechaConfirmarDatos = findViewById(R.id.tietFechaConfirmarDatos);
        tietTelefonoConfirmarDatos = findViewById(R.id.tietTelefonoConfirmarDatos);
        tietEmailConfirmarDatos = findViewById(R.id.tietEmailConfirmarDatos);
        tietDescripcionContactoConfirmarDatos = findViewById(R.id.tietDescripcionContactoConfirmarDatos);
        btn_editarConfirmarDatos = findViewById(R.id.btn_editarConfirmarDatos);

        tietNombreConfirmarDatos.setText(nombre);
        tietFechaConfirmarDatos.setText(fecha);
        tietTelefonoConfirmarDatos.setText(telefono);
        tietEmailConfirmarDatos.setText(email);
        tietDescripcionContactoConfirmarDatos.setText(descripcionContacto);

        btn_editarConfirmarDatos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v == btn_editarConfirmarDatos) {

            /*
             * Para cambiar de pantalla de MainActivity a DetalleContacto
             * al pulsar sobre un ítem de MainActivity
             */
            Intent intent = new Intent(ConfirmarDatos.this, MainActivity.class);
            /*
             * Para enviar los datos de un usuario a la Activity ConfirmarDatos
             */
            intent.putExtra(getResources().getString(R.string.pnombre), tietNombreConfirmarDatos.getText().toString());
            intent.putExtra(getResources().getString(R.string.pfecha), tietFechaConfirmarDatos.getText().toString());
            intent.putExtra(getResources().getString(R.string.ptelefono), tietTelefonoConfirmarDatos.getText().toString());
            intent.putExtra(getResources().getString(R.string.pemail), tietEmailConfirmarDatos.getText().toString());
            intent.putExtra(getResources().getString(R.string.pdescripcion), tietDescripcionContactoConfirmarDatos.getText().toString());

            startActivity(intent);
            /* Elimino esta Activity para que no se vayan congelando y guardando en background ya
             * que es como se comporta por defecto.  Una activity encima de la otra,ect.
             * Con esta forma de programar sólo tengo siempre una Activity ejecutándose
             * y mi aplicación no se ralentiza a medida que el usuario la va usando
             * ya que no se van superponiendo las activies una encima de la otra
             */
            finish();

        }
    }
}