package com.aulia.idn.foodiest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_row.view.*
import kotlinx.android.synthetic.main.item_straggered.view.*

class AllPopAdapter(private val listStaggered : ArrayList<Model>) : RecyclerView.Adapter<AllPopAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_straggered, parent, false)
        return ViewHolder(view )
    }

    override fun getItemCount(): Int = listStaggered.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listStaggered[position])
    }

    class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        fun bind(model: Model) {
            with(itemView){
//                Glide.with(itemView.context).load(model.image).apply(RequestOptions().override(7000)).into(iv_straggered_food)
                iv_straggered_food.setImageResource(model.image)
                tv_straggered_name_food.setText(model.name)
                tv_straggered_kind_food.setText(model.kind)
                tv_straggered_address_food.setText(model.address)
                tv_straggered_desc_food.setText(model.desc)
            }
        }

    }
}