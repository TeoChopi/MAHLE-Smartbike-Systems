package com.mahle.smartbikesystems.features.characters.data.repository

import com.mahle.smartbikesystems.features.characters.data.model.ResponseCharacterDataModel
import com.mahle.smartbikesystems.features.characters.data.model.ResponseCharactersDataModel
import com.mahle.smartbikesystems.features.characters.data.source.CharactersRemoteDataSourceImpl
import javax.inject.Inject


class GetCharactersRepositoryImpl @Inject constructor(
    private val charactersRemoteDataSourceImpl: CharactersRemoteDataSourceImpl
) : CharactersRepository {
    override suspend fun getCharacters(): ResponseCharactersDataModel =
        charactersRemoteDataSourceImpl.getCharacters()

    override suspend fun getCharacter(id: String): ResponseCharacterDataModel =
        charactersRemoteDataSourceImpl.getCharacter(id)
}


