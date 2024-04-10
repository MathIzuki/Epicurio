package com.btssio.ozenne.eatspiration.controller

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.btssio.ozenne.eatspiration.R
import com.btssio.ozenne.eatspiration.model.NiveauDifficulte
import com.btssio.ozenne.eatspiration.model.Recette
import com.btssio.ozenne.eatspiration.model.RecetteAdapter
import com.btssio.ozenne.eatspiration.model.TypeDePlat
import com.btssio.ozenne.eatspiration.repository.RecetteRepository

class AffichageRecettesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_affichage_recettes)
        findViewById<TextView>(R.id.txtHeader).setOnClickListener {
            // Terminez l'activité pour retourner à l'activité précédente
            finish()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.principal)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Exemple pour récupérer le type de filtre et les critères
        val typeFiltre = intent.getStringExtra("TYPE_FILTRE")
        val critere = intent.getStringExtra("CRITERE")

        val recettes = filtrerRecettes(typeFiltre, critere)

        // Afficher les recettes filtrées
        afficherRecettes(recettes)
    }
    private fun filtrerRecettes(typeFiltre: String?, critere: String?): List<Recette> {
        val repository = RecetteRepository()

        return when (typeFiltre) {
            "DIFFICULTE" -> repository.filtrerRecettesParDifficulte(NiveauDifficulte.valueOf(critere!!))
            "TYPE" -> repository.filtrerRecettesParType(TypeDePlat.valueOf(critere!!))
            "NOM" -> repository.chercherRecettesParNom(critere!!)
            "INGREDIENTS" -> {
                val ingredients = critere!!.split(",").map { it.trim() } // Transformer la chaîne en liste
                repository.filtrerRecettesParIngredients(ingredients)
            }
            else -> repository.obtenirToutesLesRecettes()
        }
    }
    private fun afficherRecettes(recettes: List<Recette>) {
        if (recettes.isEmpty()) {
            // Aucune recette ne correspond à la sélection, affichez un Toast
            Toast.makeText(this, "Aucun plat ne contient tous ces ingrédients réunis.", Toast.LENGTH_LONG).show()
        } else {
            // Il existe des recettes correspondant à la sélection
            val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewRecettes)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = RecetteAdapter(recettes)
        }
    }

}