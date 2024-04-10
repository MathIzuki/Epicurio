package com.btssio.ozenne.eatspiration.model

data class Recette(
    val id: Int,
    val titre: String,
    val ingredients: List<String>,
    val instructions: String,
    val tempsPreparation: Int, // en minutes
    val difficulte: NiveauDifficulte,
    val type: TypeDePlat, // Ajout d'un nouveau champ pour le type de plat
    val imageResId: Int? = null // Ajoutez ce champ pour stocker l'ID de ressource de l'image

)