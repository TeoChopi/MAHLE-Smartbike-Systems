package com.mahle.smartbikesystems.core.di

import com.mahle.smartbikesystems.features.characters.data.repository.CharactersRepository
import com.mahle.smartbikesystems.features.characters.data.repository.GetCharactersRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {
    @Binds
    @ViewModelScoped
    fun providerProfileRepository(impl: GetCharactersRepositoryImpl): CharactersRepository
}
