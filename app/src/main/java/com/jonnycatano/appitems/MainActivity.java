package com.jonnycatano.appitems;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button google, alarma, llamada, activity, Temporizador, contacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity = findViewById(R.id.activity);
        google = findViewById(R.id.google);
        alarma = findViewById(R.id.crearalarma);
        llamada = findViewById(R.id.llamar);
        Temporizador = findViewById(R.id.temporizador);
        contacto = findViewById(R.id.contacto);

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irAGoogle = new Intent(Intent.ACTION_VIEW);
                irAGoogle.setData(Uri.parse("http://www.google.com.co"));
                startActivity(irAGoogle);

            }
        });

        alarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crearAlarma();

            }
        });

        llamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crearLlamada("3233058340");

            }
        });

        Temporizador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTimer();
            }
        });

        contacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Contacto = new Intent(Intent.ACTION_VIEW);
                if (Contacto.resolveActivity(getPackageManager()) != null) {
                    startActivity(Contacto);
                }
            }
        });

    }

    private void crearAlarma(){
        Intent alarma = new Intent(AlarmClock.ACTION_SET_ALARM);
        alarma.putExtra(AlarmClock.EXTRA_MESSAGE, "Gimnacio");
        alarma.putExtra(AlarmClock.EXTRA_HOUR, 10);
        alarma.putExtra(AlarmClock.EXTRA_MINUTES, 30);
        if (alarma.resolveActivity(getPackageManager()) != null){
            startActivity(alarma);
        }
    }

    public void crearLlamada(String phoneNumber) {
        Intent llamada = new Intent(Intent.ACTION_DIAL);
        llamada.setData(Uri.parse("tel:" + phoneNumber));
        if (llamada.resolveActivity(getPackageManager()) != null) {
            startActivity(llamada);
        }
    }

    public void startTimer() {
        Intent Temporizador = new Intent(AlarmClock.ACTION_SET_TIMER);
        Temporizador.putExtra(AlarmClock.EXTRA_MESSAGE, "es hora");
        Temporizador.putExtra(AlarmClock.EXTRA_LENGTH, 5);
        Temporizador.putExtra(AlarmClock.EXTRA_SKIP_UI, true);
        if (Temporizador.resolveActivity(getPackageManager()) != null) {
            startActivity(Temporizador);
        }
    }


}