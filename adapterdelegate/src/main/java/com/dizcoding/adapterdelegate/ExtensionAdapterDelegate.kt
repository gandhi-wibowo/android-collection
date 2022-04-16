package com.dizcoding.adapterdelegate

import android.annotation.SuppressLint
import androidx.annotation.LayoutRes

typealias ExtensionItemDelegate<T> = ItemDelegate<T, ExtensionViewHolder<T>>


inline fun <reified T> itemDelegate(
    @LayoutRes layoutId: Int
) = LayoutItemDelegate(T::class.java, layoutId)

fun <T> ExtensionItemDelegate<T>.click(
    onClick: (T) -> Unit
) = ClickableItemDelegate(this, onClick)

fun <T> ExtensionItemDelegate<T>.create(
    block: ExtensionViewHolder<T>.() -> Unit
) = CreateItemDelegate(this, block)

fun <T> ExtensionItemDelegate<T>.bind(
    block: ExtensionViewHolder<T>.(item: T) -> Unit
) = BindItemDelegate(this, block)


fun <I : Any> DelegatesAdapter<I>.getItem(
    predict: (I) -> Boolean
): I? {
    return this.items.find(predict)
}

@SuppressLint("NotifyDataSetChanged")
fun <I : Any> DelegatesAdapter<I>.updateItems(
    item: List<I>
) {
    this.items = item
    notifyDataSetChanged()
}

fun <I : Any> DelegatesAdapter<I>.updateItem(
    item: I, itemPosition: Int
) {
    this.items.toMutableList()[itemPosition] = item
    notifyItemChanged(itemPosition)
}