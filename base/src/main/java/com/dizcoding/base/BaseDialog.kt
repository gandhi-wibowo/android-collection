package com.dizcoding.base

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import androidx.viewbinding.ViewBinding
import com.dizcoding.base.extension.avoidDoubleClicks
import com.dizcoding.base.extension.getWidth

abstract class BaseDialog<VB : ViewBinding>(context: Context) :  Dialog(context),
    View.OnClickListener {

    private var _binding: ViewBinding? = null
    abstract val bindingInflater: (LayoutInflater) -> VB
    abstract val dialogCanCancle: Boolean

    @Suppress("UNCHECKED_CAST")
    protected val binding: VB
        get() = _binding as VB

    override fun onStart() {
        super.onStart()
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater.invoke(layoutInflater)
        setContentView(requireNotNull(_binding).root)
        setCancelable(dialogCanCancle)

        window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        val layoutParams = window?.attributes
        val width = getWidth()
        val dimens = context.resources?.getDimension(R.dimen.dizcoding_base_dimens_space_60)

        if (dimens != null) {
            layoutParams?.width = width - dimens.toInt()
            window?.attributes = layoutParams
        }
        setup()
    }

    abstract fun setup()

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        _binding = null
    }

    override fun onClick(v: View?) {
        v.avoidDoubleClicks()
    }
}