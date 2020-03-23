package com.example.spongebobquotes

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var quoteText: TextView
    private lateinit var spongeBobQuote: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        quoteText = findViewById(R.id.quoteTVID)
        spongeBobQuote = findViewById(R.id.quoteETVID)



        findViewById<Button>(R.id.buttonID).setOnClickListener {
           camelCaseKinda()
        }

        findViewById<Button>(R.id.clearButtonID).setOnClickListener {
            Toast.makeText(this,"Cleared",Toast.LENGTH_SHORT).show()
            quoteText.text = ""
            spongeBobQuote.text = ""
        }
    }

    override fun onStart() {
        super.onStart()
        quoteText.text = ""
        spongeBobQuote.text = ""
    }

    private fun camelCaseKinda(){
        var newQuote = ""
        var i = 0
        if (!quoteText.text.toString().trim().isEmpty()) {
            for (eachCharacter in quoteText.text.toString()) {
                newQuote += if (i % 2 == 0) {
                    Character.toUpperCase(eachCharacter)
                } else {
                    Character.toLowerCase(eachCharacter)
                }
                i++
            }
            spongeBobQuote.text = newQuote.trim()
            copyToClipBoard(newQuote)
            Toast.makeText(this,"The new String has been copied to the clipboard",Toast.LENGTH_SHORT).show()
        }
    }

    private fun copyToClipBoard(newQuote: String) {
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("Copy Text",newQuote)
        clipboard.setPrimaryClip(clip)
    }
}