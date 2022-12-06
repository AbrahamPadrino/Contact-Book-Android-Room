package com.example.contactbook_androidroom.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contactbook_androidroom.ContactBookApplication
import com.example.contactbook_androidroom.R
import com.example.contactbook_androidroom.ui.adapter.ItemAdapter
import com.example.contactbook_androidroom.databinding.FragmentListContactsBinding
import com.example.contactbook_androidroom.ui.viewmodels.ContactViewModel
import com.example.contactbook_androidroom.ui.viewmodels.ContactViewModelFactory

class ListContactsFragment : Fragment() {

    private lateinit var binding: FragmentListContactsBinding

    private val contactViewModel : ContactViewModel by viewModels {
        ContactViewModelFactory((requireActivity().application as ContactBookApplication).repository)
    }

    private val contactAdapter = ItemAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListContactsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupViews()
    }

    private fun setupViews() {
        contactViewModel.getContacts()
        setupViewModel()
        setupRecyclerView()
        setupViewEvents()
    }

    private fun setupViewEvents() {
        binding.floatingActionButton.setOnClickListener {
                val action = ListContactsFragmentDirections
                    .actionListContactsFragmentToAddContactFragment()
                findNavController().navigate(action)
        }
    }

    private fun setupViewModel() {
        contactViewModel.liveData.observe(viewLifecycleOwner) {
            contactAdapter.add(it)
        }
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
            )
            adapter = contactAdapter
        }
    }

}