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

// Définition de la classe RecetteAdapter qui étend RecyclerView.Adapter avec un ViewHolder personnalisé.
class RecetteAdapter(private val recettes: List<Recette>) : RecyclerView.Adapter<RecetteAdapter.ViewHolder>() {

    // Définition du ViewHolder qui contient la logique d'affichage d'une seule recette.
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewNom: TextView = view.findViewById(R.id.textViewNomRecette) // Référence au TextView pour le nom de la recette.
    }

    // Méthode appelée lors de la création de nouveaux éléments de liste (ViewHolder).
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Création de la vue d'un élément de la liste à partir du layout XML.
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recette, parent, false)
        return ViewHolder(view)
    }

    // Méthode pour remplir un ViewHolder avec les données d'une recette à une position spécifique.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recette = recettes[position]  // Récupération de la recette à la position actuelle.
        holder.textViewNom.text = recette.titre  // Mise à jour du texte du TextView avec le titre de la recette.

        // Définition d'un écouteur de clic pour l'élément de la liste.
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context  // Récupération du contexte.
            val intent = Intent(context, DetailRecetteActivity::class.java).apply {
                // Ajout de données supplémentaires à l'intent pour transmettre à l'activité de détail.
                putExtra("ID", recette.id)
                putExtra("TITRE", recette.titre)
                putExtra("INGREDIENTS", recette.ingredients.joinToString(", "))
                putExtra("INSTRUCTIONS", recette.instructions)
                putExtra("TEMPS_PREPARATION", recette.tempsPreparation)
                putExtra("DIFFICULTE", recette.difficulte.name)
                putExtra("TYPE_PLAT", recette.type.name)
                putExtra("IMAGE_RES_ID", recette.imageResId.toInt())
            }
            context.startActivity(intent)  // Démarrage de l'activité de détail avec l'intent préparé.
        }
    }

    // Méthode pour obtenir la taille de la liste des recettes.
    override fun getItemCount() = recettes.size
}