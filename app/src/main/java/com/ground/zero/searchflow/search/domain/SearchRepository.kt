package com.ground.zero.searchflow.search.domain

import com.ground.zero.searchflow.search.data.SearchNetworkInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.launch

class SearchRepository(
    private val searchNetworkInstance: SearchNetworkInstance,
    private val searchMapper: SearchMapper
) {

    suspend fun getRequestResponse(query: String): SearchResult {
        val request = searchNetworkInstance.searchCalls.searchRepositories(
            query = query,
            page = PAGE,
            itemsPerPage = PER_PAGE
        )

        with(request) {
            if (isSuccessful) {
                if (body() != null) {
                    val mapper = searchMapper.responseToDomain(body()!!)
                    return SearchResult.SearchSuccess(mapper)
                }
            }
        }
        return SearchResult.SearchError()
    }

    companion object {
        private const val PER_PAGE = 100
        private const val PAGE = 0
    }
}