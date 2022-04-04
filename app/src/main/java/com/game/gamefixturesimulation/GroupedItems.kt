package com.game.gamefixturesimulation

class GroupedItems(
    val id: Int,
    val header: String,
    val groupType: Int,
    val teamWinnerItems: ArrayList<String>,
    val teamLoserItems: ArrayList<String>
) {
    constructor() : this(0, "Group AB", 1, ArrayList(), ArrayList())

    var selectionWinnerMap: HashMap<Boolean, String> = HashMap()
    var selectionRunnerUpMap: HashMap<Boolean, String> = HashMap()
    var selectedWinner: String? = null
    var selectedRunnerUp: String? = null
    var winnerTitleText: String? = null
    var runnerUpTitleText: String? = null

}