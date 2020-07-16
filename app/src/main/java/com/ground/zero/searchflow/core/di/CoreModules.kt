package com.ground.zero.searchflow.core.di

import com.ground.zero.searchflow.core.data.NetworkInstance
import org.koin.dsl.module

val coreModule = module {
    single { NetworkInstance() }
}