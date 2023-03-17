package com.example.vscore.Team.ui


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
import com.example.vscore.databinding.JoinRoomFragmentBinding

class JoinRoomFragment : Fragment() {
    lateinit var binding:JoinRoomFragmentBinding
    lateinit var viewModel: RoomViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = JoinRoomFragmentBinding.inflate(layoutInflater, container, false)
        viewModel= ViewModelProvider(this).get(RoomViewModel::class.java)
        initListener()


        return binding.root
    }

    private fun initListener() {

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}