package com.dizcoding.base.extension

import android.app.Dialog
import android.util.DisplayMetrics

var deviceWidth = 0
var deviceHeight = 0

fun Dialog.getWidth(): Int {
    return if (deviceWidth == 0) {
        val displayMetrics = DisplayMetrics()
        this.window?.windowManager?.defaultDisplay?.getMetrics(displayMetrics)
        deviceWidth = displayMetrics.widthPixels
        deviceWidth
    } else {
        deviceWidth
    }
}

fun Dialog.getHigh(): Int {
    return if (deviceHeight == 0) {
        val displayMetrics = DisplayMetrics()
        this.window?.windowManager?.defaultDisplay?.getMetrics(displayMetrics)
        deviceHeight = displayMetrics.heightPixels
        deviceHeight
    } else {
        deviceHeight
    }
}