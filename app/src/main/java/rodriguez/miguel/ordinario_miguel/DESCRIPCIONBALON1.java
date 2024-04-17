package rodriguez.miguel.ordinario_miguel;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DESCRIPCIONBALON1 extends AppCompatActivity {

    private TextView txtPrecioTotal;
    private int cantidad = 0;
    private final double precioUnitario = 20.0;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcionbalon1);

        txtPrecioTotal = findViewById(R.id.txtPrecioTotal);

        Button btnMas = findViewById(R.id.btnMas);
        Button btnMenos = findViewById(R.id.btnMenos);
        Button btnIrOtraActividad = findViewById(R.id.btnIrOtraActividad);

        sharedPreferences = getSharedPreferences("precio_total", Context.MODE_PRIVATE);


        double precioTotalGuardado = sharedPreferences.getFloat("precio_total_key", 0.0f);
        txtPrecioTotal.setText("Precio total: $" + precioTotalGuardado);

        btnMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cantidad++;
                double precioTotal = cantidad * precioUnitario;
                txtPrecioTotal.setText("Precio total: $" + precioTotal);


                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putFloat("precio_total_key", (float) precioTotal);
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
                    editor.putFloat("precio_total_key", (float) precioTotal);
                    editor.apply();
                }
            }
        });


        btnIrOtraActividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DESCRIPCIONBALON1.this, TOTALDETODOSLOSBALONES.class);
                startActivity(intent);
            }
        });
    }
}