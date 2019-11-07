package com.school.kotlin.fragments

/**
 * Created by android on 3/11/17.
 * *
 */
interface IBasePresenter {

    fun onServerError()

    fun onApiError(message: String)
}