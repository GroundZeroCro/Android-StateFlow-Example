package com.ground.zero.searchflow.search.domain

import com.ground.zero.searchflow.search.data.SearchRepository

class SearchUseCase(
    private val searchRepository: SearchRepository,
    private val searchMapper: SearchMapper
) {

    suspend fun getRequestResponse(query: String): SearchResult {
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