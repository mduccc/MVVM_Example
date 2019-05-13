package com.example.mvvm_example.viewmodels

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.android.databinding.library.baseAdapters.BR
import com.example.mvvm_example.models.RegisterDataModel

class RegisterViewModel : BaseObservable() {

    private var register = RegisterDataModel("", "", "")
    @Bindable
    private var toastMessage: String? = null

    private fun isValid(): Boolean {
        return getUsername().isNotEmpty() && getPassword().isNotEmpty() && getCountry().isNotEmpty()
    }

    fun setUsername(username: String) {
        register.username = username
        notifyPropertyChanged(BR.username)
    }

    fun setToast(messenger: String){
        toastMessage = messenger
        notifyPropertyChanged(BR.toastMessage)
    }

    fun setPassword(password: String) {
        register.password = password
        notifyPropertyChanged(BR.password)
    }

    fun setCountry(country: String) {
        register.country = country
        notifyPropertyChanged(BR.country)
    }

    @Bindable
    fun getUsername(): String {
        return register.username
    }

    @Bindable
    fun getPassword(): String {
        return register.password
    }

    @Bindable
    fun getCountry(): String {
        return register.country
    }

    @Bindable
    fun getToastMessage(): String? {
        return toastMessage
    }

    fun onCLicked() {
        if (isValid())
            setToast("RegisterDataModel done")
        else
            setToast("Some field is empty")

    }
}