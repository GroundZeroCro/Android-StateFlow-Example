package com.ground.zero.searchflow.search.di

import com.ground.zero.searchflow.search.data.SearchNetworkInstance
import com.ground.zero.searchflow.search.data.SearchRepository
import com.ground.zero.searchflow.search.domain.SearchMapper
import com.ground.zero.searchflow.search.domain.SearchUseCase
import com.ground.zero.searchflow.search.ui.SearchAdapter
import com.ground.zero.searchflow.search.ui.SearchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val searchModule = module {
    single { SearchNetworkInstance(get()) }
    factory { SearchMapper() }
    factory { SearchRepository(get()) }
    factory { SearchUseCase(get(), get()) }
    factory { SearchAdapter() }
    viewModel { SearchViewModel(get()) }
}