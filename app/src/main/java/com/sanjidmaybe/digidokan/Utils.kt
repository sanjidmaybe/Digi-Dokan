package com.sanjidmaybe.digidokan

import android.widget.EditText

fun EditText.isEmpty(): Boolean{
    return if (this.text.toString().isEmpty()){
        this.error = "This Needs to be Filled"
        true
    }else{
        false
    }
}