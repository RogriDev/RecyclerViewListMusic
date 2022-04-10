package com.rogrigamer.recyclerview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rogrigamer.recyclerview.databinding.ActivityItemBinding

class MusicAdapter : RecyclerView.Adapter<MusicViewHolder>() {

    // variavel para armazenar a nossa lista de musicas
    private var list: List<Music> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        return MusicViewHolder(
            ActivityItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val music = list[position]
        holder.bind(music)
    }

    //vai dizer quantos itens o recycler view vai mostrar
    override fun getItemCount(): Int = list.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<Music>) {
        this.list = list
        //notifica a adapter de q a lista foi mudada
        notifyDataSetChanged()
    }
}

//representação do layout.xml, ele é um holder do layout dentro do adapter
class MusicViewHolder(private val binding: ActivityItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    //ele pega as informações da model q será passada para ele e coloca no layout do item do recycler view
    fun bind(product: Music) {
        binding.apply {
            textName.text = product.name
            textMusic.text = product.musica
        }          //posso usar o kotlin sintetics para referenciar o componente do meu layout
                   // ou o view binding

        val requestOptions = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)

        Glide.with(itemView.context)
            .applyDefaultRequestOptions(requestOptions)
            .load(product.urlImage)
            .into(binding.album)
    }
}