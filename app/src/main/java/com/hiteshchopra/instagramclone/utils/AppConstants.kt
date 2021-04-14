package com.hiteshchopra.instagramclone.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.hiteshchopra.instagramclone.BaseApplication

class AppConstants {
    companion object {
        const val HOME_BASE_URL = "https://60630c3f0133350017fd2784.mockapi.io/api/"
        const val SEARCH_BASE_URL = "https://api.unsplash.com/"
        fun hasInternetConnection(application: BaseApplication): Boolean {
            val connectivityManager = application.getSystemService(
                Context.CONNECTIVITY_SERVICE
            ) as ConnectivityManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val activeNetwork = connectivityManager.activeNetwork ?: return false
                val capabilities =
                    connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
                return when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                    else -> false
                }
            } else {
                connectivityManager.activeNetworkInfo?.run {
                    return when (type) {
                        ConnectivityManager.TYPE_WIFI -> true
                        ConnectivityManager.TYPE_MOBILE -> true
                        ConnectivityManager.TYPE_ETHERNET -> true
                        else -> false
                    }
                }
            }
            return false
        }
    }
}