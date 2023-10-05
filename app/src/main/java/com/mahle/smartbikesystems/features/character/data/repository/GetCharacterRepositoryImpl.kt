package com.mahle.smartbikesystems.features.character.data.repository

import com.mahle.smartbikesystems.features.character.data.model.ResponseCharacterDataModel
import com.mahle.smartbikesystems.features.character.data.source.CharacterRemoteDataSourceImpl
import javax.inject.Inject


class GetCharacterRepositoryImpl @Inject constructor(
    private val characterRemoteDataSourceImpl: CharacterRemoteDataSourceImpl
) : CharacterRepository {

    override suspend fun getCharacter(id: String): ResponseCharacterDataModel =
        characterRemoteDataSourceImpl.getCharacter(id)
}


