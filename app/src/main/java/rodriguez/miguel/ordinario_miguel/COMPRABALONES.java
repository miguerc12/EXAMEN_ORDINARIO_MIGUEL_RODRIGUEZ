package rodriguez.miguel.ordinario_miguel;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
public class COMPRABALONES extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private TextView txtPrecioTotal;
    private LinearLayout linearLayoutProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprabalones);

        sharedPreferences = getSharedPreferences("compras", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        txtPrecioTotal = findViewById(R.id.txtPrecioTotal);
        linearLayoutProductos = findViewById(R.id.linearLayoutProductos);

        float precioTotal = sharedPreferences.getFloat("precioTotal", 0);
        txtPrecioTotal.setText("Precio Total: $" + precioTotal);


        for (int i = 1; i <= 3; i++) {
            String nombreProducto = sharedPreferences.getString("nombreProducto" + i, "");
            float precioProducto = sharedPreferences.getFloat("precioProducto" + i, 0);
            int imagenProducto = sharedPreferences.getInt("imagenProducto" + i, 0);

            if (!nombreProducto.isEmpty()) {
                mostrarProducto(nombreProducto, precioProducto, imagenProducto);
            }
        }


        Button btnGuardarCompra = findViewById(R.id.btnGuardarCompra);
        btnGuardarCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarCompraYAbrirTotalTodo();
            }
        });

        Button botonSalir = findViewById(R.id.salir);
        botonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }

    private void mostrarProducto(String nombre, float precio, int imagen) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        LinearLayout productoLayout = new LinearLayout(this);
        productoLayout.setLayoutParams(layoutParams);
        productoLayout.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(
                200,
                200
        );

        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(imageParams);
        imageView.setImageResource(imagen);

        LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        textParams.setMargins(16, 0, 0, 0);

        TextView textViewNombre = new TextView(this);
        textViewNombre.setLayoutParams(textParams);
        textViewNombre.setText("Nombre: " + nombre);

        TextView textViewPrecio = new TextView(this);
        textViewPrecio.setLayoutParams(textParams);
        textViewPrecio.setText("Precio: $" + precio);

        productoLayout.addView(imageView);
        productoLayout.addView(textViewNombre);
        productoLayout.addView(textViewPrecio);

        linearLayoutProductos.addView(productoLayout);
    }

    private void guardarCompraYAbrirTotalTodo() {
        // Enviar datos a la actividad TotalTodo
        Intent intent = new Intent(COMPRABALONES.this, TOTALTODO.class);

        // Obtener datos de SharedPreferences
        float precioTotal = sharedPreferences.getFloat("precioTotal", 0);
        String nombreProducto1 = sharedPreferences.getString("nombreProducto1", "");
        float precioProducto1 = sharedPreferences.getFloat("precioProducto1", 0);
        int imagenProducto1 = sharedPreferences.getInt("imagenProducto1", 0);
        String nombreProducto2 = sharedPreferences.getString("nombreProducto2", "");
        float precioProducto2 = sharedPreferences.getFloat("precioProducto2", 0);
        int imagenProducto2 = sharedPreferences.getInt("imagenProducto2", 0);
        String nombreProducto3 = sharedPreferences.getString("nombreProducto3", "");
        float precioProducto3 = sharedPreferences.getFloat("precioProducto3", 0);
        int imagenProducto3 = sharedPreferences.getInt("imagenProducto3", 0);


        intent.putExtra("precioTotal", precioTotal);
        intent.putExtra("nombreProducto1", nombreProducto1);
        intent.putExtra("precioProducto1", precioProducto1);
        intent.putExtra("imagenProducto1", imagenProducto1);
        intent.putExtra("nombreProducto2", nombreProducto2);
        intent.putExtra("precioProducto2", precioProducto2);
        intent.putExtra("imagenProducto2", imagenProducto2);
        intent.putExtra("nombreProducto3", nombreProducto3);
        intent.putExtra("precioProducto3", precioProducto3);
        intent.putExtra("imagenProducto3", imagenProducto3);

        startActivity(intent);
    }


}