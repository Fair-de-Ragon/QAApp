package com.fdrinc.qaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var runAccessibilityButton: Button
    lateinit var runTest: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        runAccessibilityButton = findViewById(R.id.goToSettings)
        runAccessibilityButton.setOnClickListener {
            val goToSettingsAccessibility = Intent(android.provider.Settings.ACTION_ACCESSIBILITY_SETTINGS)
            startActivity(goToSettingsAccessibility)
        }

        runTest = findViewById(R.id.runTest)
        runTest.setOnClickListener {
            val startTestingApp = Intent(packageManager.getLaunchIntentForPackage("com.fdrinc.mylist"))
            startActivity(startTestingApp)
        }
    }


}