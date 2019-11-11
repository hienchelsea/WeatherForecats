package com.sun.weatherforecats.ui.setting

import android.app.job.JobInfo
import android.app.job.JobParameters
import android.app.job.JobScheduler
import android.app.job.JobService
import android.content.ComponentName
import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class JobAlarmService:JobService() {
    override fun onStopJob(p0: JobParameters?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onStartJob(p0: JobParameters?): Boolean {
       Toast.makeText(applicationContext,"Hien",Toast.LENGTH_LONG).show()
        return false
    }

    companion object {
        private const val JOB_ID = 1

        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        fun scheduleJob(context: Context) {
            (context.getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler)
                .schedule(
                    JobInfo.Builder(JOB_ID, ComponentName(context, JobAlarmService::class.java))
                    .setRequiresDeviceIdle(true)
                    .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                    .build())
        }
    }
}