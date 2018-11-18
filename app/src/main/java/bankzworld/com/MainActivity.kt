package bankzworld.com

import android.app.Activity
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    val Activity.app: App
        get() = application as App

    // inject the pref dependency
    @Inject
    lateinit var prefs: SharedPreferences

    private val key = "key"
    private var message = "Hi!, This is a simple application of dagger!!!"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // inject necessary component
        app.component.inject(this)

        // store message to preference
        prefs.edit().putString(key, message).apply()

        // displays the stored value in the preference
        show_text.text = prefs.getString(key, "")
    }
}
