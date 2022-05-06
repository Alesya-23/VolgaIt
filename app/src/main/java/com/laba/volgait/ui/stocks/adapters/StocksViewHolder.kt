package com.laba.volgait.ui.stocks.adapters

import androidx.recyclerview.widget.RecyclerView
import com.laba.volgait.databinding.ItemListStockBinding
import com.laba.volgait.model.models.Stock

class StocksViewHolder(private val itemBinding: ItemListStockBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(stock: Stock) {
        itemBinding.nameStock.text = stock.name
        itemBinding.price.text = stock.price.toString()
    }
}