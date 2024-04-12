package com.btssio.ozenne.epicurio.repository

import android.content.Context
import android.util.Log
import com.btssio.ozenne.epicurio.R
import com.btssio.ozenne.epicurio.model.NiveauDifficulte
import com.btssio.ozenne.epicurio.model.Recette
import com.btssio.ozenne.epicurio.model.TypeDePlat
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import java.io.IOException

class RecetteRepository(private val context: Context) {
    private var recettes: List<Recette> = listOf()

    init {
        recettes = chargerRecettes()
    }

    private fun chargerRecettes(): List<Recette> {
        val jsonFileString = getJsonDataFromAsset(context, "recettes.json")
        if (jsonFileString == null) {
            Log.e("RecetteRepository", "JSON data is null")
            return emptyList()
        }
        val gson = Gson()
        val listRecetteType = object : TypeToken<List<Recette>>() {}.type
        val recettes = gson.fromJson<List<Recette>>(jsonFileString, listRecetteType) ?: emptyList()

        // Convertir les noms de fichiers en identifiants de ressources
        return recettes.map { recette ->
            recette.apply {
                imageResId = context.resources.getIdentifier(imageResId, "drawable", context.packageName).toString()
                Log.d("imageresid", imageResId)
            }
        }
    }

    private fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        return try {
            context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            Log.e("RecetteRepository", "Error reading from $fileName", ioException)
            null
        }
    }
    fun obtenirToutesLesRecettes(): List<Recette> {
        return recettes
    }


    fun chercherRecettesParNom(nom: String): List<Recette> {
        return recettes.filter { it.titre.contains(nom, ignoreCase = true) }
    }

    fun obtenirRecetteAleatoire(): Recette? {
        if (recettes.isNotEmpty()) {
            return recettes.random()
        }
        return null
    }

    fun filtrerRecettesParDifficulte(difficulte: NiveauDifficulte): List<Recette> {
        return recettes.filter { it.difficulte == difficulte }
    }

    fun filtrerRecettesParType(type: TypeDePlat): List<Recette> {
        return recettes.filter { it.type == type }
    }

    // Fonction pour chercher des recettes par liste d'ingrédients
    fun filtrerRecettesParIngredients(ingredientsRecherches: List<String>): List<Recette> {
        return recettes.filter { recette ->
            ingredientsRecherches.all { ingredientRecherche ->
                recette.ingredients.any { it.contains(ingredientRecherche, ignoreCase = true) }
            }
        }
    }}