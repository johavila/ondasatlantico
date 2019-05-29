package ondasatlantico.com.modelo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ondasatlantico.com.R;

public class Adapter extends RecyclerView.Adapter<Adapter.ProductsViewHolder> {
    List<GrupoInvestigacion> products;

    public Adapter(List<GrupoInvestigacion> productos){
        this.products = productos;
    }

    @Override
    public ProductsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent,false);
        ProductsViewHolder holder = new ProductsViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ProductsViewHolder holder, int position) {
        for (int i = 0; i < products.size(); i++) {
            GrupoInvestigacion producto = products.get(i);
            holder.txtCodigoCard.setText("Código: "+producto.getId());
            holder.txtNameCard.setText("Nombre del grupo: "+producto.getNombre());
            holder.txtSedeCard.setText("Nombre de la sede: "+producto.getSede());
            holder.txtDescription.setText("Nombre del municipio: "+producto.getMunicipio());
        }
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class ProductsViewHolder extends RecyclerView.ViewHolder{
        TextView txtNameCard, txtCodigoCard, txtDescription, txtSedeCard, txtValueCard, txtCantidadCard;
        public ProductsViewHolder(View itemView){
            super(itemView);
            txtNameCard = (TextView)itemView.findViewById(R.id.nameCard);
            txtCodigoCard = (TextView)itemView.findViewById(R.id.codigoCard);
            txtDescription = (TextView)itemView.findViewById(R.id.descriptionCard);
            txtSedeCard = (TextView)itemView.findViewById(R.id.sedeCard);
        }
    }
}
