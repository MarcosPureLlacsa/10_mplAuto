package pe.eval2.a10_mplauto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import pe.eval2.a10_mplauto.adaptadores.AutosImagenAdapter;
import pe.eval2.a10_mplauto.entidades.Auto;
import pe.eval2.a10_mplauto.utilidades.Util;

public class ConsultarImagenAuto extends AppCompatActivity implements Response.ErrorListener, Response.Listener<JSONObject> {

    RecyclerView recyclerAutos;
    ArrayList<Auto> listaAutos;
    ProgressDialog dialog;
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_imagen_auto);

        listaAutos = new ArrayList<>();
        recyclerAutos = (RecyclerView) findViewById(R.id.rvRecyclerView);
        recyclerAutos.setLayoutManager(new LinearLayoutManager(this));
        recyclerAutos.setHasFixedSize(true);
        request= Volley.newRequestQueue(this);
        cargarWebservice();
    }

    private void cargarWebservice() {
        dialog = new ProgressDialog(this);
        dialog .setMessage("Consultando con imagenes");
        dialog.show();
        String url= Util.RUTA + "consultarlistaimagenes.php?";
        url=url.replace(" ","%20");
        jsonObjectRequest= new JsonObjectRequest(Request.Method.GET, url,null,this, this);
        request.add(jsonObjectRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        dialog.hide();
        Toast.makeText(this, "Error al consultar " + error.toString(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        dialog.hide();
        Auto miauto= null;
        JSONArray json=response.optJSONArray("auto");
        try {
            for (int i = 0; i < json.length(); i++) {
                miauto = new Auto();
                JSONObject jsonObject = null;
                jsonObject = json.getJSONObject(i);
                int documento = jsonObject.optInt("id");
                miauto.setId(documento);
                String conductor = jsonObject.optString("conductor");
                miauto.setConductor(conductor);
                miauto.setDato(jsonObject.optString("imagen"));
                listaAutos.add(miauto);
            }
            dialog.hide();
            AutosImagenAdapter adapter = new AutosImagenAdapter(listaAutos);
            recyclerAutos.setAdapter(adapter);
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, "NO conexion con el servidor",
                    Toast.LENGTH_SHORT).show();
            dialog.hide();
        }
    }
}