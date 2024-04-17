package rodriguez.miguel.ordinario_miguel;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class COMPRATENNIS extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private TextView txtPrecioTotal;
    private LinearLayout linearLayoutProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compratennis);

        sharedPreferences = getSharedPreferences("compras", MODE_PRIVATE);

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
}