package com.ground.zero.searchflow.search.di

import com.ground.zero.searchflow.search.data.SearchNetworkInstance
import com.ground.zero.searchflow.search.domain.SearchMapper
import com.ground.zero.searchflow.search.domain.SearchRepository
import com.ground.zero.searchflow.search.ui.SearchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val searchModule = module {
    single { SearchNetworkInstance(get()) }
    factory { SearchMapper() }
    factory { SearchRepository(get(), get()) }
    viewModel { SearchViewModel(get()) }
}