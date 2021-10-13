package com.aulia.idn.foodiest.RecycleList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aulia.idn.foodiest.Model
import com.aulia.idn.foodiest.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_list.view.*

class ListAdapter(private val listBest : ArrayList<Model>) : RecyclerView.Adapter<ListAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listBest.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listBest[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(model: Model) {
            with(itemView) {
                Glide.with(itemView.context).load(model.image).apply(RequestOptions().override(1000)).into(iv_list)
//                iv_list.setImageResource(model.image)
                tv_list_name.setText(model.name)
                tv_list_address.setText(model.address)
            }
        }

    }
}