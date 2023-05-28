package com.lmamlrg.servicios

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.lmamlrg.servicios.db.MonedasDB
import com.lmamlrg.servicios.work.syncWorker
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import java.util.concurrent.TimeUnit

class MainActivity : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy {
        MonedasDB.getDatabase(this, applicationScope)
    }
    override fun onCreate() {
        super.onCreate()
        val workRequest = PeriodicWorkRequestBuilder<syncWorker>(1, TimeUnit.DAYS).build()
        WorkManager.getInstance(applicationContext).enqueue(workRequest)
    }
}