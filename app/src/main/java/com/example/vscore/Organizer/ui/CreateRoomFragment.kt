package com.example.vscore.Organizer.ui


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.vscore.Organizer.viewmodel.RoomViewModel
import com.example.vscore.databinding.FragmentCreateRoomBinding

class CreateRoomFragment : Fragment() {
    lateinit var binding:FragmentCreateRoomBinding
    lateinit var viewModel: RoomViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCreateRoomBinding.inflate(layoutInflater, container, false)
        viewModel= ViewModelProvider(this).get(RoomViewModel::class.java)
        observeCodeApiCall()
        callCodeApi()
        initListener()


        return binding.root
    }

    private fun initListener() {
        binding.refreshCode.setOnClickListener {
            callCodeApi()
        }
        binding.imgWhatsapp.setOnClickListener {
                val id =binding.codeTV.text.toString()
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.setPackage("com.whatsapp")
                intent.putExtra(Intent.EXTRA_TEXT, "Room code for your game is $id")
                ContextCompat.startActivity(requireContext(), intent, null)
        }

        binding.imgShare.setOnClickListener {
            val id =binding.codeTV.text.toString()
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Room code for your game is $id")
            ContextCompat.startActivity(
                requireContext(),
                Intent.createChooser(shareIntent, "Share Via"),
                null
            )
        }
    }

    private fun observeCodeApiCall() {
        viewModel.codeResponseMutableLiveData.observe(viewLifecycleOwner, Observer {
            binding.code=it.code.toString()
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    private fun callCodeApi() {
        val id =activity?.intent?.getStringExtra("org_id").toString()
        Log.d("Org_id",id)
        viewModel.callCodeApi(id)
    }
}