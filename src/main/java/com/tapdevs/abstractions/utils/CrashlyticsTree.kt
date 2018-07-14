package com.tapdevs.abstractions.utils

import android.util.Log
import com.crashlytics.android.Crashlytics
import timber.log.Timber

/**
 * Created by  Jan Shair on 28/05/2017.
 */

class CrashlyticsTree : Timber.Tree() {

    override fun log(priority: Int, tag: String?, message: String?, t: Throwable?) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG || priority == Log.INFO) {
            return
        }

        //TODO: Integrate Crashlytics and uncomment these lines

          Crashlytics.setInt(CRASHLYTICS_KEY_PRIORITY, priority);
          Crashlytics.setString(CRASHLYTICS_KEY_TAG, tag);
          Crashlytics.setString(CRASHLYTICS_KEY_MESSAGE, message);

          if (t == null) {
          Crashlytics.logException(Exception(message));
          } else {
          Crashlytics.logException(t);
          }

    }

    companion object {
        private val CRASHLYTICS_KEY_PRIORITY = "priority"
        private val CRASHLYTICS_KEY_TAG = "tag"
        private val CRASHLYTICS_KEY_MESSAGE = "message"
    }
}