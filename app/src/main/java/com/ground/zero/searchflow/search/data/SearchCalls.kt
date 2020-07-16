package com.ground.zero.searchflow.search.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchCalls {

    @GET("search/repositories")
    suspend fun searchRepositories(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("per_page") itemsPerPage: Int
    ): Response<SearchResponse>
}