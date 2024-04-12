package com.btssio.ozenne.epicurio.controller

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.btssio.ozenne.epicurio.R
import com.btssio.ozenne.epicurio.model.TypeDePlat

class DetailRecetteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_recette)
        findViewById<TextView>(R.id.txtHeader).setOnClickListener {
            // Terminez l'activité pour retourner à l'activité précédente
            finish()
        }
        // Récupération des données de l'intent
        val titre = intent.getStringExtra("TITRE")
        val ingredients = intent.getStringExtra("INGREDIENTS")
        val instructions = intent.getStringExtra("INSTRUCTIONS")
        val tempsPreparation = intent.getIntExtra("TEMPS_PREPARATION", 0)
        val difficulte = intent.getStringExtra("DIFFICULTE")
        val typePlat = intent.getStringExtra("TYPE_PLAT")
        val imageResId = intent.getIntExtra("IMAGE_RES_ID", 0)

        // Affichage des informations de la recette
        findViewById<TextView>(R.id.textViewTitreRecette).text = titre
        findViewById<TextView>(R.id.textViewIngredientsRecette).text = ingredients
        findViewById<TextView>(R.id.textViewInstructionsRecette).text = instructions
        val affichageTempsPreparation = "$tempsPreparation minutes"
        findViewById<TextView>(R.id.textViewTempsPreparation).text = "Temps de préparation : " + affichageTempsPreparation
        Log.d("temps", tempsPreparation.toString())
        if (difficulte != null) {
            findViewById<TextView>(R.id.textViewDifficulte).text = "Difficulté : "+ difficulte.capitalizeFirstLetter()
        }
        val typePlatAffichage = when (typePlat) {
            TypeDePlat.ENTREE.name -> "Entrée"
            TypeDePlat.PLAT_PRINCIPAL.name -> "Plat Principal"
            TypeDePlat.DESSERT.name -> "Dessert"
            TypeDePlat.SNACK.name -> "Snack"
            TypeDePlat.ACCOMPAGNEMENT.name -> "Accompagnement"
            else -> "Non spécifié"
        }

        findViewById<TextView>(R.id.textViewTypePlat).text = "Type de plat : $typePlatAffichage"
        findViewById<ImageView>(R.id.imageViewRecette).setImageResource(imageResId)
    }
    fun String.capitalizeFirstLetter(): String = this.lowercase().replaceFirstChar(Char::uppercase)
}