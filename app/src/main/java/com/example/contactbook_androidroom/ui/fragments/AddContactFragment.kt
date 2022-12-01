package com.example.contactbook_androidroom.ui.fragments

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.contactbook_androidroom.R
import com.example.contactbook_androidroom.databinding.FragmentAddContactBinding
import com.example.contactbook_androidroom.databinding.FragmentContactDetailsBinding
import com.google.android.material.textfield.TextInputEditText

class AddContactFragment : Fragment() {

    private lateinit var _binding: FragmentAddContactBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddContactBinding.inflate(inflater, container, false)
        return binding.root

    }

}

