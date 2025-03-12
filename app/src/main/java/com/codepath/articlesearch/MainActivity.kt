package com.codepath.articlesearch

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.articlesearch.databinding.ActivityMainBinding
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.serialization.json.Json
import okhttp3.Headers
import org.json.JSONException

fun createJson() = Json {
    isLenient = true
    ignoreUnknownKeys = true
    useAlternativeNames = false
}
private const val TAG = "MainActivity/"
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        // It is important to place the R.id references after this line. Otherwise, they will not be
        // recognized.
        setContentView(view)
        // handle navigation selection
        val fragmentManager: FragmentManager = supportFragmentManager
        // define your fragments here
        val fragment1: Fragment = BestSellerBooksFragment()
        val fragment2: Fragment = ArticleListFragment()
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener(){ item ->
            lateinit var fragment: Fragment
            when (item.itemId) {
                R.id.BooksTab ->
                    // do something here
                    fragment = fragment1
                R.id.ArticlesTab ->
                    // do something here
                    fragment = fragment2
                else -> true
            }
            fragmentManager.beginTransaction().replace(R.id.clContainer, fragment).commit()
            true
        }
        // Set default selection
        bottomNavigationView.selectedItemId = R.id.BooksTab
    }
}
