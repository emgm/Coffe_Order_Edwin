package com.android.curso.coffe_order_edwin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnOrdenar, btnMas, btnMenos;

    private EditText etName;

    private TextView tvMostrarOrden, tvCantidad;

    private CheckBox cbAdicionalVainilla;

    int cantidad = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbAdicionalVainilla = (CheckBox) findViewById(R.id.cbAdicionalVainilla);

        btnOrdenar = (Button) findViewById(R.id.btnOrdenar);

        etName = (EditText) findViewById(R.id.etName);

        tvMostrarOrden = (TextView) findViewById(R.id.tvMostrarOrden);
        tvCantidad = (TextView) findViewById(R.id.tvCantidad);

        btnMas = (Button) findViewById(R.id.btnMas);
        btnMenos = (Button) findViewById(R.id.btnMenos);


        btnOrdenar.setOnClickListener(this);
        btnMas.setOnClickListener(this);
        btnMenos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnOrdenar:

               String name=  etName.getText().toString(); // Obtnemos el nombre

                int totalAPagar=0;

                if(!(name.equals("")) && !(cantidad == 0)) {

                    totalAPagar = cantidad * 3;

                    String ingredientesAdicionales = "N/E";

                     if(cbAdicionalVainilla.isChecked()){

                         ingredientesAdicionales = "Vainilla";

                         totalAPagar = totalAPagar + cantidad ;
                     }

                    tvMostrarOrden.setText("Usuario: " + name + "\n" +
                                           "Cantidad Cafes: " + String.valueOf(cantidad) + "\n" +
                                            "Ingredientes Adicionales: " + ingredientesAdicionales + "\n" +
                                            "Valor Compra: " + "$US " + totalAPagar + " Dolares");


                }else{

                    tvMostrarOrden.setText("Revise campos en vacios");
                }

                etName.setText("");
                tvCantidad.setText("0");
                cbAdicionalVainilla.setChecked(false);

                break;

            case R.id.btnMas:

                cantidad = Integer.parseInt(tvCantidad.getText().toString()); // Convertimos a Entero

                cantidad = cantidad + 1; // Adicionamos una unidad

                tvCantidad.setText(String.valueOf(cantidad)); // convertimos a string


                break;


            case R.id.btnMenos:

                cantidad = Integer.parseInt(tvCantidad.getText().toString()); // Convertimos a Entero

                cantidad = cantidad - 1; // Adicionamos una unidad

                if(cantidad >= 0) {

                    tvCantidad.setText(String.valueOf(cantidad)); // convertimos a string

                }
                break;

        }








    }
}
