package com.btssio.ozenne.epicurio.model

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.btssio.ozenne.epicurio.R
import com.btssio.ozenne.epicurio.controller.DetailRecetteActivity

class RecetteAdapter(private val recettes: List<Recette>) : RecyclerView.Adapter<RecetteAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewNom: TextView = view.findViewById(R.id.textViewNomRecette)
        // Vous pouvez ajouter d'autres vues ici si nécessaire
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recette, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recette = recettes[position]
        holder.textViewNom.text = recette.titre

        // Configurez un OnClickListener pour l'élément de la liste
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailRecetteActivity::class.java).apply {
                putExtra("ID", recette.id) // ou passez tout objet Recette si nécessaire
                putExtra("TITRE", recette.titre)
                putExtra("INGREDIENTS", recette.ingredients.joinToString(", "))
                putExtra("INSTRUCTIONS", recette.instructions)
                putExtra("TEMPS_PREPARATION", recette.tempsPreparation)
                putExtra("DIFFICULTE", recette.difficulte.name)
                putExtra("TYPE_PLAT", recette.type.name)
                putExtra("IMAGE_RES_ID", recette.imageResId.toInt())
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = recettes.size
}
