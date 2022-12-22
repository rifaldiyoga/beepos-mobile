package com.bits.bee.bpmc.presentation.ui.initial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * Created by aldi on 08/12/22
 */
class SliderFragment : Fragment() {

    companion object {
        fun newInstance(layoutInt : Int) : Fragment {
            val args = Bundle()
            args.putInt("layout", layoutInt)
            val f = SliderFragment()
            f.arguments = args
            return f
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(requireArguments().getInt("layout"), container)
    }

}