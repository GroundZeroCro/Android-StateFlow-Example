package com.ground.zero.searchflow.search.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.ground.zero.searchflow.search.domain.SearchRepository

class SearchViewModel(
    private val repository: SearchRepository
) : ViewModel() {
    // TODO dispatcher
    fun getRepositories(query: String) =
        repository.getSearchRepositories(query).asLiveData(viewModelScope.coroutineContext)
}