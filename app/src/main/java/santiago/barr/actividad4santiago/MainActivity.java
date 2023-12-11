package santiago.barr.actividad4santiago;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.provider.AlarmClock;
import android.provider.CalendarContract;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //crear una alarma
        Button btnCrearAlarma = findViewById(R.id.button);
        btnCrearAlarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirAppRelojCrearAlarma();
            }
        });

        //crear un evento en el calendario
        Button btnCrearEvento = findViewById(R.id.button2);
        btnCrearEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirAppCalendarioCrearEvento();
            }
        });
    }

    private void abrirAppRelojCrearAlarma() {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
        intent.putExtra(AlarmClock.EXTRA_MESSAGE, "Mensaje de la alarma");
        intent.putExtra(AlarmClock.EXTRA_HOUR, 12);
        intent.putExtra(AlarmClock.EXTRA_MINUTES, 0);
        startActivity(intent);
    }

    private void abrirAppCalendarioCrearEvento() {
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setData(CalendarContract.Events.CONTENT_URI);
        intent.putExtra(CalendarContract.Events.TITLE, "Nuevo evento");
        intent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Ubicación del evento");
        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, System.currentTimeMillis());
        intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, System.currentTimeMillis() + 3600000); // Duración de 1 hora
        startActivity(intent);
    }
}
