package com.ground.zero.searchflow.search.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.ground.zero.searchflow.databinding.FragmentSearchBinding
import com.ground.zero.searchflow.search.domain.SearchResult
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.collect
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

@FlowPreview
@ExperimentalCoroutinesApi
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
        observeSearchInput()
    }

    private fun instantiateRecyclerView() {
        binding.searchRecyclerView.adapter = adapter
    }

    private fun observeSearchedRepositories() {
        lifecycleScope.launchWhenStarted {
            viewModel.getRepositoryFlow().collect {
                when (it) {
                    is SearchResult.SearchLoading -> showProgress(true)
                    is SearchResult.SearchSuccess -> {
                        adapter.submitList(it.repositories)
                        showProgress(false)
                    }
                    is SearchResult.SearchError -> showProgress(true)
                }
            }
        }
    }

    private fun showProgress(show: Boolean) = apply { binding.progressVisibility = show }

    private fun observeSearchInput() {
        binding.searchInput.addTextChangedListener {
            viewModel.setQuery(it)
        }
    }
}