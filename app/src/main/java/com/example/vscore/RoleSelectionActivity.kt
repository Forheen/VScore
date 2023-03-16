package com.example.vscore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.vscore.databinding.ActivitySelectRoleloginBinding
import com.talen_titan.utility.PrefUtil

class RoleSelectionActivity: AppCompatActivity() {
    lateinit var binding: ActivitySelectRoleloginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this@RoleSelectionActivity,R.layout.activity_select_rolelogin)
        binding.btnOrganizer.setOnClickListener {
            PrefUtil(this@RoleSelectionActivity).sharedPreferences?.edit()
                ?.putString(PrefUtil.ROLE, "Organiser")?.apply()
        }
        binding.btnTeam.setOnClickListener {
            PrefUtil(this@RoleSelectionActivity).sharedPreferences?.edit()
                ?.putString(PrefUtil.ROLE, "Team")?.apply()
        }
    }
}