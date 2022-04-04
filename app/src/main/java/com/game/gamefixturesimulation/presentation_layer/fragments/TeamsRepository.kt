package com.game.gamefixturesimulation.presentation_layer.fragments

import android.app.Application
import android.content.res.Resources
import com.game.gamefixturesimulation.*
import com.game.gamefixturesimulation.data_layer.TeamViewModel
import java.text.MessageFormat

class TeamsRepository(application: Application) {
    var app = application
    private val teamA = GroupA()
    private val teamB = GroupB()
    private val teamC = GroupC()
    private val teamD = GroupD()
    private val teamE = GroupE()
    private val teamF = GroupF()
    private val teamG = GroupG()
    private val teamH = GroupH()

    fun getFullTeamListInGroup(group: String): MutableList<String> {
       return  when(group) {
            "Group A" -> { //teamA will have 4 teams - team 1, team 2, team 3, team 4
                arrayListOf(teamA.team1, teamA.team2, teamA.team3, teamA.team4)
            }
            "Group B" -> {
                arrayListOf(teamB.team1, teamB.team2, teamB.team3, teamB.team4)
            }
            "Group C" -> {
                arrayListOf(teamC.team1, teamC.team2, teamC.team3, teamC.team4)
            }
            "Group D" -> {
                arrayListOf(teamD.team1, teamD.team2, teamD.team3, teamD.team4)
            }
            "Group E" -> {
                arrayListOf(teamE.team1, teamE.team2, teamE.team3, teamE.team4)
            }
            "Group F" -> {
                arrayListOf(teamF.team1, teamF.team2, teamF.team3, teamF.team4)
            }
            "Group G" -> {
                arrayListOf(teamG.team1, teamG.team2, teamG.team3, teamG.team4)
            }
            "Group H" -> {
                arrayListOf(teamH.team1, teamH.team2, teamH.team3, teamH.team4)
            }
           else -> {
               arrayListOf()
           }
        }
    }

    private fun createGroupedItemListAB(): List<GroupedItems> {
        val groupedItemList = arrayListOf<GroupedItems>()
        val headerText = "Group AB"
        val itemListA = arrayListOf(teamA.team1, teamA.team2, teamA.team3, teamA.team4)
        val itemListB = arrayListOf( teamB.team1, teamB.team2, teamB.team3, teamB.team4)
        val gItems = GroupedItems(101, headerText, 1, itemListA, itemListB)

        gItems.selectedWinner = teamA.team1
        gItems.selectedRunnerUp = teamB.team1

        gItems.selectionWinnerMap[false] = teamA.team1
        gItems.selectionRunnerUpMap[false] = teamB.team1

        var mHeader = headerText.substring(6, 7)

        gItems.winnerTitleText = MessageFormat.format(app.getString(R.string.select_group_winner_team),
            mHeader)
        mHeader = headerText.substring(7, 8)
        gItems.runnerUpTitleText = MessageFormat.format(app.getString(R.string.select_group_runner_team),
            mHeader)

        groupedItemList.add(gItems)

        return groupedItemList
    }

    private fun createGroupedItemListBA(): List<GroupedItems> {
        val groupedItemList = arrayListOf<GroupedItems>()

        val headerText = "Group BA"

        val itemListB = arrayListOf(teamA.team2, teamA.team1, teamA.team3, teamA.team4)
        val itemListA = arrayListOf(teamB.team2, teamB.team1, teamB.team3, teamB.team4)

        val gItems = GroupedItems(102, headerText, 1, itemListA, itemListB)
        gItems.selectedWinner = teamB.team2
        gItems.selectedRunnerUp = teamA.team2

        gItems.selectionWinnerMap[false] = teamB.team2
        gItems.selectionRunnerUpMap[false] = teamA.team2
        var mHeader = headerText.substring(6, 7)

        gItems.winnerTitleText = MessageFormat.format(app.getString(R.string.select_group_winner_team),
            mHeader)
        mHeader = headerText.substring(7, 8)
        gItems.runnerUpTitleText = MessageFormat.format(app.getString(R.string.select_group_runner_team),
            mHeader)

        groupedItemList.add(gItems)

        return groupedItemList
    }

    private fun createGroupedItemListCD(): List<GroupedItems> {
        val groupedItemList = arrayListOf<GroupedItems>()

        val headerText = "Group CD"
        val teamC = GroupC()
        val teamD = GroupD()

        val itemListC = arrayListOf(teamC.team1, teamC.team2, teamC.team3, teamC.team4)
        val itemListD = arrayListOf( teamD.team1, teamD.team2, teamD.team3, teamD.team4)

        val gItems = GroupedItems(103, headerText, 2, itemListC, itemListD)
        gItems.selectedWinner = teamC.team1
        gItems.selectedRunnerUp = teamD.team1

        gItems.selectionWinnerMap[false] = teamC.team1
        gItems.selectionRunnerUpMap[false] = teamD.team1

        var mHeader = headerText.substring(6, 7)

        gItems.winnerTitleText = MessageFormat.format(app.getString(R.string.select_group_winner_team),
            mHeader)
        mHeader = headerText.substring(7, 8)
        gItems.runnerUpTitleText = MessageFormat.format(app.getString(R.string.select_group_runner_team),
            mHeader)

        groupedItemList.add(gItems)

        return groupedItemList
    }

