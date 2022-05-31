package com.laba.volgait.ui.stocks.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.laba.volgait.databinding.ItemListStockBinding
import com.laba.volgait.ui.stocks.StocksListViewModel
import io.finnhub.api.models.StockSymbol
import java.util.ArrayList

class StocksAdapter(
    private val stocks: ArrayList<StockSymbol>
) :
    RecyclerView.Adapter<StocksViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StocksViewHolder {
        val itemBinding =
            ItemListStockBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StocksViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: StocksViewHolder, position: Int) {
        holder.bind(stocks[position])
    }

    override fun getItemCount(): Int {
        return stocks.size
    }
}