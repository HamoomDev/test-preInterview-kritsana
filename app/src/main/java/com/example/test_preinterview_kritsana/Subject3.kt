package com.example.test_preinterview_kritsana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test_preinterview_kritsana.databinding.ActivitySubject3Binding

class Subject3 : AppCompatActivity() {
    private lateinit var binding: ActivitySubject3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubject3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            btn.setOnClickListener {
                result.text = squareDigits(edt.text.toString().toInt()).toString()
            }
        }
    }

    private fun squareDigits(n: Int): Int {

        //covert ชุดตัวเลขให้เป็น list
        val numbers = n.toString().map { it.toString().toInt() }

        var result = ""

        // วนลุปเพื่อเอาตัวเลขมายกกำลัง
        numbers.forEach {

            // ยกกำลังตัวเลขและแปลงค่าเป็น Int เพื่อลบ .0 ออก และแปลงเป็น String เพื่อไม่ให้เลขชุดก่วนมาบวกกัน
            result += Math.pow(it.toDouble(), 2.0).toInt().toString()
        }
        return result.toInt()
    }
}