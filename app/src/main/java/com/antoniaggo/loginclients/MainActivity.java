package com.antoniaggo.loginclients;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {

    Button btnDatePicker, btnSiguiente;
    TextInputEditText tietNombre, tietFecha, tietEmail, tietTelefono, tietDescripcionContacto;
    int  mYear, mMonth, mDay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tietNombre = findViewById(R.id.tietNombre);
        tietFecha = findViewById(R.id.tietFecha);
        tietTelefono = findViewById(R.id.tietTelefono);
        tietEmail = findViewById(R.id.tietEmail);
        tietDescripcionContacto = findViewById(R.id.tietDescripcionContacto);

        btnDatePicker = findViewById(R.id.btn_date);
        btnSiguiente = findViewById(R.id.btn_siguiente);

        btnDatePicker.setOnClickListener(this);
        btnSiguiente.setOnClickListener(this);

    try{
        // Recogemos los extras que nos envía la Activity MainActivity.class
        Bundle parametros = getIntent().getExtras();
        // getString(getResources().getString(R.string.pnombre)) equivale a poner pnombre que está en strings.xml
        String nombre = parametros.getString(getResources().getString(R.string.pnombre));
        String fecha = parametros.getString(getResources().getString(R.string.pfecha));
        String telefono = parametros.getString(getResources().getString(R.string.ptelefono));
        String email = parametros.getString(getResources().getString(R.string.pemail));
        String descripcionContacto = parametros.getString(getResources().getString(R.string.pdescripcion));

        tietNombre.setText(nombre);
        tietFecha.setText(fecha);
        tietTelefono.setText(telefono);
        tietEmail.setText(email);
        tietDescripcionContacto.setText(descripcionContacto);
        }catch(Exception e){
            Toast.makeText(getBaseContext(),"Error"+e, Toast.LENGTH_SHORT).show();
        }
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
                intent.putExtra(getResources().getString(R.string.pnombre), tietNombre.getText().toString());
                intent.putExtra(getResources().getString(R.string.pfecha), tietFecha.getText().toString());
                intent.putExtra(getResources().getString(R.string.ptelefono), tietTelefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.pemail), tietEmail.getText().toString());
                intent.putExtra(getResources().getString(R.string.pdescripcion), tietDescripcionContacto.getText().toString());

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

