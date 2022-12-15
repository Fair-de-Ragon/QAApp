package com.fdrinc.qaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.fdrinc.qaapp.AccessibilityService.FirstTest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var runAccessibilityButton: Button
    lateinit var runTest: Button
    lateinit var firstTestCheckBox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        runAccessibilityButton = findViewById(R.id.goToSettings)
        runAccessibilityButton.setOnClickListener {
            val goToSettingsAccessibility = Intent(android.provider.Settings.ACTION_ACCESSIBILITY_SETTINGS)
            startActivity(goToSettingsAccessibility)
        }

        val firstTest = FirstTest()

        runTest = findViewById(R.id.runTest)
        runTest.setOnClickListener {
            val startTestingApp = Intent(packageManager.getLaunchIntentForPackage("com.fdrinc.mylist"))
            startActivity(startTestingApp)
            lifecycleScope.launch {
                firstTest.firstTest()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        checkTests()
    }

    fun checkTests() {
        if (TestsStatus.firstTestisDone) {
            firstTestCheckBox = findViewById(R.id.firstTestCheckBox)
            firstTestCheckBox.isChecked = true
        }
    }

    fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

}