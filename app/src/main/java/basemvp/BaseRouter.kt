package basemvp

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.example.mvp.MainActivity
import java.lang.ref.WeakReference
import kotlin.system.exitProcess

abstract class BaseRouter(activity: BaseActivity<*>? = null) {
    private var activity = activity?.let { WeakReference(activity) }

    fun requireContext(): Context? {
        activity?.get()?.let {
            return it
        }
        return null
    }

    fun startActivity(intent: Intent, requestCode: Int) {
        activity?.get()?.let {
            it.startActivityForResult(intent, requestCode)
        }
    }
}