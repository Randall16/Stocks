package com.randallgr.stocks.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.randallgr.stocks.R
import com.randallgr.stocks.data.models.FinancialItem
import kotlinx.android.synthetic.main.financial_item_layout.view.*

class FinancialItemListAdapter internal constructor(context: Context)
    : RecyclerView.Adapter<FinancialItemListAdapter.FinancialItemHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var items = emptyList<FinancialItem>()

    inner class FinancialItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val symbolTextView: TextView = itemView.findViewById(R.id.symbolTextView)
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val priceTextView: TextView = itemView.findViewById(R.id.priceTextView)
        val percentPriceChangeTextView: TextView = itemView.findViewById(R.id.percentageTextView)
        val priceChangeTextView: TextView = itemView.findViewById(R.id.amountChangedTextView)
    }

    internal fun setFinancialItems(financialItems: List<FinancialItem>) {
        this.items = financialItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FinancialItemHolder {
        val itemView = inflater.inflate(R.layout.financial_item_layout, parent, false)
        return FinancialItemHolder(itemView)
    }

    override fun onBindViewHolder(holder: FinancialItemHolder, position: Int) {
        // Left off here
    }

    override fun getItemCount() = items.size
}