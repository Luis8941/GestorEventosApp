package com.example.proyectoinnovacion

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import android.util.Log


class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        // Maneja el mensaje recibido
        Log.d(TAG, "From: ${remoteMessage.from}")

        // Verifica si el mensaje contiene datos
        remoteMessage.data.isNotEmpty().let {
            Log.d(TAG, "Message data payload: ${remoteMessage.data}")
            // Manejar la carga útil de datos
        }

        // Verifica si el mensaje contiene una notificación
        remoteMessage.notification?.let {
            Log.d(TAG, "Message Notification Body: ${it.body}")
            // Manejar la carga útil de la notificación
        }
    }

    override fun onNewToken(token: String) {
        Log.d(TAG, "Refreshed token: $token")
        // Envía el token al servidor de tu aplicación si es necesario
    }

    companion object {
        private const val TAG = "MyFirebaseMsgService"
    }
}