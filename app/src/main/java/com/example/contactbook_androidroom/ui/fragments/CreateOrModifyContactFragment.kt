package com.example.contactbook_androidroom.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.contactbook_androidroom.ContactBookApplication
import com.example.contactbook_androidroom.R
import com.example.contactbook_androidroom.databinding.FragmentAddContactBinding
import com.example.contactbook_androidroom.ui.models.ActionContact
import com.example.contactbook_androidroom.ui.models.PersonModel
import com.example.contactbook_androidroom.ui.viewmodels.ContactViewModel
import com.example.contactbook_androidroom.ui.viewmodels.ContactViewModelFactory

class CreateOrModifyContactFragment : Fragment() {

    private lateinit var _binding: FragmentAddContactBinding

    private val arguments: CreateOrModifyContactFragmentArgs by navArgs()

    private val binding get() = _binding

    private val contactViewModel: ContactViewModel by viewModels {
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
        if (arguments.action == ActionContact.MODIFY) setupOnModify()
        // setupFabIconAction()
        setupViewModel()
        setupViewEvents()
    }

    private fun setupFabIconAction() {
        val action = if (arguments.model == null) ActionContact.CREATE // Create the contact
        else ActionContact.MODIFY // Modify the contact
        handleActionType(action)
    }

    private fun setupViewModel() {
        contactViewModel.liveData.observe(viewLifecycleOwner) {
            // TODO("AGREGAR Y MOSTRAR LA LISTA DE CONTACTOS ACTUALIZADA")
        }
    }

    private fun setupViewEvents() {
        binding.buttonSave.setOnClickListener {
            when (arguments.action) {
                ActionContact.CREATE -> onCreateEvent()
                ActionContact.MODIFY -> onModifyEvent()
            }

            findNavController().popBackStack()
        }
    }

    private fun handleActionType(action: ActionContact) {
        val buttonStringResource = when (action) {
            ActionContact.CREATE -> R.string.save // Text for create action
            ActionContact.MODIFY -> R.string.save // Text for modify action
        }

        binding.buttonSave.text = getString(buttonStringResource)
    }

    private fun onCreateEvent() {
        val model = getModelFromValues()
        contactViewModel.createContact(model)
    }

    private fun onModifyEvent() {
        val model = getModelFromValues()
        contactViewModel.updateContact(model)
    }

    private fun getContactValues(): Triple<String, String, String> {
        return Triple(
            binding.tilContactName.editText?.text.toString(),
            binding.tilContactPhone.editText?.text.toString(),
            binding.tilContactEmail.editText?.text.toString()
        )
    }

    private fun getModelFromValues(): PersonModel {
        val contactValues = getContactValues()
        val contactName: String = contactValues.first
        val contactPhoneNumber: String = contactValues.second
        val contactEmail: String = contactValues.third

        return PersonModel(
            name = contactName,
            phone = contactPhoneNumber,
            email = contactEmail
        )
    }

    private fun setupOnModify() {
        binding.tilContactName.editText?.setText(
            arguments.model?.name.orEmpty(),
            TextView.BufferType.EDITABLE
        )
        binding.tilContactPhone.editText?.setText(
            arguments.model?.phone.orEmpty(),
            TextView.BufferType.EDITABLE
        )
        binding.tilContactEmail.editText?.setText(
            arguments.model?.email.orEmpty(),
            TextView.BufferType.EDITABLE
        )
    }

}

