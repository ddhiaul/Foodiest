package com.aulia.idn.foodiest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_row.view.*

class Adapter(private val listener: (Model) -> Unit) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    private val listStaggered = ArrayList<Model>()

    fun setData(items: ArrayList<Model>) {
        listStaggered.clear()
        listStaggered.addAll(items)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(model: Model, listener: (Model) -> Unit) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(model.image)
                    .apply(RequestOptions().override(800))
                    .into(img_food)
                tv_name.setText(model.name)
                tv_address.setText(model.address)
                tv_kind.setText(model.kind)

                itemView.setOnClickListener { listener(model) }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listStaggered.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listStaggered[position], listener)
    }
}
//size() -> menuju koleksi data
//lenght() -> hanya menghitung data tanpa pencadangan (klo size ada cadangannya)
//count() -> menghitung ada yg ada isinya saja (cth. ada lemari yg pnya 5 slot dan yg ke isi cma 3, nah si count itu cma itung 3)
//capacity() -> jarang di pake :^
