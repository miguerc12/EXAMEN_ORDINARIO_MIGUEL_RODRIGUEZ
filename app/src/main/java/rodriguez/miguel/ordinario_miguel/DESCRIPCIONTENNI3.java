package rodriguez.miguel.ordinario_miguel;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class DESCRIPCIONTENNI3 extends AppCompatActivity {

    private TextView txtPrecioTotal;
    private int cantidad = 0;
    private final double precioUnitario = 600.0;
    private SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "precio_total_tenni3";
    private static final String TOTAL_PRICE_KEY = "precio_total_key_tenni3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripciontenni3);

        txtPrecioTotal = findViewById(R.id.txtPrecioTotal);
        Button btnMas = findViewById(R.id.btnMas);
        Button btnMenos = findViewById(R.id.btnMenos);
        Button btnVolver3 = findViewById(R.id.btnVolver3);


        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);


        double precioTotalGuardado = sharedPreferences.getFloat(TOTAL_PRICE_KEY, 0.0f);
        cantidad = (int) (precioTotalGuardado / precioUnitario);


        txtPrecioTotal.setText("Precio total: $" + precioTotalGuardado);

        btnMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cantidad++;
                double precioTotal = cantidad * precioUnitario;
                txtPrecioTotal.setText("Precio total: $" + precioTotal);


                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putFloat(TOTAL_PRICE_KEY, (float) precioTotal);
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
                    editor.putFloat(TOTAL_PRICE_KEY, (float) precioTotal);
                    editor.apply();
                }
            }
        });

        btnVolver3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DESCRIPCIONTENNI3.this, TOTALDETODOSLOSTENNIS.class);
                startActivity(intent);
            }
        });
    }
}