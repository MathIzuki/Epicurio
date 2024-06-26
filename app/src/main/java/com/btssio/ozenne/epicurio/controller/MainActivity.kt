package com.btssio.ozenne.epicurio.controller

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.btssio.ozenne.epicurio.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.principal)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bouton_entree = findViewById<Button>(R.id.button_entree)
        // On définit un écouteur d'événements de clic pour ce bouton.

        bouton_entree.setOnClickListener() {
            // On créer une intention pour démarrer une nouvelle activité.
            val intention = Intent(this, BoutonsActivity::class.java)
            // On démarre l'activité spécifiée par l'intention.
            startActivity(intention)
            finish()
        }


    }
}