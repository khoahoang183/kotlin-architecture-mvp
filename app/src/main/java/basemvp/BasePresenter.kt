package basemvp

import android.app.AlertDialog
import android.content.Context
import java.lang.ref.WeakReference

abstract class BasePresenter(context: Context)  {
    private var progressDialog: AlertDialog? = null
    var context = WeakReference(context)

    fun requireContext(): Context = context.get()!!

    fun showProgress() {

        if (progressDialog != null) {
            return
        }

        context.get()?.let {
            val builder = AlertDialog.Builder(it)
            progressDialog = builder.create()
            progressDialog?.show()
        }
    }

    fun hideProgress() {
        progressDialog?.dismiss()
        progressDialog = null
    }

}