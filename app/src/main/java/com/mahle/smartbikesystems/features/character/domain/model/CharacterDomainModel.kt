package com.mahle.smartbikesystems.features.character.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class CharacterDomainModel(
    val id: Int? = null,
    val name: String? = null,
    val description: String? = null,
    val thumbnailPath: String? = null,
    val thumbnailExtension: String? = null
) : Parcelable
