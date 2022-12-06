package com.example.contactbook_androidroom.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.contactbook_androidroom.ContactBookApplication
import com.example.contactbook_androidroom.databinding.FragmentAddContactBinding
import com.example.contactbook_androidroom.ui.models.Person
import com.example.contactbook_androidroom.ui.viewmodels.ContactViewModel
import com.example.contactbook_androidroom.ui.viewmodels.ContactViewModelFactory

class AddContactFragment : Fragment() {

    private lateinit var _binding: FragmentAddContactBinding
    private val binding get() = _binding

    private val contactViewModel : ContactViewModel by viewModels {
        ContactViewModelFactory((requireActivity().application as ContactBookApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddContactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        setupViewModel()
        setupViewEvents()
    }

    private fun setupViewModel() {
        contactViewModel.liveData.observe(viewLifecycleOwner) {
            // TODO("AGREGAR Y MOSTRAR LA LISTA DE CONTACTOS ACTUALIZADA")
        }
    }

    private fun setupViewEvents() {
        binding.buttonSave.setOnClickListener {
            val contactName : String = binding.nameContact.text.toString()
            val contactPhoneNumber : String = binding.phoneContact.text.toString()
            val contactEmail : String = binding.emailContact.text.toString()

            val model = Person(
                name = contactName,
                phone = contactPhoneNumber,
                email = contactEmail
            )

            contactViewModel.createContact(model)
        }
    }

}

