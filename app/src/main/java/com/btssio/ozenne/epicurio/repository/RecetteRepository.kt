package com.btssio.ozenne.epicurio.repository

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import com.btssio.ozenne.epicurio.model.NiveauDifficulte
import com.btssio.ozenne.epicurio.model.Recette
import com.btssio.ozenne.epicurio.model.TypeDePlat
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

/**
 * Classe de dépôt pour la gestion des données de recettes.
 *
 * @param context Contexte de l'application nécessaire pour accéder aux ressources et aux actifs.
 */
class RecetteRepository(private val context: Context) {
    private var recettes: List<Recette> = listOf()

    // Charge les recettes au démarrage du repository.

    init {
        recettes = chargerRecettes()
    }

    @SuppressLint("DiscouragedApi")
    /**
     * Charge les recettes à partir d'un fichier JSON situé dans les assets.
     *
     * @return Une liste de recettes décodées depuis le fichier JSON.
     */
    private fun chargerRecettes(): List<Recette> {
        // Tentative de récupération du contenu JSON du fichier 'recettes.json' stocké dans les assets de l'application.
        val jsonFileString = getJsonDataFromAsset(context, "recettes.json")

        // Vérification si le contenu JSON n'est pas null, sinon log d'une erreur et retour d'une liste vide.
        if (jsonFileString == null) {
            Log.e("RecetteRepository", "Le JSON est vide ") // Log d'erreur si aucun contenu n'est trouvé.
            return emptyList() // Retourne une liste vide si le contenu JSON est null.
        }

        // Initialisation de Gson pour la désérialisation du JSON.
        val gson = Gson()

        // Création d'un type token pour indiquer à Gson quel type de données il doit désérialiser,
        // ici une liste de Recette.
        val listRecetteType = object : TypeToken<List<Recette>>() {}.type

        // Désérialisation du string JSON en une liste d'objets Recette.
        // Utilisation de l'opérateur Elvis pour retourner une liste vide si le résultat est null.
        val recettes = gson.fromJson<List<Recette>>(jsonFileString, listRecetteType) ?: emptyList()

        // Parcours de chaque recette pour convertir les noms de fichiers d'images (imageResId) en identifiants de ressources.
        return recettes.map { recette ->
            recette.apply {
                // Conversion du nom de fichier en identifiant de ressource drawable.
                // Utilisation de resources.getIdentifier pour obtenir un ID de ressource à partir du nom de fichier.
                imageResId = context.resources.getIdentifier(imageResId, "drawable", context.packageName).toString()
                // Log du nouvel identifiant de ressource pour le débogage.
                Log.d("imageresid", imageResId)
            }
        }
    }


    /**
     * Lit les données JSON à partir d'un fichier dans les assets.
     *
     * @param context Contexte de l'application.
     * @param fileName Nom du fichier à lire.
     * @return Le contenu du fichier en tant que chaîne de caractères ou null si une erreur se produit.
     */
    private fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        return try {
            context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            Log.e("RecetteRepository", "Erreur en lisant $fileName", ioException)
            null
        }
    }

    /**
     * Retourne toutes les recettes chargées.
     *
     * @return Une liste des recettes.
     */
    fun obtenirToutesLesRecettes(): List<Recette> {
        return recettes
    }

    /**
     * Recherche des recettes par nom.
     *
     * @param nom Le nom partiel ou complet à rechercher.
     * @return Une liste des recettes correspondantes.
     */
    fun chercherRecettesParNom(nom: String): List<Recette> {
        return recettes.filter { it.titre.contains(nom, ignoreCase = true) }
    }

    /**
     * Sélectionne une recette aléatoirement dans la liste.
     *
     * @return Une recette aléatoire ou null si la liste est vide.
     */
    fun obtenirRecetteAleatoire(): Recette? {
        if (recettes.isNotEmpty()) {
            return recettes.random()
        }
        return null
    }

    /**
     * Filtre les recettes par niveau de difficulté.
     *
     * @param difficulte Le niveau de difficulté spécifique à filtrer.
     * @return Une liste des recettes filtrées par difficulté.
     */
    fun filtrerRecettesParDifficulte(difficulte: NiveauDifficulte): List<Recette> {
        return recettes.filter { it.difficulte == difficulte }
    }

    /**
     * Filtre les recettes par type de plat.
     *
     * @param type Le type de plat à filtrer.
     * @return Une liste des recettes filtrées par type de plat.
     */
    fun filtrerRecettesParType(type: TypeDePlat): List<Recette> {
        return recettes.filter { it.type == type }
    }

    /**
     * Filtre les recettes en fonction d'une liste d'ingrédients recherchés.
     *
     * @param ingredientsRecherches Liste des ingrédients à vérifier.
     * @return Une liste de recettes contenant tous les ingrédients recherchés.
     */
    fun filtrerRecettesParIngredients(ingredientsRecherches: List<String>): List<Recette> {
        return recettes.filter { recette ->
            ingredientsRecherches.all { ingredientRecherche ->
                recette.ingredients.any { it.contains(ingredientRecherche, ignoreCase = true) }
            }
        }
    }}