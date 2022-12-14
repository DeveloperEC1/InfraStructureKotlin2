package elior.com.infrastructurekotlin.others

import android.app.Application

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        application = this
    }

    companion object {

        lateinit var application: Application
    }

}