package com.ground.zero.searchflow.search.utils

import android.text.Editable

infix fun Editable?.toSearchQuery(block: (Boolean, String) -> Unit) {
    block.invoke(this?.let {
        it.toString() != ""
    } ?: false, this.toString())
}