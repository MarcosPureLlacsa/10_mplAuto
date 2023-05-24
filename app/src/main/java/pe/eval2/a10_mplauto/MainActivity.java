package pe.eval2.a10_mplauto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnConsultar, btnListar;

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
        btnListar= findViewById(R.id.btnInicioIrListarAuto);
        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IrListarAuto();
            }
        });

    }

    private void IrListarAuto() {
        Intent intent = new Intent(this, ConsultarImagenAuto.class);
        startActivity(intent);
    }

    private void IrConsultarAuto() {
        Intent intent = new Intent(this, ConsultarAuto.class);
        startActivity(intent);
    }
}