package com.dizcoding.base.extension

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import java.util.*


fun Context.openChatWhatsApp(number: String, messages: String? = null) {
    var url = "https://api.whatsapp.com/send?phone=+$number"
    if (!messages.isNullOrEmpty()) {
        url += "&text=$messages"
    }
    val i = Intent(Intent.ACTION_VIEW)
    i.data = Uri.parse(url)
    this.startActivity(i)
}

fun Context.openSmsApp(number: String) {
    val i = Intent(Intent.ACTION_VIEW)
    i.data = Uri.parse("smsto:$number")
    this.startActivity(i)
}

fun Context.openCallApp(number: String) {
    val i = Intent(Intent.ACTION_DIAL)
    i.data = Uri.parse("tel:$number")
    this.startActivity(i)
}

fun Context.openBrowser(url: String?) {
    val i = Intent(Intent.ACTION_VIEW)
    i.data = Uri.parse(url)
    this.startActivity(i)
}

fun Context.openMailApp(email: String, hashMap: HashMap<String, String> = hashMapOf()) {
    val i = Intent(Intent.ACTION_SENDTO)
    i.data = Uri.parse("mailto:$email")
    if (hashMap.isNotEmpty()) {
        hashMap.forEach {
            i.putExtra(it.key, it.value)
        }
    }
    this.startActivity(i)
}

fun Context.showDatePickerDialog(selectedDate: (Int, Int, Int) -> Unit) {
    val calendar = Calendar.getInstance(Locale.getDefault())
    DatePickerDialog(
        this,
        { _, p1, p2, p3 ->
            selectedDate.invoke(p1, p2, p3)
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    ).show()
}

fun Context.showTimePickerDialog(selectedTime: (Int, Int) -> Unit) {
    val calendar = Calendar.getInstance(Locale.getDefault())
    TimePickerDialog(
        this,
        { _, p1, p2 ->
            selectedTime.invoke(p1, p2)
        },
        calendar.get(Calendar.HOUR_OF_DAY),
        calendar.get(Calendar.MINUTE),
        true
    ).show()
}

fun Context.getRealPath(file: Uri, result: (String) -> Unit) {
    var cursor: Cursor? = null
    try {
        val proj = arrayOf(MediaStore.Images.Media.DATA)
        cursor = this.contentResolver.query(file, proj, null, null, null)
        val columnIndex: Int? = cursor?.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        cursor?.moveToFirst()
        columnIndex?.let { i ->
            cursor?.getString(i)?.let {
                result.invoke(it)
            }
        }
    } catch (e: Exception) {
        result.invoke("")
    } finally {
        cursor?.close()
    }
}
