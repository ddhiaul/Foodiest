package com.aulia.idn.foodiest.RecycleList

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.aulia.idn.foodiest.Model
import com.aulia.idn.foodiest.R
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {
    private val listFood = ArrayList<Model>()
//    private lateinit var listAdapter : ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        supportActionBar?.hide()

        rv_list_best.setHasFixedSize(true)
        listFood.addAll(getListFood())

        showRecyclerList()
    }

    private fun getListFood(): Collection<Model> {
        val name = resources.getStringArray(R.array.name)
        val address = resources.getStringArray(R.array.address)
        val kind = resources.getStringArray(R.array.kind)
        val desc = resources.getStringArray(R.array.desc)
        val price = resources.getStringArray(R.array.price)
        val image = resources.obtainTypedArray(R.array.image)

        val listFood = ArrayList<Model>()

        for (position in name.indices){
            val food = Model(
                name[position],
                address[position],
                kind[position],
                desc[position],
                price[position],
                image.getResourceId(position, -1)
            )
            listFood.add(food)
        }
        return listFood
    }

    private fun showRecyclerList() {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_list_best.layoutManager = layoutManager
        rv_list_best.adapter = ListAdapter(listFood)
    }


}
