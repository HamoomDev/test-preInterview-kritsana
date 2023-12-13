package com.example.test_preinterview_kritsana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test_preinterview_kritsana.databinding.ActivitySubject4Binding

class Subject4 : AppCompatActivity() {
    private lateinit var binding: ActivitySubject4Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubject4Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            btn.setOnClickListener {
                result.text = reverse(edt.text.toString())
            }
        }
    }

    private fun reverse(txt:String):String{
        //คำสั่ง reverse ค่าใน string
        return txt.reversed()
    }
}