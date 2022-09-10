package com.kotmaster.di

import com.kotmaster.data.sources.MessagesDataSource
import com.kotmaster.data.sources.MessagesDataSourceImpl
import org.koin.dsl.bind
import org.koin.dsl.module

val dataSourcesModule = module {
    single {
        MessagesDataSourceImpl(get())
    } bind MessagesDataSource::class
}