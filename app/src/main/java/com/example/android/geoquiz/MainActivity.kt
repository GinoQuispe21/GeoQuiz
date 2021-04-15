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
    var lifes = 3

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
        var question5 = Question("La capital de Uruguay es Montevideo?", true)
        questions.add(question5)
    }

    fun setupViews() {
        val btYes = findViewById<Button>(R.id.btYes)
        val btNo = findViewById<Button>(R.id.btNo)
        val btReiniciar = findViewById<Button>(R.id.btReinicio)

        showLifes()
        showSentences()
        youLose()

        btReiniciar.setOnClickListener {
            Toast.makeText(this, "Se reinicio el juego", Toast.LENGTH_LONG).show()
            position = 0
            lifes = 3
            showSentences()
            showLifes()
            youLose()
        }

        btYes.setOnClickListener{
            if(questions[position].answer == true){
                Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_LONG).show()
                lifes -= 1
            }
            next()
        }
        btNo.setOnClickListener{
            if(!questions[position].answer == true){
                Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_LONG).show()
                lifes -= 1
            }
            next()
        }
    }

    fun next(){
        if(questions.size - position > 1){
            position++
            showSentences()
            showLifes()
            youLose()
        }
        else {
            Results()
            Toast.makeText(this, "Se acabo el juego, reinicia para jugar de nuevo", Toast.LENGTH_LONG).show()
        }
    }

    fun showSentences() {
        val tvSentence = findViewById<TextView>(R.id.tvSentence)
        tvSentence.text = questions[position].sentence
    }

    fun showLifes(){
        val tvLifes = findViewById<TextView>(R.id.tvVidas)
        tvLifes.text = lifes.toString()
    }

    fun youLose(){
        if (lifes == 0) {
            Toast.makeText(this, "Te quedaste sin vidas, toca el boton reiniciar para volver a jugar", Toast.LENGTH_LONG).show()
        }
    }
    fun Results(){
        if(lifes == 3){
            Toast.makeText(this, "Eres muy bueno", Toast.LENGTH_LONG).show()
        }
        if(lifes == 2){
            Toast.makeText(this, "Eres bueno", Toast.LENGTH_LONG).show()
        }
        if(lifes == 1){
            Toast.makeText(this, "Toca estudiar mas", Toast.LENGTH_LONG).show()
        }
    }

}