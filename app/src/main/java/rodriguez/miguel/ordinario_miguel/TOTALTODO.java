package rodriguez.miguel.ordinario_miguel;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class TOTALTODO extends AppCompatActivity {


    private TextView txtTotalTodo;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_totaltodo);

        txtTotalTodo = findViewById(R.id.txtTotalTodo);


        sharedPreferences = getSharedPreferences("compras", MODE_PRIVATE);
        float precioTotal = sharedPreferences.getFloat("precioTotal", 0);
        StringBuilder detallesCompra = new StringBuilder();


        for (int i = 1; i <= 3; i++) {
            String nombreProducto = sharedPreferences.getString("nombreProducto" + i, "");
            float precioProducto = sharedPreferences.getFloat("precioProducto" + i, 0);
            int imagenProducto = sharedPreferences.getInt("imagenProducto" + i, 0);

            if (!nombreProducto.isEmpty()) {
                detallesCompra.append("Producto: ").append(nombreProducto).append(", Precio: $").append(precioProducto).append("\n");
            }
        }


        txtTotalTodo.setText("Precio Total: $" + precioTotal + "\n\n" + detallesCompra.toString());


        Button btnVolver = findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarCompraYVolver();
            }
        });
    }

    private void guardarCompraYVolver() {



        Intent intent = new Intent(TOTALTODO.this, MENUACCESORIOS.class);
        startActivity(intent);
        finish();
    }
}
