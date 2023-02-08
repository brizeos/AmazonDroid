package fr.brizeos.amazon.di

import fr.brizeos.amazon.database.AppDatabase

val appComponent = listOf(
    databaseModule,
    viewModelsModule,
    networkModule
)