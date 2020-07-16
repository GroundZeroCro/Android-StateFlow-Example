package com.ground.zero.searchflow.search.domain

import com.ground.zero.searchflow.search.data.SearchNetworkInstance
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchRepository(
    private val searchNetworkInstance: SearchNetworkInstance,
    private val searchMapper: SearchMapper
) {

    fun getSearchRepositories(
        query: String
    ): Flow<SearchResult> = flow {

        emit(SearchResult.SearchLoading)

        val request = searchNetworkInstance.searchCalls.searchRepositories(
            query = query,
            page = PAGE,
            itemsPerPage = PER_PAGE
        )

        with(request) {
            if (isSuccessful) {
                if (body() != null) {
                    val mapper = searchMapper.responseToDomain(body()!!)
                    emit(SearchResult.SearchSuccess(mapper))
                }
            } else {
                emit(SearchResult.SearchError())
            }
        }
    }

    companion object {
        private const val PER_PAGE = 100
        private const val PAGE = 0
    }
}