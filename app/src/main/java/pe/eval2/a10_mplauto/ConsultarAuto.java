package pe.eval2.a10_mplauto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import pe.eval2.a10_mplauto.entidades.Auto;
import pe.eval2.a10_mplauto.utilidades.Util;

public class ConsultarAuto extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

    EditText edtId;
    TextView txtCon, txtApell,txtmarca, txtmodelo,txtcolor;
    Button btnBuscar;
    ProgressDialog progreso;
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;
    ImageView campoImagen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_auto);
        edtId=findViewById(R.id.UCI_id);
        txtCon=findViewById(R.id.UCI_txtConductor);
//        txtApell=findViewById(R.id.UCI_txtApellidos);
        txtmarca = findViewById(R.id.UCI_txtMarca);
        txtmodelo = findViewById(R.id.UCI_txtModelo);
        txtcolor=findViewById(R.id.UCI_txtColor);
        btnBuscar=findViewById(R.id.UCI_btnConsutar);
///
        campoImagen = findViewById(R.id.UCI_imagenId);
///
        request= Volley.newRequestQueue(this);
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarWebserviceImagen();
            }
        });
    }

    private void cargarWebserviceImagen() {
        progreso= new ProgressDialog(this);
        progreso.setMessage("Consultando datos");
        progreso.show();
        String url= Util.RUTA + "consultarauto.php?id="+edtId.getText().toString();
        url=url.replace(" ","%20");
        jsonObjectRequest= new JsonObjectRequest(Request.Method.GET, url,null,this, this);
        request.add(jsonObjectRequest);
    }

    @Override
    public void onResponse(JSONObject response) {
        progreso.hide();
        Auto miauto= new Auto();
        JSONArray json=response.optJSONArray("auto");
        JSONObject jsonObject= null;
        try {
            jsonObject=json.getJSONObject(0); //
            miauto.setConductor(jsonObject.optString("conductor"));
            miauto.setDato(jsonObject.optString("imagen"));
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        txtCon.setText(miauto.getConductor());
        txtmarca.setText(jsonObject.optString("marca"));
        txtmodelo.setText(jsonObject.optString("modelo"));
        txtcolor.setText(jsonObject.optString("color"));
        campoImagen.setImageBitmap(miauto.getImagen());
    }
    @Override
    public void onErrorResponse(VolleyError error) {
        progreso.hide();
        Toast.makeText(this, "No se pudo consultar" + error.toString(), Toast.LENGTH_SHORT).show();
        Log.i("Error ", error.toString());

    }
}