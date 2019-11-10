package com.school.kotlin.ui.select_class

interface ListItem {

    val itemType: Int

    companion object {
        val TYPE_ITEM = 0
        val TYPE_HEADER = 1
    }
}
