package rodriguez.miguel.ordinario_miguel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.content.SharedPreferences;
import android.content.Context;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TOTAL3COSAS extends AppCompatActivity {
    TextView txtPrecioTotalCamisas;
    TextView txtPrecioTotalBalones;
    TextView txtPrecioTotalTenis;

    Button btnSalir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total3_cosas);


        txtPrecioTotalCamisas = findViewById(R.id.txtPrecioTotal);


        txtPrecioTotalBalones = findViewById(R.id.txtPrecioTotal2);


        txtPrecioTotalTenis = findViewById(R.id.txtPrecioTotal3);

        btnSalir = findViewById(R.id.btnSalir);
        Button btnRegresar = findViewById(R.id.btnRegresar);

        Button btnRealizarPago = findViewById(R.id.btnpagar);

        btnRealizarPago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Pago realizado con éxito. Gracias por su compra.", Toast.LENGTH_SHORT).show();
            }
        });


        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferencesCamisas = getSharedPreferences("MiPreferencia", Context.MODE_PRIVATE);
                sharedPreferencesCamisas.edit().clear().apply();


                SharedPreferences sharedPreferencesBalones = getSharedPreferences("Balones", Context.MODE_PRIVATE);
                sharedPreferencesBalones.edit().clear().apply();


                SharedPreferences sharedPreferencesTenis = getSharedPreferences("TennisPrefs", Context.MODE_PRIVATE);
                sharedPreferencesTenis.edit().clear().apply();


                finishAffinity();
            }
        });
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(TOTAL3COSAS.this, MENUACCESORIOS.class);
                startActivity(intent);

                finish();
            }
        });


        SharedPreferences sharedPreferencesCamisas = getSharedPreferences("MiPreferencia", Context.MODE_PRIVATE);


        float precioTotalRecuperadoCamisas = sharedPreferencesCamisas.getFloat("precioTotal", 0.0f);


        txtPrecioTotalCamisas.setText("Precio total de todos los productos (Camisas): $" + precioTotalRecuperadoCamisas);


        SharedPreferences sharedPreferencesBalones = getSharedPreferences("Balones", Context.MODE_PRIVATE);


        float precioTotalRecuperadoBalones = sharedPreferencesBalones.getFloat("precio_total", 0.0f);


        txtPrecioTotalBalones.setText("Precio total de todos los productos (Balones): $" + precioTotalRecuperadoBalones);


        SharedPreferences sharedPreferencesTenis = getSharedPreferences("TennisPrefs", Context.MODE_PRIVATE);


        float precioTotalRecuperadoTenis = sharedPreferencesTenis.getFloat("precioTotal", 0.0f);


        txtPrecioTotalTenis.setText("Precio total de todos los productos (Tenis): $" + precioTotalRecuperadoTenis);


        float sumaTotal = precioTotalRecuperadoCamisas + precioTotalRecuperadoBalones + precioTotalRecuperadoTenis;

        TextView txtSumaTotal = findViewById(R.id.txtSumaTotal);

        txtSumaTotal.setText("Suma total de todos los productos: $" + sumaTotal);





    }
    protected void onDestroy() {
        super.onDestroy();


        SharedPreferences preferences1 = getSharedPreferences("precio_total", MODE_PRIVATE);
        preferences1.edit().clear().apply();

        SharedPreferences preferences2 = getSharedPreferences("precio_total2", MODE_PRIVATE);
        preferences2.edit().clear().apply();

        SharedPreferences preferences3 = getSharedPreferences("precio_total3", MODE_PRIVATE);
        preferences3.edit().clear().apply();



        SharedPreferences preferences4 = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        preferences4.edit().clear().apply();



        SharedPreferences preferences5 = getSharedPreferences("precio_total_tenni1", MODE_PRIVATE);
        preferences5.edit().clear().apply();

        SharedPreferences preferences6 = getSharedPreferences("precio_total_tenni2", MODE_PRIVATE);
        preferences6.edit().clear().apply();

        SharedPreferences preferences7 = getSharedPreferences("precio_total_tenni3", MODE_PRIVATE);
        preferences7.edit().clear().apply();





        //YERSEY//

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();


        editor.remove("cantidad");


        editor.remove("cantidad_producto2");


        editor.remove("cantidad");


        editor.apply();
    }
    }


