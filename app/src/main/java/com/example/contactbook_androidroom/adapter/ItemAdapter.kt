package com.example.contactbook_androidroom.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.contactbook_androidroom.R
import com.example.contactbook_androidroom.view.models.Person


class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private val items = mutableListOf<Person>()

    fun add(collection: List<Person>) {
        items.clear()
        items.addAll(collection)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.card_layout,
                parent,
                false
            )
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemName: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemName = itemView.findViewById(R.id.item_title)
        }

        fun bind(person: Person) {
            itemName.text = person.name

            itemView.setOnClickListener {
                // todo("Ir al detalle del contacto")
                Toast.makeText(itemView.context, "Detalle del contacto", Toast.LENGTH_LONG).show()
            }

            itemImage.setOnClickListener {
                Toast.makeText(itemView.context, "LLamar al contacto", Toast.LENGTH_LONG).show()
                // todo("iniciar llamada")
            }
        }

    }

}