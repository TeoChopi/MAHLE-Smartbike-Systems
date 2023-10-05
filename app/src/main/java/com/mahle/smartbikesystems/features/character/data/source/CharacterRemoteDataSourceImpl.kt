package com.mahle.smartbikesystems.features.character.data.source


import com.mahle.smartbikesystems.core.api.ApiService
import com.mahle.smartbikesystems.core.utils.Common
import com.mahle.smartbikesystems.features.character.data.model.ResponseCharacterDataModel
import javax.inject.Inject

class CharacterRemoteDataSourceImpl  @Inject constructor(
    private val apiService: ApiService
) : CharacterDataSource {

    override suspend fun getCharacter(id: String): ResponseCharacterDataModel =
        apiService.getCharacter(
            id,
            Common.getTimeStamp(),
            Common.getPublicApiKey(),
            Common.calculateHash()
        )
}