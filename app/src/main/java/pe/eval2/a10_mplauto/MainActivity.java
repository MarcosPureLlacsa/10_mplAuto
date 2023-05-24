package pe.eval2.a10_mplauto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnConsultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnConsultar = findViewById(R.id.btnInicioIrConsultarAuto);
        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IrConsultarAuto();
            }
        });

    }

    private void IrConsultarAuto() {
        Intent intent = new Intent(this, ConsultarAuto.class);
        startActivity(intent);
    }
}