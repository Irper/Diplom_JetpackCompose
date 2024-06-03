package ru.vovan.diplomcompose.ui.model

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class CurrentAudience(private val context: Context) {

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("AudienceNumber")
        private val AUDIENCE_NUMBER = stringPreferencesKey("audience_number")
    }

    val getAudienceNumber: Flow<String?> = context.dataStore.data.map {preferences ->
        preferences[AUDIENCE_NUMBER] ?: "101"
    }

    suspend fun saveAudienceNumber(name : String){
        context.dataStore.edit { preferences ->
            preferences[AUDIENCE_NUMBER] = name
        }
    }
}

object CurrentAudienceObject{
    var currentAudience = ""
}