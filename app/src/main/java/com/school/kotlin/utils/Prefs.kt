package com.school.kotlin.utils

import android.content.SharedPreferences

/**
 * Created by android on 11/12/17.
 * Take cares of the shared preferences
 */
inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
    val editor = this.edit()
    operation(editor)
    editor.commit()
}

/**
 * puts a key value pair in shared prefs if doesn't exists, otherwise updates value on given [key]
 */
fun SharedPreferences.setValue(key: String, value: Any?) {
    when (value) {
        is String -> edit({ it.putString(key, value) })
        is Int -> edit({ it.putInt(key, value) })
        is Boolean -> edit({ it.putBoolean(key, value) })
        is Float -> edit({ it.putFloat(key, value) })
        is Long -> edit({ it.putLong(key, value) })
        else -> throw UnsupportedOperationException("Not yet implemented")
    }
}

/**
 * finds value on given key.
 * [T] is the type of value
 * @param defaultValue optional default value - will take null for strings,
 * false for bool and -1 for numeric values if [defaultValue] is not specified
 */
inline fun <reified T : Any> SharedPreferences.getValue(key: String, defaultValue: T?): T {
    return when (T::class) {
        String::class -> getString(key, defaultValue as String) as T
        Int::class -> getInt(key, defaultValue as Int ) as T
        Boolean::class -> getBoolean(key, defaultValue as Boolean) as T
        Float::class -> getFloat(key, defaultValue as Float ) as T
        Long::class -> getLong(key, defaultValue as Long ) as T
        else -> throw UnsupportedOperationException("Not yet implemented")
    }


}
 fun SharedPreferences.clearPref(){
    val editor = this.edit()
    editor.clear()
    editor.apply()
    }

