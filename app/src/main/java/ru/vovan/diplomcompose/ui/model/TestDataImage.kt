package ru.vovan.diplomcompose.ui.model

import ru.vovan.diplomcompose.R

object TestDataImage {

    private val imagesList = listOf(
        R.drawable.desc1,
        R.drawable.desc2,
        R.drawable.desc3,
        R.drawable.desc4,
        R.drawable.desc5,
        R.drawable.desc6,
    )

    val testItemsList = List(imagesList.size) {
        TestDataImageItem(
            url = imagesList[it]
        )
    }
}
data class TestDataImageItem(
    var url: Int
)
