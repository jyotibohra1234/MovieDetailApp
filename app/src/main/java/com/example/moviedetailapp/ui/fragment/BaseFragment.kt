package com.example.moviedetailapp.ui.fragment

import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.moviedetailapp.ui.activity.MainActivity

open class BaseFragment(private var layoutResId: Int) : Fragment(layoutResId) {

    protected val mainActivity by lazy {
        requireActivity() as MainActivity
    }

    protected val fragmentContext by lazy {
        requireContext()
    }

    private val navController by lazy {
        findNavController()
    }

    /**
     * @param actionId id used to navigate between fragment
     * @param navDirections navigate and exchange data between fragment using NavDirections
     */
    protected fun navigateTo(actionId: Int? = null, navDirections: NavDirections? = null) {
        actionId?.let {
            navController.navigate(it)
        }
        navDirections?.let {
            navController.navigate(it)
        }
    }

    /**
     * Method to clear current fragment from backstack
     */
    protected fun navigateUp() {
        navController.navigateUp()
    }
}