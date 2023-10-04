package com.mahle.smartbikesystems.features.characters.data.source


import com.mahle.smartbikesystems.core.api.ApiService
import com.mahle.smartbikesystems.core.utils.Common
import com.mahle.smartbikesystems.features.characters.data.model.ResponseCharacterDataModel
import com.mahle.smartbikesystems.features.characters.data.model.ResponseCharactersDataModel
import javax.inject.Inject

class CharactersRemoteDataSourceImpl  @Inject constructor(
    private val apiService: ApiService
) : CharactersDataSource {

    override suspend fun getCharacters(): ResponseCharactersDataModel =
        apiService.getCharacters(
            Common.getTimeStamp(),
            Common.getPublicApiKey(),
            Common.getHash(),
            20,
            0
        )

    override suspend fun getCharacter(id: String): ResponseCharacterDataModel =
        apiService.getCharacter(
            id,
            Common.getTimeStamp(),
            Common.getPrivateApiKey(),
            Common.getHash()
        )
}