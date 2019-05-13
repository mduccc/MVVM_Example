package com.example.mvvm_example.views

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvm_example.R
import com.example.mvvm_example.databinding.ActivityMainBinding
import com.example.mvvm_example.viewmodels.RegisterViewModel
import android.widget.Toast
import android.databinding.BindingAdapter
import android.view.View


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        activityMainBinding.registerViewModel = RegisterViewModel()
        activityMainBinding.executePendingBindings()
    }

    companion object {
        @BindingAdapter("toastMessage")
        @JvmStatic
        fun runMe(view: View, message: String?) {
            message?.let {
                Toast.makeText(view.context, it, Toast.LENGTH_SHORT).show()
            }
        }
    }

}
