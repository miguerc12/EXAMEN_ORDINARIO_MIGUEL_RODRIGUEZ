package rodriguez.miguel.ordinario_miguel;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class TOTALDETODOSLOSTENNIS extends AppCompatActivity {

    private TextView txtPrecioTotalTodosLosProductos3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_totaldetodoslostennis);


        txtPrecioTotalTodosLosProductos3 = findViewById(R.id.txtPrecioTotalTodosLosProductos3);



        SharedPreferences sharedPreferencesTenni1 = getSharedPreferences("precio_total_tenni1", Context.MODE_PRIVATE);


        double precioTotalGuardadoTenni1 = sharedPreferencesTenni1.getFloat("precio_total_key_tenni1", 0.0f);


        TextView txtPrecioTotalTenni1 = findViewById(R.id.txtPrecioTotalTenni1);
        txtPrecioTotalTenni1.setText("Precio total Tenni1: $" + precioTotalGuardadoTenni1);


        SharedPreferences sharedPreferencesTenni2 = getSharedPreferences("precio_total_tenni2", Context.MODE_PRIVATE);


        double precioTotalGuardadoTenni2 = sharedPreferencesTenni2.getFloat("precio_total_key_tenni2", 0.0f);


        TextView txtPrecioTotalTenni2 = findViewById(R.id.txtPrecioTotalTenni2);
        txtPrecioTotalTenni2.setText("Precio total Tenni2: $" + precioTotalGuardadoTenni2);


        SharedPreferences sharedPreferencesTenni3 = getSharedPreferences("precio_total_tenni3", Context.MODE_PRIVATE);


        double precioTotalGuardadoTenni3 = sharedPreferencesTenni3.getFloat("precio_total_key_tenni3", 0.0f);


        TextView txtPrecioTotalTenni3 = findViewById(R.id.txtPrecioTotalTenni3);
        txtPrecioTotalTenni3.setText("Precio total Tenni3: $" + precioTotalGuardadoTenni3);


        double precioTotal = precioTotalGuardadoTenni1 + precioTotalGuardadoTenni2 + precioTotalGuardadoTenni3;


        txtPrecioTotalTodosLosProductos3.setText("Precio total de todos los productos: $" + precioTotal);


        SharedPreferences sharedPreferences = getSharedPreferences("TennisPrefs", Context.MODE_PRIVATE);


        SharedPreferences.Editor editor = sharedPreferences.edit();


        editor.putFloat("precioTotal", (float) precioTotal);
        editor.apply();

        Button btnRegresar = findViewById(R.id.btnRegresar);
        Button btnTotal3CosasBalones = findViewById(R.id.btntotal3cosasbalones);
        btnTotal3CosasBalones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(TOTALDETODOSLOSTENNIS.this, TOTAL3COSAS.class);


                startActivity(intent);
            }
        });


        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(TOTALDETODOSLOSTENNIS.this, MENUTENNIS.class);
                startActivity(intent);

                finish();
            }
        });

    }
}