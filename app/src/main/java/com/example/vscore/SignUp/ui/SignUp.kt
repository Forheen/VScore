package com.example.vscore.SignUp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContentProviderCompat
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.vscore.AppUrls
import com.example.vscore.Login.ui.LoginActivity
import com.example.vscore.R
import com.example.vscore.SignUp.model.SignUpRequestModel
import com.example.vscore.SignUp.viewmodel.SignUpViewModel
import com.example.vscore.databinding.ActivitySignUpBinding
import com.talen_titan.utility.PrefUtil

class SignUp : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding
    lateinit var viewModel: SignUpViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)
        initListener()
        observeRegisterApiResponse()
        observeErrorMessage()
    }

    private fun initListener() {
        binding.signInBtn.setOnClickListener {
            val intent = Intent(this@SignUp, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.signUpBtn.setOnClickListener {
            callRegisterApi()
        }
    }

    private fun callRegisterApi() {
        val name = binding.edtUsername.text.toString()
        val email = binding.edtEmail.text.toString()
        val password = binding.edtPassword.text.toString()
        var url=""
        url = if(PrefUtil(applicationContext).sharedPreferences?.getString(PrefUtil.ROLE, "")=="Organiser")
            AppUrls.ORGANIZATION_REGISTER_URL
        else
            AppUrls.TEAM_REGISTER_URL
        viewModel.callRegisterApi(url,SignUpRequestModel(name, email, password))
    }

    private fun observeRegisterApiResponse() {
        viewModel.registerResponseMutableLiveData.observe(this, Observer {
            val intent = Intent(this@SignUp, LoginActivity::class.java)
            startActivity(intent)
            finish()
        })
    }

    private fun observeErrorMessage() {
        viewModel.errorMessage.observe(this, Observer {
            Toast.makeText(this,it.toString(), Toast.LENGTH_SHORT).show()
        })
    }
}