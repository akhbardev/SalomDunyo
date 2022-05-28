package com.example.calculator

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kalkulyator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()

    }

    private fun initview() {
        binding.btnPlus.setOnClickListener {
            val number1 = binding.editOne.text.toString().trim()
            val number2 = binding.editTwo.text.toString().trim()

            if (isNotEmpty(number1, number2)) {
                val sum = add(number1.toInt(), number2.toInt())
                binding.textResult.text = sum
            }else {
                toast("Enter data")
            }

        }
    }
    private fun add(a: Int, b:Int): String {
        return (a + b).toString()
    }

    private fun toast(text: String) {

        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    private fun isNotEmpty(s1: String , s2: String): Boolean {
        return !(TextUtils.isEmpty(s1) && TextUtils.isEmpty(s2))
    }

}