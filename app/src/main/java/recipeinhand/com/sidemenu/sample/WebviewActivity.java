package recipeinhand.com.sidemenu.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import recipeinhand.com.sidemenu.sample.fragment.ContentFragment;

public class WebviewActivity extends AppCompatActivity {
    private WebView webview;
    //private String url = "https://blog.naver.com/tsu_star/222346387373";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        Intent intent = getIntent();
        int id = intent.getExtras().getInt("onclick");
        int key = intent.getExtras().getInt("Key");


        webview = (WebView) findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
        if ( id == 1 ) {
            String url = "https://post.naver.com/viewer/postView.naver?volumeNo=16109212&memberNo=175047&searchKeyword=%EC%9E%90%EC%B7%A8%EC%83%9D%20%EC%9E%AC%ED%99%9C%EC%9A%A9%20%EA%BF%80%ED%8C%81&searchRank=8";
            webview.loadUrl(url);
        }
        if ( id == 2) {
            String url = "https://post.naver.com/viewer/postView.naver?volumeNo=6671967&memberNo=15865090&searchKeyword=%EC%9E%90%EC%B7%A8%EC%83%9D%20%EC%B2%AD%EC%86%8C%20%EA%BF%80%ED%8C%81&searchRank=3";
            webview.loadUrl(url);
        }
        if ( id == 3) {
            String url = "https://post.naver.com/viewer/postView.nhn?volumeNo=17153860&memberNo=4836725&vType=VERTICAL";
            webview.loadUrl(url);
        }
        if ( id == 4) {
            String url = "https://post.naver.com/viewer/postView.naver?volumeNo=16195559&memberNo=34545175&searchKeyword=%EC%9E%90%EC%B7%A8%EC%83%9D%20%EC%9E%A5%EB%A7%88&searchRank=8";
            webview.loadUrl(url);
        }



        if (key == 2131099832 ) {
            String url = "https://www.youtube.com/watch?v=rEnnfMFAijU";
            webview.loadUrl(url);
        }
        if (key == 2131099835 ) {
            String url = "https://www.youtube.com/watch?v=kmIYGGlua9s";
            webview.loadUrl(url);
        }
        if (key == 2131099834 ) {
            String url = "https://www.youtube.com/watch?v=rgjxXgDLPc0";
            webview.loadUrl(url);
        }
        if (key == 2131099833 ) {
            String url = "https://www.youtube.com/watch?v=tkaWoUMKV7E";
            webview.loadUrl(url);
        }
        webview.setWebChromeClient(new WebChromeClient());
        webview.setWebViewClient(new WebViewClientClass());
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()) {
            webview.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}