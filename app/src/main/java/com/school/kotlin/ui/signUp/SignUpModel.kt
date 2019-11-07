package com.school.kotlin.ui.signUp


import android.arch.lifecycle.MutableLiveData
import com.school.kotlin.api.model.MyViewModel
import com.school.kotlin.data.signUp.SignUpRequest
import com.school.kotlin.data.signUp.SignUpResponse

/**
 * Created by android on 19/2/18.
 * model class for login
 */
class SignUpModel : MyViewModel() {

    var response = MutableLiveData<SignUpResponse>()

    fun submitData(request: SignUpRequest) {
        isLoading.value = true
        SignUpRepository.registerUser({
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