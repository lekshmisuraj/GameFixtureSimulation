package com.game.gamefixturesimulation.data_layer.adapter


import android.content.ContentValues.TAG
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.game.gamefixturesimulation.GroupedItemsQuarter
import com.game.gamefixturesimulation.R
import com.game.gamefixturesimulation.TeamHelper
import com.game.gamefixturesimulation.databinding.ItemQsfBinding
import java.text.MessageFormat

class QuarterFinalAdapter(
    private val groups: ArrayList<GroupedItemsQuarter>,
    private val activity: FragmentActivity,
    private val listener: QuarterFinalAdapterListener
) :
    RecyclerView.Adapter<QuarterFinalAdapter.QuarterFinalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuarterFinalViewHolder {
        return QuarterFinalViewHolder(
            ItemQsfBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: QuarterFinalViewHolder, position: Int) {
        val game = groups[position]
        holder.onBind(game, activity)
    }

    override fun getItemCount(): Int {
        return groups.size
    }

    fun getAllItems(): List<GroupedItemsQuarter> {
        return groups
    }

    interface QuarterFinalAdapterListener {
        fun onTeamWinner1Click(selectedTeam: String, teams: GroupedItemsQuarter)
        fun onTeamWinner2Click(selectedTeam: String, teams: GroupedItemsQuarter)
    }

    inner class QuarterFinalViewHolder(private val binding: ItemQsfBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var dataAdapter1: ArrayAdapter<String>
        private lateinit var dataAdapter2: ArrayAdapter<String>
        private lateinit var mGameTeams: GroupedItemsQuarter
        private var isSpinner1UserSelected = false
        private var isSpinner2UserSelected = false

        fun onBind(
            gameTeams: GroupedItemsQuarter,
            activity: FragmentActivity
        ) {

            mGameTeams = gameTeams

            dataAdapter1 = ArrayAdapter(
                activity,
                android.R.layout.simple_spinner_item,
                mGameTeams.teamWinner1Items
            )
            dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            dataAdapter2 = ArrayAdapter(
                activity,
                android.R.layout.simple_spinner_item,
                mGameTeams.teamWinner2Items
            )
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            val winnerSelected = mGameTeams.selectedWinner1
            val spinnerPositionWinner: Int = dataAdapter1.getPosition(winnerSelected)

            binding.spinnerWinner1.setOnTouchListener { v, event ->
                isSpinner1UserSelected = true
                v.performClick()

                false
            }

            with(binding.spinnerWinner1)
            {
                adapter = dataAdapter1
                setSelection(spinnerPositionWinner, false)
                prompt = "Select your Winner team"
                gravity = android.view.Gravity.CENTER

            }

            binding.spinnerWinner1.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                    if (isSpinner1UserSelected) {
                        val selectedTeam = mGameTeams.teamWinner1Items[position]
                        listener.onTeamWinner1Click(
                            selectedTeam,
                            mGameTeams
                        )
                        isSpinner1UserSelected = false
                    }
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {}
            }

            val runnerUpSelected = mGameTeams.selectedWinner2
            val spinnerPosition: Int = dataAdapter2.getPosition(runnerUpSelected)

            binding.spinnerWinner2.setOnTouchListener { v, event ->
                isSpinner2UserSelected = true
                v.performClick()
                false
            }

            with(binding.spinnerWinner2)
            {
                adapter = dataAdapter2
                setSelection(spinnerPosition, false)
                prompt = "Select your Runner up team"
                gravity = android.view.Gravity.CENTER

            }

            binding.spinnerWinner2.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    if (isSpinner2UserSelected) {
                        val selectedTeam = mGameTeams.teamWinner2Items[position]
                        listener.onTeamWinner2Click(
                            selectedTeam,
                            mGameTeams
                        )
                        isSpinner2UserSelected = false
                    }
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {}
            }

            when (mGameTeams.id) {
                0 -> {
                    binding.cardView.setCardBackgroundColor(activity.resources.getColor(R.color.nice_blue));
                    binding.headerCard.setCardBackgroundColor(activity.resources.getColor(R.color.nice_blue))
                    binding.textViewHeader.text = MessageFormat.format(
                        activity.resources.getString(R.string.quarter_final),
                        1
                    )
                    binding.tvmatch1.text = MessageFormat.format(
                        activity.resources.getString(R.string.select_winner_of_pre_quarter_1),
                        1
                    )
                    binding.tvmatch2.text = MessageFormat.format(
                        activity.resources.getString(R.string.select_winner_of_pre_quarter_2),
                        2
                    )

                }
                1 -> {
                    binding.cardView.setCardBackgroundColor(activity.resources.getColor(R.color.sap_green))
                    binding.headerCard.setCardBackgroundColor(activity.resources.getColor(R.color.sap_green))
                    binding.textViewHeader.text = MessageFormat.format(
                        activity.resources.getString(R.string.quarter_final),
                        2
                    )
                    binding.tvmatch1.text = MessageFormat.format(
                        activity.resources.getString(R.string.select_winner_of_pre_quarter_1),
                        3
                    )
                    binding.tvmatch2.text = MessageFormat.format(
                        activity.resources.getString(R.string.select_winner_of_pre_quarter_2),
                        4
                    )
                }
                2 -> {
                    binding.cardView.setCardBackgroundColor(activity.resources.getColor(R.color.teal_green))
                    binding.headerCard.setCardBackgroundColor(activity.resources.getColor(R.color.teal_green))
                    binding.textViewHeader.text = MessageFormat.format(
                        activity.resources.getString(R.string.quarter_final),
                        3
                    )
                    binding.tvmatch1.text = MessageFormat.format(
                        activity.resources.getString(R.string.select_winner_of_pre_quarter_1),
                        5
                    )
                    binding.tvmatch2.text = MessageFormat.format(
                        activity.resources.getString(R.string.select_winner_of_pre_quarter_2),
                        6
                    )
                }
                3 -> {
                    binding.cardView.setCardBackgroundColor(activity.resources.getColor(R.color.light_red))
                    binding.headerCard.setCardBackgroundColor(activity.resources.getColor(R.color.light_red))
                    binding.textViewHeader.text = MessageFormat.format(
                        activity.resources.getString(R.string.quarter_final),
                        4
                    )
                    binding.tvmatch1.text = MessageFormat.format(
                        activity.resources.getString(R.string.select_winner_of_pre_quarter_1),
                        7
                    )
                    binding.tvmatch2.text = MessageFormat.format(
                        activity.resources.getString(R.string.select_winner_of_pre_quarter_2),
                        8
                    )
                }
            }

            val image1: Drawable? = TeamHelper.getImage(activity, mGameTeams.selectedWinner1!!)
            binding.headerImage1.setColorFilter(activity.resources.getColor(R.color.grape))
            binding.headerImage1.setBackgroundDrawable(image1)
            val image2: Drawable? = TeamHelper.getImage(activity, mGameTeams.selectedWinner2!!)
            binding.headerImage2.setColorFilter(activity.resources.getColor(R.color.grape))
            binding.headerImage2.setBackgroundDrawable(image2)

        }

    }

}