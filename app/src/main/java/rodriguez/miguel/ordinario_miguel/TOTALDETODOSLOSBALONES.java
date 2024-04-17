package rodriguez.miguel.ordinario_miguel;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class TOTALDETODOSLOSBALONES extends AppCompatActivity {


    private TextView txtPrecioTotalBalon1;
    private TextView txtPrecioTotalBalon2;
    private TextView txtPrecioTotalBalon3;

    private TextView txtPrecioTotalTodosLosProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_totaldetodoslosbalones);


        txtPrecioTotalBalon1 = findViewById(R.id.txtPrecioTotalBalon1);
        txtPrecioTotalBalon2 = findViewById(R.id.txtPrecioTotalBalon2);
        txtPrecioTotalBalon3 = findViewById(R.id.txtPrecioTotalBalon3);
        txtPrecioTotalTodosLosProductos = findViewById(R.id.txtPrecioTotalTodosLosProductos2);


        SharedPreferences sharedPreferencesProducto1 = getSharedPreferences("precio_total", Context.MODE_PRIVATE);


        float precioTotalGuardadoProducto1 = sharedPreferencesProducto1.getFloat("precio_total_key", 0.0f);


        txtPrecioTotalBalon1.setText("Precio total guardado del producto 1: $" + precioTotalGuardadoProducto1);


        SharedPreferences sharedPreferencesProducto2 = getSharedPreferences("precio_total2", Context.MODE_PRIVATE);


        float precioTotalGuardadoProducto2 = sharedPreferencesProducto2.getFloat("precio_total_key2", 0.0f);


        txtPrecioTotalBalon2.setText("Precio total guardado del producto 2: $" + precioTotalGuardadoProducto2);


        SharedPreferences sharedPreferencesProducto3 = getSharedPreferences("precio_total3", Context.MODE_PRIVATE);


        float precioTotalGuardadoProducto3 = sharedPreferencesProducto3.getFloat("precio_total_key3", 0.0f);


        txtPrecioTotalBalon3.setText("Precio total guardado del producto 3: $" + precioTotalGuardadoProducto3);


        double precioTotal = precioTotalGuardadoProducto1 + precioTotalGuardadoProducto2 + precioTotalGuardadoProducto3;


        txtPrecioTotalTodosLosProductos.setText("Precio total de todos los productos: $" + precioTotal);


        SharedPreferences sharedPreferences = getSharedPreferences("Balones", Context.MODE_PRIVATE);


        SharedPreferences.Editor editor = sharedPreferences.edit();


        editor.putFloat("precio_total", (float) precioTotal);


        editor.apply();

        Button btnRegresar = findViewById(R.id.btnRegresar);
        Button btnTotal3CosasBalones = findViewById(R.id.btntotal3cosas);
        btnTotal3CosasBalones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(TOTALDETODOSLOSBALONES.this, TOTAL3COSAS.class);


                startActivity(intent);
            }
        });
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(TOTALDETODOSLOSBALONES.this, MENUBALONES.class);
                startActivity(intent);

                finish();
            }
        });

    }


}