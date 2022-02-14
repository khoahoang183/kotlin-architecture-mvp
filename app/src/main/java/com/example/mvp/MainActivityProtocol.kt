package com.example.mvp

import android.app.Activity
import android.content.Context
import android.content.Intent
import basemvp.BaseActivity
import basemvp.BasePresenter
import basemvp.BaseRouter

// --- View Protocol
abstract class MainActivityViewProtocol:BaseActivity<MainActivityPresenterProtocol>() {
    override fun createPresenter() {
        val router = MainActivityRouter(activity = this)
        presenter = MainActivityPresenter(this).apply {
            this.router = router
        }
    }
}

// --- Presenter Protocol
abstract class MainActivityPresenterProtocol(context: Context): BasePresenter(context) {
    var router: MainActivityRouterProtocol? = null

    abstract fun onCreate(intent: Intent)
    abstract fun onClickProcessButton(string1: String, string2: String)

    var setToastProcessButton: ((Int?) -> Unit)? = null
}

// --- Router Protocol
abstract class MainActivityRouterProtocol(activity: BaseActivity<*>? = null) :
    BaseRouter(activity) {
}