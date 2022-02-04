package com.example.tes31

import android.icu.text.DecimalFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Button
import com.example.tes31.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var w = ""
    var n1 = ""
    var n2 = true
    var check = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        b17.setOnClickListener {
            if (n2)
                textView.text = formatDecimal("${textView.text}0")
            else {
                textView.text = "0"
                n2 = true
            }
        }
        b13.setOnClickListener {
            if (n2)
                textView.text = formatDecimal("${textView.text}1")
            else {
                textView.text = "1"
                n2 = true
            }
        }
        b14.setOnClickListener {
            if (n2)
                textView.text = formatDecimal("${textView.text}2")
            else {
                textView.text = "2"
                n2 = true
            }
        }
       b15.setOnClickListener {
            if (n2)
                textView.text = formatDecimal("${textView.text}3")
            else {
                textView.text = "3"
                n2 = true
            }
        }
        b9.setOnClickListener {
            if (n2)
                textView.text = formatDecimal("${textView.text}4")
            else {
                textView.text = "4"
                n2 = true
            }
        }
        b10.setOnClickListener {
            if (n2)
                textView.text = formatDecimal("${textView.text}5")
            else {
                textView.text = "5"
                n2 = true
            }
        }
        b11.setOnClickListener {
            if (n2)
                textView.text = formatDecimal("${textView.text}6")
            else {
                textView.text = "6"
                n2 = true
            }
        }
        b5.setOnClickListener {
            if (n2)
                textView.text = formatDecimal("${textView.text}7")
            else {
                textView.text = "7"
                n2 = true
            }
        }
        b6.setOnClickListener {
            if (n2)
                textView.text = formatDecimal("${textView.text}8")
            else {
                textView.text = "8"
                n2 = true
            }
        }
        b7.setOnClickListener {
            if (n2)
                textView.text = formatDecimal("${textView.text}9")
            else {
                textView.text = "9"
                n2 = true
            }
        }
        b16.setOnClickListener {
            w = "+"
            if (w != "" && n1 == "") {
                n1 = textView.text.toString()
            }
            if (check) {
                compute()
                n1 = textView.text.toString()
            }
            check = true
            n2 = false
        }
        b12.setOnClickListener {
            w = "-"
            if (w != "" && n1 == "") {
                n1 = textView.text.toString()
            }
            if (check) {
                compute()
                n1 = textView.text.toString()
            }
            check = true
            n2 = false
        }
        b8.setOnClickListener {
            w = "*"
            if (w != "" && n1 == "") {
                n1 = textView.text.toString()
            }
            if (check) {
                compute()
                n1 = textView.text.toString()
            }
            check = true
            n2 = false
        }
        b4.setOnClickListener {
            w = "/"
            if (w != "" && n1 == "") {
                n1 = textView.text.toString()
            }
            if (check) {
                compute()
                n1 = textView.text.toString()
            }
            check = true
            n2 = false
        }
        b3.setOnClickListener {
            w = "%"
            if (w != "" && n1 == "") {
                n1 = textView.text.toString()
            }
            if (check) {
                compute()
                n1 = textView.text.toString()
            }
            check = true
            n2 = false
        }
        b19.setOnClickListener{
            compute ()
            w = ""
            n1 = ""
            check = false
        }
        b2.setOnClickListener {
            textView.text = textView.text.toString().dropLast(1).ifEmpty { "0" }
        }
        b18.setOnClickListener {
            if (!textView.text.toString().contains(".")&& textView.text.toString().isNotEmpty()) {
                textView.text = "${textView.text}."
            }
        }
        b1.setOnClickListener {
            w = ""
            n1 = ""
            n2 = true
            textView.text = "0"
            check = false
        }
    }
    private fun compute () {
        val number1 = textView.text.toString()
        if (w != "" && number1 != "") {
            if (w == "+") {
                println(n1 + number1)
                textView.text =
                    formatDecimal((n1.toDouble() + number1.toDouble()).toString())
            } else if (w == "-") {
                textView.text =
                    formatDecimal((n1.toDouble() - number1.toDouble()).toString())
            } else if (w == "*") {
                textView.text =
                    formatDecimal((n1.toDouble() * number1.toDouble()).toString())
            } else if (w == "/") {
                if (number1 == "0" || number1 == "") {
                    textView.text = "ERROR"
                    return@compute
                }
                textView.text =
                    formatDecimal((n1.toDouble() / number1.toDouble()).toString())
            } else if (w == "%") {
                if (number1 == "0" || number1 == "") {
                    textView.text = "ERROR"
                    return@compute
                }
                textView.text =
                    formatDecimal((n1.toDouble() % number1.toDouble()).toString())
            }
        }
    }
    private fun formatDecimal(num: String): String {
        val format = DecimalFormat("0.#######");
        return format.format(num.ifEmpty { "0" }.toDouble())
    }
}