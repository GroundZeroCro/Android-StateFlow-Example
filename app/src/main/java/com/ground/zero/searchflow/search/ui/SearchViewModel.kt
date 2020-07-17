package com.ground.zero.searchflow.search.ui

import android.text.Editable
import androidx.lifecycle.*
import com.ground.zero.searchflow.search.domain.SearchRepository
import com.ground.zero.searchflow.search.utils.toSearchQuery

class SearchViewModel(
    private val repository: SearchRepository
) : ViewModel() {

    private val queryLive = MutableLiveData<String>(INITIAL_QUERY)

    fun setQuery(editable: Editable?) {
        editable toSearchQuery { valid, query ->
            if (valid) queryLive.postValue(query)
        }
    }

    fun getRepositories() = Transformations.switchMap(queryLive) {
        repository.getSearchRepositories(it)
            .asLiveData(viewModelScope.coroutineContext)
    }

    companion object {
        private const val INITIAL_QUERY = "Android"
    }
}