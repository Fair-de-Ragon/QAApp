package com.fdrinc.qaapp.AccessibilityService

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.os.Build
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import androidx.annotation.RequiresApi

class AccessibilityServices: AccessibilityService() {
    override fun onAccessibilityEvent(event: AccessibilityEvent) {

        var isStarted = false
        var nodeInfo = NodeInfo()

        if ((event.packageName.toString() == "com.fdrinc.mylist") && !isStarted) {
            isStarted = true
            Log.d("Connected to ", event.packageName.toString())
            nodeInfo.firstTest(rootInActiveWindow)
        }
    }

    override fun onInterrupt() {}
}