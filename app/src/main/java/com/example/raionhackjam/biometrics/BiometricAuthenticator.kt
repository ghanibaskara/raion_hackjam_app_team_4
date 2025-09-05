package com.example.raionhackjam.biometrics

import android.content.Context
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.fragment.app.FragmentActivity

class BiometricAuthenticator (
    private val context: Context
) {

    private lateinit var promptInfo: BiometricPrompt.PromptInfo
    private val biometricManager: BiometricManager = BiometricManager.from(context.applicationContext)
    private lateinit var biometricPrompt: BiometricPrompt

    fun isBiometricAuthAvailable(): BiometricAuthenticationStatus {
        return when (biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_STRONG or BiometricManager.Authenticators.DEVICE_CREDENTIAL)) {
            BiometricManager.BIOMETRIC_SUCCESS -> BiometricAuthenticationStatus.READY
            BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> BiometricAuthenticationStatus.NOT_AVAILABLE
            BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE -> BiometricAuthenticationStatus.TEMPORARY_NOT_AVAILABLE
            BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> BiometricAuthenticationStatus.AVAILABLE_BUT_NOT_ENROLLED
            else -> BiometricAuthenticationStatus.NOT_AVAILABLE
        }
    }

    fun promptBiometricAuth(
        title: String,
        subtitle: String,
        negativeButtonText: String,
        fragmentActivity: FragmentActivity,
        onSuccess: (result: BiometricPrompt.AuthenticationResult) -> Unit,
        onFail: () -> Unit,
        onError: (errorCode: Int, errorString: CharSequence) -> Unit
    ) {
        when (isBiometricAuthAvailable()) {
            BiometricAuthenticationStatus.NOT_AVAILABLE -> {
                onError(BiometricAuthenticationStatus.NOT_AVAILABLE.id, "Not available for this device")
            }

            BiometricAuthenticationStatus.TEMPORARY_NOT_AVAILABLE -> {
                onError(BiometricAuthenticationStatus.TEMPORARY_NOT_AVAILABLE.id, "Not available at this moment")
            }

            BiometricAuthenticationStatus.AVAILABLE_BUT_NOT_ENROLLED -> {
                onError(BiometricAuthenticationStatus.AVAILABLE_BUT_NOT_ENROLLED.id, "You should add a fingerprint or a face id first")
            }

            BiometricAuthenticationStatus.READY -> {
                // All good, proceed
            }

            else -> Unit
        }

        biometricPrompt = BiometricPrompt(
            fragmentActivity,
            object: BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)
                    onSuccess(result)
                }

                override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                    super.onAuthenticationError(errorCode, errString)
                    onError(errorCode, errString)
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    onFail()
                }
            }
        )
        promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle(title)
            .setSubtitle(subtitle)
            .setNegativeButtonText(negativeButtonText)
            .build()
        biometricPrompt.authenticate(promptInfo)

    }



}