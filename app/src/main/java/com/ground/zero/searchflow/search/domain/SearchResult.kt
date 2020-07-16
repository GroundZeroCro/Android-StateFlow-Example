package com.ground.zero.searchflow.search.domain

sealed class SearchResult{
    object SearchLoading: SearchResult()
    class SearchSuccess(val repositories: List<SearchRepositoryDomain>): SearchResult()
    class SearchError: SearchResult()
}