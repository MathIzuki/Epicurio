package com.btssio.ozenne.epicurio.model

data class Recette(
    val id: Int,
    val titre: String,
    val ingredients: List<String>,
    val instructions: String,
    val tempsPreparation: Int, // en minutes
    val difficulte: NiveauDifficulte,
    val type: TypeDePlat, // Ajout d'un nouveau champ pour le type de plat
    var imageResId: String // Changé en String pour gérer la conversion après la désérialisation
)