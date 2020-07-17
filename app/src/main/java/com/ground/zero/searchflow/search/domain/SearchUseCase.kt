package com.ground.zero.searchflow.search.domain

import com.ground.zero.searchflow.search.data.SearchRepository
import kotlinx.coroutines.flow.flow

class SearchUseCase(
    private val searchRepository: SearchRepository,
    private val searchMapper: SearchMapper
) {

    suspend fun getResponseFlow(query: String) = flow {
        emit(SearchResult.SearchLoading)
        emit(getRequestResponse(query))
    }

    private suspend fun getRequestResponse(query: String): SearchResult {
        with(searchRepository.getRemoteData(query)) {
            if (isSuccessful) {
                if (body() != null) {
                    val mapper = searchMapper.responseToDomain(body()!!)
                    return SearchResult.SearchSuccess(mapper)
                }
            }
        }
        return SearchResult.SearchError()
    }
}