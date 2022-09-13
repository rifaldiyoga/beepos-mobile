package com.bits.bee.bpmc.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.viewbinding.ViewBinding
import com.bits.bee.bpmc.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar

/**
 * Created by aldi on 28/03/22.
 */
abstract class BaseBottomSheetDialogFragment<T : ViewBinding> : BottomSheetDialogFragment(), BaseInterface {

    //View Binding
    private var _binding : ViewBinding? = null
    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> T

    @Suppress("UNCHECKED_CAST")
    protected val binding: T
        get() = _binding as T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.ThemeOverlay_Demo_BottomSheetDialog)
    }

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

        initComponents()
        subscribeListeners()
        subscribeObservers()
    }

    abstract override fun initComponents()

    abstract override fun subscribeListeners()

    abstract override fun subscribeObservers()

    override fun showSnackbar(message: String) =
        Snackbar.make(requireView(), message, Snackbar.LENGTH_SHORT).show()

    override fun showSnackbarWithAction(
        @StringRes message: Int,
        @StringRes actionText: Int,
        action: () -> Any
    ) {
        val snackBar = Snackbar.make(requireView(), message, Snackbar.LENGTH_INDEFINITE)
        snackBar.setAction(actionText) { _ -> action.invoke() }
        snackBar.setActionTextColor(ContextCompat.getColor(requireContext(), R.color.red))
        snackBar.show()
    }

    override fun showToast(message: Int) =
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()

}