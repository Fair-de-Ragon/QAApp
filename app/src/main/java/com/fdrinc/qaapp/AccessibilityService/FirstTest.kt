package com.fdrinc.qaapp.AccessibilityService

import android.os.Bundle
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import androidx.core.os.bundleOf
import com.fdrinc.qaapp.MainActivity
import com.fdrinc.qaapp.TestsStatus
import kotlinx.coroutines.delay

class FirstTest : AccessibilityNodeInfo() {

    suspend fun firstTest() {

        val nameText = Bundle()
        val whereToBuyText = Bundle()
        val descriptionText = Bundle()
        nameText.putString(AccessibilityNodeInfo.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, "Сыр")
        whereToBuyText.putString(AccessibilityNodeInfo.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, "Магнит")
        descriptionText.putString(AccessibilityNodeInfo.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, "Марки Natura, 400 грамм")

        while (!EventRepo.event?.packageName.toString().equals("com.fdrinc.mylist")) {
            delay(1000)
            Log.d("Event", EventRepo.event?.packageName.toString())
        }

        val addButton: AccessibilityNodeInfo =
            EventRepo.rootElement?.findAccessibilityNodeInfosByViewId("com.fdrinc.mylist:id/add_button")!!.first()
        addButton.performAction(ACTION_CLICK)

        delay(1000)
        val nameField: AccessibilityNodeInfo = EventRepo.rootElement?.findAccessibilityNodeInfosByViewId("com.fdrinc.mylist:id/name_more_info")!!.first()
        nameField.performAction(ACTION_SET_TEXT, nameText)

        delay(1000)
        val whereToBuyField: AccessibilityNodeInfo = EventRepo.rootElement?.findAccessibilityNodeInfosByViewId("com.fdrinc.mylist:id/where_to_buy_more_info")!!.first()
        whereToBuyField.performAction(ACTION_SET_TEXT, whereToBuyText)

        delay(1000)
        val descriptionField: AccessibilityNodeInfo = EventRepo.rootElement?.findAccessibilityNodeInfosByViewId("com.fdrinc.mylist:id/description_more_info")!!.first()
        descriptionField.performAction(ACTION_SET_TEXT, descriptionText)

        delay(1000)
        val doneButton: AccessibilityNodeInfo =
            EventRepo.rootElement?.findAccessibilityNodeInfosByViewId("com.fdrinc.mylist:id/more_info_done")!!.first()
        doneButton.performAction(ACTION_CLICK)

        delay(1000)
        val cheeseCard: AccessibilityNodeInfo =
            EventRepo.rootElement?.findAccessibilityNodeInfosByViewId("com.fdrinc.mylist:id/one_item")!!.get(1)
        if (cheeseCard.isVisibleToUser) {
            TestsStatus.firstTestisDone = true
        }
    }
}