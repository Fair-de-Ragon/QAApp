package com.fdrinc.qaapp.AccessibilityService

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.os.Build
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import kotlinx.coroutines.delay

class AccessibilityServices: AccessibilityService() {

    override fun onAccessibilityEvent(event: AccessibilityEvent) {
        if (event.eventType == AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED) {
            EventRepo.event = event
            EventRepo.rootElement = rootInActiveWindow
            Log.i("Root element = ", rootInActiveWindow.toString())
        }
    }

    override fun onInterrupt() {}
}