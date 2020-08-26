package com.lipnus.sbu.util

import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatDialog
import com.lipnus.sbu.R

object LoadingDialog{
    var progressDialog: AppCompatDialog? = null

    fun show(activity: Activity){

        if(activity.isFinishing) return

        progressDialog = AppCompatDialog(activity).apply{
            setCancelable(false)
            setCanceledOnTouchOutside(false)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setContentView(R.layout.dialog_loading)
            show()
        }
    }

    fun dismiss(){
        if (progressDialog != null && progressDialog!!.isShowing ) {
            progressDialog!!.dismiss()
        }
    }
}