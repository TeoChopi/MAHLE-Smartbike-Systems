package com.mahle.smartbikesystems.core.api

import com.mahle.smartbikesystems.features.characters.data.model.ResponseCharacterDataModel
import com.mahle.smartbikesystems.features.characters.data.model.ResponseCharactersDataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("v1/public/characters")
    suspend fun getCharacters(
        @Query("ts") ts: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
    ): ResponseCharactersDataModel

    @GET("v1/public/characters/{id}")
    suspend fun getCharacter(
        @Path("id") id: String,
        @Query("ts") ts: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String
    ): ResponseCharacterDataModel
}