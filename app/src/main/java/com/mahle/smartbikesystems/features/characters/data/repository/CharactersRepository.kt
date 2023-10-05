package com.mahle.smartbikesystems.features.characters.data.repository

import com.mahle.smartbikesystems.features.characters.data.model.ResponseCharactersDataModel

interface CharactersRepository {
    suspend fun getCharacters(): ResponseCharactersDataModel
}