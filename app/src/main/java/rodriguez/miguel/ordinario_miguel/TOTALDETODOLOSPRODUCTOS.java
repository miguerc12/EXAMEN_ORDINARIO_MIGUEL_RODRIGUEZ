package rodriguez.miguel.ordinario_miguel;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;

public class TOTALDETODOLOSPRODUCTOS extends AppCompatActivity {

    private TextView txtPrecioTotalProducto1;
    private TextView txtPrecioTotalProducto2;
    private TextView txtPrecioTotalProducto3;
    private TextView txtPrecioTotalTodosLosProductos;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_totaldetodolosproductos);

        txtPrecioTotalProducto1 = findViewById(R.id.txtPrecioTotalProducto1);
        txtPrecioTotalProducto2 = findViewById(R.id.txtPrecioTotalProducto2);
        txtPrecioTotalProducto3 = findViewById(R.id.txtPrecioTotalProducto3);
        txtPrecioTotalTodosLosProductos = findViewById(R.id.txtPrecioTotalTodosLosProductos);
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);


        int cantidadProducto1 = sharedPreferences.getInt("cantidad", 0);
        double precioUnitarioProducto1 = 800.0;
        double precioTotalProducto1 = cantidadProducto1 * precioUnitarioProducto1;


        int cantidadProducto2 = sharedPreferences.getInt("cantidad_producto2", 0);
        double precioUnitarioProducto2 = 500.0;
        double precioTotalProducto2 = cantidadProducto2 * precioUnitarioProducto2;


        int cantidadProducto3 = sharedPreferences.getInt("cantidad", 0);
        double precioUnitarioProducto3 = 300.0;
        double precioTotalProducto3 = cantidadProducto3 * precioUnitarioProducto3;


        txtPrecioTotalProducto1.setText("Precio total producto 1: $" + precioTotalProducto1);
        txtPrecioTotalProducto2.setText("Precio total producto 2: $" + precioTotalProducto2);
        txtPrecioTotalProducto3.setText("Precio total producto 3: $" + precioTotalProducto3);


        double precioTotal = precioTotalProducto1 + precioTotalProducto2 + precioTotalProducto3;


        txtPrecioTotalTodosLosProductos.setText("Precio total de todos los productos: $" + precioTotal);


        SharedPreferences sharedPreferences = getSharedPreferences("MiPreferencia", Context.MODE_PRIVATE);


        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat("precioTotal", (float) precioTotal);
        editor.apply();





        Button btnRegresar = findViewById(R.id.btnRegresar);
        Button btntotal3cosas = findViewById(R.id.btntotal3cosas);


        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(TOTALDETODOLOSPRODUCTOS.this, MENUJERSEYS.class);
                startActivity(intent);

                finish();
            }
        });

        btntotal3cosas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(TOTALDETODOLOSPRODUCTOS.this, TOTAL3COSAS.class);
                startActivity(intent);


                finish();
            }
        });

    }
}
