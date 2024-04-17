package rodriguez.miguel.ordinario_miguel;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
;

public class DESCRIPCIONJERSEY1 extends AppCompatActivity {

    private TextView txtPrecioTotal;
    private int cantidad = 0;
    private final double precioUnitario = 800.0;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcionjersey1);

        txtPrecioTotal = findViewById(R.id.txtPrecioTotal);
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);


        cantidad = sharedPreferences.getInt("cantidad", 0);
        actualizarPrecioTotal();

        Button btnMas = findViewById(R.id.btnMas);
        Button btnMenos = findViewById(R.id.btnMenos);
        Button btnIrOtraPantalla = findViewById(R.id.btnIrOtraPantalla);

        btnMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cantidad++;
                actualizarPrecioTotal();
            }
        });

        btnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cantidad > 0) {

                    cantidad--;
                    actualizarPrecioTotal();
                }
            }
        });

        btnIrOtraPantalla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DESCRIPCIONJERSEY1.this, TOTALDETODOLOSPRODUCTOS.class);
                startActivity(intent);
            }
        });
    }

    private void actualizarPrecioTotal() {
        double precioTotal = cantidad * precioUnitario;
        txtPrecioTotal.setText("Precio total: $" + precioTotal);


        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("cantidad", cantidad);
        editor.apply();
    }
}