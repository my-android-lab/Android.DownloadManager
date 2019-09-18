# Start DownloadManager

용량이 큰 파일이나 사용자에게 다운로드 진행상황을 노티를 통해서 보여주고자 할 때 DownloadManager를 사용하면 된다.

사용법은 아주 쉽다.

```kotlin
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
```

## Download ID

다운로드 요청을 enqueue하면 id를 반환하는데 이 Id로 여러가지 일을 할 수 있다.

## 자세한 내용은 아래 글을 참고한다.

 * [https://codechacha.com/ko/android-downloadmanager/](https://codechacha.com/ko/android-downloadmanager/)
 * [https://developer.android.com/reference/android/app/DownloadManager](https://developer.android.com/reference/android/app/DownloadManager)

