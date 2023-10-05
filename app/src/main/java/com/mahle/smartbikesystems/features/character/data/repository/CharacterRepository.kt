package com.mahle.smartbikesystems.features.character.data.repository

import com.mahle.smartbikesystems.features.character.data.model.ResponseCharacterDataModel

interface CharacterRepository {
    suspend fun getCharacter(id: String): ResponseCharacterDataModel
}