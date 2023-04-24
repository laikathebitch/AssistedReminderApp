package com.bizarre.assistedreminderapp.ui.map.geofence

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bizarre.assistedreminderapp.MainActivity
import com.bizarre.assistedreminderapp.ui.home.AppViewModel
import com.bizarre.core_domain.entity.Reminder
import com.google.android.gms.location.Geofence
import com.google.android.gms.location.GeofencingEvent

const val GEOFENCE_RADIUS = 200
const val GEOFENCE_ID = "REMINDER_GEOFENCE_ID"
const val GEOFENCE_EXPIRATION = 10 * 24 * 60 * 60 * 1000 // 10 days
const val GEOFENCE_DWELL_DELAY =  10 * 1000 // 10 secs // 2 minutes
const val GEOFENCE_LOCATION_REQUEST_CODE = 12345
const val CAMERA_ZOOM_LEVEL = 13f
const val LOCATION_REQUEST_CODE = 123

class GeofenceReceiver(viewModel1:AppViewModel) : BroadcastReceiver() {
    val viewModel = viewModel1
    var id: Long = 0
    lateinit var text: String

    override fun onReceive(context: Context?, intent: Intent?) {
        if (context != null) {
            val geofencingEvent = GeofencingEvent.fromIntent(intent)
            val geofencingTransition = geofencingEvent.geofenceTransition

            if (geofencingTransition == Geofence.GEOFENCE_TRANSITION_ENTER || geofencingTransition == Geofence.GEOFENCE_TRANSITION_DWELL) {
                // Retrieve data from intent
                if (intent != null) {
                   id = intent.getLongExtra("id",0)!!
                    text = intent.getStringExtra("message")!!
                }
                    viewModel.setNotification(id,true)


                // remove geofence
                val triggeringGeofences = geofencingEvent.triggeringGeofences




               MainActivity.removeGeofences(context, triggeringGeofences)
            }
        }
    }
}