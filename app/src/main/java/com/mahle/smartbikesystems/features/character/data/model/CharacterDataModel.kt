package com.mahle.smartbikesystems.features.character.data.model

import com.google.gson.annotations.SerializedName

data class CharacterDataModel(

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("thumbnail")
    val thumbnail: Thumbnail? = null,
)

data class Thumbnail(

    @field:SerializedName("path")
    val path: String? = null,

    @field:SerializedName("extension")
    val extension: String? = null,
)
