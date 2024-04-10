package com.btssio.ozenne.eatspiration.repository

import com.btssio.ozenne.eatspiration.R
import com.btssio.ozenne.eatspiration.model.NiveauDifficulte
import com.btssio.ozenne.eatspiration.model.Recette
import com.btssio.ozenne.eatspiration.model.TypeDePlat

class RecetteRepository {

    private val recettes = listOf(
        Recette(
            id = 1,
            titre = "Spaghetti Carbonara",
            ingredients = listOf("Spaghetti", "Œufs", "Pancetta", "Parmesan", "Poivre noir"),
            instructions = """
            1. Cuire les spaghetti al dente selon les instructions du paquet.
            2. Dans une poêle, faire revenir la pancetta coupée en dés jusqu'à ce qu'elle soit croustillante.
            3. Battre les œufs dans un bol, ajouter le parmesan râpé et bien mélanger.
            4. Égoutter les pâtes en réservant un peu d'eau de cuisson. Mélanger les pâtes chaudes avec le mélange d'œufs et ajouter un peu d'eau de cuisson pour obtenir une sauce onctueuse.
            5. Ajouter la pancetta, du poivre noir fraîchement moulu, mélanger et servir immédiatement.
        """.trimIndent(),
            tempsPreparation = 20,
            difficulte = NiveauDifficulte.MOYEN,
            type = TypeDePlat.PLAT_PRINCIPAL,
            imageResId = R.drawable.spaghetti_carbonara
        ),
        Recette(
            id = 2,
            titre = "Salade Niçoise",
            ingredients = listOf("Thon", "Œufs durs", "Olives noires", "Tomates", "Haricots verts", "Anchois", "Vinaigrette"),
            instructions = """
            1. Cuire les haricots verts à la vapeur jusqu'à ce qu'ils soient tendres, puis les refroidir dans de l'eau glacée.
            2. Couper les tomates en quartiers et disposer dans un grand saladier.
            3. Ajouter les haricots verts, les œufs durs coupés en quartiers, les olives noires et les filets d'anchois.
            4. Émietter le thon sur la salade et assaisonner avec la vinaigrette.
            5. Mélanger délicatement et servir frais.
        """.trimIndent(),
            tempsPreparation = 15,
            difficulte = NiveauDifficulte.FACILE,
            type = TypeDePlat.ENTREE,
            imageResId = R.drawable.salade_nicoise

        ),
        Recette(
            id = 3,
            titre = "Poulet Basquaise",
            ingredients = listOf("Poulet", "Poivrons", "Tomates", "Oignons", "Ail", "Piment d'Espelette"),
            instructions = """
        1. Faire dorer les morceaux de poulet dans une sauteuse avec de l'huile.
        2. Ajouter les oignons émincés, l'ail, puis les poivrons coupés en lanières.
        3. Incorporer les tomates concassées et assaisonner avec le piment d'Espelette.
        4. Laisser mijoter à couvert pendant environ 40 minutes.
        5. Servir chaud avec du riz blanc.
    """.trimIndent(),
            tempsPreparation = 60,
            difficulte = NiveauDifficulte.MOYEN,
            type = TypeDePlat.PLAT_PRINCIPAL,
            imageResId = R.drawable.poulet_basquaise
        ),
        Recette(
            id = 4,
            titre = "Ratatouille",
            ingredients = listOf("Aubergines", "Courgettes", "Poivrons", "Tomates", "Oignon", "Ail", "Thym"),
            instructions = """
        1. Couper les légumes en dés et les faire revenir séparément.
        2. Mélanger tous les légumes dans une grande casserole, ajouter de l'ail et du thym.
        3. Laisser mijoter à feu doux pendant 45 minutes.
        4. Servir chaud comme accompagnement ou plat principal.
    """.trimIndent(),
            tempsPreparation = 60,
            difficulte = NiveauDifficulte.MOYEN,
            type = TypeDePlat.ACCOMPAGNEMENT,
            imageResId = R.drawable.ratatouille
        ),
        Recette(
            id = 5,
            titre = "Tarte Tatin",
            ingredients = listOf("Pommes", "Pâte feuilletée", "Sucre", "Beurre"),
            instructions = """
        1. Caraméliser le sucre dans un moule à manqué, ajouter le beurre.
        2. Disposer les pommes épluchées et coupées en quartiers sur le caramel.
        3. Couvrir avec la pâte feuilletée, enfourner à 180°C pendant 25 minutes.
        4. Retourner la tarte sur un plat avant de servir.
    """.trimIndent(),
            tempsPreparation = 60,
            difficulte = NiveauDifficulte.MOYEN,
            type = TypeDePlat.DESSERT,
            imageResId = R.drawable.tarte_tatin
        ),
        Recette(
            id = 6,
            titre = "Quiche Lorraine",
            ingredients = listOf("Pâte brisée", "Lardons", "Crème fraîche", "Œufs", "Fromage râpé"),
            instructions = """
        1. Étaler la pâte dans un moule, piquer le fond avec une fourchette.
        2. Répartir les lardons sur le fond de pâte.
        3. Battre les œufs avec la crème fraîche, verser sur les lardons.
        4. Saupoudrer de fromage râpé, cuire à 180°C pendant 30 minutes.
    """.trimIndent(),
            tempsPreparation = 45,
            difficulte = NiveauDifficulte.FACILE,
            type = TypeDePlat.ENTREE,
            imageResId = R.drawable.quiche_lorraine
        ),
        Recette(
            id = 7,
            titre = "Curry de Poulet",
            ingredients = listOf("Poulet", "Lait de coco", "Pâte de curry", "Oignons", "Tomates", "Coriandre"),
            instructions = """
        1. Faire revenir les oignons émincés, ajouter la pâte de curry.
        2. Ajouter le poulet coupé en morceaux, faire dorer.
        3. Incorporer le lait de coco et les tomates, laisser mijoter.
        4. Parsemer de coriandre fraîche avant de servir.
    """.trimIndent(),
            tempsPreparation = 40,
            difficulte = NiveauDifficulte.MOYEN,
            type = TypeDePlat.PLAT_PRINCIPAL,
            imageResId = R.drawable.curry_de_poulet
        ),
        Recette(
            id = 8,
            titre = "Gazpacho",
            ingredients = listOf("Tomates", "Concombre", "Poivron", "Oignon", "Ail", "Vinaigre", "Huile d'olive"),
            instructions = """
        1. Mixer tous les légumes après les avoir épluchés et coupés en morceaux.
        2. Assaisonner avec du vinaigre, de l'huile d'olive, sel et poivre.
        3. Laisser reposer au frais plusieurs heures.
        4. Servir très froid, accompagné de croûtons.
    """.trimIndent(),
            tempsPreparation = 15,
            difficulte = NiveauDifficulte.FACILE,
            type = TypeDePlat.ENTREE,
            imageResId = R.drawable.gazpacho
        ),
        Recette(
            id = 9,
            titre = "Paella",
            ingredients = listOf("Riz", "Poulet", "Fruits de mer", "Chorizo", "Poivrons", "Petits pois", "Safran"),
            instructions = """
        1. Faire revenir le poulet et le chorizo coupés en morceaux.
        2. Ajouter le riz, le safran et le bouillon, cuire à couvert.
        3. Quelques minutes avant la fin de la cuisson, ajouter les fruits de mer et les petits pois.
        4. Laisser reposer quelques minutes avant de servir.
    """.trimIndent(),
            tempsPreparation = 60,
            difficulte = NiveauDifficulte.DIFFICILE,
            type = TypeDePlat.PLAT_PRINCIPAL,
            imageResId = R.drawable.paella
        ),
        Recette(
            id = 10,
            titre = "Soupe à l'Oignon",
            ingredients = listOf("Oignons", "Bouillon de bœuf", "Vin blanc", "Baguette", "Fromage râpé"),
            instructions = """
        1. Caraméliser les oignons émincés dans du beurre.
        2. Déglacer au vin blanc, ajouter le bouillon, laisser mijoter.
        3. Verser la soupe dans des bols résistants à la chaleur.
        4. Couvrir de tranches de baguette et de fromage râpé, gratiner.
    """.trimIndent(),
            tempsPreparation = 45,
            difficulte = NiveauDifficulte.MOYEN,
            type = TypeDePlat.ENTREE,
            imageResId = R.drawable.soupe_oignon
        ),
        Recette(
            id = 11,
            titre = "Cheesecake",
            ingredients = listOf("Biscuits", "Beurre", "Fromage frais", "Sucre", "Œufs", "Vanille"),
            instructions = """
        1. Mélanger les biscuits écrasés avec du beurre, tasser dans un moule.
        2. Battre le fromage frais avec le sucre, les œufs et la vanille, verser sur la base.
        3. Cuire au four au bain-marie pendant 1 heure à 160°C.
        4. Laisser refroidir et réfrigérer avant de servir.
    """.trimIndent(),
            tempsPreparation = 120,
            difficulte = NiveauDifficulte.MOYEN,
            type = TypeDePlat.DESSERT,
            imageResId = R.drawable.cheesecake
        ),
        Recette(
            id = 12,
            titre = "Bœuf Bourguignon",
            ingredients = listOf("Bœuf", "Vin rouge", "Carottes", "Oignons", "Champignons", "Lardons", "Ail"),
            instructions = """
        1. Faire dorer les morceaux de bœuf, réserver.
        2. Dans la même cocotte, faire revenir carottes, oignons, lardons et ail.
        3. Remettre le bœuf, couvrir de vin rouge, ajouter un bouquet garni.
        4. Mijoter à feu doux pendant 3 heures, ajouter les champignons émincés une heure avant la fin de la cuisson.
        5. Assaisonner à votre goût, retirer le bouquet garni et servir chaud.
        6. Accompagner de pommes de terre vapeur ou de tagliatelles fraîches.
            """.trimIndent(),
            tempsPreparation = 120,
            difficulte = NiveauDifficulte.MOYEN,
            type = TypeDePlat.DESSERT,
            imageResId = R.drawable.boeuf_bourguignon
        ),
        Recette(
            id = 13,
            titre = "Lasagnes à la Bolognaise",
            ingredients = listOf("Feuilles de lasagne", "Viande hachée", "Tomates concassées", "Oignon", "Ail", "Fromage râpé", "Béchamel"),
            instructions = """
        1. Faire revenir l'oignon et l'ail, ajouter la viande jusqu'à coloration.
        2. Incorporer les tomates, sel, poivre, et laisser mijoter.
        3. Monter les lasagnes en alternant couches de pâtes, de sauce bolognaise, de béchamel, et finir par du fromage.
        4. Cuire au four à 180°C pendant 45 minutes.
    """,
            tempsPreparation = 90,
            difficulte = NiveauDifficulte.MOYEN,
            type = TypeDePlat.PLAT_PRINCIPAL,
            imageResId = R.drawable.lasagne

        ),
        Recette(
            id = 14,
            titre = "Soupe de Poissons",
            ingredients = listOf("Poissons de roche", "Tomates", "Oignon", "Ail", "Fenouil", "Safran", "Croûtons", "Rouille"),
            instructions = """
        1. Faire revenir l'oignon, l'ail et le fenouil, ajouter les poissons découpés.
        2. Couvrir d'eau, ajouter les tomates et le safran, cuire pendant 1 heure.
        3. Mixer la soupe, filtrer, servir avec des croûtons et de la rouille.
    """,
            tempsPreparation = 80,
            difficulte = NiveauDifficulte.MOYEN,
            type = TypeDePlat.ENTREE,
            imageResId = R.drawable.soupe_de_poisson
        ),
        Recette(
            id = 15,
            titre = "Moussaka",
            ingredients = listOf("Aubergines", "Viande hachée d'agneau", "Tomates", "Oignon", "Ail", "Béchamel", "Fromage râpé"),
            instructions = """
        1. Griller les tranches d'aubergines.
        2. Faire revenir l'oignon, l'ail, ajouter la viande et les tomates.
        3. Superposer dans un plat les aubergines, la viande, napper de béchamel et saupoudrer de fromage.
        4. Cuire au four à 180°C pendant 40 minutes.
    """,
            tempsPreparation = 120,
            difficulte = NiveauDifficulte.MOYEN,
            type = TypeDePlat.PLAT_PRINCIPAL,
            imageResId = R.drawable.moussaka
        ),
        Recette(
            id = 16,
            titre = "Crème Brûlée",
            ingredients = listOf("Jaunes d'œufs", "Crème liquide", "Sucre", "Vanille", "Sucre pour caraméliser"),
            instructions = """
        1. Chauffer la crème avec la vanille, fouetter les jaunes d'œufs avec le sucre.
        2. Verser la crème chaude sur le mélange œufs-sucre, remettre à cuire au bain-marie.
        3. Refroidir, saupoudrer de sucre et caraméliser au chalumeau.
    """,
            tempsPreparation = 45,
            difficulte = NiveauDifficulte.MOYEN,
            type = TypeDePlat.DESSERT,
            imageResId = R.drawable.creme_brulee
        ),
        Recette(
            id = 17,
            titre = "Risotto aux Champignons",
            ingredients = listOf("Riz arborio", "Champignons", "Bouillon de légumes", "Oignon", "Vin blanc", "Parmesan"),
            instructions = """
        1. Faire revenir l'oignon, ajouter le riz jusqu'à ce qu'il devienne translucide.
        2. Déglacer avec le vin, ajouter les champignons, verser le bouillon petit à petit jusqu'à absorption.
        3. Incorporer le parmesan avant de servir.
    """,
            tempsPreparation = 30,
            difficulte = NiveauDifficulte.MOYEN,
            type = TypeDePlat.PLAT_PRINCIPAL,
            imageResId = R.drawable.risotto_aux_champignons
        ),
        Recette(
            id = 18,
            titre = "Tiramisu",
            ingredients = listOf("Mascarpone", "Œufs", "Sucre", "Café fort", "Biscuits à la cuillère", "Cacao en poudre"),
            instructions = """
        1. Séparer les blancs des jaunes d'œufs, fouetter les jaunes avec le sucre, ajouter le mascarpone.
        2. Battre les blancs en neige, incorporer délicatement au mélange.
        3. Tremper les biscuits dans le café, disposer une couche dans un plat, couvrir de crème, répéter.
        4. Saupoudrer de cacao, réfrigérer plusieurs heures avant de servir.
    """,
            tempsPreparation = 240,
            difficulte = NiveauDifficulte.FACILE,
            type = TypeDePlat.DESSERT,
            imageResId = R.drawable.tiramisu
        ),
        Recette(
            id = 19,
            titre = "Salade César",
            ingredients = listOf("Salade romaine", "Poulet grillé", "Croûtons", "Parmesan", "Anchois", "Sauce César"),
            instructions = """
        1. Déchirer la salade en morceaux, disposer dans un grand saladier.
        2. Ajouter le poulet grillé tranché, les croûtons et le parmesan.
        3. Assaisonner avec la sauce César, mélanger délicatement avant de servir.
    """,
            tempsPreparation = 20,
            difficulte = NiveauDifficulte.FACILE,
            type = TypeDePlat.ENTREE,
            imageResId = R.drawable.salade_cesar
        ),
        Recette(
            id = 20,
            titre = "Pizza Margherita",
            ingredients = listOf("Pâte à pizza", "Sauce tomate", "Mozzarella", "Basilic", "Huile d'olive"),
            instructions = """
        1. Étaler la pâte, recouvrir de sauce tomate, disposer des tranches de mozzarella.
        2. Cuire au four préchauffé à 220°C pendant 10-15 minutes.
        3. Garnir de feuilles de basilic frais et d'un filet d'huile d'olive avant de servir.
    """,
            tempsPreparation = 30,
            difficulte = NiveauDifficulte.FACILE,
            type = TypeDePlat.PLAT_PRINCIPAL,
            imageResId = R.drawable.pizza_margherita
        ),
        Recette(
            id = 21,
            titre = "Gâteau au Chocolat",
            ingredients = listOf("Chocolat noir", "Beurre", "Sucre", "Œufs", "Farine"),
            instructions = """
        1. Faire fondre le chocolat avec le beurre, ajouter le sucre, puis les œufs un à un.
        2. Incorporer la farine, verser dans un moule beurré.
        3. Cuire au four à 180°C pendant 25 minutes.
    """,
            tempsPreparation = 45,
            difficulte = NiveauDifficulte.FACILE,
            type = TypeDePlat.DESSERT,
            imageResId = R.drawable.gateau_au_chocolat
        ),
        Recette(
            id = 22,
            titre = "Pad Thaï",
            ingredients = listOf("Nouilles de riz", "Poulet", "Crevettes", "Œufs", "Pousses de soja", "Cacahuètes", "Citron vert", "Sauce de poisson", "Tamarin"),
            instructions = """
        1. Faire cuire les nouilles selon les instructions du paquet.
        2. Sauter le poulet et les crevettes, ajouter les œufs battus.
        3. Incorporer les nouilles, assaisonner avec la sauce de poisson, le tamarin.
        4. Servir garni de pousses de soja, cacahuètes concassées, et quartiers de citron vert.
    """,
            tempsPreparation = 30,
            difficulte = NiveauDifficulte.MOYEN,
            type = TypeDePlat.PLAT_PRINCIPAL,
            imageResId = R.drawable.pad_thai
        ),Recette(
            id = 23,
            titre = "Chips de Kale",
            ingredients = listOf("Feuilles de kale", "Huile d'olive", "Sel"),
            instructions = """
        1. Préchauffez votre four à 160°C.
        2. Retirez les tiges des feuilles de kale et déchirez les feuilles en gros morceaux.
        3. Lavez et séchez soigneusement le kale, puis massez-le avec un peu d'huile d'olive.
        4. Étalez le kale sur une plaque de cuisson en une seule couche et saupoudrez légèrement de sel.
        5. Faites cuire au four pendant 10 minutes ou jusqu'à ce que les bords soient légèrement bruns mais pas brûlés.
    """.trimIndent(),
            tempsPreparation = 15,
            difficulte = NiveauDifficulte.FACILE,
            type = TypeDePlat.SNACK,
            imageResId = R.drawable.chips_de_kale

        ),
        Recette(
            id = 24,
            titre = "Houmous classique",
            ingredients = listOf("Pois chiches en conserve", "Tahini", "Jus de citron", "Ail", "Huile d'olive", "Paprika"),
            instructions = """
        1. Égouttez et rincez les pois chiches.
        2. Dans un mixeur, combinez les pois chiches, le tahini, le jus de citron, l'ail et une pincée de sel.
        3. Mixez jusqu'à obtenir une texture lisse et ajoutez de l'eau ou de l'huile d'olive au besoin.
        4. Servez le houmous dans un bol et faites un puits au centre. Versez un peu d'huile d'olive et saupoudrez de paprika.
    """.trimIndent(),
            tempsPreparation = 10,
            difficulte = NiveauDifficulte.FACILE,
            type = TypeDePlat.SNACK,
            imageResId = R.drawable.houmous_classique
        ),
        Recette(
            id = 25,
            titre = "Barres de céréales maison",
            ingredients = listOf("Flocons d'avoine", "Miel", "Beurre de cacahuète", "Graines de chia", "Fruits secs"),
            instructions = """
        1. Dans une casserole, faites chauffer le miel et le beurre de cacahuète jusqu'à ce qu'ils soient bien mélangés.
        2. Hors du feu, ajoutez les flocons d'avoine, les graines de chia et les fruits secs hachés.
        3. Étalez le mélange dans un moule recouvert de papier cuisson et pressez fermement.
        4. Laissez refroidir, puis coupez en barres.
    """.trimIndent(),
            tempsPreparation = 20,
            difficulte = NiveauDifficulte.MOYEN,
            type = TypeDePlat.SNACK,
            imageResId = R.drawable.barre_de_cereal
        ),
        Recette(
            id = 26,
            titre = "Guacamole",
            ingredients = listOf("Avocats", "Tomate", "Oignon", "Coriandre", "Jus de citron vert", "Piment jalapeño"),
            instructions = """
        1. Écrasez la chair d'avocat dans un bol.
        2. Ajoutez la tomate coupée en dés, l'oignon finement haché, la coriandre ciselée et le piment haché (optionnel).
        3. Arrosez de jus de citron vert et mélangez délicatement. Salez à votre goût.
    """.trimIndent(),
            tempsPreparation = 10,
            difficulte = NiveauDifficulte.FACILE,
            type = TypeDePlat.SNACK,
            imageResId = R.drawable.guacamole
        ),
        Recette(
            id = 27,
            titre = "Nachos au fromage",
            ingredients = listOf("Chips de maïs", "Cheddar râpé", "Piments jalapeños", "Olives noires", "Sauce salsa"),
            instructions = """
        1. Préchauffez le four à 180°C.
        2. Disposez les chips de maïs sur une plaque allant au four.
        3. Parsemez généreusement de fromage râpé, de tranches de jalapeños et d'olives noires.
        4. Faites cuire au four jusqu'à ce que le fromage soit fondu.
        5. Servez chaud avec de la sauce salsa.
    """.trimIndent(),
            tempsPreparation = 15,
            difficulte = NiveauDifficulte.FACILE,
            type = TypeDePlat.SNACK,
            imageResId = R.drawable.nachos_au_fromage
        ),
        Recette(
            id = 28,
            titre = "Soufflé au fromage",
            ingredients = listOf("Beurre", "Farine", "Lait", "Jaunes d'œufs", "Blancs d'œufs", "Fromage gruyère râpé", "Noix de muscade"),
            instructions = """
        1. Préchauffez le four à 190°C et beurrez les ramequins.
        2. Faites une béchamel épaisse, incorporez les jaunes d'œufs et le fromage gruyère.
        3. Montez les blancs en neige et incorporez-les délicatement à la préparation.
        4. Remplissez les ramequins et faites cuire pendant 25 minutes sans ouvrir le four.
    """.trimIndent(),
            tempsPreparation = 30,
            difficulte = NiveauDifficulte.DIFFICILE,
            type = TypeDePlat.ENTREE,
            imageResId = R.drawable.souffle_au_fromage
        ),
        Recette(
            id = 29,
            titre = "Canard à l'orange",
            ingredients = listOf("Canard entier", "Oranges", "Vinaigre de vin", "Sucre", "Bouillon de volaille", "Cognac"),
            instructions = """
        1. Faites dorer le canard de tous côtés dans une cocotte.
        2. Préparez un caramel avec le sucre et déglacez au vinaigre.
        3. Ajoutez le jus d'orange, le zeste et le bouillon au canard.
        4. Faites cuire à feu doux pendant 2 heures.
        5. Flambez avec le cognac avant de servir.
    """.trimIndent(),
            tempsPreparation = 150,
            difficulte = NiveauDifficulte.DIFFICILE,
            type = TypeDePlat.PLAT_PRINCIPAL,
            imageResId = R.drawable.canard_a_lorange
        ),
        Recette(
            id = 30,
            titre = "Bouillabaisse",
            ingredients = listOf("Poissons variés", "Fruits de mer", "Tomates", "Poireaux", "Oignons", "Ail", "Fenouil", "Safran", "Pommes de terre", "Croûtons", "Rouille"),
            instructions = """
        1. Préparez un bouillon avec des arêtes de poisson, des légumes et du safran.
        2. Faites revenir les oignons, le fenouil et l'ail, ajoutez les tomates puis mouillez avec le bouillon.
        3. Ajoutez les pommes de terre et les poissons en commençant par les plus fermes.
        4. Servez la soupe avec des croûtons aillés et la rouille.
    """.trimIndent(),
            tempsPreparation = 120,
            difficulte = NiveauDifficulte.DIFFICILE,
            type = TypeDePlat.PLAT_PRINCIPAL,
            imageResId = R.drawable.bouillabaisse
        ),
        Recette(
            id = 31,
            titre = "Macarons",
            ingredients = listOf("Poudre d'amande", "Sucre glace", "Blancs d'œufs", "Sucre en poudre", "Colorant alimentaire", "Ganache ou confiture pour la garniture"),
            instructions = """
        1. Tamisez la poudre d'amande et le sucre glace, montez les blancs en neige avec le sucre.
        2. Incorporez les poudres aux blancs, macaronnez jusqu'à la consistance lisse et brillante.
        3. Pochez les coques et laissez croûter une heure avant de cuire.
        4. Faites cuire chaque plaque pendant 12 minutes dans un four préchauffé à 150°C.
    """.trimIndent(),
            tempsPreparation = 180,
            difficulte = NiveauDifficulte.DIFFICILE,
            type = TypeDePlat.DESSERT,
            imageResId = R.drawable.macarons
        ),
        Recette(
            id = 32,
            titre = "Cassoulet",
            ingredients = listOf("Haricots blancs", "Saucisse de Toulouse", "Confit de canard", "Lardons", "Carottes", "Oignons", "Ail", "Bouquet garni", "Chapelure"),
            instructions = """
        1. Faites tremper les haricots blancs une nuit.
        2. Cuisez les haricots avec un bouquet garni, des carottes et des oignons.
        3. Dans une cocotte, montez le cassoulet en alternant haricots, saucisse, confit de canard et lardons.
        4. Recouvrez de chapelure et faites cuire au four à 130°C pendant 3 heures, en mouillant avec le bouillon de haricots.
    """.trimIndent(),
            tempsPreparation = 240,
            difficulte = NiveauDifficulte.DIFFICILE,
            type = TypeDePlat.PLAT_PRINCIPAL,
            imageResId = R.drawable.cassoulet
        )

    )

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