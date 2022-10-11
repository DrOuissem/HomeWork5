package com.example.homework5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_exercise2.*

class Exercise2 : AppCompatActivity() {

    var list:ArrayList<Food>?=arrayListOf<Food>();
    fun initListFood(){
        var s1 = resources.getStringArray(R.array.foodName);
        var  s2 = resources.getStringArray(R.array.foodRecipe);

        var images = intArrayOf(
            R.drawable.coffee_pot,
            R.drawable.espresso,
            R.drawable.french_fries,
            R.drawable.honey,
            R.drawable.strawberry_ice_cream,
            R.drawable.sugar_cubes
        )

        for (i in 0 until images.size){
            list?.add(Food(s1[i],s2[i],images[i]))
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise2)
        initListFood()
        recv.layoutManager = GridLayoutManager(this,2)
        // Create an object for the MyAdapter
        val adapter = MyAdapter(this,list!!)
        // Set adapter to your RecyclerView
        recv.adapter = adapter
    }
}