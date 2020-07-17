package com.ground.zero.searchflow.search.data

class SearchRepository(
    private val searchNetworkInstance: SearchNetworkInstance
) {
    suspend fun getRemoteData(query: String) = searchNetworkInstance.searchCalls.searchRepositories(
        query = query,
        page = PAGE,
        itemsPerPage = PER_PAGE
    )

    companion object {
        private const val PER_PAGE = 100
        private const val PAGE = 0
    }
}