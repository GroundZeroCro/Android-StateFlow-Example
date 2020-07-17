package com.ground.zero.searchflow.search.domain

import com.ground.zero.searchflow.search.data.SearchResponse

class SearchMapper {

    fun responseToDomain(searchResponse: SearchResponse): List<SearchDomain> =
        searchResponse.repositories.map {
            SearchDomain(it.name, it.fullName, it.description)
        }
}