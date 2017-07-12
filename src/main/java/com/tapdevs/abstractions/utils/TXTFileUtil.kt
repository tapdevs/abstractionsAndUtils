package com.tapdevs.abstractions.utils

import android.content.Context
import android.os.Environment
import com.tapdevs.abstractions.utils.DateUtil.getCurrentDate
import com.tapdevs.abstractions.utils.DateUtil.getDateAndTimeFromMillis
import com.tapdevs.abstractions.R
import timber.log.Timber
import java.io.*


/**
 * Created by ${ Jan Shair } on 10/07/2017.
 */

object TXTFileUtil{

    fun writeTextToFile(activity: Context?, text: String) {
            createFolderIfnotExist(activity)
            putDataInSDFile(activity!!, text)
    }

    fun writeTextToFile(activity: Context?, title:String, text: String) : String {

        createFolderIfnotExist(activity,title)
        return putDataInSDFile(activity!!,title, text)
    }

    fun createFolderIfnotExist(activity: Context?) {
        if (activity == null) {
            return
        }
        val direct = File(Environment.getExternalStorageDirectory().toString() + "/"
                + activity.getString(R.string.app_name))

        if (!direct.exists()) {
            if (direct.mkdir()) {
                Timber.d("Directory is Created.")
            }
        }
    }

    fun createFolderIfnotExist(activity: Context?, title:String) {
        if (activity == null) {
            return
        }
        val direct = File(Environment.getExternalStorageDirectory().toString() + "/"
                + activity.getString(R.string.app_name)+"/"+title)

        if (!direct.exists()) {
            if (direct.mkdir()) {
                Timber.d("Directory is Created.")
            }
        }

    }

    fun putDataInSDFile(activity: Context, title: String, text: String) : String {

        // Find the root of the external storage.
        // See http://developer.android.com/guide/topics/data/data-  storage.html#filesExternal

        // See http://stackoverflow.com/questions/3551821/android-write-to-sd-card-folder
        val dir = File("${Environment.getExternalStorageDirectory()}/${activity.getString(R.string.app_name)}/$title")
        val filePath : String = activity.getString(R.string.app_name).decapitalize().replace(" ","_") + getCurrentDate() + ".txt"
        val file = File(dir, filePath)
        if (!dir.exists()) {
            if (dir.mkdir()) {
                Timber.d("Directory is Created.")
            }
        }


        try {
            val f: FileOutputStream = FileOutputStream(file, false)

            val pw = PrintWriter(f)
            pw.println(text)
            pw.flush()
            pw.close()
            f.close()
        } catch (e: FileNotFoundException) {
            Timber.i(activity.getString(R.string.app_name), "******* File not found. Did you" + " add a WRITE_EXTERNAL_STORAGE permission to the   manifest?")
        } catch (e: IOException) {
            Timber.e(e)
        }
        return dir.absolutePath+"/"+filePath
    }

    fun putDataInSDFile(activity: Context, text: String) {

        // Find the root of the external storage.
        // See http://developer.android.com/guide/topics/data/data-  storage.html#filesExternal

        // See http://stackoverflow.com/questions/3551821/android-write-to-sd-card-folder
        var lengthInMbs = false
        val dir = File("${Environment.getExternalStorageDirectory()}/${activity.getString(R.string.app_name)}/logs")

        val file = File(dir, activity.getString(R.string.app_name).decapitalize().replace(" ","_") + getCurrentDate() + ".txt")
        if (!dir.exists()) {
            if (dir.mkdir()) {
                Timber.d("Directory is Created.")
            }

        } else {
            val mbs: Long = 15
            val length_in_mbs = file.length() / 1024 / 1024
            if (length_in_mbs > mbs) {
                lengthInMbs = true
                val isDeleted = file.delete()
                if (isDeleted) {
                    if (dir.mkdir()) {
                        println("Directory is Created again")

                    }
                }
            }
        }


        try {
            var f: FileOutputStream? = null
            if (lengthInMbs) {
                f = FileOutputStream(file, false)
            } else {
                f = FileOutputStream(file, true)
            }
            val pw = PrintWriter(f)
            pw.print(getDateAndTimeFromMillis(System.currentTimeMillis()) + "> " + getClassName(activity) + " ")
            pw.println(text)

            println(text)
            pw.flush()
            pw.close()
            f!!.close()
        } catch (e: FileNotFoundException) {
            Timber.i(activity.getString(R.string.app_name), "******* File not found. Did you" + " add a WRITE_EXTERNAL_STORAGE permission to the   manifest?")
        } catch (e: IOException) {
            Timber.e(e)
        }


    }

    private fun getClassName(activity: Context): String {
        var str = ""
        try {
            str = activity.javaClass.getSimpleName()
        } catch (e: Exception) {
            writeException(activity, e)
            str = ""
        }

        return str
    }

        fun writeException(context: Context, e: Exception) {
            try {
                val errors = StringWriter()
                e.printStackTrace(PrintWriter(errors))
                writeTextToFile(context, "Writing Exception \n" + errors.toString())
            } catch (e1: Exception) {
                try {
                    val errors = StringWriter()
                    e1.printStackTrace(PrintWriter(errors))
                    writeTextToFile(context, "Throwed Excpetion while Writing Exception \n" + errors.toString())
                } catch (e2: Exception) {

                }
            }

        }

}