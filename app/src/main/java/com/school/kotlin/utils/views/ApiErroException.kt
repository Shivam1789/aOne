package com.school.kotlin.utils.views

class ApiErroException(message: String?) : Exception(message) {

    override fun getLocalizedMessage(): String {
        return super.getLocalizedMessage()
    }
}