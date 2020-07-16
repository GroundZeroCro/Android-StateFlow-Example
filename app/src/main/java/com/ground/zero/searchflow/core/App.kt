package com.ground.zero.searchflow.core

import android.app.Application
import com.ground.zero.searchflow.core.di.coreModule
import com.ground.zero.searchflow.search.di.searchModule
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(coreModule, searchModule)
        }
    }
}