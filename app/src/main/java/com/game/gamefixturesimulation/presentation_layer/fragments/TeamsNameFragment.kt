package com.game.gamefixturesimulation.presentation_layer.fragments

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.game.gamefixturesimulation.*
import com.game.gamefixturesimulation.data_layer.TeamViewModel
import com.game.gamefixturesimulation.data_layer.adapter.TeamNamesAdapter
import com.game.gamefixturesimulation.databinding.FragmentTeamNamesBinding

class TeamsNameFragment: Fragment() {

    private val viewModel: TeamViewModel by activityViewModels()
    private lateinit var binding: FragmentTeamNamesBinding
    private lateinit var mAdapter: TeamNamesAdapter
    private lateinit var teamsFullList: MutableList<GroupNames>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_team_names, container, false)

        teamsFullList = viewModel.getFullTeamsList()

        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.setHasFixedSize(true)
        mAdapter = activity.let {
            TeamNamesAdapter(teamsFullList, it!!)
        }
        binding.recyclerView.adapter = mAdapter
        binding.lifecycleOwner = viewLifecycleOwner

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_next, menu)

        // Configure the search info and add any event listeners...

        return super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.next -> {
            findNavController().navigate(R.id.navigation_round16)
            true
        }

        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }


}