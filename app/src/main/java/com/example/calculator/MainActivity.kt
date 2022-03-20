package com.example.calculator

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var firstValue: String = ""
    private var input: String = ""
    private var sign: String = ""
    private var answer: Double? = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        Log.d("lifeCycle", "onCreate")

        setListeners()
        signBtnClick()
        equalBtnClick()

//        if (savedInstanceState != null) {
//            sign = savedInstanceState.getString("sign") ?: ""
//            firstValue = savedInstanceState.getString("firstValue") ?: ""
//            input = savedInstanceState.getString("input") ?: ""
//            answer = savedInstanceState.getDouble("answer")
//            setInput()
//            setSign(sign)
//
//        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("lifeCycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("lifeCycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("lifeCycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("lifeCycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("lifeCycle", "onDestroy")
    }


//    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
//        super.onSaveInstanceState(outState, outPersistentState)
//        outState.putString("sign", sign)
//        outState.putString("firstValue", firstValue)
//        outState.putString("input", input)
//        outState.putDouble("answer", answer ?: 0.0)
//    }
//
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        savedInstanceState.getString("sign")
//        savedInstanceState.getString("firstValue")
//        savedInstanceState.getString("input")
//        savedInstanceState.getDouble("answer")
//    }

    private fun setListeners() {
        binding.btn0.setOnClickListener {
            input += "0"
            setInput()
        }
        binding.btn1.setOnClickListener {
            input += "1"
            setInput()
        }
        binding.btn2.setOnClickListener {
            input += "2"
            setInput()
        }
        binding.btn3.setOnClickListener {
            input += "3"
            setInput()
        }
        binding.btn4.setOnClickListener {
            input += "4"
            setInput()
        }
        binding.btn5.setOnClickListener {
            input += "5"
            setInput()
        }
        binding.btn6.setOnClickListener {
            input += "6"
            setInput()
        }
        binding.btn7.setOnClickListener {
            input += "7"
            setInput()
        }
        binding.btn8.setOnClickListener {
            input += "8"
            setInput()
        }
        binding.btn9.setOnClickListener {
            input += "9"
            setInput()
        }

        binding.btnClear.setOnClickListener {
            firstValue = ""
            input = ""
            sign = ""
            setSign("")
            setInput()
        }

        binding.btnBack.setOnClickListener {
            if (!input.isNullOrBlank()) {
                input = input.dropLast(1)
                setInput()
            }
        }

    }

    private fun signBtnClick() {
        binding.btnPlus.setOnClickListener {
            setSign("+")
        }
        binding.btnMinus.setOnClickListener {
            setSign("-")
        }
        binding.btnDivide.setOnClickListener {
            setSign("/")
        }
        binding.btnMultiply.setOnClickListener {
            setSign("*")
        }
    }

    private fun equalBtnClick() {
        binding.btnAnswer.setOnClickListener {
            if (!input.isNullOrBlank() && !firstValue.isNullOrBlank()) {
                when (sign) {
                    SignEnums.PLUS.id -> {
                        answer = firstValue.toDouble().plus(input.toDouble())
                    }
                    SignEnums.MINUS.id -> {
                        answer = firstValue.toDouble().minus(input.toDouble())
                    }
                    SignEnums.DIVIDE.id -> {
                        answer = firstValue.toDouble() / (input.toDouble())
                    }
                    SignEnums.MULTIPLY.id -> {
                        answer = firstValue.toDouble() * (input.toDouble())
                    }
                    else -> {

                    }
                }
                setAnswer()
            } else {
                if (firstValue.isNullOrBlank()) {
                    binding.tvAnswer.text = input
                }
            }
        }
    }

    private fun setInput() {
        binding.etInput.setText(input)
    }

    private fun setSign(sign: String) {
        firstValue = input
        input = ""
        this.sign = sign
        setInput()
        binding.tvSign.text = sign
    }

    private fun setAnswer() {
        binding.tvAnswer.text = answer.toString()
        firstValue = ""
        input = ""
        sign = ""
    }

}