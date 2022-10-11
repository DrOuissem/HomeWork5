package com.example.homework5

import android.content.DialogInterface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_exercise1.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class Exercise1 : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    val positiveButtonClick = { dialog: DialogInterface, which: Int ->
        Toast.makeText(applicationContext,
            android.R.string.yes, Toast.LENGTH_SHORT).show()
    }
    val negativeButtonClick = { dialog: DialogInterface, which: Int ->
        Toast.makeText(applicationContext,
            android.R.string.no, Toast.LENGTH_SHORT).show()
    }
    val neutralButtonClick = { dialog: DialogInterface, which: Int ->
        Toast.makeText(applicationContext,
            "Maybe", Toast.LENGTH_SHORT).show()
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise1)
        reset.setOnClickListener {
            radioGroup.clearCheck()
            checkBox.isChecked=false
            checkBox2.isChecked=false
            checkBox3.isChecked=false
        }
        submit.setOnClickListener {
            val current = LocalDateTime.now()

            val formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
            val formatted = current.format(formatter)
            var score=0.0;
            if(radioButton.isChecked==true )score++;
            if(checkBox.isChecked==true && !checkBox2.isChecked && !checkBox3.isChecked )
                score++;
            val builder = AlertDialog.Builder(this)

            with(builder)
            {
                setTitle("Submitted on : "+formatted)
                setMessage("You achieved: "+(score/2)*100+"%")
                setPositiveButton("OK", DialogInterface.OnClickListener(function = positiveButtonClick))
                //setNegativeButton(android.R.string.no, negativeButtonClick)
                //setNeutralButton("Maybe", neutralButtonClick)
                show()
            }


        }
    }
}