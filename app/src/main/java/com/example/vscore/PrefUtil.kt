package com.talen_titan.utility

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.widget.WithHint
import java.lang.ref.WeakReference

class PrefUtil(context: Context) {
    var sharedPreferences:SharedPreferences?=null
    val context:WeakReference<Context>
    init {
        this.context=WeakReference<Context>(context)
        sharedPreferences=context.getSharedPreferences(SESSION,Context.MODE_PRIVATE)
    }
    companion object{
        const val IS_LOGIN = "IS_LOGIN"
        const val TOKEN = "TOKEN"
        const val ID = "ID"
        const val ROLE = "ROLE"
        const val USER_ID = "USER_ID"
        const val USERNAME = "USERNAME"
        const val USER_COINS = "USER_COINS"
        const val USER_AVATAR = "USER_AVATAR"
        const val SESSION = "SESSION"
        const val FIRST_VISIT = "FIRST_VISIT"
        const val WITHDRAW_FIRST_VISIT = "WITHDRAW_FIRST_VISIT"
    }
    fun removeSavedValue(){
        val edit= sharedPreferences?.edit()
        edit?.remove(IS_LOGIN)
        edit?.remove(TOKEN)
        edit?.remove(ID)
        edit?.remove(SESSION)
        edit?.remove(USERNAME)
        edit?.commit()
    }
}