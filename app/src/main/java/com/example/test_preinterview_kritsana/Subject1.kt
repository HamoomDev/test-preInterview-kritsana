package com.example.test_preinterview_kritsana

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test_preinterview_kritsana.databinding.ActivityMainBinding
import com.example.test_preinterview_kritsana.databinding.ActivitySubject1Binding
import kotlin.math.roundToInt

class Subject1 : AppCompatActivity() {
    private lateinit var binding: ActivitySubject1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubject1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCal.setOnClickListener {
            calculate()
        }
    }

    @SuppressLint("StringFormatInvalid")
    private fun calculate() = with(binding) {
        val qtyA = edtA.text.toString().toDouble()
        val qtyB = edtB.text.toString().toDouble()
        val qtyC = edtC.text.toString().toDouble()

        val total = qtyA + qtyB + qtyC

        val saleOA = (((qtyA / total).toFloat()) * 100).roundToInt()
        val saleOB = (((qtyB / total).toFloat()) * 100).roundToInt()
        val saleOC = (((qtyC / total).toFloat()) * 100).roundToInt()

        totalSale.text = resources.getString(R.string.total_sale, total.toInt())
        saleA.text = resources.getString(R.string.sale_of_a, saleOA)
        saleB.text = resources.getString(R.string.sale_of_b, saleOB)
        saleC.text = resources.getString(R.string.sale_of_c, saleOC)

    }
}