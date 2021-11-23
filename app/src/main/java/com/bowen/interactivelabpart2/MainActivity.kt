package com.bowen.interactivelabpart2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import org.w3c.dom.Text

var teamAScore = 0
var teamBScore = 0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val teamAPlusThreeButton: Button = findViewById(R.id.team_a_plus_three_pts_button)
        teamAPlusThreeButton.setOnClickListener {
            addForTeam(3, "A")
        }
        val teamAPlusTwoButton: Button = findViewById(R.id.team_a_plus_two_pts_button)
        teamAPlusTwoButton.setOnClickListener{
            addForTeam(2, "A")
        }
        val teamAFreeThrowButton: Button = findViewById(R.id.team_a_free_throw_button)
        teamAFreeThrowButton.setOnClickListener{
            addForTeam(1, "A")
        }
        val teamBPlusThreeButton: Button = findViewById(R.id.team_b_plus_three_pts_button)
        teamBPlusThreeButton.setOnClickListener {
            addForTeam(3, "B")
        }
        val teamBPlusTwoButton: Button = findViewById(R.id.team_b_plus_two_pts_button)
        teamBPlusTwoButton.setOnClickListener {
            addForTeam(2, "B")
        }
        val teamBFreeThrowButton : Button = findViewById(R.id.team_b_free_throw_button)
        teamBFreeThrowButton.setOnClickListener {
            addForTeam(1, "B")
        }
        val resetButton : Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener {
            teamAScore = 0
            val teamAScoreText: TextView = findViewById(R.id.team_a_score_textView)
            teamAScoreText.text = teamAScore.toString()
            teamBScore = 0
            val teamBScoreText: TextView = findViewById(R.id.team_b_score_textView)
            teamBScoreText.text = teamBScore.toString()
        }
    }

    fun addForTeam(amount: Int, team: String){
        if(team == "A") {
            teamAScore += amount
            val teamAScoreText: TextView = findViewById(R.id.team_a_score_textView)
            teamAScoreText.text = teamAScore.toString()
        }
        else {
            teamBScore += amount
            val teamBScoreText: TextView = findViewById(R.id.team_b_score_textView)
            teamBScoreText.text = teamBScore.toString()
        }
        if(amount == 3) {
            val cheer = "YAY TEAM " + team
            Snackbar.make(
                findViewById(R.id.myCoordinatorLayout),
                cheer,
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }
}