package com.tapdevs.abstractions.adapterHelpers

/**
 * Created by ${ Jan Shair } on 05/07/2017.
 */

interface ItemTouchHelperViewHolder {

    /**
     * Called when the {@link ItemTouchHelper} first registers an item as being moved or swiped.
     * Implementations should update the item view to indicate it's active state.
     */
    fun onItemSelected()


    /**
     * Called when the {@link ItemTouchHelper} has completed the move or swipe, and the active item
     * state should be cleared.
     */
    fun onItemClear()
}
