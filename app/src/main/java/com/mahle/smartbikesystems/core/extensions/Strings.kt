package com.mahle.smartbikesystems.core.extensions


import korlibs.crypto.md5

fun String.toMD5() = toByteArray(Charsets.UTF_8).md5().toString()
