package ru.vovan.diplomcompose.ui.model

import ru.vovan.diplomcompose.R

object TestDataImage {

    private val imagesList = listOf(
        R.drawable.a3430_1,
        R.drawable.a3430_2,
        R.drawable.a3430_3,
        R.drawable.a3430_4,
        R.drawable.a3430_5,
        R.drawable.a3430_6,
        R.drawable.a3132_1,
        R.drawable.a3132_2,
        R.drawable.a3252_1,
        R.drawable.a3252_2,
    )
    private val audList = listOf(
        "3430",
        "3430",
        "3430",
        "3430",
        "3430",
        "3430",
        "3132",
        "3132",
        "3252",
        "3252",
    )
    val testItemsList = List(imagesList.size) {
        TestDataImageItem(
            url = imagesList[it],
            audNum = audList[it]
        )
    }
}
data class TestDataImageItem(
    var url : Int,
    var audNum : String
)
