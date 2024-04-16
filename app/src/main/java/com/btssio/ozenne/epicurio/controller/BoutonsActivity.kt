package com.btssio.ozenne.epicurio.controller

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.btssio.ozenne.epicurio.R
import com.btssio.ozenne.epicurio.repository.RecetteRepository
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

        // Lorsqu'on clique sur le bouton type de plat on utilise la méthode montrerDialogueTypeDePlat pour
        // afficher une boite de dialogue et séléctionner le type de son plat
        findViewById<MaterialButton>(R.id.btnTypePlat).setOnClickListener {
            montrerDialogueTypeDePlat()
        }

        // Lorsqu'on clique sur le bouton type de plat on utilise la méthode montrerDialogueSelectionIngredients pour
        // afficher une boite de dialogue et on séléctionne ses ingrédients
        findViewById<MaterialButton>(R.id.btnIngrédients).setOnClickListener {
            montrerDialogueSelectionIngredients()
        }

        val edtChercherPlatParNom = findViewById<EditText>(R.id.edtChercherPlatParNom)
        // Mise en place d'un écouteur d'événements sur les actions de l'éditeur de texte.
        edtChercherPlatParNom.setOnEditorActionListener { v, actionId, event ->
            // Vérification si l'action correspond à une action de recherche ou de validation
            // ou si la touche Entrée a été pressée.
            if (actionId == EditorInfo.IME_ACTION_SEARCH || actionId == EditorInfo.IME_ACTION_DONE ||
                event?.action == KeyEvent.ACTION_DOWN && event.keyCode == KeyEvent.KEYCODE_ENTER) {
                // Extraction du texte saisi par l'utilisateur, nettoyage des espaces avant et après le texte avec trim
                val nomPlat = edtChercherPlatParNom.text.toString().trim()
                // Vérification si le texte extrait n'est pas vide.
                if (nomPlat.isNotEmpty()) {
                    // Création d'une intention pour démarrer une nouvelle activité avec des paramètres supplémentaires.
                    val intent = Intent(this, AffichageRecettesActivity::class.java).apply {
                        // Ajout d'extra pour préciser le type de filtre (par nom) et le critère (nom du plat).
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
                putExtra("AFFICHAGE", "TOUTES")
            }
            startActivity(intent)
        }

        // Récupération du bouton par son ID et configuration d'un écouteur de clic.
        findViewById<MaterialButton>(R.id.btnPlatAleatoire).setOnClickListener {
            // Création d'une instance de RecetteRepository pour accéder aux méthodes de gestion des recettes.
            val repository = RecetteRepository(this@BoutonsActivity)

            // Appel de la méthode pour obtenir une recette aléatoire depuis le repository.
            val recetteAleatoire = repository.obtenirRecetteAleatoire()

            // Création d'une intention pour démarrer DetailRecetteActivity, destinée à afficher les détails de la recette.
            val intent = Intent(this, DetailRecetteActivity::class.java).apply {
                // Vérification si une recette a été obtenue avec succès.
                if (recetteAleatoire != null) {
                    // Ajout des détails de la recette à l'intent pour être utilisés dans l'activité de détail.
                    putExtra("TITRE", recetteAleatoire.titre)  // Titre de la recette.
                    putExtra("INGREDIENTS", recetteAleatoire.ingredients.joinToString(", "))  // Liste des ingrédients.
                    putExtra("INSTRUCTIONS", recetteAleatoire.instructions)  // Instructions de préparation.
                    putExtra("TEMPS_PREPARATION", recetteAleatoire.tempsPreparation)  // Temps nécessaire pour préparer.
                    putExtra("DIFFICULTE", recetteAleatoire.difficulte.name)  // Niveau de difficulté de la recette.
                    putExtra("TYPE_PLAT", recetteAleatoire.type.name)  // Type de plat (entrée, dessert, etc.).
                    putExtra("IMAGE_RES_ID", recetteAleatoire.imageResId.toInt())  // Référence à l'image associée à la recette.
                }
            }

            // Démarrage de DetailRecetteActivity avec l'intent contenant les données de la recette.
            startActivity(intent)
        }

        // Lorsqu'on clique sur le bouton type de plat on utilise la méthode montrerDialogueDifficultes pour
        // afficher une boite de dialogue et on séléctionne la difficulté voulu
        findViewById<MaterialButton>(R.id.btnChercherPlatParDifficulte).setOnClickListener {
            montrerDialogueDifficultes()
        }
    }

    // On définit la fonction qui montre un dialogue avec des options de types de plats.
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

    // On définit la fonction pour afficher un dialogue de sélection de difficulté.
    private fun montrerDialogueDifficultes() {
        // Tableau contenant les options de difficulté à afficher dans le dialogue.
        val difficulte = arrayOf("FACILE", "MOYEN", "DIFFICILE")

        // Création d'un constructeur de dialogue AlertDialog avec le contexte de l'activité actuelle.
        val builder = AlertDialog.Builder(this)

        // Configuration du titre du dialogue.
        builder.setTitle("Difficulté du plat")
            // Ajout des éléments (difficultés) au dialogue, avec un écouteur d'événements pour les clics sur les éléments.
            .setItems(difficulte) { dialog, which ->
                // Récupération du choix de l'utilisateur basé sur l'index de l'élément sélectionné.
                val choixUtilisateur = difficulte[which]

                // Création d'une intention pour démarrer AffichageRecettesActivity avec des extras spécifiant le filtre.
                val intent = Intent(this, AffichageRecettesActivity::class.java).apply {
                    // Ajout d'extras pour passer le type de filtre et le critère spécifique choisi (niveau de difficulté).
                    putExtra("TYPE_FILTRE", "DIFFICULTE")
                    putExtra("CRITERE", choixUtilisateur)
                }

                // Démarrage de l'activité cible avec l'intention configurée.
                startActivity(intent)
            }

        // Construction et affichage du dialogue.
        builder.create().show()
    }

    // On définit la fonction pour afficher un dialogue de sélection de sélection des ingrédients.
    private fun montrerDialogueSelectionIngredients() {
        // Initialisation d'un tableau contenant les ingrédients disponibles pour la sélection.
        val ingredients = arrayOf(
            "Tomates", "Œufs", "Fromage", "Poulet", "Pâtes", "Riz",
            "Poivrons", "Oignons", "Ail", "Carottes", "Courgettes",
            "Champignons", "Crevettes", "Saumon", "Boeuf", "Porc",
            "Basilic", "Persil", "Cumin", "Curry", "Paprika",
            "Chocolat", "Vanille", "Sucre", "Farine", "Lait",
            "Beurre", "Huile d'olive", "Vinaigre", "Citron", "Avocat",
            "Noix", "Amandes", "Lentilles", "Pois chiches", "Quinoa"
        )

        // Création d'un tableau de booléens pour garder trace des ingrédients sélectionnés.
        val ingredientsSelectionnes = BooleanArray(ingredients.size) { false }

        // Construction du dialogue avec AlertDialog.Builder.
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Sélectionnez les ingrédients")

        // Ajout d'options multiples avec des cases à cocher pour chaque ingrédient.
        builder.setMultiChoiceItems(ingredients, ingredientsSelectionnes) { _, which, isChecked ->
            // Mise à jour de l'état de sélection pour chaque ingrédient lorsque l'utilisateur modifie son choix.
            ingredientsSelectionnes[which] = isChecked
        }

        // Configuration du bouton "OK" du dialogue.
        builder.setPositiveButton("OK") { _, _ ->
            // Filtrage et récupération des ingrédients choisis basés sur leur état de sélection.
            val ingredientsChoisis = ingredients.filterIndexed { index, _ -> ingredientsSelectionnes[index] }

            // Création d'une intention pour démarrer une nouvelle activité avec les ingrédients sélectionnés.
            val intent = Intent(this, AffichageRecettesActivity::class.java).apply {
                putExtra("TYPE_FILTRE", "INGREDIENTS")
                putExtra("CRITERE", ingredientsChoisis.joinToString(","))
            }
            startActivity(intent)  // Démarrage de l'activité avec l'intention contenant les ingrédients.
        }

        // Configuration du bouton "Annuler" pour fermer le dialogue sans action supplémentaire.
        builder.setNegativeButton("Annuler") { dialog, _ ->
            dialog.dismiss()
        }

        // Création et affichage du dialogue.
        val dialog = builder.create()
        dialog.show()
    }
}