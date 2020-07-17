package com.ground.zero.searchflow.search.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ground.zero.searchflow.databinding.ItemSearchRepositoryBinding
import com.ground.zero.searchflow.search.domain.SearchRepositoryDomain

class SearchAdapter : ListAdapter<SearchRepositoryDomain, SearchAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemSearchRepositoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: ItemSearchRepositoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(repository: SearchRepositoryDomain) {
            binding.repository = repository
        }
    }

    private object DiffCallback : DiffUtil.ItemCallback<SearchRepositoryDomain>() {
        override fun areItemsTheSame(
            oldItem: SearchRepositoryDomain,
            newItem: SearchRepositoryDomain
        ): Boolean = oldItem.name == newItem.name

        override fun areContentsTheSame(
            oldItem: SearchRepositoryDomain,
            newItem: SearchRepositoryDomain
        ): Boolean = oldItem == newItem
    }
}