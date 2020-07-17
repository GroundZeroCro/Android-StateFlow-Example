package com.ground.zero.searchflow.search.domain

sealed class SearchResult{
    object SearchLoading: SearchResult()
    class SearchSuccess(val repositories: List<SearchDomain>): SearchResult()
    class SearchError: SearchResult()
}