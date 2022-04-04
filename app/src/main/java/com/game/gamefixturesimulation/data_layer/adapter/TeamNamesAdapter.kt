package com.game.gamefixturesimulation.data_layer.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.game.gamefixturesimulation.GroupNames
import com.game.gamefixturesimulation.R
import com.game.gamefixturesimulation.TeamHelper.Companion.getImage
import com.game.gamefixturesimulation.databinding.ItemTeamBinding

class TeamNamesAdapter(
    private val groups: MutableList<GroupNames>,
    private val activity: FragmentActivity
) :
    RecyclerView.Adapter<TeamNamesAdapter.TeamNameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamNameViewHolder {
        return TeamNameViewHolder(
            ItemTeamBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: TeamNameViewHolder, position: Int) {
        val group = groups[position]
        holder.onBind(group, activity)
    }

    override fun getItemCount(): Int {
        return groups.size
    }

    inner class TeamNameViewHolder(private val binding: ItemTeamBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(
            group: GroupNames,
            activity: FragmentActivity
        ) {

            when(group.header) {
                "Group A" -> {
                    binding.cardView.setCardBackgroundColor(activity.resources.getColor(R.color.nice_blue));
                }
                "Group B" -> {
                    binding.cardView.setCardBackgroundColor(activity.resources.getColor(R.color.teal_green));
                }
                "Group C" -> {
                    binding.cardView.setCardBackgroundColor(activity.resources.getColor(R.color.grey_note));
                }
                "Group D" -> {
                    binding.cardView.setCardBackgroundColor(activity.resources.getColor(R.color.grassy_green));
                }
                "Group E" -> {
                    binding.cardView.setCardBackgroundColor(activity.resources.getColor(R.color.very_light_blue));
                }
                "Group F" -> {
                    binding.cardView.setCardBackgroundColor(activity.resources.getColor(R.color.light_red));
                }
                "Group G" -> {
                    binding.cardView.setCardBackgroundColor(activity.resources.getColor(R.color.grape_light));
                }
                "Group H" -> {
                    binding.cardView.setCardBackgroundColor(activity.resources.getColor(R.color.grey_note));
                }
            }
            binding.teamA.text = group.team1
            binding.teamB.text = group.team2
            binding.teamC.text = group.team3
            binding.teamD.text = group.team4
            binding.textViewHeader.text = group.header
            binding.headerImage1.setImageDrawable(getImage(activity, group.team1))
            binding.headerImage2.setImageDrawable(getImage(activity, group.team2))
            binding.headerImage3.setImageDrawable(getImage(activity, group.team3))
            binding.headerImage4.setImageDrawable(getImage(activity, group.team4))

        }

    }
}