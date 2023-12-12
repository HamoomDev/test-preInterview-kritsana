package com.example.test_preinterview_kritsana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test_preinterview_kritsana.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setUp()
    }

    private fun setUp() = with(binding) {
        one.setOnClickListener {
            val intent = Intent(this@MainActivity, Subject1::class.java)
            startActivity(intent)
        }
        two.setOnClickListener {
            val intent = Intent(this@MainActivity, Subject2::class.java)
            startActivity(intent)
        }
        three.setOnClickListener {
            val intent = Intent(this@MainActivity, Subject3::class.java)
            startActivity(intent)
        }
        four.setOnClickListener {
            val intent = Intent(this@MainActivity, Subject4::class.java)
            startActivity(intent)
        }
        five.setOnClickListener {
            val intent = Intent(this@MainActivity, Subject5::class.java)
            startActivity(intent)
        }
        six.setOnClickListener {
            val intent = Intent(this@MainActivity, Subject6::class.java)
            startActivity(intent)
        }
    }
}