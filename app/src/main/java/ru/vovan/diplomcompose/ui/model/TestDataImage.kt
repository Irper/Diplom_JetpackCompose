package ru.vovan.diplomcompose.ui.model

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import ru.vovan.diplomcompose.R
import ru.vovan.diplomcompose.ui.model.TestDataImage.imagesList

object TestDataImage {

    /*private val imagesList = listOf(
        "https://img.freepik.com/free-photo/wide-angle-shot-single-tree-growing-clouded-sky-during-sunset-surrounded-by-grass_181624-22807.jpg",
        "https://img.freepik.com/free-photo/beautiful-view-greenery-bridge-forest-perfect-background_181624-17827.jpg",
        "https://img.freepik.com/free-photo/green-field-tree-blue-skygreat-as-backgroundweb-banner-generative-ai_1258-153069.jpg",
        "https://img.freepik.com/free-photo/waterfall-nature-thailand_335224-989.jpg",
        "https://img.freepik.com/free-photo/beautiful-shot-crystal-clear-lake-snowy-mountain-base-during-sunny-day_181624-5459.jpg",
        "https://img.freepik.com/free-photo/aerial-view-koh-hong-island-krabi-thailand_335224-1378.jpg",
    )

    val testItemsList = List(44) {
        val random = (0..5).random()
        TestDataImageItem(
            url = imagesList[random]
        )
    }*/
    private val imagesList = listOf(
        R.drawable.desc1,
        R.drawable.desc2,
        R.drawable.desc3,
        R.drawable.desc4,
        R.drawable.desc5,
        R.drawable.desc6,
    )

    val testItemsList = imagesList.forEach {
        /*TestDataImageItem(
            url = it
        )*/
    }
}

/*
data class TestDataImageItem(
    var url: String
) : ImageBitmap*/
