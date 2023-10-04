package com.mahle.smartbikesystems.features.characters.data.model

import com.google.gson.annotations.SerializedName
import com.mahle.smartbikesystems.features.characters.domain.model.CharacterDomainModel

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
	val status: String? = null
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

fun CharacterDataModel.toCharter(): CharacterDomainModel =
    CharacterDomainModel(
        id = id,
        name = name,
        description = description,
        thumbnailPath = thumbnail?.path,
        thumbnailExtension = thumbnail?.extension,
        resourceURI = resourceURI
    )
