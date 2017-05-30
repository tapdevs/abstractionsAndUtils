package com.tapdevs.abstractions.views

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


/**
 * Created by  Jan Shair on 28/5/2017.
 */

abstract class BaseFragment : Fragment() {

    override fun onAttach(activity: Context?) {
        super.onAttach(activity)
        injectDependencies()

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view: View? = getBindingView(inflater!!, fragmentLayout, container!!, false)
        if (view == null) {
            view = inflater!!.inflate(fragmentLayout, container, false)
        }

        return view
    }

    abstract fun getBindingView(inflater: LayoutInflater, fragmentLayout: Int, container: ViewGroup, b: Boolean): View


    /**
     * Initialize any core functions
     */
    abstract fun initialize()

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    /**
     * Every fragment has to inflate a layout in the onCreateView method. We have added this method to
     * avoid duplicate all the inflate code in every fragment. You only have to return the layout to
     * inflate in this method when extends BaseFragment.
     */
    protected abstract val fragmentLayout: Int

    /**
     * Replace every field annotated using @Inject annotation with the provided dependency specified
     * inside a Dagger module value.
     */
    protected abstract fun injectDependencies()

}