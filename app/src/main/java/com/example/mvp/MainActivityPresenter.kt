package com.example.mvp

import android.content.Context
import android.content.Intent
import kotlin.random.Random

class MainActivityPresenter (context: Context)
    : MainActivityPresenterProtocol(context) {

    override fun onCreate(intent: Intent) {

    }

    override fun onClickProcessButton(string1: String, string2: String) {

        val number1 = string1.toIntOrNull()
        val number2 = string2.toIntOrNull()

        number1?.let {
            number2?.let {
                setToastProcessButton?.invoke(number1+number2)
                return
            }
        }
        setToastProcessButton?.invoke(null)
    }
}