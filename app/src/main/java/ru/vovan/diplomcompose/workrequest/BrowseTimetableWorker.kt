package ru.vovan.diplomcompose.workrequest

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import ru.vovan.diplomcompose.ui.model.CurrentAudienceObject
import ru.vovan.diplomcompose.viewmodel.DataViewModel

class BrowseTimetableWorker (
    context : Context,
    parameters: WorkerParameters,
    private val dataViewModel: DataViewModel
) : Worker(context, parameters) {
    override fun doWork(): Result {
        return try {
            dataViewModel.browserAnnouncement()
            dataViewModel.browserTimetable(CurrentAudienceObject.currentAudience)
            Result.success()
        }
        catch (throwable : Throwable){
            Result.retry()
        }
    }
}