package com.antoniaggo.loginclients;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {

    Button btnDatePicker, btnSiguiente;
    TextInputEditText tietNombre, tietFecha, tietTelefono, tietDescripcionContacto;
    int  mYear, mMonth, mDay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tietFecha = findViewById(R.id.tietFecha);
        tietNombre = findViewById(R.id.tietNombre);
        tietFecha = findViewById(R.id.tietFecha);
        tietTelefono = findViewById(R.id.tietTelefono);
        tietDescripcionContacto = findViewById(R.id.tietDescripcionContacto);

        btnDatePicker = findViewById(R.id.btn_date);
        btnSiguiente = findViewById(R.id.btn_siguiente);

        btnDatePicker.setOnClickListener(this);
        btnSiguiente.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        if (v == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    (view, year, monthOfYear, dayOfMonth) -> tietFecha.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year), mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == btnSiguiente) {
            /*
             * Para cambiar de pantalla de MainActivity a DetalleContacto
             * al pulsar sobre un ítem de MainActivity
             */
            Intent intent = new Intent(MainActivity.this,ConfirmarDatos.class);
            /*
             * Para enviar los datos de un usuario a la Activity ConfirmarDatos
             */
            intent.putExtra(getResources().getString(R.string.pnombre), tietFecha.getText().toString());
            intent.putExtra(getResources().getString(R.string.ptelefono), tietFecha.getText().toString());
            intent.putExtra(getResources().getString(R.string.pemail), tietFecha.getText().toString());
            intent.putExtra(getResources().getString(R.string.pfecha), tietFecha.getText().toString());

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

