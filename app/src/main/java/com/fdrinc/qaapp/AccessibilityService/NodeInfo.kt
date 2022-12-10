package com.fdrinc.qaapp.AccessibilityService

import android.util.Log
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo

class NodeInfo : AccessibilityNodeInfo() {
    fun firstTest(root: AccessibilityNodeInfo) {
        val addButton: AccessibilityNodeInfo =
            root.findAccessibilityNodeInfosByViewId("com.fdrinc.mylist:id/add_button").first()
        addButton.performAction(ACTION_CLICK)
    }

    fun debugClick( event: AccessibilityEvent) {
        Log.d(
            "Element info", "ClassName:" + event.className +
                    " Text:" + event.text +
                    " ViewIdResourceName:" + event.source.viewIdResourceName
            // " isClickable:" + event.
        )
    }

    fun debugView(event: AccessibilityEvent) {
        Log.d("Parent: ", event.source.parent.toString())
    }
}