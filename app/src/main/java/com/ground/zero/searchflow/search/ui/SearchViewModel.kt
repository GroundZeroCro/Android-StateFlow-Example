package com.ground.zero.searchflow.search.ui

import android.text.Editable
import androidx.lifecycle.ViewModel
import com.ground.zero.searchflow.search.domain.SearchRepository
import com.ground.zero.searchflow.search.domain.SearchResult
import com.ground.zero.searchflow.search.utils.toSearchQuery
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*

@FlowPreview
@ExperimentalCoroutinesApi
class SearchViewModel(
    private val repository: SearchRepository
) : ViewModel() {

    private val queryFlow = MutableStateFlow(INITIAL_QUERY)

    fun getRepositoryFlow() = queryFlow
        .debounce(500)
        .transform {
            emit(SearchResult.SearchLoading)
            emit(repository.getRequestResponse(it))
        }

    fun setQuery(editable: Editable?) {
        editable toSearchQuery { valid, query ->
            if (valid) queryFlow.value = query
        }
    }

    companion object {
        private const val INITIAL_QUERY = "Android"
    }
}