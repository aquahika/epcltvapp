package com.daigorian.epcltvapp


import android.os.Bundle
import androidx.fragment.app.FragmentActivity

class SettingsActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                .replace(R.id.settings_fragment, SettingsFragment())
                .commit()

        }
    }
}