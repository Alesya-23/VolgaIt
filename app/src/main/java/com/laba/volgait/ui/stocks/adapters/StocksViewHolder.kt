package com.laba.volgait.ui.stocks.adapters

import androidx.recyclerview.widget.RecyclerView
import com.laba.volgait.databinding.ItemListStockBinding
import io.finnhub.api.models.StockSymbol

class StocksViewHolder(private val itemBinding: ItemListStockBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(stock: StockSymbol) {
        itemBinding.nameStock.text = stock.currency
        itemBinding.price.text = stock.displaySymbol.toString()
    }
}