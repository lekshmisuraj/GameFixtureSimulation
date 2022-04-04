package com.game.gamefixturesimulation

import androidx.databinding.Observable
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class GroupedItemsQuarter(
    val id: Int,
    val header: String,
    val teamWinner1Items: ArrayList<String>,
    val teamWinner2Items: ArrayList<String>
) {
    var selectedWinner1: String? = null
    var selectedWinner2: String? = null

}