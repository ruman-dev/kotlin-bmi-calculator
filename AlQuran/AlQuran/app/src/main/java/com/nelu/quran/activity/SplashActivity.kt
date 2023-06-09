package com.nelu.quran.activity

import android.content.*
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.nelu.minar.database.UserData
import com.nelu.quran.R
import com.nelu.quran.database.ApplicationData
import com.nelu.quran.sql.QuranHelper
import com.nelu.quran.sql.SurahHelper
import com.nelu.quran.theme.ApplicationTheme
import com.nelu.quran.utils.ContextUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.*
import java.lang.Exception
import java.util.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ApplicationTheme(this)
        setContentView(R.layout.activity_splash)

        launch()
    }

    private fun launch() {
        CoroutineScope(Dispatchers.Default).launch {
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(
                    Intent(
                        this@SplashActivity,
                        activity()
                    )
                )
                finish()
            },1000)
        }
    }

    private fun activity(): Class<*> {
        return if (UserData(this@SplashActivity).quranLaunched) {
            try {
                if (SurahHelper(this@SplashActivity).readData().size == 114
                    && QuranHelper(this@SplashActivity).readData().size == 6236)
                    QuranMainActivity::class.java
                else QuranActivity::class.java
            } catch (e: Exception) {
                QuranActivity::class.java
            }
        } else QuranActivity::class.java
    }

    override fun attachBaseContext(newBase: Context?) {
        val localeToSwitchTo = Locale(ApplicationData(newBase!!).language)
        val localeUpdatedContext: ContextWrapper = ContextUtils.updateLocale(newBase, localeToSwitchTo)
        super.attachBaseContext(localeUpdatedContext)
    }
}