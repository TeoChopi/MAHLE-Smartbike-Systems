package com.mahle.smartbikesystems.features.characters.data.source

import com.mahle.smartbikesystems.features.characters.data.model.ResponseCharacterDataModel
import com.mahle.smartbikesystems.features.characters.data.model.ResponseCharactersDataModel

interface CharactersDataSource {
    suspend fun getCharacters(): ResponseCharactersDataModel
    suspend fun getCharacter(id: String): ResponseCharacterDataModel
}