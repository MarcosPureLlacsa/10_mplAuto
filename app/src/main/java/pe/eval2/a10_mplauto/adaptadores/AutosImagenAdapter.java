package pe.eval2.a10_mplauto.adaptadores;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pe.eval2.a10_mplauto.entidades.Auto;

public class AutosImagenAdapter extends RecyclerView.Adapter<AutosImagenAdapter.AutosHolder> {

    List<Auto> listaAutos;

    public AutosImagenAdapter(List<Auto> listaAutos) {
        this.listaAutos = listaAutos;
    }


    @NonNull
    @Override
    public AutosImagenAdapter.AutosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AutosImagenAdapter.AutosHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class AutosHolder extends RecyclerView.ViewHolder {
        public AutosHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
