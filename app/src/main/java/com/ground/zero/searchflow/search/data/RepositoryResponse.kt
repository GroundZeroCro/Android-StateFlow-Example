package com.ground.zero.searchflow.search.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RepositoryResponse(
    val id: Long,
    val name: String? = null,
    @SerializedName("full_name")
    val fullName: String? = null,
    @SerializedName("html_url")
    val htmlUrl: String? = null,
    val description: String? = null,
    @SerializedName("fork")
    val isFork: Boolean? = null,
    val watchers: Long? = null,
    val forks: Long? = null,
    @SerializedName("open_issues")
    val issues: Long? = null,
    @SerializedName("created_at")
    val createdAt: String? = null,
    @SerializedName("updated_at")
    val updatedAt: String? = null,
    val language: String? = null
) : Serializable