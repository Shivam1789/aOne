package com.school.kotlin.ui.select_class

class Person(var name: String) : ListItem {

    override val itemType: Int
        get() = ListItem.TYPE_ITEM
}
