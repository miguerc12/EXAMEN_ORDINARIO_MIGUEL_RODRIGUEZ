package rodriguez.miguel.ordinario_miguel;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import android.content.Intent;
import android.content.SharedPreferences;

public class MENUJERSEYS extends AppCompatActivity {

    private TextView txtPrecioTotal;
    private double precioTotal = 0.0;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menujerseys);

        txtPrecioTotal = findViewById(R.id.txtPrecioTotal);
        sharedPreferences = getSharedPreferences("compras", MODE_PRIVATE);

        Button btnAgregarCompra1 = findViewById(R.id.btnAgregarCompra1);
        Button btnAgregarCompra2 = findViewById(R.id.btnAgregarCompra2);
        Button btnAgregarCompra3 = findViewById(R.id.btnAgregarCompra3);
        Button btnVerDescripcionJERSEY1 = findViewById(R.id.btnVerDescripcionJERSEY1);
        Button btnVerDescripcionJERSEY2 = findViewById(R.id.btnVerDescripcionJERSEY2);
        Button btnVerDescripcionJERSEY3 = findViewById(R.id.btnVerDescripcionJERSEY3);

        btnAgregarCompra1.setOnClickListener(agregarCompraClickListener);
        btnAgregarCompra2.setOnClickListener(agregarCompraClickListener);
        btnAgregarCompra3.setOnClickListener(agregarCompraClickListener);

        btnVerDescripcionJERSEY1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MENUJERSEYS.this, DESCRIPCIONJERSEY1.class);
                startActivity(intent);
            }
        });

        btnVerDescripcionJERSEY2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MENUJERSEYS.this, DESCRIPCIONJERSEY2.class);
                startActivity(intent);
            }
        });

        btnVerDescripcionJERSEY3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MENUJERSEYS.this, DESCRIPCIONJERSEY3.class);
                startActivity(intent);
            }
        });

        Button btnAgregarCompra = findViewById(R.id.btnAgregarCompra);
        btnAgregarCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarCompras();
                abrirActividadCompras();
            }
        });


        Button btnIrVerTotalJerseys = findViewById(R.id.btnIrVerTotalJerseys);


        btnIrVerTotalJerseys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MENUJERSEYS.this, TOTALDETODOLOSPRODUCTOS.class);
                startActivity(intent);
            }
        });
    }

    private View.OnClickListener agregarCompraClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            double precio = Double.parseDouble((String) v.getTag());
            precioTotal += precio;
            actualizarPrecioTotal();
        }
    };

    private void actualizarPrecioTotal() {
        txtPrecioTotal.setText("Precio total: $" + precioTotal);
    }

    private void guardarCompras() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat("precioTotal", (float) precioTotal);


        editor.putString("nombreProducto1", "JERSEY AMERICA");
        editor.putFloat("precioProducto1", 800);
        editor.putInt("imagenProducto1", R.drawable.img_6);

        editor.putString("nombreProducto2", "Jersey CITY");
        editor.putFloat("precioProducto2", 500);
        editor.putInt("imagenProducto2", R.drawable.img_7);

        editor.putString("nombreProducto3", "Jersey MEXICO");
        editor.putFloat("precioProducto3", 600);
        editor.putInt("imagenProducto3", R.drawable.img_8);

        editor.apply();
    }

    private void abrirActividadCompras() {
        Intent intent = new Intent(MENUJERSEYS.this, COMPRAJERSEYS.class);
        startActivity(intent);
    }
}