package com.game.gamefixturesimulation.data_layer.adapter


import android.content.ContentValues.TAG
import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.*
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.game.gamefixturesimulation.data_layer.TeamViewModel

import android.view.*
import com.game.gamefixturesimulation.GroupedItems
import com.game.gamefixturesimulation.R
import com.game.gamefixturesimulation.TeamHelper.Companion.getImage
import com.game.gamefixturesimulation.databinding.ItemItemBinding
import java.text.MessageFormat


class GroupStageAdapter(
    private var groups: MutableList<GroupedItems>,
    private val activity: FragmentActivity,
    private val listener: GroupStageAdapterListener
) :
    RecyclerView.Adapter<GroupStageAdapter.GroupStageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupStageViewHolder {

        return GroupStageViewHolder(
            ItemItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: GroupStageViewHolder, position: Int) {
        val game = groups[position]
        holder.onBind(game, activity)
    }

    override fun getItemCount(): Int {
        return groups.size
    }

    interface GroupStageAdapterListener {
        fun onTeamWinnerClick(selectedTeam: String, teams: GroupedItems, userSelected: Boolean)
        fun onTeamRunnerUpClick(selectedTeam: String, teams: GroupedItems, userSelected: Boolean)
    }

    fun getAllItems(): List<GroupedItems> {
        return groups
    }

    fun updateAll(items: MutableList<GroupedItems>) {
        groups = items
    }

    inner class GroupStageViewHolder(private val binding: ItemItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private lateinit var dataAdapter1: ArrayAdapter<String>
        private lateinit var dataAdapter2: ArrayAdapter<String>
        private lateinit var mGameTeams: GroupedItems
        private var userSelected = false
        private var isSpinner1UserSelected  = false
        private var isSpinner2UserSelected  = false

        fun onBind(gameTeams: GroupedItems, activity: FragmentActivity) {

            mGameTeams = gameTeams

            binding.group = mGameTeams

            dataAdapter1 = ArrayAdapter(
                activity,
                android.R.layout.simple_spinner_item,
                mGameTeams.teamWinnerItems
            )
            dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            dataAdapter2 = ArrayAdapter(
                activity,
                android.R.layout.simple_spinner_item,
                mGameTeams.teamLoserItems
            )
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            when (mGameTeams.id) {
                101 -> {
                    binding.cardView.setCardBackgroundColor(activity.resources.getColor(R.color.nice_blue))
                    binding.headerCard.setCardBackgroundColor(activity.resources.getColor(R.color.nice_blue))
                    binding.textViewHeader.text = MessageFormat.format(activity.resources.getString(
                        R.string.pre_quarter_match
                    ),
                        1)

                }
                102 -> {
                    binding.cardView.setCardBackgroundColor(activity.resources.getColor(R.color.nice_blue))
                    binding.headerCard.setCardBackgroundColor(activity.resources.getColor(R.color.nice_blue))
                    binding.textViewHeader.text = MessageFormat.format(activity.resources.getString(
                        R.string.pre_quarter_match
                    ),
                        5)
                }
                103 -> {
                    binding.cardView.setCardBackgroundColor(activity.resources.getColor(R.color.teal_green))
                    binding.headerCard.setCardBackgroundColor(activity.resources.getColor(R.color.teal_green))
                    binding.textViewHeader.text = MessageFormat.format(activity.resources.getString(
                        R.string.pre_quarter_match
                    ),
                        2)
                }
                104 -> {
                    binding.cardView.setCardBackgroundColor(activity.resources.getColor(R.color.grey_note))
                    binding.headerCard.setCardBackgroundColor(activity.resources.getColor(R.color.grey_note))
                    binding.textViewHeader.text = MessageFormat.format(activity.resources.getString(
                        R.string.pre_quarter_match
                    ),
                        6)
                }
                105 -> {
                    binding.cardView.setCardBackgroundColor(activity.resources.getColor(R.color.light_red))
                    binding.headerCard.setCardBackgroundColor(activity.resources.getColor(R.color.light_red))
                    binding.textViewHeader.text = MessageFormat.format(activity.resources.getString(
                        R.string.pre_quarter_match
                    ),
                        3)
                }
                106 -> {
                    binding.cardView.setCardBackgroundColor(activity.resources.getColor(R.color.teal_green))
                    binding.headerCard.setCardBackgroundColor(activity.resources.getColor(R.color.teal_green))
                    binding.textViewHeader.text = MessageFormat.format(activity.resources.getString(
                        R.string.pre_quarter_match
                    ),
                        7)
                }
                107 -> {
                    binding.cardView.setCardBackgroundColor(activity.resources.getColor(R.color.grey_note))
                    binding.headerCard.setCardBackgroundColor(activity.resources.getColor(R.color.grey_note))
                    binding.textViewHeader.text = MessageFormat.format(activity.resources.getString(
                        R.string.pre_quarter_match
                    ),
                        4)
                }
                108 -> {
                    binding.cardView.setCardBackgroundColor(activity.resources.getColor(R.color.light_red))
                    binding.headerCard.setCardBackgroundColor(activity.resources.getColor(R.color.light_red))
                    binding.textViewHeader.text = MessageFormat.format(activity.resources.getString(
                        R.string.pre_quarter_match
                    ),
                        8)
                }
            }

            val image1: Drawable? = getImage(activity, mGameTeams.selectedWinner!!)
            binding.headerImage1.setColorFilter(activity.resources.getColor(R.color.grape))
            binding.headerImage1.setBackgroundDrawable(image1)
            val image2: Drawable? = getImage(activity, mGameTeams.selectedRunnerUp!!)
            binding.headerImage2.setColorFilter(activity.resources.getColor(R.color.grape))
            binding.headerImage2.setBackgroundDrawable(image2)

            val winnerSelected = mGameTeams.selectedWinner
            val spinnerPositionWinner: Int = dataAdapter1.getPosition(winnerSelected)

            with(binding.spinnerWinner1)
            {
                adapter = dataAdapter1
                setSelection(spinnerPositionWinner, false)
                prompt = "Select your Winner team"
                gravity = Gravity.CENTER

            }

            binding.spinnerWinner1.setOnTouchListener { v, event ->
                isSpinner1UserSelected = true
                v.performClick()
                false
            }

            binding.spinnerWinner1.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                    if(isSpinner1UserSelected) {
                        val selectedTeam = mGameTeams.teamWinnerItems[position]
                        mGameTeams.selectedWinner = selectedTeam
                        listener.onTeamWinnerClick(selectedTeam, mGameTeams, userSelected)
                        isSpinner1UserSelected = false
                    }
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }
            }

            val runnerUpSelected = mGameTeams.selectedRunnerUp
                val spinnerPosition: Int = dataAdapter2.getPosition(runnerUpSelected)

            with(binding.spinnerWinner2)
            {
                adapter = dataAdapter2
                isSelected = false
                setSelection(spinnerPosition, true)
                prompt = "Select your Runner up team"
                gravity = Gravity.CENTER

            }
            binding.spinnerWinner2.setOnTouchListener { v, event ->
                isSpinner2UserSelected = true
                v.performClick()
                false
            }

            binding.spinnerWinner2.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                    if(isSpinner2UserSelected) {
                        val selectedTeam = mGameTeams.teamLoserItems[position]
                        mGameTeams.selectedRunnerUp = selectedTeam
                        listener.onTeamRunnerUpClick(selectedTeam, mGameTeams, userSelected)
                        isSpinner2UserSelected = false
                    }
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }
            }

        }
    }

}