package rodriguez.miguel.ordinario_miguel;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;


public class DESCRIPCIONTENNI1 extends AppCompatActivity {

    private TextView txtPrecioTotal;
    private int cantidad = 0;
    private final double precioUnitario = 400.0;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripciontenni1);

        txtPrecioTotal = findViewById(R.id.txtPrecioTotal);
        Button btnMas = findViewById(R.id.btnMas);
        Button btnMenos = findViewById(R.id.btnMenos);
        Button btnVolver = findViewById(R.id.btnVolver);


        sharedPreferences = getSharedPreferences("precio_total_tenni1", Context.MODE_PRIVATE);


        double precioTotalGuardado = sharedPreferences.getFloat("precio_total_key_tenni1", 0.0f);
        cantidad = (int) (precioTotalGuardado / precioUnitario);


        txtPrecioTotal.setText("Precio total: $" + precioTotalGuardado);

        btnMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cantidad++;
                double precioTotal = cantidad * precioUnitario;
                txtPrecioTotal.setText("Precio total: $" + precioTotal);


                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putFloat("precio_total_key_tenni1", (float) precioTotal);
                editor.apply();
            }
        });

        btnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cantidad > 0) {

                    cantidad--;
                    double precioTotal = cantidad * precioUnitario;
                    txtPrecioTotal.setText("Precio total: $" + precioTotal);


                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putFloat("precio_total_key_tenni1", (float) precioTotal);
                    editor.apply();
                }
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DESCRIPCIONTENNI1.this, TOTALDETODOSLOSTENNIS.class);
                startActivity(intent);
            }
        });
    }
}