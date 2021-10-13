package com.aulia.idn.foodiest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.aulia.idn.foodiest.Fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_pop_all.*

class ActivityPopAll : AppCompatActivity() {
    private val listFood = ArrayList<Model>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pop_all)
        rv_all_popular.setHasFixedSize(true)
        listFood.addAll(getListFood())
        showRecyclerGrid()

        supportActionBar?.hide()

        iv_all_back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
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

    private fun showRecyclerGrid() {
        val layoutManagerStaggered = StaggeredGridLayoutManager(2, GridLayoutManager. VERTICAL)
        rv_all_popular.layoutManager = layoutManagerStaggered
        rv_all_popular.adapter = AllPopAdapter(listFood)
    }

}
