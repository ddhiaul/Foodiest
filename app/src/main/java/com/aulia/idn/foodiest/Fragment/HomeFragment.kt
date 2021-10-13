package com.aulia.idn.foodiest.Fragment


import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.aulia.idn.foodiest.*
import com.aulia.idn.foodiest.RecycleList.ListActivity
import com.bumptech.glide.Glide
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.fragment_home.*


/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : Fragment() {
//    private val foodList = ArrayList<Model>()
    private lateinit var popFoodAdapter : Adapter

    companion object {
        fun defaultFragment() : HomeFragment {
            val fragment = HomeFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    val imgcontentSlider = intArrayOf(
        R.drawable.food1,
        R.drawable.food2,
        R.drawable.food3,
        R.drawable.food4,
        R.drawable.food5
    )

    val imgContentListener : ImageListener = object : ImageListener{
        override fun setImageForPosition(position: Int, imageView: ImageView) {
            imageView.setImageResource(imgcontentSlider[position])
//            Glide.with(context!!).load(imgcontentSlider).placeholder(R.drawable.food2).into(imageView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val carouselView = is_main as CarouselView
        carouselView.setImageListener(imgContentListener)
        carouselView.setPageCount(imgcontentSlider.count())

//        rv_food.setHasFixedSize(true)
//        foodList.addAll(getListFood())
        showRecycleList()

        tv_see.setOnClickListener {
            val intent = Intent(context, ActivityPopAll::class.java)
            startActivity(intent)
        }

        tv_see_seafood.setOnClickListener {
            val intent = Intent(context, ListActivity::class.java)
            startActivity(intent)
        }
    }
    private fun getListFood(): ArrayList<Model> {
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

    private fun showRecycleList() {
        popFoodAdapter = Adapter { showSelected(it) }
        popFoodAdapter.notifyDataSetChanged()
        popFoodAdapter.setData(getListFood())
        rv_food.setHasFixedSize(true)
        rv_food.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//        val adapter = Adapter(foodList)
        rv_food.adapter = popFoodAdapter
    }

    private fun showSelected(it: Model) {
        val page = Intent(context, DetailPopActivity::class.java)
        page.putExtra(DetailPopActivity.KEY_POP_FOOD, it)
        startActivity(page)
    }



}