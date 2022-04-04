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
import com.game.gamefixturesimulation.data_layer.adapter.FinalAdapter
import com.game.gamefixturesimulation.databinding.FragmentFinalBinding
import java.text.MessageFormat

class FinalFragment: Fragment(), FinalAdapter.FinalAdapterListener {

    private val viewModel: TeamViewModel by activityViewModels()
    private lateinit var binding: FragmentFinalBinding
    private lateinit var finalistList: ArrayList<GroupedItemsQuarter>
    private lateinit var mAdapter: FinalAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_final, container, false)

        finalistList = viewModel.fullListFinal
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.setHasFixedSize(true)

        mAdapter = activity.let{
            FinalAdapter(finalistList, it!!, this)
        }

        binding.recyclerView.adapter = mAdapter
        binding.lifecycleOwner = viewLifecycleOwner
        binding.startOver.setOnClickListener {
            findNavController().navigate(R.id.navigation_round16)
        }
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
            item.isEnabled = false
            binding.recyclerView.isEnabled = false
            actionNext(allItems)
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    private fun actionNext(items: List<GroupedItemsQuarter>) {
        val winner1 = items[0].selectedWinner1
        val winner2 = items[0].selectedWinner2

        binding.tv3.text = MessageFormat.format(requireActivity().resources.getString(R.string.congratulations_3),
            winner1, winner2)
        binding.startOver.visibility = View.VISIBLE
        binding.tv1.visibility = View.VISIBLE
        binding.tv2.visibility = View.VISIBLE
        binding.tv3.visibility = View.VISIBLE

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

