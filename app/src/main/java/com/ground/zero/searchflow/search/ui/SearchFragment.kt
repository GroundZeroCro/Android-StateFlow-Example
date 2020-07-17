package com.ground.zero.searchflow.search.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.ground.zero.searchflow.databinding.FragmentSearchBinding
import com.ground.zero.searchflow.search.domain.SearchResult
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private val viewModel: SearchViewModel by viewModel()
    private val adapter: SearchAdapter by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentSearchBinding.inflate(inflater, container, false).also {
        binding = it
    }.root.also {
        instantiateRecyclerView()
        observeSearchedRepositories()
    }

    private fun instantiateRecyclerView() {
        binding.searchRecyclerView.adapter = adapter
    }

    private fun observeSearchedRepositories() {
        viewModel.getRepositories("Android").observe(viewLifecycleOwner, Observer {
            when (it) {
                is SearchResult.SearchLoading -> println("Loading data")
                is SearchResult.SearchSuccess -> adapter.submitList(it.repositories)
                is SearchResult.SearchError -> println("Loading error")
            }
        })
    }
}