package com.game.gamefixturesimulation.data_layer

import android.app.Application
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.game.gamefixturesimulation.*
import com.game.gamefixturesimulation.presentation_layer.fragments.TeamsRepository

class TeamViewModel(application: Application) : AndroidViewModel(application) {

    var fullList: MutableList<GroupedItems> = arrayListOf()
    var fullListQuarter = arrayListOf<GroupedItemsQuarter>()
    var fullListSemiFinal = arrayListOf<GroupedItemsQuarter>()
    var fullListFinal = arrayListOf<GroupedItemsQuarter>()

    var app = application
    var teamsRepository = TeamsRepository(app)

    init {
        createGroupStageList()
    }

    private val mUpdatedRound16List: MutableLiveData<MutableList<GroupedItems>> by lazy {
        MutableLiveData<MutableList<GroupedItems>>()
    }
    val updatedRound16List: LiveData<MutableList<GroupedItems>> get() = mUpdatedRound16List

    private fun createGroupStageList(): MutableList<GroupedItems> {
        fullList = teamsRepository.getRound16TeamStructure()
        return fullList
    }

    fun getFullTeamsList(): MutableList<GroupNames> {
        val groupNameA = GroupNames()
        val groupNameB = GroupNames()
        val groupNameC = GroupNames()
        val groupNameD = GroupNames()
        val groupNameE = GroupNames()
        val groupNameF = GroupNames()
        val groupNameG = GroupNames()
        val groupNameH = GroupNames()
        val list = arrayListOf<GroupNames>()

        val teamA = GroupA()

        groupNameA.header = "Group A"
        groupNameA.team1 = teamA.team1
        groupNameA.team2 = teamA.team2
        groupNameA.team3 = teamA.team3
        groupNameA.team4 = teamA.team4

        val teamB = GroupB()
        groupNameB.header = "Group B"
        groupNameB.team1 = teamB.team1
        groupNameB.team2 = teamB.team2
        groupNameB.team3 = teamB.team3
        groupNameB.team4 = teamB.team4

        val teamC = GroupC()
        groupNameC.header = "Group C"
        groupNameC.team1 = teamC.team1
        groupNameC.team2 = teamC.team2
        groupNameC.team3 = teamC.team3
        groupNameC.team4 = teamC.team4

        val teamD = GroupD()
        groupNameD.header = "Group D"
        groupNameD.team1 = teamD.team1
        groupNameD.team2 = teamD.team2
        groupNameD.team3 = teamD.team3
        groupNameD.team4 = teamD.team4

        val teamE = GroupE()
        groupNameE.header = "Group E"
        groupNameE.team1 = teamE.team1
        groupNameE.team2 = teamE.team2
        groupNameE.team3 = teamE.team3
        groupNameE.team4 = teamE.team4

        val teamF = GroupF()
        groupNameF.header = "Group F"
        groupNameF.team1 = teamF.team1
        groupNameF.team2 = teamF.team2
        groupNameF.team3 = teamF.team3
        groupNameF.team4 = teamF.team4

        val teamG = GroupG()
        groupNameG.header = "Group G"
        groupNameG.team1 = teamG.team1
        groupNameG.team2 = teamG.team2
        groupNameG.team3 = teamG.team3
        groupNameG.team4 = teamG.team4

        val teamH = GroupH()
        groupNameH.header = "Group H"
        groupNameH.team1 = teamH.team1
        groupNameH.team2 = teamH.team2
        groupNameH.team3 = teamH.team3
        groupNameH.team4 = teamH.team4

        list.addAll(listOf(groupNameA))
        list.addAll(listOf(groupNameB))
        list.addAll(listOf(groupNameC))
        list.addAll(listOf(groupNameD))
        list.addAll(listOf(groupNameE))
        list.addAll(listOf(groupNameF))
        list.addAll(listOf(groupNameG))
        list.addAll(listOf(groupNameH))
        return list
    }

