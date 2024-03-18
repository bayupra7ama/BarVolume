package com.example.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edtWidth :EditText
    private lateinit var edtHeight :EditText
    private lateinit var edtLenght :EditText

    private lateinit var btnCalculate: Button
    private lateinit var tvResult :TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtWidth = findViewById(R.id.et_width)
        edtHeight = findViewById(R.id.et_height)
        edtLenght = findViewById(R.id.et_lenght)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener(this)

        if (savedInstanceState  != null){
            val result = savedInstanceState.getString(STATE_RESULT)
            tvResult.text = result
        }
    }

    override fun onClick(View: View) {
       if (View.id == R.id.btn_calculate){
           //trim digunakan untuk mengabaikan jika ada sepasi
           val inputLength = edtLenght.text.toString().trim()
           val inputWidth = edtWidth.text.toString().trim()
           val inputHeight =edtHeight.text.toString().trim()

           var isEmptiField = false

           if (inputLength.isEmpty()){
               isEmptiField = true
               //pesan erorr gika colom kosong
               edtLenght.error = "kolom ini tidak boleh kosong"
           }
           if(inputHeight.isEmpty()){
               isEmptiField = true
               edtHeight.error = "kolom ini tidak boleh kosong"

           }
           if (inputWidth.isEmpty()){
               isEmptiField = true
               edtWidth.error = "kolom ini tidak boleh kosong"
           }
           if(!isEmptiField){
               val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
               tvResult.text = volume.toString()
           }


       }
    }
    companion object{
        val STATE_RESULT = "state_result"
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT , tvResult.text.toString())
    }
}