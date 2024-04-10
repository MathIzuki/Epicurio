package com.btssio.ozenne.eatspiration.controller

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.btssio.ozenne.eatspiration.R
import com.btssio.ozenne.eatspiration.repository.RecetteRepository
import com.google.android.material.button.MaterialButton

class BoutonsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_boutons)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.principal)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<MaterialButton>(R.id.btnTypePlat).setOnClickListener {
            montrerDialogueTypeDePlat()
        }

        findViewById<MaterialButton>(R.id.btnIngrédients).setOnClickListener {
            montrerDialogueSelectionIngredients()
        }

        val edtChercherPlatParNom = findViewById<EditText>(R.id.edtChercherPlatParNom)
        edtChercherPlatParNom.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH || actionId == EditorInfo.IME_ACTION_DONE ||
                event?.action == KeyEvent.ACTION_DOWN && event.keyCode == KeyEvent.KEYCODE_ENTER) {
                // Exécutez votre logique de recherche ici
                val nomPlat = edtChercherPlatParNom.text.toString().trim()
                if (nomPlat.isNotEmpty()) {
                    // Création et démarrage de l'Intent vers AffichageRecettesActivity avec le nom du plat
                    val intent = Intent(this, AffichageRecettesActivity::class.java).apply {
                        putExtra("TYPE_FILTRE", "NOM")
                        putExtra("CRITERE", nomPlat)
                    }
                    startActivity(intent)
                } else {
                    // Gérer le cas où edtChercherPlatParNom est vide
                    Toast.makeText(this, "Veuillez entrer le nom d'un plat", Toast.LENGTH_SHORT).show()
                }
                true // Retournez true pour indiquer que vous avez géré l'action
            } else false
        }

        findViewById<MaterialButton>(R.id.btnAfficherTousLesPlats).setOnClickListener {
            // Création d'un intent pour démarrer AffichageRecettesActivity sans filtre spécifique
            val intent = Intent(this, AffichageRecettesActivity::class.java).apply {
                // Vous pourriez passer un extra spécifique pour indiquer que vous voulez afficher toutes les recettes
                // ou vous pouvez simplement ne pas passer de filtre et gérer ce cas dans AffichageRecettesActivity
                putExtra("AFFICHAGE", "TOUTES")
            }
            startActivity(intent)
        }

        findViewById<MaterialButton>(R.id.btnPlatAleatoire).setOnClickListener {
            // Supposons que RecetteRepository a une méthode getRecetteAleatoire() qui renvoie une recette aléatoire
            val repository = RecetteRepository()

            val recetteAleatoire = repository.obtenirRecetteAleatoire()

            // Création de l'intent pour démarrer DetailRecetteActivity
            val intent = Intent(this, DetailRecetteActivity::class.java).apply {
                if(recetteAleatoire != null) {
                    putExtra("TITRE", recetteAleatoire.titre)
                    putExtra("INGREDIENTS", recetteAleatoire.ingredients.joinToString(", "))
                    putExtra("INSTRUCTIONS", recetteAleatoire.instructions)
                    putExtra("TEMPS_PREPARATION", recetteAleatoire.tempsPreparation)
                    putExtra("DIFFICULTE", recetteAleatoire.difficulte.name)
                    putExtra("TYPE_PLAT", recetteAleatoire.type.name)
                    putExtra("IMAGE_RES_ID", recetteAleatoire.imageResId)
                }
            }

            // Démarrage de DetailRecetteActivity avec l'intent
            startActivity(intent)
        }


        findViewById<MaterialButton>(R.id.btnChercherPlatParDifficulte).setOnClickListener {
            montrerDialogueDifficultes()
        }
    }
    private fun montrerDialogueTypeDePlat() {
        // Tableau pour l'affichage dans le dialogue
        val typesDePlatAffichage = arrayOf("Entrée", "Plat Principal", "Dessert", "Snack", "Accompagnement")
        // Tableau des valeurs techniques correspondantes
        val typesDePlatValeurs = arrayOf("ENTREE", "PLAT_PRINCIPAL", "DESSERT", "SNACK", "ACCOMPAGNEMENT")

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Choisissez un type de plat")
            .setItems(typesDePlatAffichage) { dialog, which ->
                // Utilisez le tableau de valeurs pour récupérer la valeur technique
                val choixUtilisateur = typesDePlatValeurs[which]

                // Création d'un intent pour démarrer AffichageRecettesActivity avec le type de plat choisi
                val intent = Intent(this, AffichageRecettesActivity::class.java).apply {
                    putExtra("TYPE_FILTRE", "TYPE")
                    putExtra("CRITERE", choixUtilisateur)
                }
                startActivity(intent)
            }
        builder.create().show()
    }


    private fun montrerDialogueDifficultes() {
        val difficulte = arrayOf("FACILE", "MOYEN", "DIFFICILE")
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Difficulté du plat")
            .setItems(difficulte) { dialog, which ->
                val choixUtilisateur = difficulte[which] // Récupération du choix de l'utilisateur
                // Intention d'ouvrir AffichageRecettesActivity avec le filtre de difficulté appliqué
                val intent = Intent(this, AffichageRecettesActivity::class.java).apply {
                    putExtra("TYPE_FILTRE", "DIFFICULTE")
                    putExtra("CRITERE", choixUtilisateur)
                }
                startActivity(intent)
            }
        builder.create().show()
    }

    private fun montrerDialogueSelectionIngredients() {
         val ingredients = arrayOf(
            "Tomates", "Œufs", "Fromage", "Poulet", "Pâtes", "Riz",
            "Poivrons", "Oignons", "Ail", "Carottes", "Courgettes",
            "Champignons", "Crevettes", "Saumon", "Boeuf", "Porc",
            "Basilic", "Persil", "Cumin", "Curry", "Paprika",
            "Chocolat", "Vanille", "Sucre", "Farine", "Lait",
            "Beurre", "Huile d'olive", "Vinaigre", "Citron", "Avocat",
            "Noix", "Amandes", "Lentilles", "Pois chiches", "Quinoa"
        )
        val ingredientsSelectionnes = BooleanArray(ingredients.size) { false }

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Sélectionnez les ingrédients")

        builder.setMultiChoiceItems(ingredients, ingredientsSelectionnes) { _, which, isChecked ->
            // Mettre à jour le tableau d'ingrédients sélectionnés
            ingredientsSelectionnes[which] = isChecked
        }

        builder.setPositiveButton("OK") { _, _ ->
            // Récupérer les ingrédients choisis
            val ingredientsChoisis = ingredients.filterIndexed { index, _ -> ingredientsSelectionnes[index] }

            // Passer les ingrédients choisis à AffichageRecettesActivity via Intent
            val intent = Intent(this, AffichageRecettesActivity::class.java).apply {
                putExtra("TYPE_FILTRE", "INGREDIENTS")
                putExtra("CRITERE", ingredientsChoisis.joinToString(","))
            }
            startActivity(intent)
        }

        builder.setNegativeButton("Annuler") { dialog, _ ->
            // Gestion du clic sur le bouton Annuler si nécessaire
            dialog.dismiss()
        }

        val dialog = builder.create()
        dialog.show()
    }
}