package rodriguez.miguel.ordinario_miguel;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.content.Intent;
import android.content.SharedPreferences;

public class MENUBALONES extends AppCompatActivity {


    private TextView txtPrecioTotal;
    private double precioTotal = 0.0;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menubalones);

        txtPrecioTotal = findViewById(R.id.txtPrecioTotal);
        sharedPreferences = getSharedPreferences("compras", MODE_PRIVATE);

        Button btnAgregarCompraBalon1 = findViewById(R.id.btnAgregarCompraBalon1);
        Button btnAgregarCompraBalon2 = findViewById(R.id.btnAgregarCompraBalon2);
        Button btnAgregarCompraBalon3 = findViewById(R.id.btnAgregarCompraBalon3);
        Button btnVerDescripcionBalon1 = findViewById(R.id.btnVerDescripcionBalon1);
        Button btnVerDescripcionBalon2 = findViewById(R.id.btnVerDescripcionBalon2);
        Button btnVerDescripcionBalon3 = findViewById(R.id.btnVerDescripcionBalon3);

        btnAgregarCompraBalon1.setOnClickListener(agregarCompraClickListener);
        btnAgregarCompraBalon2.setOnClickListener(agregarCompraClickListener);
        btnAgregarCompraBalon3.setOnClickListener(agregarCompraClickListener);




        btnVerDescripcionBalon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MENUBALONES.this, DESCRIPCIONBALON1.class);
                startActivity(intent);
            }
        });

        btnVerDescripcionBalon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MENUBALONES.this, DESCRIPCIONBALON2.class);
                startActivity(intent);
            }
        });

        btnVerDescripcionBalon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MENUBALONES.this, DESCRIPCIONBALON3.class);
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


        editor.putString("nombreProducto1", "Balón Adidas azul");
        editor.putFloat("precioProducto1", 20);
        editor.putInt("imagenProducto1", R.drawable.img_3);

        editor.putString("nombreProducto2", "Balón adidas rosa");
        editor.putFloat("precioProducto2", 25);
        editor.putInt("imagenProducto2", R.drawable.img_4);

        editor.putString("nombreProducto3", "Balón premier");
        editor.putFloat("precioProducto3", 30);
        editor.putInt("imagenProducto3", R.drawable.img_5);

        editor.apply();
    }

    private void abrirActividadCompras() {
        Intent intent = new Intent(MENUBALONES.this, COMPRABALONES.class);
        startActivity(intent);
    }
}