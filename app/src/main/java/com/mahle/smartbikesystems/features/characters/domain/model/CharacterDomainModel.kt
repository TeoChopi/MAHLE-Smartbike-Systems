package com.mahle.smartbikesystems.features.characters.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class CharacterDomainModel(
    val id: Int? = null,
    val name: String? = null,
    val description: String? = null,
    val thumbnailPath: String?,
    val thumbnailExtension: String?,
    val resourceURI: String? = null,
) : Parcelable
