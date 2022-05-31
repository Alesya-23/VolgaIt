package com.laba.volgait.ui.stocks

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.activity.viewModels
import androidx.core.view.isGone
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.laba.volgait.R
import com.laba.volgait.data.DataRepositorySource
import com.laba.volgait.data.Resource
import com.laba.volgait.databinding.ActivityStocksBinding
import com.laba.volgait.model.models.Stocks
import com.laba.volgait.ui.base.BaseActivity
import com.laba.volgait.ui.stocks.adapters.StocksAdapter
import kotlin.reflect.KFunction1

class StocksActivity : BaseActivity() {

    private lateinit var stocksBinding: ActivityStocksBinding
    private val stocksListViewModel: StocksListViewModel by viewModels()
    private lateinit var stocksAdapter: StocksAdapter
    private lateinit var dataRepositoryRepository: DataRepositorySource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = getString(R.string.list_stock_activity_title)
        stocksListViewModel.getStocks()
    }

    override fun observeViewModel() {
        observe(
                stocksListViewModel.stocksLiveData,
                ::handleStocksList
        )
    }

    private fun bindListStocks(stocks: Stocks) {
        if (!(stocks.stocksList.isNullOrEmpty())) {
            stocksAdapter = StocksAdapter(stocks.stocksList)
            stocksBinding.listStock.adapter = stocksAdapter
        }
    }

    private fun handleStocksList(status: Resource<Stocks>) {
        when (status) {
            is Resource.Loading -> showLoadingView()
            is Resource.Success -> status.data?.let { bindListStocks(stocks = it) }
            is Resource.DataError -> {
                showDataView(false)
                status.errorCode?.let { stocksListViewModel.showToastMessage(it) }
            }
        }
    }

    private fun showDataView(show: Boolean) {
        stocksBinding.listStock.visibility = if (show) GONE else VISIBLE
    }

    private fun showLoadingView() {
        stocksBinding.listStock.isGone
    }

    override fun initViewBinding() {
        stocksBinding = ActivityStocksBinding.inflate(layoutInflater)
        val view = stocksBinding.root
        setContentView(view)
    }

    private fun LifecycleOwner.observe(liveData: LiveData<Resource<Stocks>>, action: KFunction1<Resource<Stocks>, Unit>) {
        liveData.observe(this, Observer { it?.let { t -> action(t) } })
    }
}