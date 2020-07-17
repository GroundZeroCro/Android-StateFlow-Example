package com.ground.zero.searchflow.search.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.ground.zero.searchflow.R
import com.ground.zero.searchflow.search.domain.SearchResult
import org.koin.android.viewmodel.ext.android.viewModel

class SearchFragment : Fragment() {

    private val viewModel: SearchViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel.getRepositories("Android").observe(viewLifecycleOwner, Observer {
            when(it) {
                is SearchResult.SearchLoading-> println("Loading data")
                is SearchResult.SearchSuccess-> println(it.repositories)
                is SearchResult.SearchError-> println("Loading error")
            }
        })

        return inflater.inflate(R.layout.fragment_search, container, false)
    }
}