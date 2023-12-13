package com.example.test_preinterview_kritsana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.test_preinterview_kritsana.databinding.ActivitySubject5Binding

class Subject5 : AppCompatActivity() {
    private lateinit var binding: ActivitySubject5Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubject5Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            btn.setOnClickListener {
                result.text = checkFormat(edt.text.toString()).toString()
            }
        }
    }

    fun checkFormat(data :String):Boolean{

        // ตั้งตัวแปลเอาไว้เก็บค่าเพื่อตรวจสอบ
        val result = mutableListOf<Char>()

        // ตั้ง Set ของสัญลักษณ์เพื่อใช้ตรวจสอบ
        val open = setOf('(', '[', '{')
        val close = setOf(')', ']', '}')

        // นำตัวแปรที่รับมาเข้าลุปเพื่อตรวจสอบ
        for (char in data) {
            when {
                // เมื่อมีสัญลักษณ์ในหมวด Open จะทำการเพิ่มค่านั้นเข้า result
                char in open -> {
                    result.add(char)
                }
                // เมื่อมีสัญลักษณ์ในหมวด Close จะทำเช็คเงื่อนไข
                char in close -> {
                    /***
                     *  ถ้า result เป็นค่าว่าง หรือ
                     *  สัญลักษณ์ตำแหน่งที่จับคู่กันใน open และ close (เช่น () จะเป็นตำแหน่งที่ 0)
                     *  ไม่เท่ากับ result ที่ลบตำแหน่ง index ของ จำนวนขนาดลบด้วย1 แล้วไม่เท่ากัน
                     *  จะมีค่าเป็น false
                     *  เช่น ({)
                     *  -> (
                     *  if ( != { -> false
                     */
                    if (result.isEmpty() ||
                        open.elementAt(close.indexOf(char)) != result.removeAt(result.size - 1)) {
                        return false
                    }
                }
                else -> {
                    
                }
            }

        }
        return result.isEmpty()
    }
}