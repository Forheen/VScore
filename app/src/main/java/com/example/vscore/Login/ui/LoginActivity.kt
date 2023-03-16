package com.example.vscore.Login.ui
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.vscore.Login.model.SignInRequestModel
import com.example.vscore.Login.viewmodel.LoginViewModel
import com.example.vscore.MainActivity
import com.example.vscore.R
import com.example.vscore.SignUp.ui.SignUp
import com.example.vscore.SignUp.viewmodel.SignUpViewModel
import com.example.vscore.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this@LoginActivity,R.layout.activity_login)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        initListener()
        observeLoginApi()
        observeErrorMessage()
    }

    private fun observeLoginApi() {
        viewModel.loginResponseMutableLiveData.observe(this, Observer {
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        })
    }

    private fun initListener() {
        binding.signUpBtn.setOnClickListener {
            val intent= Intent(this@LoginActivity,SignUp::class.java)
            startActivity(intent)
            finish()
        }
        binding.signInBtn.setOnClickListener {
            callLoginApi()
        }
    }

    private fun callLoginApi() {
        val email = binding.edtEmail.text.toString()
        val password = binding.edtPassword.text.toString()
        viewModel.callLoginApi(SignInRequestModel(email, password))
    }

    private fun observeErrorMessage() {
        viewModel?.errorMessage?.observe(this, Observer {

                val snack = Snackbar.make(binding.root, "${it}", Snackbar.LENGTH_SHORT)
                snack.setBackgroundTint(resources.getColor(R.color.black))
                snack.setTextColor(resources.getColor(R.color.white))
                snack.show()
        })
    }
}