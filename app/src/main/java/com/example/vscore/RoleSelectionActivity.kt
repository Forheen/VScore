package com.example.vscore

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.vscore.Login.ui.LoginActivity
import com.example.vscore.databinding.ActivitySelectRoleloginBinding
import com.talen_titan.utility.PrefUtil

class RoleSelectionActivity: AppCompatActivity() {
    lateinit var binding: ActivitySelectRoleloginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this@RoleSelectionActivity,R.layout.activity_select_rolelogin)
        PrefUtil(this).removeSavedValue()
        binding.btnOrganizer.setOnClickListener {
            PrefUtil(this@RoleSelectionActivity).sharedPreferences?.edit()
                ?.putString(PrefUtil.ROLE, "Organiser")?.apply()
            val intent= Intent(this@RoleSelectionActivity,LoginActivity::class.java)
            startActivity(intent)
        }
        binding.btnTeam.setOnClickListener {
            PrefUtil(this@RoleSelectionActivity).sharedPreferences?.edit()
                ?.putString(PrefUtil.ROLE, "Team")?.apply()
            val intent= Intent(this@RoleSelectionActivity,LoginActivity::class.java)
            startActivity(intent)
        }
    }
}