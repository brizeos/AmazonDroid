package fr.brizeos.amazon.ui.dashboard.main


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import fr.brizeos.amazon.R
import fr.brizeos.amazon.databinding.ArticleLineBinding
import fr.brizeos.amazon.model.Article

class ArticleAdapter(val listArticles: MutableList<Article>
//, val onItemClickListener: (article: Article) -> Unit
) :
    RecyclerView.Adapter<ArticleAdapter.ArticleVH>() {


    class ArticleVH(val binding: ArticleLineBinding) : ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleVH {
        val binding = ArticleLineBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ArticleVH(binding)
    }

    override fun getItemCount(): Int = listArticles.size


    override fun onBindViewHolder(holder: ArticleVH, position: Int) {
        val beer = listArticles[position]
        holder.binding.article = beer
//        holder.itemView.setOnClickListener { onItemClickListener.invoke(beer) }
    }

}