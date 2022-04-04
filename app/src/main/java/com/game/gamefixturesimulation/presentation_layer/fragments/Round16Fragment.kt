package com.game.gamefixturesimulation.presentation_layer.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.game.gamefixturesimulation.*
import com.game.gamefixturesimulation.data_layer.TeamViewModel
import com.game.gamefixturesimulation.data_layer.adapter.GroupStageAdapter
import com.game.gamefixturesimulation.databinding.FragmentRound16Binding
import androidx.annotation.NonNull

class Round16Fragment : Fragment(), GroupStageAdapter.GroupStageAdapterListener {

    private val viewModel: TeamViewModel by activityViewModels()
    private lateinit var binding: FragmentRound16Binding
    private lateinit var round16FullList: MutableList<GroupedItems>
    private lateinit var mAdapter: GroupStageAdapter
    lateinit var callback: OnBackPressedCallback

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_round_16, container, false)

        round16FullList = viewModel.fullList

        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.setHasFixedSize(true)
        mAdapter = activity.let {
            GroupStageAdapter(round16FullList, it!!, this)
        }
        binding.recyclerView.adapter = mAdapter
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.updatedRound16List.observe(viewLifecycleOwner, {
            mAdapter.updateAll(it)
            mAdapter.notifyDataSetChanged()
        })

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
         callback = object : OnBackPressedCallback(
            true
        ) {
            override fun handleOnBackPressed() {

                if(findNavController().previousBackStackEntry?.destination?.id == R.id.navigation_final) {
                    findNavController().navigate(R.id.navigation_teamNameFragment)
                }
                else {
                    findNavController().popBackStack()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            callback
        )
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_next, menu)
        return super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {

        R.id.next -> {
            val allItems = mAdapter.getAllItems()
            viewModel.createQuarterList(allItems)
            findNavController().navigate(R.id.navigation_quarter)
            true
        }

        android.R.id.home -> {
            callback.handleOnBackPressed()
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }

    }


    override fun onTeamRunnerUpClick(
        selectedTeam: String,
        teams: GroupedItems,
        userSelected: Boolean
    ) {
        teams.selectedRunnerUp = selectedTeam
        teams.selectionRunnerUpMap[true] = selectedTeam
        viewModel.updateRound16TeamList(selectedTeam, teams, false)
        mAdapter.notifyDataSetChanged()
    }

    override fun onTeamWinnerClick(
        selectedTeam: String,
        teams: GroupedItems,
        userSelected: Boolean
    ) {
        teams.selectedWinner = selectedTeam
        teams.selectionWinnerMap[true] = selectedTeam
        viewModel.updateRound16TeamList(selectedTeam, teams, true)
        mAdapter.notifyDataSetChanged()
    }


}

