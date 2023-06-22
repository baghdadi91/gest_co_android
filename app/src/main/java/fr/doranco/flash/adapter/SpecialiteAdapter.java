package fr.doranco.flash.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.doranco.flash.R;
import fr.doranco.flash.entity.Specialite;


public class SpecialiteAdapter extends RecyclerView.Adapter<SpecialiteAdapter.SpecialiteViewHolder>{
    private List<Specialite> specialiteList;

    /**
     * Initialisation des donnees
     * @param specialiteList est la liste des objets a afficher par le recyclerview
     */
    public SpecialiteAdapter(List<Specialite> specialiteList) {
        this.specialiteList = specialiteList;
    }

    /**
     * Cette methode permet de creer une vue a partir du fichier xml(dans notre cas recycler_view_item_specialite.xml)
     * elle est utilise pour creer une instance de notre classe SpecialiteViewHolder
     * Elle est applee a chaque fois le recycler  a besoin de creer une nouvelle vue
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return
     */
    @NonNull
    @Override
    public SpecialiteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // generer un objet de type view a partir de notre fichier recycler_view_item_specialite.xml
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item_specialite, parent,false);
        return new SpecialiteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpecialiteViewHolder holder, int position) {

        //recuperer l'objet a afficher
        Specialite specialite =specialiteList.get(position);
        //update de la vue
        holder.nomSpecialite.setText(specialite.getNom());
    }

    @Override
    public int getItemCount() {
        return specialiteList.size();
    }

    /**
     * 1- creer une classe qui extends RecyclerView.ViewHolder. Elle permet d'initialiser les données de la vue
     *
     * 2- Faire que la classe SpecialaiteAdapter extends RecyclerView.Adapter<SpecialiteAdapter.SpecialiteViewHolder>
     */
    public class SpecialiteViewHolder extends RecyclerView.ViewHolder{
    private TextView nomSpecialite;
        public SpecialiteViewHolder(@NonNull View itemView) {
            super(itemView);
            nomSpecialite = itemView.findViewById(R.id.textViewRecycleViewSpecialite);
        }
    }

}
