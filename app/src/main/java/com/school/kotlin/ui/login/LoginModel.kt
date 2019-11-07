package com.besttyme.kotlin.ui.signUp


import android.arch.lifecycle.MutableLiveData
import com.school.kotlin.api.model.MyViewModel
import com.school.kotlin.data.Login.LoginRequest
import com.school.kotlin.data.Login.LoginResponse
import com.school.kotlin.data.signUp.SignUpRequest
import com.school.kotlin.data.signUp.SignUpResponse
import com.school.kotlin.ui.login.LoginRepository
import com.school.kotlin.ui.signUp.SignUpRepository

/**
 * Created by shivam on 15/6/18.
 * model class for login
 */
class LoginModel : MyViewModel() {

    var response = MutableLiveData<LoginResponse>()

    fun loginData(request: LoginRequest) {
        isLoading.value = true
        LoginRepository.loginUser({
            response.value = it
            isLoading.value = false
        }, {
            apiError.value = it
            isLoading.value = false
        }, {
            onFailure.value = it
            isLoading.value = false
        }, request)
    }


}