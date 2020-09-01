package com.example.madlevel1task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Toast
import com.example.madlevel1task1.databinding.ActivityHigherLowerBinding
import kotlinx.android.synthetic.main.activity_higher_lower.*

class HigherLowerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHigherLowerBinding
    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHigherLowerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()

    }


    /**
     * sets the UI
     */
    private  fun initViews() {
        binding.btnHigher.setOnClickListener { onHigherClick() }
        binding.btnLower.setOnClickListener { onLowerClick() }
        binding.btnEquals.setOnClickListener { onEqualClick() }
        updateUI()
    }


    /**
     * updates the view of the current dice and number
     */
    private  fun updateUI() {

        if (currentThrow == 1){
            binding.imageView.setImageResource(R.drawable.dice1)
        }
         else if (currentThrow == 2){
            binding.imageView.setImageResource(R.drawable.dice2)
        }
        else  if (currentThrow == 3){
            binding.imageView.setImageResource(R.drawable.dice3)
        }
         else if (currentThrow == 4){
            binding.imageView.setImageResource(R.drawable.dice4)
        }
        else if (currentThrow == 5){
            binding.imageView.setImageResource(R.drawable.dice5)
        }
        else if (currentThrow == 6){
            binding.imageView.setImageResource(R.drawable.dice6)
        }

        binding.LastThrow.text = getString(R.string.last_throw, lastThrow)

    }

    /**
     * rolls dice randomly
     */
    private fun rollDice() {
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }

    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onHigherClick() {
            rollDice()

        if(currentThrow > lastThrow){
            correctAnswer()
        } else {
            incorrectAnswer()
        }

    }

    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onLowerClick() {
        rollDice()

        if(currentThrow < lastThrow){
            correctAnswer()
        } else{
            incorrectAnswer()
        }
    }

    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onEqualClick() {
        rollDice()

        if(currentThrow === lastThrow){
            correctAnswer()
        } else{
            incorrectAnswer()
        }
    }

   /**
    * gives answer correct if input is correct
    */
    private fun correctAnswer() {

        Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_SHORT).show()

    }

    /**
     * gives answer incorrect if input is incorrect
     */
    private fun incorrectAnswer() {

        Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_SHORT).show()


    }



}



