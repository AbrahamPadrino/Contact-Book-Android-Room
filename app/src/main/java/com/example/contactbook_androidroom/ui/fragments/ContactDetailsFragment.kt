package com.example.contactbook_androidroom.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.contactbook_androidroom.R
import com.example.contactbook_androidroom.databinding.FragmentContactDetailsBinding
import com.example.contactbook_androidroom.databinding.FragmentListContactsBinding

class ContactDetailsFragment : Fragment() {
    private lateinit var _binding: FragmentContactDetailsBinding
    private val binding get() = _binding

    companion object {
        val NAME = "name"
        val NUMBER = "phoneNumber"
        val EMAIL = "addressEmail"

    }
    private lateinit var name: String
    private lateinit var number: String
    private lateinit var email: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            name = it.getString(NAME).toString()
            number = it.getString(NUMBER).toString()
            email = it.getString(EMAIL).toString()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContactDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.txtName.text= name
        binding.txtNumber.text = number
        binding.txtEmail.text = email

    }

}