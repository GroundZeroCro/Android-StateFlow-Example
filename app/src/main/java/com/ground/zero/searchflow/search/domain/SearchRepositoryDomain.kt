package com.ground.zero.searchflow.search.domain

import com.google.gson.annotations.SerializedName

data class SearchRepositoryDomain(
    val name: String? = null,
    val fullName: String? = null,
    val description: String? = null
)