package com.example.usta

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.usta.database.DatabaseUst
import com.example.usta.database.model.UserIdModel

class Profile : AppCompatActivity() {
    private lateinit var username: TextView
    private lateinit var history: Button
    private lateinit var homeButton: ImageButton
    private lateinit var ticketButton: ImageButton

    private fun initComponents() {
        username = findViewById(R.id.usernameProfile)
        history = findViewById(R.id.historyTicketButton)
        homeButton = findViewById(R.id.homeButtonProfile)
        ticketButton = findViewById(R.id.ticketButtonProfile)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        initComponents()
        val databaseUst = DatabaseUst(this)

        username.text = databaseUst.getUsername(UserIdModel.getId())

        history.setOnClickListener {
            startActivity(Intent(this, TicketHistory::class.java))
        }

        homeButton.setOnClickListener {
            startActivity(Intent(this, Home::class.java))
        }
        ticketButton.setOnClickListener {
            startActivity(Intent(this, Ticket::class.java))
        }
    }
}