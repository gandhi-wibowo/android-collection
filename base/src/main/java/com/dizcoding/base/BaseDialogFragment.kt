package com.dizcoding.base

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding
import com.dizcoding.base.extension.avoidDoubleClicks
import com.dizcoding.base.extension.getWidth


abstract class BaseDialogFragment<VB : ViewBinding> : DialogFragment(), View.OnClickListener {

    private var _binding: ViewBinding? = null
    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB

    @Suppress("UNCHECKED_CAST")
    protected val binding: VB
        get() = _binding as VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater.invoke(inflater, container, false)
        return requireNotNull(_binding).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        val layoutParams = dialog?.window?.attributes
        val width = dialog?.getWidth() ?: 0
        val dimens = context?.resources?.getDimension(R.dimen.dizcoding_base_dimens_space_16)

        if (dimens != null) {
            layoutParams?.width = width - dimens.toInt()
            dialog?.window?.attributes = layoutParams
        }
        setup()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View?) {
        v.avoidDoubleClicks()
    }

    abstract fun setup()

}