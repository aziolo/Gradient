package pl.daftcode.gradient

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.animation.ArgbEvaluatorCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {



    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val upButton = findViewById<FloatingActionButton>(R.id.floatingActionButtonUp)
        val downButton = findViewById<FloatingActionButton>(R.id.floatingActionButtonDown)
        val tw1 = findViewById<TextView>(R.id.TextView1)
        val tw2 = findViewById<TextView>(R.id.textView2)
        val tw3 = findViewById<TextView>(R.id.textView3)
        val tw4 = findViewById<TextView>(R.id.textView4)
        val tw5 = findViewById<TextView>(R.id.textView5)
        val tw6 = findViewById<TextView>(R.id.textView6)
        val tw7 = findViewById<TextView>(R.id.textView7)
        val tw8 = findViewById<TextView>(R.id.textView8)

        val step = 1.0/7.0
        val colorBlue4 = ContextCompat.getColor(this,R.color.daftBlue)
        val colorGreen4 = ContextCompat.getColor(this,R.color.daftGreen)
        val middleGreen3 = ArgbEvaluatorCompat.getInstance().evaluate(step.toFloat(), colorGreen4, colorBlue4)
        val middleGreen2 = ArgbEvaluatorCompat.getInstance().evaluate((2.0/7).toFloat(), colorGreen4, colorBlue4)
        val middleGreen1 = ArgbEvaluatorCompat.getInstance().evaluate((3.0/7).toFloat(), colorGreen4, colorBlue4)

        val middleBlue1 = ArgbEvaluatorCompat.getInstance().evaluate((4.0/7).toFloat(), colorGreen4, colorBlue4)
        val middleBlue2 = ArgbEvaluatorCompat.getInstance().evaluate((5.0/7).toFloat(), colorGreen4, colorBlue4)
        val middleBlue3 = ArgbEvaluatorCompat.getInstance().evaluate((6.0/7).toFloat(), colorGreen4, colorBlue4)


        val textBlue3 = toHexString(middleBlue3)
        val textBlue2 = toHexString(middleBlue2)
        val textBlue1 = toHexString(middleBlue1)
        val textBlue = toHexString(colorBlue4)

        val textGreen3 = toHexString(middleGreen3)
        val textGreen2 = toHexString(middleGreen2)
        val textGreen1 = toHexString(middleGreen1)
        val textGreen = toHexString(colorGreen4)

        val green4 = State(colorGreen4, textGreen)
        val green3 = State(middleGreen3, textGreen3)
        val green2 = State(middleGreen2, textGreen2)
        val green1 = State(middleGreen1, textGreen1)

        val blue1 = State(middleBlue1, textBlue1)
        val blue2 = State(middleBlue2, textBlue2)
        val blue3 = State(middleBlue3, textBlue3)
        val blue4 = State(colorBlue4, textBlue)

        val list = ArrayList<State>()

        list.add(green4)
        list.add(green3)
        list.add(green2)
        list.add(green1)
        list.add(blue1)
        list.add(blue2)
        list.add(blue3)
        list.add(blue4)
        list.add(blue3)
        list.add(blue2)
        list.add(blue1)
        list.add(green1)
        list.add(green2)
        list.add(green3)
        list.add(green4)
        list.add(green3)
        list.add(green2)
        list.add(green1)
        list.add(blue1)
        list.add(blue2)
        list.add(blue3)
        list.add(blue4)
        list.add(blue3)
        list.add(blue2)
        list.add(blue1)

        var position = 0
        setValues(tw1, list, position, tw2, tw3, tw4, tw5, tw6, tw7, tw8)


        upButton.setOnClickListener {
            position++
            if(8+ position > list.size) position = 4
            setValues(tw1, list, position, tw2, tw3, tw4, tw5, tw6, tw7, tw8)
            println(position.toString())
        }

        downButton.setOnClickListener {
            position--
            if(8+  position > list.size || position < 0) position = 13
            setValues(tw1, list, position, tw2, tw3, tw4, tw5, tw6, tw7, tw8)
            println(position.toString())
        }


    }

    private fun setValues(
        tw1: TextView,
        list: ArrayList<State>,
        position: Int,
        tw2: TextView,
        tw3: TextView,
        tw4: TextView,
        tw5: TextView,
        tw6: TextView,
        tw7: TextView,
        tw8: TextView
    ) {
        tw1.text = list[position].name
        tw2.text = list[1 + position].name
        tw3.text = list[2 + position].name
        tw4.text = list[3 + position].name
        tw5.text = list[4 + position].name
        tw6.text = list[5 + position].name
        tw7.text = list[6 + position].name
        tw8.text = list[7 + position].name

        tw1.setBackgroundColor(list[position].color)
        tw2.setBackgroundColor(list[1 + position].color)
        tw3.setBackgroundColor(list[2 + position].color)
        tw4.setBackgroundColor(list[3 + position].color)
        tw5.setBackgroundColor(list[4 + position].color)
        tw6.setBackgroundColor(list[5 + position].color)
        tw7.setBackgroundColor(list[6 + position].color)
        tw8.setBackgroundColor(list[7 + position].color)
    }


    private class State(val color: Int, val name: String)

}
