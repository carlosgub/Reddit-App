package com.carlosgub.redditapp.features.top.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.carlosgub.redditapp.R
import com.carlosgub.redditapp.databinding.ViewTopPostBinding
import com.carlosgub.redditapp.features.top.presentation.model.PostModel
import com.squareup.picasso.Picasso

class TopPostAdapter : RecyclerView.Adapter<TopPostAdapter.ViewHolder>() {

    private val list: MutableList<PostModel> = mutableListOf()
    private var listener: Listener? = null

    inner class ViewHolder(val binding: ViewTopPostBinding) : RecyclerView.ViewHolder(binding.root)

    companion object {
        private const val NO_IMAGE = "default"
        private const val NSFW = "nsfw"
    }

    fun add(post: PostModel) {
        list.add(post)
        notifyItemInserted(this.itemCount)
    }

    fun clear() {
        list.clear()
        notifyDataSetChanged()
    }

    fun setListener(listener: Listener) {
        this.listener = listener
    }

    interface Listener {
        fun onPostClicked(url: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewTopPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = list[position]
        setAuthorAndTimestamp(holder, post)
        setTitle(holder, post)
        setImage(post, holder)
        setNumberOfComments(holder, post)
        holder.itemView.setOnClickListener {
            listener?.onPostClicked(post.url)
        }
    }

    private fun setAuthorAndTimestamp(
        holder: ViewHolder,
        post: PostModel
    ) {
        holder.binding.tvAuthor.text = String.format(
            holder.itemView.resources.getString(R.string.top_post_author),
            post.author,
            post.time,
            holder.itemView.resources.getString(post.timeUnit)
        )
    }

    private fun setTitle(
        holder: ViewHolder,
        post: PostModel
    ) {
        holder.binding.tvTitle.text = post.title
    }

    private fun setImage(
        post: PostModel,
        holder: ViewHolder
    ) {
        if (post.thumbnail == NO_IMAGE || post.thumbnail == NSFW) {
            holder.binding.ivThumbnail.isVisible = false
        } else {
            holder.binding.ivThumbnail.isVisible = true
            Picasso.get().load(post.thumbnail).into(holder.binding.ivThumbnail)
        }
    }

    private fun setNumberOfComments(
        holder: ViewHolder,
        post: PostModel
    ) {
        holder.binding.tvNumberOfComments.text = String.format(
            holder.itemView.resources.getString(R.string.number_of_comments),
            post.numberOfComments
        )
    }
}