package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    var txt = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttons = listOf(
            Pair(one, "1"),
            Pair(two, "2"),
            Pair(three, "3"),
            Pair(four, "4"),
            Pair(five, "5"),
            Pair(six, "6"),
            Pair(seven, "7"),
            Pair(height, "8"),
            Pair(nine, "9"),
            Pair(dot, "."),
            Pair(plus , "+"),
            Pair(less, "-"),
            Pair(divide, "/"),
            Pair(multiply, "*")
        )
        del.setOnClickListener{
            if(txt.length > 0){
                txt = txt.removeRange(txt.length-1,txt.length)
                calcTxt.text = txt
            } else {
                txt = ""
                calcTxt.text = "_"
            }
        }
        equal.setOnClickListener{
            var builder = ExpressionBuilder(txt)
            var res = builder.build().evaluate()
            resultView.text = res.toString()
        }
        buttons.forEach{button ->
            button.first.setOnClickListener{
                txt = txt.plus(button.second)
                calcTxt.text = txt
            }
        }
    }
}
