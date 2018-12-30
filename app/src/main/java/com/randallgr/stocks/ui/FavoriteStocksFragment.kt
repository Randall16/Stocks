package com.randallgr.stocks.ui


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.randallgr.stocks.R
import com.randallgr.stocks.data.models.BookResponse
import com.randallgr.stocks.data.network.API_Client_Instance
import kotlinx.android.synthetic.main.fragment_favorite_stocks.view.*
import retrofit2.Call
import retrofit2.Response


class FavoriteStocksFragment : Fragment() {

    // Static string for Logcat debugging purposes
    companion object {
        private const val TAG = "FavoriteStocksFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_favorite_stocks, container, false)

        /*
        val temp = API_Client_Instance.IEX_API_INSTANCE

        // Sample run of pulling Google stock and displaying it TextView
        temp.getBook("goog").enqueue(object: retrofit2.Callback<BookResponse>{
            override fun onFailure(call: Call<BookResponse>, t: Throwable) {
            }

            override fun onResponse(call: Call<BookResponse>, response: Response<BookResponse>) {
                view.tv.text = response.body()?.quote?.latestPrice.toString()

            }
        })
        */

        return view
    }


}
