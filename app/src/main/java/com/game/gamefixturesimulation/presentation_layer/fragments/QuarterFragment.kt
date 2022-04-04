package com.game.gamefixturesimulation.presentation_layer.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.game.gamefixturesimulation.*
import com.game.gamefixturesimulation.data_layer.TeamViewModel
import com.game.gamefixturesimulation.data_layer.adapter.QuarterFinalAdapter
import com.game.gamefixturesimulation.databinding.FragmentQuarterBinding

class QuarterFragment: Fragment(), QuarterFinalAdapter.QuarterFinalAdapterListener {

    private val viewModel: TeamViewModel by activityViewModels()
    private lateinit var binding: FragmentQuarterBinding
    private lateinit var quarterFinalistList: ArrayList<GroupedItemsQuarter>
    private lateinit var mAdapter: QuarterFinalAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_quarter, container, false)

        quarterFinalistList = viewModel.fullListQuarter
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.setHasFixedSize(true)

        mAdapter = activity.let{
            QuarterFinalAdapter(quarterFinalistList, it!!, this)
        }

        binding.recyclerView.adapter = mAdapter
        binding.lifecycleOwner = viewLifecycleOwner

        requireActivity().onBackPressedDispatcher.addCallback(object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().popBackStack()
            }
        })

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_next, menu)

        return super.onCreateOptionsMenu(menu,inflater)
    }


    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.next -> {
            val allItems = mAdapter.getAllItems()
            viewModel.createSemiFinalList(allItems)
            findNavController().navigate(R.id.navigation_semiFinal)
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    override fun onTeamWinner1Click(selectedTeam: String, teams: GroupedItemsQuarter) {
        teams.selectedWinner1 = selectedTeam
        mAdapter.notifyDataSetChanged()
    }

    override fun onTeamWinner2Click(selectedTeam: String, teams: GroupedItemsQuarter) {
        teams.selectedWinner2 = selectedTeam
        mAdapter.notifyDataSetChanged()
    }

}

