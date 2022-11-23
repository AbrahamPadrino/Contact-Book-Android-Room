package com.example.contactbook_androidroom.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contactbook_androidroom.R
import com.example.contactbook_androidroom.adapter.ItemAdapter
import com.example.contactbook_androidroom.data.ContactDataSourceBuilder
import com.example.contactbook_androidroom.databinding.FragmentListContactsBinding
import com.example.contactbook_androidroom.view.models.Person

class ListContactsFragment : Fragment() {

    private lateinit var _binding: FragmentListContactsBinding

    private val binding get() = _binding

    private lateinit var recyclerView: RecyclerView

    private val contactAdapter = ItemAdapter()

    private val contacts: List<Person>
        get() = ContactDataSourceBuilder(requireContext()).getContacts()

    private lateinit var addContact: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListContactsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        addContact = view.findViewById(R.id.floating_action_button)
        addContact.setOnClickListener {
            Toast.makeText(view.context, "**Agregar Nuevo Contacto**", Toast.LENGTH_LONG).show()

            val action =
                ListContactsFragmentDirections.actionListContactsFragmentToAddContactFragment()
            addContact.findNavController().navigate(action)

        }


        contactAdapter.add(contacts)

        recyclerView = binding.recyclerView

        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = contactAdapter

    }


}