package rodriguez.miguel.ordinario_miguel;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class DESCRIPCIONJERSEY2 extends AppCompatActivity {


    private TextView txtPrecioTotal;
    private int cantidad = 0;
    private final double precioUnitario = 500.0;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcionjersey2);

        txtPrecioTotal = findViewById(R.id.txtPrecioTotal);
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);


        double precioTotalGuardado = sharedPreferences.getFloat("precioTotal", 0.0f);
        txtPrecioTotal.setText("Precio total: $" + precioTotalGuardado);

        Button btnMas = findViewById(R.id.btnMas);
        Button btnMenos = findViewById(R.id.btnMenos);
        Button btnIrOtraPantalla = findViewById(R.id.btnIrOtraPantalla);

        btnMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cantidad++;
                double precioTotal = cantidad * precioUnitario;
                txtPrecioTotal.setText("Precio total: $" + precioTotal);


                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("cantidad_producto2", cantidad);
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
                    editor.putFloat("precioTotal", (float) precioTotal);
                    editor.apply();
                }
            }
        });


        btnIrOtraPantalla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DESCRIPCIONJERSEY2.this, TOTALDETODOLOSPRODUCTOS.class);
                intent.putExtra("precioTotal", sharedPreferences.getFloat("precioTotal", 0.0f));
                startActivity(intent);
                startActivity(intent);
            }
        });
    }
}