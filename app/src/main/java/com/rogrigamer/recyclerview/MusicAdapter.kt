package com.rogrigamer.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MusicAdapter: RecyclerView.Adapter<MusicViewHolder>() {

    private var list: List<Music> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_item, parent, false)
        return MusicViewHolder(view)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val music = list[position]
        holder.bind(music)
    }

    override fun getItemCount(): Int = list.size

    fun updateList(list: List<Music>) {
        this.list = list
        //notifica a adapter de q a lista foi mudada
        notifyDataSetChanged()
    }
}

class MusicViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(product: Music) {
        view.apply {
            findViewById<TextView>(R.id.textName).text = product.name
            findViewById<TextView>(R.id.textMusic).text = product.musica
        }
    }
}