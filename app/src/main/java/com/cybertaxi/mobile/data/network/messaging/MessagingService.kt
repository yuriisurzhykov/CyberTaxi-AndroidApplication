package com.cybertaxi.mobile.data.network.messaging

import com.cybertaxi.mobile.di.NetworkModule
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MessagingService : FirebaseMessagingService() {

    @Inject
    var pushTokenApi: PushTokenApi? = null

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        registerNewToken(token)
    }

    private fun registerNewToken(token: String) {
        CoroutineScope(Dispatchers.IO).launch {
            pushTokenApi?.registerNewPushToken(token)
        }
    }
}