package elior.com.infrastructurekotlin.presentation.pages.fragments

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {

    var activity: Activity? = null
    private var dialog: ProgressDialog? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        activity = context as Activity

        dialog = ProgressDialog(activity)
    }

    fun showProgressDialog(text: String?) {
        dialog!!.setMessage(text)
        dialog!!.show()
    }

    fun hideProgressDialog() {
        if (dialog!!.isShowing) {
            dialog!!.dismiss()
        }
    }

}
