package elior.com.infrastructurekotlin.presentation.pages.activities

import android.os.Bundle
import elior.com.infrastructurekotlin.R
import elior.com.infrastructurekotlin.data.managers.ViewModelManager

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ViewModelManager.instance.initViewModels(this)

        setContentView(R.layout.activity_main)
    }

}
