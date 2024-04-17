package rodriguez.miguel.ordinario_miguel;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MENUACCESORIOS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuaccesorios);


        String username = getIntent().getStringExtra("username");


        if (username != null) {

            Toast.makeText(this, "Bienvenido usuario " + username, Toast.LENGTH_SHORT).show();
        }

        Button buttonTennis = findViewById(R.id.buttonTennis);
        Button buttonBalones = findViewById(R.id.buttonBalones);
        Button buttonJerseys = findViewById(R.id.buttonJerseys);
        Button buttonOtraActividad = findViewById(R.id.buttonOtraActividad);
        Button buttonbtntotal = findViewById(R.id.btntotal);
        buttonTennis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MENUACCESORIOS.this, MENUTENNIS.class);
                startActivity(intent);
            }
        });

        buttonBalones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MENUACCESORIOS.this, MENUBALONES.class);
                startActivity(intent);
            }
        });

        buttonJerseys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MENUACCESORIOS.this, MENUJERSEYS.class);
                startActivity(intent);
            }
        });

        buttonOtraActividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MENUACCESORIOS.this, TOTALTODO.class);
                startActivity(intent);
            }
        });

        buttonbtntotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MENUACCESORIOS.this, TOTAL3COSAS.class);
                startActivity(intent);
            }
        });
    }}