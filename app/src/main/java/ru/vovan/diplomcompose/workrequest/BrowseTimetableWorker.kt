package ru.vovan.diplomcompose.workrequest

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import ru.vovan.diplomcompose.viewmodel.DataViewModel

class
BrowseTimetableWorker (
    context : Context,
    parameters: WorkerParameters,
    private val dataViewModel: DataViewModel
) : Worker(context, parameters) {
    override fun doWork(): Result {
        return try {
            //dataViewModel.browserAnnouncement()
            //dataViewModel.browserTimetable(CurrentAudienceObject.currentAudience)
            Log.d("123","Success")
            Result.success()
        }
        catch (throwable : Throwable){
            Result.retry()
        }
    }
}