    private fun createGroupedItemListDC(): List<GroupedItems> {
        val groupedItemList = arrayListOf<GroupedItems>()

        val headerText = "Group DC"

        val itemListD = arrayListOf( teamC.team2, teamC.team1, teamC.team3, teamC.team4)
        val itemListC = arrayListOf( teamD.team2, teamD.team1, teamD.team3, teamD.team4)


        val gItems = GroupedItems(104, headerText, 2, itemListC, itemListD)

        gItems.selectedWinner = teamD.team2
        gItems.selectedRunnerUp = teamC.team2

        gItems.selectionWinnerMap[false] = teamD.team2
        gItems.selectionRunnerUpMap[false] = teamC.team2
        var mHeader = headerText.substring(6, 7)

        gItems.winnerTitleText = MessageFormat.format(app.getString(R.string.select_group_winner_team),
            mHeader)
        mHeader = headerText.substring(7, 8)
        gItems.runnerUpTitleText = MessageFormat.format(app.getString(R.string.select_group_runner_team),
            mHeader)

        groupedItemList.add(gItems)

        return groupedItemList
    }

    private fun createGroupedItemListEF(): List<GroupedItems> {
        val groupedItemList = arrayListOf<GroupedItems>()

        val headerText = "Group EF"
        val itemListE = arrayListOf( teamE.team1, teamE.team2, teamE.team3, teamE.team4)
        val itemListF = arrayListOf( teamF.team1, teamF.team2, teamF.team3, teamF.team4)

        val gItems = GroupedItems(105, headerText, 3, itemListE, itemListF)
        gItems.selectedWinner = teamE.team1
        gItems.selectedRunnerUp = teamF.team1

        gItems.selectionWinnerMap[false] = teamE.team1
        gItems.selectionRunnerUpMap[false] = teamF.team1
        var mHeader = headerText.substring(6, 7)

        gItems.winnerTitleText = MessageFormat.format(app.getString(R.string.select_group_winner_team),
            mHeader)
        mHeader = headerText.substring(7, 8)
        gItems.runnerUpTitleText = MessageFormat.format(app.getString(R.string.select_group_runner_team),
            mHeader)

        groupedItemList.add(gItems)

        return groupedItemList
    }

    private fun createGroupedItemListFE(): List<GroupedItems> {
        val groupedItemList = arrayListOf<GroupedItems>()

        val headerText = "Group FE"
        val itemListF = arrayListOf( teamE.team2, teamE.team1, teamE.team3, teamE.team4)
        val itemListE = arrayListOf( teamF.team2, teamF.team1, teamF.team3, teamF.team4)

        val gItems = GroupedItems(106, headerText, 3, itemListE, itemListF)

        gItems.selectedWinner = teamF.team2
        gItems.selectedRunnerUp = teamE.team2

        gItems.selectionWinnerMap[false] = teamF.team2
        gItems.selectionRunnerUpMap[false] = teamE.team2

        var mHeader = headerText.substring(6, 7)

        gItems.winnerTitleText = MessageFormat.format(app.getString(R.string.select_group_winner_team),
            mHeader)
        mHeader = headerText.substring(7, 8)
        gItems.runnerUpTitleText = MessageFormat.format(app.getString(R.string.select_group_runner_team),
            mHeader)

        groupedItemList.add(gItems)

        return groupedItemList
    }

    private fun createGroupedItemListGH(): List<GroupedItems> {
        val groupedItemList = arrayListOf<GroupedItems>()

        val headerText = "Group GH"

        val itemListG = arrayListOf( teamG.team1, teamG.team2, teamG.team3, teamG.team4)
        val itemListH = arrayListOf( teamH.team1, teamH.team2, teamH.team3, teamH.team4)

        val gItems = GroupedItems(107, headerText, 4, itemListG, itemListH)
        gItems.selectedWinner = teamG.team1
        gItems.selectedRunnerUp = teamH.team1

        gItems.selectionWinnerMap[false] = teamG.team1
        gItems.selectionRunnerUpMap[false] = teamH.team1


        var mHeader = headerText.substring(6, 7)

        gItems.winnerTitleText = MessageFormat.format(app.getString(R.string.select_group_winner_team),
            mHeader)
        mHeader = headerText.substring(7, 8)
        gItems.runnerUpTitleText = MessageFormat.format(app.getString(R.string.select_group_runner_team),
            mHeader)

        groupedItemList.add(gItems)
        return groupedItemList
    }

    private fun createGroupedItemListHG(): List<GroupedItems> {
        val groupedItemList = arrayListOf<GroupedItems>()

        val headerText = "Group HG"
        val itemListH = arrayListOf( teamG.team2, teamG.team1, teamG.team3, teamG.team4)
        val itemListG = arrayListOf( teamH.team2, teamH.team1, teamH.team3, teamH.team4)

        val gItems = GroupedItems(108, headerText, 4, itemListG, itemListH)
        gItems.selectedWinner = teamH.team2
        gItems.selectedRunnerUp = teamG.team2

        gItems.selectionWinnerMap[false] = teamH.team2
        gItems.selectionRunnerUpMap[false] = teamG.team2
        var mHeader = headerText.substring(6, 7)

        gItems.winnerTitleText = MessageFormat.format(app.getString(R.string.select_group_winner_team),
            mHeader)
        mHeader = headerText.substring(7, 8)
        gItems.runnerUpTitleText = MessageFormat.format(app.getString(R.string.select_group_runner_team),
            mHeader)

        groupedItemList.add(gItems)

        return groupedItemList
    }

    fun getRound16TeamStructure(): ArrayList<GroupedItems> {
        val fullList = arrayListOf<GroupedItems>()

        fullList.addAll(createGroupedItemListAB())
        fullList.addAll(createGroupedItemListCD())
        fullList.addAll(createGroupedItemListEF())
        fullList.addAll(createGroupedItemListGH())
        fullList.addAll(createGroupedItemListBA())
        fullList.addAll(createGroupedItemListDC())
        fullList.addAll(createGroupedItemListFE())
        fullList.addAll(createGroupedItemListHG())
        return fullList
    }

}