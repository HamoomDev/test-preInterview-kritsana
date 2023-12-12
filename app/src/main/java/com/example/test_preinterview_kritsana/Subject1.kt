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
        /***
         * set bind data for activity
         */
        binding = ActivitySubject1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        /***
         * set on click button to begin function
         */
        binding.btnCal.setOnClickListener {
            calculate()
        }
    }

    @SuppressLint("StringFormatInvalid")
    private fun calculate() = with(binding) {
        /***
         * get number from EditText
         */
        val qtyA = edtA.text.toString().toDouble()
        val qtyB = edtB.text.toString().toDouble()
        val qtyC = edtC.text.toString().toDouble()

        /***
         * summery number
         */
        val total = qtyA + qtyB + qtyC

        /***
         * calculate by data from edittext / summery data to total sale in type
         * and X100 to percent last round data to Integer
         */
        val saleOA = (((qtyA / total).toFloat()) * 100).roundToInt()
        val saleOB = (((qtyB / total).toFloat()) * 100).roundToInt()
        val saleOC = (((qtyC / total).toFloat()) * 100).roundToInt()

        /***
         * print data to screen by add data to resource string from parameter
         */
        totalSale.text = resources.getString(R.string.total_sale, total.toInt())
        saleA.text = resources.getString(R.string.sale_of_a, saleOA)
        saleB.text = resources.getString(R.string.sale_of_b, saleOB)
        saleC.text = resources.getString(R.string.sale_of_c, saleOC)

    }
}