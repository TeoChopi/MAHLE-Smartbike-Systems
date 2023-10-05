package com.mahle.smartbikesystems.features.character.data.model

import com.google.gson.annotations.SerializedName
import com.mahle.smartbikesystems.features.character.domain.model.CharacterDomainModel

data class ResponseCharacterDataModel(

    @field:SerializedName("copyright")
    val copyright: String? = null,

    @field:SerializedName("code")
    val code: Int? = null,

    @field:SerializedName("data")
    val data: DataCharter? = null,

    @field:SerializedName("attributionHTML")
    val attributionHTML: String? = null,

    @field:SerializedName("attributionText")
    val attributionText: String? = null,

    @field:SerializedName("etag")
    val etag: String? = null,

    @field:SerializedName("status")
    val status: String? = null,
)

data class DataCharter(

    @field:SerializedName("total")
    val total: Int? = null,

    @field:SerializedName("offset")
    val offset: Int? = null,

    @field:SerializedName("limit")
    val limit: Int? = null,

    @field:SerializedName("count")
    val count: Int? = null,

    @field:SerializedName("results")
    val results: List<CharacterDataModel>? = null,
)

fun ResponseCharacterDataModel.toCharter(): CharacterDomainModel =
    CharacterDomainModel(
        id = data?.results?.get(0)?.id,
        name = data?.results?.get(0)?.name,
        description = data?.results?.get(0)?.description,
        thumbnailPath = data?.results?.get(0)?.thumbnail?.path,
        thumbnailExtension = data?.results?.get(0)?.thumbnail?.extension,
    )
