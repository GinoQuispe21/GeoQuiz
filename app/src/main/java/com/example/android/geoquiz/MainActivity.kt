package com.example.android.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    lateinit var questions: ArrayList<Question>
    var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadQuestions()
        setupViews()
    }

    fun loadQuestions() {
        questions = ArrayList()
        var question = Question("Es Lima la capital de Peru?", true)
        questions.add(question)
        var question2 = Question("Es Lima la capital de Chile?", false)
        questions.add(question2)
        var question3 = Question("Es Venezuela la capital de Argentina", false)
        questions.add(question3)
        var question4 = Question("Es Santiago la capital de Chile?", true)
        questions.add(question4)
        var question5 = Question("Es Pedro castillo un comunista?", true)
        questions.add(question5)
    }

    fun setupViews(){
        val btYes = findViewById<Button>(R.id.btYes)
        val btNo = findViewById<Button>(R.id.btNo)
        val btNext = findViewById<Button>(R.id.btNext)

        showSentences()

        btYes.setOnClickListener{
            if(questions[position].answer == true){
                Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_LONG).show()
            }
        }
        btNo.setOnClickListener{
            if(!questions[position].answer == true){
                Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_LONG).show()
            }
        }
        btNext.setOnClickListener {
            position++
            showSentences()
        }
    }

    fun showSentences() {
        val tvSentence = findViewById<TextView>(R.id.tvSentence)
        tvSentence.text = questions[position].sentence
    }
}