package com.example.test_preinterview_kritsana

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.test_preinterview_kritsana.databinding.ActivitySubject2Binding
import kotlin.random.Random

class Subject2 : AppCompatActivity() {
    private lateinit var binding: ActivitySubject2Binding
    private val od: OddEvenList<String> = OddEvenList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubject2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
    }

    private fun setup() = with(binding) {
        btnAdd.setOnClickListener {
            val add = od.add(edtAdd.text.toString())
            showData(od.getAll().contentToString(), "add index", add.toString())
        }

        btnRemove.setOnClickListener {
            val remove = od.remove(edtRemove.text.toString().toInt())
            showData(od.getAll().contentToString(), "Remove", remove.toString())
        }
        btnGetOdd.setOnClickListener {
            showData(od.getAll().contentToString(), "Get Odd", od.getOdd().contentToString())
        }
        btnGetEven.setOnClickListener {
            showData(od.getAll().contentToString(), "get Even", od.getEven().contentToString())
        }
        btnGetRan.setOnClickListener {
            showData(od.getAll().contentToString(), "Random", od.getRandom().contentToString())
        }
    }

    private fun showData(list: String, action: String, acList: String) = with(binding) {
        showList.text = list
        result.text = action
        resultList.text = acList
    }
}

class OddEvenList<T> {

    var dataArray: Array<Any> = arrayOf()

    fun <T : Any> add(input: T): Int {
        // เพิ่มค่าเข้า array
        dataArray = dataArray.plusElement(input)
        // return index ล่าสุด
        return dataArray.lastIndex
    }

    fun remove(index: Int): Boolean {
        // เก็บค่าใน index เพื่อเอาไม่ตรวสอบค่าใน array
        val data = dataArray[index]

        // เปลี่ยน array เป็น mutablelist เพื่อลบค่า
        val arrList = dataArray.toMutableList()

        // ลบค่าใน mutablelist
        arrList.removeAt(index)

        // เปลี่ยน type กลับเป็น array เพื่อ return ค่า
        dataArray = arrList.toTypedArray()

        return !dataArray.contains(data)
    }


    fun getOdd(): Array<T> {
        // ตัดค่า index ที่ หารเศษแล้วไม่เท่ากับ 0
        val res = dataArray.filterIndexed { index, any -> index % 2 != 0 }.toTypedArray()
        return res as Array<T>
    }

    fun getEven(): Array<T> {
        // ตัดค่า index ที่ หารเศษแล้วไม่เท่ากับ 1
        val res = dataArray.filterIndexed { index, any -> index % 2 != 1 }.toTypedArray()
        return res as Array<T>
    }

    fun getRandom(): Array<T> {
        // สร้างลิสต์ของตัวเลข 0 ถึง จำนวน index
        val numbers = (0..<dataArray.size).toMutableList()

        // สลับลำดับของตัวเลข
        numbers.shuffle()

        // เก็บค่าตัวเลขจากการสลับ
        val randomNumbers = numbers.take(dataArray.size)

        // สร้าง array เพื่อเก็บค่าที่สุ่ม
        var data:Array<Any> = arrayOf()

        // ลูปเลขที่สลับเพื่อเอาไปใส่ใน array ที่สร้างขึ้น
        randomNumbers.forEach {
            data = data.plusElement(dataArray[randomNumbers[it]])
        }
        return data as Array<T>
    }

    fun getAll(): Array<T> {
        return dataArray as Array<T>
    }
}



