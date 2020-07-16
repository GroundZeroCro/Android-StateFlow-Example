package com.ground.zero.searchflow.search.data

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("total_count")
    val totalCount: Int = 0,
    @SerializedName("items")
    val repositories: List<RepositoryResponse> = emptyList(),
    val nextPage: Int? = null
)