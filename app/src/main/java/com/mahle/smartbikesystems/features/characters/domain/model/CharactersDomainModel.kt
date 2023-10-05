package com.mahle.smartbikesystems.features.characters.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharactersDomainModel(
    val results: List<CharacterDomainModel>? = null,
) : Parcelable
