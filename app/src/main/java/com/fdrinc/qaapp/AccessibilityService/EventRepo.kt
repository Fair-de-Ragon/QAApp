package com.fdrinc.qaapp.AccessibilityService

import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo


object EventRepo {
    var event: AccessibilityEvent? = null
    var rootElement: AccessibilityNodeInfo? = null
}