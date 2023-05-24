package pe.eval2.a10_mplauto.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pe.eval2.a10_mplauto.R;
import pe.eval2.a10_mplauto.entidades.Auto;

public class AutosImagenAdapter extends RecyclerView.Adapter<AutosImagenAdapter.AutosHolder> {

    List<Auto> listaAutos;
    public AutosImagenAdapter(List<Auto> listaAutos){
        this.listaAutos = listaAutos;
    }

    @NonNull
    @Override
    public AutosImagenAdapter.AutosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from (parent.getContext ()).inflate (R.layout.autos_list_imagen, parent, false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        vista.setLayoutParams (layoutParams);
        return new AutosHolder (vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AutosImagenAdapter.AutosHolder holder, int position) {
        holder.txtId.setText ( String.valueOf ( listaAutos.get ( position ).getId () ) );
        holder.txtConductor.setText ( String.valueOf ( listaAutos.get ( position ).getConductor () ) );
        if (listaAutos.get ( position ).getImagen () != null)
            holder.imagen.setImageBitmap ( listaAutos.get ( position ).getImagen () );
        else holder.imagen.setImageResource ( R.drawable.img_base );
    }

    @Override
    public int getItemCount() {
        return listaAutos.size();
    }

    public class AutosHolder extends RecyclerView.ViewHolder {
        TextView txtId, txtConductor;
        ImageView imagen;
        public AutosHolder(@NonNull View itemView) {
            super(itemView);
            txtId = itemView.findViewById( R.id.uli_idDocumento );
            txtConductor = itemView.findViewById( R.id.uli_idConductor );
            imagen = itemView.findViewById( R.id.uli_idimagen );
        }
    }
}
