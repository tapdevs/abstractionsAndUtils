package com.tapdevs.abstractions.views

import android.support.design.widget.FloatingActionButton
import android.support.design.widget.CoordinatorLayout
import android.support.v4.view.ViewCompat
import android.view.View


class ScrollAwareBehaviour : FloatingActionButton.Behavior() {

//    override fun onNestedScroll(coordinatorLayout: CoordinatorLayout, child: FloatingActionButton,
//                       target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int , dzConsumed: Int) {
//        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed,
//                dyUnconsumed ,dzConsumed)
//
//        if (dyConsumed > 0 && child.visibility == View.VISIBLE) {
//            child.hide()
//        } else if (dyConsumed < 0 && child.visibility != View.VISIBLE) {
//            child.show()
//        }
//    }

    override fun onNestedScroll(coordinatorLayout: CoordinatorLayout, child: FloatingActionButton, target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed)
        if (dyConsumed > 0 && child.visibility == View.VISIBLE) {
            child.hide()
        } else if (dyConsumed < 0 && child.visibility != View.VISIBLE) {
            child.show()
        }
    }

//    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: FloatingActionButton, directTargetChild: View, target: View, axes: Int, type: Int): Boolean {
//        return axes == ViewCompat.SCROLL_AXIS_VERTICAL
//    }

    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: FloatingActionButton, directTargetChild: View, target: View, axes: Int): Boolean {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL
    }
}