    fun createQuarterList(items: List<GroupedItems>) {
        var i = 0
        var j = 0
        val quarterList: ArrayList<GroupedItemsQuarter> = ArrayList()
        while (i < items.size) {
            val winner1: ArrayList<String> = ArrayList()
            winner1.add(items[i].selectedWinner!!)
            winner1.add(items[i].selectedRunnerUp!!)

            val winner2: ArrayList<String> = ArrayList()
            winner2.add(items[i + 1].selectedWinner!!)
            winner2.add(items[i + 1].selectedRunnerUp!!)
            val item = GroupedItemsQuarter(j, "Quarter Final 1", winner1, winner2)
            item.selectedWinner1 = winner1.component1()
            item.selectedWinner2 = winner2.component1()
            quarterList.add(item)
            i += 2
            j += 1
        }
        fullListQuarter = quarterList
    }

    fun createSemiFinalList(items: List<GroupedItemsQuarter>) {
        var i = 0
        var j = 0
        val semiFinalList: ArrayList<GroupedItemsQuarter> = ArrayList()
        while (i < items.size) {
            val winner1: ArrayList<String> = ArrayList()
            winner1.add(items[i].selectedWinner1!!)
            winner1.add(items[i].selectedWinner2!!)

            val winner2: ArrayList<String> = ArrayList()
            winner2.add(items[i + 1].selectedWinner1!!)
            winner2.add(items[i + 1].selectedWinner2!!)
            val item = GroupedItemsQuarter(j, "Semi Final 1", winner1, winner2)
            item.selectedWinner1 = winner1.component1()
            item.selectedWinner2 = winner2.component1()
            semiFinalList.add(item)
            i += 2
            j += 1
        }
        fullListSemiFinal = semiFinalList
    }

    fun createFinalList(items: List<GroupedItemsQuarter>) {
        var i = 0
        var j = 0
        val finalList: ArrayList<GroupedItemsQuarter> = ArrayList()
        while (i < items.size) {
            val winner1: ArrayList<String> = ArrayList()
            winner1.add(items[i].selectedWinner1!!)
            winner1.add(items[i].selectedWinner2!!)

            val winner2: ArrayList<String> = ArrayList()
            winner2.add(items[i + 1].selectedWinner1!!)
            winner2.add(items[i + 1].selectedWinner2!!)
            val item = GroupedItemsQuarter(j, "Semi Final 1", winner1, winner2)
            item.selectedWinner1 = winner1.component1()
            item.selectedWinner2 = winner2.component1()
            finalList.add(item)
            i += 2
            j += 1
        }
        fullListFinal = finalList
    }

    fun updateRound16TeamList(selectedTeam: String, teams: GroupedItems, isWinner: Boolean) {
        val temp = fullList
        val mGroupType = teams.groupType
        val mId = teams.id

        if (isWinner) {
            for (groupedItem in temp) {
                if (groupedItem.groupType == mGroupType) {
                    if (mId != groupedItem.id) {
                        val groupName = groupedItem.header.substring(7)
                        val group = "Group $groupName"
                        val fullTeamList = teamsRepository.getFullTeamListInGroup(group)
                        fullTeamList.remove(selectedTeam)
                        groupedItem.teamLoserItems.clear()
                        groupedItem.teamLoserItems.addAll(fullTeamList)
                        if(!groupedItem.selectionRunnerUpMap.containsKey(true)) {
                            groupedItem.selectedRunnerUp = fullTeamList[0]
                        }
                        break
                    }
                }
            }

        } else {
            for (groupedItem in temp) {
                if (groupedItem.groupType == mGroupType) {
                    if (mId != groupedItem.id) {
                        val groupName = groupedItem.header.substring(6, 7)
                        val group = "Group $groupName"
                        val fullTeamList = teamsRepository.getFullTeamListInGroup(group)
                        fullTeamList.remove(selectedTeam)
                        groupedItem.teamWinnerItems.clear()
                        groupedItem.teamWinnerItems.addAll(fullTeamList)
                        if(!groupedItem.selectionWinnerMap.containsKey(true)) {
                            groupedItem.selectedWinner = fullTeamList[0]
                        }
                        break
                    }
                }
            }
        }
        fullList = temp
        mUpdatedRound16List.postValue(temp)
    }
}