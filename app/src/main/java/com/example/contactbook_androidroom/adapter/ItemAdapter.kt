package com.example.contactbook_androidroom.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contactbook_androidroom.R


class ItemAdapter() : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

    val names = arrayOf("A",
    "B",
    "C",
    "D",
    "E")
    val numbers = arrayOf("01",
    "02",
    "03",
    "04",
    "05")
    val images = intArrayOf(
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_layout,parent,false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.itemImage.setImageResource(images[position])
        holder.itemName.text = names[position]
        holder.itemNumber.text = numbers[position]
    }

    override fun getItemCount(): Int {
        return names.size
    }

    inner class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemName: TextView
        var itemNumber: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemName = itemView.findViewById(R.id.item_title)
            itemNumber = itemView.findViewById(R.id.item_detail)
        }

    }

}