package com.ground.zero.searchflow.search.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ground.zero.searchflow.databinding.ItemSearchRepositoryBinding
import com.ground.zero.searchflow.search.domain.SearchDomain

class SearchAdapter : ListAdapter<SearchDomain, SearchAdapter.ViewHolder>(DiffCallback) {

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
        fun bind(repository: SearchDomain) {
            binding.repository = repository
        }
    }

    private object DiffCallback : DiffUtil.ItemCallback<SearchDomain>() {
        override fun areItemsTheSame(
            oldItem: SearchDomain,
            newItem: SearchDomain
        ): Boolean = oldItem.name == newItem.name

        override fun areContentsTheSame(
            oldItem: SearchDomain,
            newItem: SearchDomain
        ): Boolean = oldItem == newItem
    }
}