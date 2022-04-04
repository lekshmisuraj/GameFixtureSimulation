package com.game.gamefixturesimulation

import android.app.Activity
import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat

class TeamHelper {

    companion object {
        fun getImage(activity:Activity, country: String): Drawable? {
            return when(country) {

                GroupA().team1 -> ResourcesCompat.getDrawable(
                    activity.resources,
                    R.drawable.ic_qatar,
                    null
                )
                GroupA().team2 -> ResourcesCompat.getDrawable(
                    activity.resources,
                    R.drawable.ic_ecuador,
                    null
                )
                GroupA().team3 -> ResourcesCompat.getDrawable(
                    activity.resources,
                    R.drawable.ic_senegal,
                    null
                )
                GroupA().team4 -> ResourcesCompat.getDrawable(
                    activity.resources,
                    R.drawable.ic_netherlands,
                    null
                )

                GroupB().team1 -> ResourcesCompat.getDrawable(
                    activity.resources,
                    R.drawable.ic_england,
                    null
                )
                GroupB().team2 -> ResourcesCompat.getDrawable(
                    activity.resources,
                    R.drawable.ic_iran,
                    null
                )
                GroupB().team3 -> ResourcesCompat.getDrawable(
                    activity.resources,
                    R.drawable.ic_usa,
                    null
                )
                GroupB().team4 -> ResourcesCompat.getDrawable(
                    activity.resources,
                    R.drawable.ic_football_strike,
                    null
                )

                GroupC().team1 -> ResourcesCompat.getDrawable(
                    activity.resources,
                    R.drawable.ic_argentina,
                    null
                )
                GroupC().team2 -> ResourcesCompat.getDrawable(
                    activity.resources,
                    R.drawable.ic_saudi,
                    null
                )
                GroupC().team3 -> ResourcesCompat.getDrawable(
                    activity.resources,
                    R.drawable.ic_mexico,
                    null
                )
                GroupC().team4 -> ResourcesCompat.getDrawable(
                    activity.resources,
                    R.drawable.ic_poland,
                    null
                )


                GroupD().team1 -> ResourcesCompat.getDrawable(
                    activity.resources,
                    R.drawable.ic_france,
                    null
                )
                GroupD().team2 -> ResourcesCompat.getDrawable(
                    activity.resources,
                    R.drawable.ic_football_strike,
                    null
                )
                GroupD().team3 -> ResourcesCompat.getDrawable(
                    activity.resources,
                    R.drawable.ic_denmark,
                    null
                )
                GroupD().team4 -> ResourcesCompat.getDrawable(
                    activity.resources,
                    R.drawable.ic_tunisia,
                    null
                )

                GroupE().team1 -> ResourcesCompat.getDrawable(
                    activity.resources,
                    R.drawable.ic_spain,
                    null
                )
                GroupE().team2 -> ResourcesCompat.getDrawable(
                    activity.resources,
                    R.drawable.ic_football_strike,
                    null
                )
                GroupE().team3 -> ResourcesCompat.getDrawable(
                    activity.resources,
                    R.drawable.ic_germany,
                    null
                )
                GroupE().team4 -> ResourcesCompat.getDrawable(
                    activity.resources,
                    R.drawable.ic_japan,
                    null
                )


                GroupF().team1 -> ResourcesCompat.getDrawable(
                    activity.resources,
                    R.drawable.ic_belgium,
                    null
                )
                GroupF().team2 -> ResourcesCompat.getDrawable(
                    activity.resources,
                    R.drawable.ic_canada,
                    null
                )
                GroupF().team3 -> ResourcesCompat.getDrawable(
                    activity.resources,
                    R.drawable.ic_morocco,
                    null
                )
                GroupF().team4 -> ResourcesCompat.getDrawable(
                    activity.resources,
                    R.drawable.ic_croatia,
                    null
                )


                GroupG().team1 -> ResourcesCompat.getDrawable(
                    activity.resources,
                    R.drawable.ic_brazil,
                    null
                )
                GroupG().team2 -> ResourcesCompat.getDrawable(
                    activity.resources,
                    R.drawable.ic_serbia,
                    null
                )
                GroupG().team3 -> ResourcesCompat.getDrawable(
                    activity.resources,
                    R.drawable.ic_switzerland,
                    null
                )
                GroupG().team4 -> ResourcesCompat.getDrawable(
                    activity.resources,
                    R.drawable.ic_cameroon,
                    null
                )


                GroupH().team1 -> ResourcesCompat.getDrawable(
                    activity.resources,
                    R.drawable.ic_portugal,
                    null
                )
                GroupH().team2 -> ResourcesCompat.getDrawable(
                    activity.resources,
                    R.drawable.ic_ghana,
                    null
                )
                GroupH().team3 -> ResourcesCompat.getDrawable(
                    activity.resources,
                    R.drawable.ic_uruguay,
                    null
                )
                GroupH().team4 -> ResourcesCompat.getDrawable(
                    activity.resources,
                    R.drawable.ic_south_korea,
                    null
                )

                else -> ResourcesCompat.getDrawable(
                    activity.resources,
                    R.drawable.ic_spain,
                    null
                )
            }
        }
    }

}