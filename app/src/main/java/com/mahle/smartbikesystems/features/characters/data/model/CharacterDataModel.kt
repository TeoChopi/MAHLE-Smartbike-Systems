package com.mahle.smartbikesystems.features.characters.data.model

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
