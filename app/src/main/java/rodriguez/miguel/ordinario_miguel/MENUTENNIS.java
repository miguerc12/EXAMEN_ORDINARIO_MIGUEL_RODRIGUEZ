package rodriguez.miguel.ordinario_miguel;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;

public class MENUTENNIS extends AppCompatActivity {

    private TextView txtPrecioTotal;
    private double precioTotal = 0.0;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menutennis);

        txtPrecioTotal = findViewById(R.id.txtPrecioTotal);
        sharedPreferences = getSharedPreferences("compras", MODE_PRIVATE);

        Button btnAgregarCompraTennis1 = findViewById(R.id.btnAgregarCompra1);
        Button btnAgregarCompraTennis2 = findViewById(R.id.btnAgregarCompra2);
        Button btnAgregarCompraTennis3 = findViewById(R.id.btnAgregarCompra3);
        Button btnVerDescripcion1 = findViewById(R.id.btnVerDescripcion1);
        Button btnVerDescripcion2 = findViewById(R.id.btnVerDescripcion2);
        Button btnVerDescripcion3 = findViewById(R.id.btnVerDescripcion3);


        btnAgregarCompraTennis1.setOnClickListener(agregarCompraClickListener);
        btnAgregarCompraTennis2.setOnClickListener(agregarCompraClickListener);
        btnAgregarCompraTennis3.setOnClickListener(agregarCompraClickListener);


        btnVerDescripcion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MENUTENNIS.this, DESCRIPCIONTENNI1.class);
                startActivity(intent);
            }
        });

        btnVerDescripcion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MENUTENNIS.this, DESCRIPCIONTENNI2.class);
                startActivity(intent);
            }
        });

        btnVerDescripcion3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MENUTENNIS.this, DESCRIPCIONTENNI3.class);
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


        editor.putString("nombreProducto1", "Tennis Nike");
        editor.putFloat("precioProducto1", 400);
        editor.putInt("imagenProducto1", R.drawable.img_2);

        editor.putString("nombreProducto2", "Tennis Adidas");
        editor.putFloat("precioProducto2", 500);
        editor.putInt("imagenProducto2", R.drawable.img_1);

        editor.putString("nombreProducto3", "Tennis Puma");
        editor.putFloat("precioProducto3", 600);
        editor.putInt("imagenProducto3", R.drawable.img);

        editor.apply();
    }

    private void abrirActividadCompras() {
        Intent intent = new Intent(MENUTENNIS.this, COMPRATENNIS.class);
        startActivity(intent);
    }

}