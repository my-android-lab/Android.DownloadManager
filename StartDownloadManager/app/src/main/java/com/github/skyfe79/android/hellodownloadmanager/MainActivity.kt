package com.github.skyfe79.android.hellodownloadmanager

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var downloadId: Long = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        downloadButton.setOnClickListener {
            startDownload()
        }

    }

    private fun startDownload() {
        val downloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as? DownloadManager
        downloadManager?.apply {
            val uri = Uri.parse("https://docs.google.com/uc?export=download&id=1NR1-dhGbYqQMrbI5FJHCCSsPhHy8Geqs")
            val request = DownloadManager.Request(uri)
            downloadId = downloadManager.enqueue(request)
        }
    }
}
