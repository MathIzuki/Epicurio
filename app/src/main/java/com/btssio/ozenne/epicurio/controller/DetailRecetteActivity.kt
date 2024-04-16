package com.btssio.ozenne.epicurio.controller

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.btssio.ozenne.epicurio.R
import com.btssio.ozenne.epicurio.model.TypeDePlat

// Classe qui gère l'affichage détaillé d'une recette.

class DetailRecetteActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_recette)
        findViewById<TextView>(R.id.txtHeader).setOnClickListener {
            // On termine l'activité pour retourner à l'activité précédente
            finish()
        }
        // On récupère des données de l'intent
        val titre = intent.getStringExtra("TITRE")
        val ingredients = intent.getStringExtra("INGREDIENTS")
        val instructions = intent.getStringExtra("INSTRUCTIONS")
        val tempsPreparation = intent.getIntExtra("TEMPS_PREPARATION", 0)
        val difficulte = intent.getStringExtra("DIFFICULTE")
        val typePlat = intent.getStringExtra("TYPE_PLAT")
        val imageResId = intent.getIntExtra("IMAGE_RES_ID", 0)
        // On affiche les données de la recette dans les vues correspondantes.
        findViewById<TextView>(R.id.textViewTitreRecette).text = titre
        findViewById<TextView>(R.id.textViewIngredientsRecette).text = ingredients
        findViewById<TextView>(R.id.textViewInstructionsRecette).text = instructions
        val affichageTempsPreparation = "$tempsPreparation minutes"
        findViewById<TextView>(R.id.textViewTempsPreparation).text =
            "Temps de préparation : $affichageTempsPreparation"
        // Affiche la difficulté avec la première lettre en majuscule grâce à la fonction capitalizeFirstLetter.

        if (difficulte != null) {
            findViewById<TextView>(R.id.textViewDifficulte).text = "Difficulté : "+ difficulte.capitalizeFirstLetter()
        }

        // Traduit le type de plat de du format de l'objet en format Affichable pour l'esthétique
        val typePlatAffichage = when (typePlat) {
            TypeDePlat.ENTREE.name -> "Entrée"
            TypeDePlat.PLAT_PRINCIPAL.name -> "Plat Principal"
            TypeDePlat.DESSERT.name -> "Dessert"
            TypeDePlat.SNACK.name -> "Snack"
            TypeDePlat.ACCOMPAGNEMENT.name -> "Accompagnement"
            else -> "Non spécifié"
        }
        // Affiche le type de plat.
        findViewById<TextView>(R.id.textViewTypePlat).text = "Type de plat : $typePlatAffichage"

        // Affiche l'image de la recette.
        findViewById<ImageView>(R.id.imageViewRecette).setImageResource(imageResId)
    }

    //Fonction qui permet de mettre la première lettre d'un string en majuscule
    private fun String.capitalizeFirstLetter(): String = this.lowercase().replaceFirstChar(Char::uppercase)
}