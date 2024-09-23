package com.example.calculationtime

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var firstInputET: EditText
    private lateinit var secondInputET: EditText
    private lateinit var buttonSumBTN: Button
    private lateinit var buttonDifferenceBTN: Button
    private lateinit var resultTimeTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        firstInputET = findViewById(R.id.firstInputET)
        secondInputET = findViewById(R.id.secondInputET)
        buttonSumBTN = findViewById(R.id.buttonSumBTN)
        buttonDifferenceBTN = findViewById(R.id.buttonDifferenceBTN)
        resultTimeTV = findViewById(R.id.resultTimeTV)

        buttonSumBTN.setOnClickListener(this)
        buttonDifferenceBTN.setOnClickListener(this)


    }

    override fun onClick(v: View) {
        val firstStringTime = firstInputET.text.toString()
        val secondStringTime = secondInputET.text.toString()

        val (firstHours, firstMinutes, firstSeconds) = parseTime(firstStringTime)
        val (secondHours, secondMinutes, secondSeconds) = parseTime(secondStringTime)

        val firstTotalSeconds = firstHours * 3600 + firstMinutes * 60 + firstSeconds
        val secondTotalSeconds = secondHours * 3600 + secondMinutes * 60 + secondSeconds

        val totalCalculationTimes = when (v.id) {
            R.id.buttonSumBTN -> firstTotalSeconds + secondTotalSeconds
            R.id.buttonDifferenceBTN -> firstTotalSeconds - secondTotalSeconds
            else -> 0
        }

        if (totalCalculationTimes < 0) resultTimeTV.text =
            "Время не может быть отрицательным числом"
        else {
            val hoursTotalSumTimes = totalCalculationTimes / 3600
            val minutesTotalSumTimes = (totalCalculationTimes - hoursTotalSumTimes * 3600) / 60
            val secondsTotalSumTimes =
                totalCalculationTimes - hoursTotalSumTimes * 3600 - minutesTotalSumTimes * 60

            resultTimeTV.text =
                "${hoursTotalSumTimes}h${minutesTotalSumTimes}m${secondsTotalSumTimes}s"
        }
    }
}
