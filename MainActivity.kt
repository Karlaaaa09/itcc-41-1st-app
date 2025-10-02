package com.example.diceroller

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.diceroller.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonOne.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val dice = Dice(numSides = 6)
        val diceRoll = dice.diceRoll()

        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        binding.imageView.setImageResource(drawableResource)
        binding.imageView.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {
    fun diceRoll(): Int {
        return (1..numSides).random()
    }
}
