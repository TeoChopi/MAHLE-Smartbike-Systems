package com.mahle.smartbikesystems.features.character.data.source

import com.mahle.smartbikesystems.features.character.data.model.ResponseCharacterDataModel

interface CharacterDataSource {
    suspend fun getCharacter(id: String): ResponseCharacterDataModel
}