package com.example.gloomrecorder.characters.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.gloomrecorder.base.recyclerview.BaseRvAdapter
import com.example.gloomrecorder.base.recyclerview.BaseViewHolder
import com.example.gloomrecorder.characters.viewmodel.CharactersViewModel
import com.example.gloomrecorder.databinding.FragmentCharactersBinding
import com.example.gloomrecorder.databinding.ItemCharacterSummaryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersFragment : Fragment() {

    companion object {
        fun newInstance() = CharactersFragment()
    }

    private val viewModel: CharactersViewModel by viewModels()
    private lateinit var binding: FragmentCharactersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharactersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = object : BaseRvAdapter<String>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<String> {
                return object : BaseViewHolder<String>(ItemCharacterSummaryBinding.inflate(layoutInflater,binding.charactersRecycler,false)){
                    override fun bind(item: String) {
                        (this.databinding as ItemCharacterSummaryBinding).item = item
                    }
                }
            }
        }

        binding.charactersRecycler.adapter = adapter

        adapter.items = viewModel.list
    }
}