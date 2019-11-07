package com.school.kotlin.fragments

/**
 * Created by android on 3/11/17.
 */
interface IBaseView {

    fun showProgressDialog()

    fun hideProgressDialog()

    fun onServerError()

    fun onApiError(error: String)

}