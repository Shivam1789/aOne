package com.school.kotlin.ui.select_class

class Header(var name: String) : ListItem {

    override val itemType: Int
        get() = ListItem.TYPE_HEADER
}
