package com.example.superheroapp.di

import com.example.superheroapp.data.SuperheroRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSuperheroRepository(): SuperheroRepository {
        return SuperheroRepository()
    }
}