package com.example.test_preinterview_kritsana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import com.example.test_preinterview_kritsana.databinding.ActivitySubject6Binding

class Subject6 : AppCompatActivity() {
    private lateinit var binding: ActivitySubject6Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubject6Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            btn.setOnClickListener {
                result.text = checkMost(edt.text.toString().lowercase())
                edt.setText(edt.text.toString().lowercase())
            }
        }
    }

    private fun checkMost(data: String): String {
        // แบ่ง string ออกเป็น list โดยช่องว่าง
        val list = data.split(" ")

        // ตั้งตัวแปรเพื่อเก็บค่าที่สูงที่สุดโดยช่องแรกเป็น Int ช่อง 2 เป็น String
        var firstPoint: Pair<Int, String> = Pair(0, "")

        //ลูปลิสที่สร้างไว้
        list.forEach {
            // คำนวนคะแนนของคำ
            val point = calPoint(it)

            // ถ้าคะแนนที่คำนวนมาจากคำในลูปมากกว่า จะแทนค่าลงตัวแปรที่สร้างไว้
            if (firstPoint.first < point) {
                firstPoint = Pair(point, it)
            }
        }
        return firstPoint.second
    }

    fun calPoint(data: String): Int {
        // คำนวนคำโดยตั้งค่าจากตัวแปรที่มีในระบบโดย + ทีละ 1
        // a ในระบบ จะเริ่มต้นที่ 97 จึงนำมาลบกับ a และ +1 อ้างอิงจาก ascii
        return data.sumOf { it.code - 'a'.code + 1 }
    }
}