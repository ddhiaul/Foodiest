package com.aulia.idn.foodiest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aulia.idn.foodiest.Fragment.HomeFragment
import com.aulia.idn.foodiest.RecycleList.ListActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail_pop.*

class DetailPopActivity : AppCompatActivity() {
    companion object{
        const val KEY_POP_FOOD = "key_pop_food"
    }

    private var model : Model? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_pop)

        iv_back_to_home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        model = intent.getParcelableExtra(KEY_POP_FOOD)

        supportActionBar?.hide()

        tv_detail_title_food.setText(model?.name)
        tv_detail_name_food.setText(model?.name)
        tv_detail_kind_food.setText(model?.kind)
        tv_detail_address_food.setText(model?.address)
        tv_detail_desc_food.setText(model?.desc)
        tv_price.setText(model?.price)
        iv_detail_food.setImageResource(model?.image!!)
//        Glide.with(this).load(model?.image).apply(RequestOptions().override(500)).into(iv_detail_food)
    }
}
