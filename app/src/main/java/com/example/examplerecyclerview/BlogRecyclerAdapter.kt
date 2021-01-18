package com.example.examplerecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.examplerecyclerview.models.BlogPost
import kotlinx.android.synthetic.main.layout_blog_list_item.view.*

class  BlogRecyclerAdapter : RecyclerView.Adapter<BlogRecyclerAdapter.BlogViewHolder>(){

    private var items : List<BlogPost> = ArrayList()

    fun submitList(blogList : List<BlogPost>){
        items = blogList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        return BlogViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_blog_list_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        holder.bind(items[position])
    }


    // ViewHolder START
    class BlogViewHolder constructor(itemView : View) : RecyclerView.ViewHolder(itemView){
        private val blogImage: ImageView = itemView.blog_image
        private val blogTitle : TextView = itemView.blog_title
        private val blogAuthor : TextView = itemView.blog_author

        fun bind(blogPost: BlogPost){
            blogTitle.text = blogPost.title
            blogAuthor.text = blogPost.userName

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(blogPost.image)
                .into(blogImage)

        }

    }
    //ViewHolder END

}