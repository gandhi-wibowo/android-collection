package com.dizcoding.base

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding
import com.dizcoding.base.extension.avoidDoubleClicks

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity(), View.OnClickListener {
    private var _binding: ViewBinding? = null
    abstract val bindingInflater: (LayoutInflater) -> VB

    @Suppress("UNCHECKED_CAST")
    protected val binding: VB
        get() = _binding as VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater.invoke(layoutInflater)
        setContentView(requireNotNull(_binding).root)
        setup()
    }

    abstract fun setup()

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClick(v: View?) {
        v.avoidDoubleClicks()
    }

    fun intentTo(cls: Class<*>, vararg bundle: Bundle) {
        startActivity(
            Intent(this, cls)
                .apply {
                    if (bundle.isNotEmpty()) {
                        bundle.forEach {
                            putExtras(it)
                        }
                    }
                }
        )
    }

    fun showDialogFragment(dialogFragment: DialogFragment, bundle: Bundle = bundleOf()) {
        if (!bundle.isEmpty) dialogFragment.arguments = bundle
        dialogFragment.show(supportFragmentManager, "Tag")
    }
}