package com.bits.bee.bpmc.presentation.base

import android.app.Activity
import android.app.Dialog
import android.graphics.Point
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_EXPANDED
import com.google.android.material.bottomsheet.BottomSheetDialog
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


    override fun onResume() {
        super.onResume()
        if (BeePreferenceManager.ORIENTATION == BPMConstants.SCREEN_LANDSCAPE) {
            val params: ViewGroup.LayoutParams = dialog!!.window!!.attributes
            val lp = WindowManager.LayoutParams()
            try {
                val display: Display = (activity as Activity?)!!.windowManager.defaultDisplay
                val size = Point()
                display.getSize(size)
                val width: Int = size.x
                val widthDialog: Double = width / BPMConstants.DIVIDE_DIALOG_SIZE
                params.width = (width - widthDialog).toInt()
                params.height = WindowManager.LayoutParams.WRAP_CONTENT
            } catch (e: Exception) {
                e.printStackTrace()
            }
            dialog!!.window!!.attributes = params as WindowManager.LayoutParams
        }
    }

    override fun onCreateDialog(@Nullable savedInstanceState: Bundle?): Dialog {
        val dialog: Dialog = super.onCreateDialog(savedInstanceState)
        if (BeePreferenceManager.ORIENTATION == BPMConstants.SCREEN_LANDSCAPE)
            dialog.window?.setBackgroundDrawable(ContextCompat.getDrawable(requireActivity(), R.drawable.bg_rounded_transparent))
        return dialog
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(BeePreferenceManager.ORIENTATION == BPMConstants.SCREEN_POTRAIT) {
            setStyle(STYLE_NORMAL, R.style.ThemeOverlay_Demo_BottomSheetDialog)
        } else {
            setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Material_Dialog)
        }
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
        (dialog as? BottomSheetDialog)?.behavior?.state = STATE_EXPANDED
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