package com.mahle.smartbikesystems.features.characters.domain.presentation


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.mahle.smartbikesystems.R
import com.mahle.smartbikesystems.databinding.ItemCharactersBinding
import com.mahle.smartbikesystems.features.characters.domain.model.CharacterDomainModel

class CharactersAdapter(
    private var items: List<CharacterDomainModel>,
    private val onClick: (Int) -> Unit,) :
    RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<CharacterDomainModel>) {
        this.items = data
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], onClick)
    }

    class ViewHolder(itemView: ViewGroup) : RecyclerView.ViewHolder(
        ItemCharactersBinding.inflate(
            LayoutInflater.from(itemView.context),
            itemView,
            false
        ).root
    ) {
        fun bind(
            item: CharacterDomainModel,
            onClick: (Int) -> Unit
        ) = with(ItemCharactersBinding.bind(itemView)) {
            txtName.text = item.name
            val url = item.thumbnailPath.plus(".").plus(item.thumbnailExtension)
            Glide.with(itemView.context).load(url)
                .circleCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(image)
            lyView.setOnClickListener { item.id?.let { it1 -> onClick(it1) } }
        }
    }
}