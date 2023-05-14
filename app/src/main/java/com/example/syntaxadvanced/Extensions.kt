package com.example.syntaxadvanced

import java.text.SimpleDateFormat
import java.util.*

fun Date?.customFormat() : String? {
    val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZ", Locale.getDefault())
    if (this != null) {
        return formatter.format(this)
    }
    return null
}

val Date?.formatSize : Int
    get() = this.customFormat()?.length ?: 0 // notation in case of value is null, return 0 (?: 0)