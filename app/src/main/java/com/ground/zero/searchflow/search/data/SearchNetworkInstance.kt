package com.ground.zero.searchflow.search.data

import com.ground.zero.searchflow.core.data.NetworkInstance

class SearchNetworkInstance(private val networkInstance: NetworkInstance) {
    val searchCalls: SearchCalls by lazy { networkInstance.getNetwork.create(SearchCalls::class.java) }
}