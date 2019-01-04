package com.randallgr.stocks.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.randallgr.stocks.R
import com.randallgr.stocks.data.models.FinancialListItem
import kotlin.math.roundToInt

class FinancialListItemAdapter internal constructor(context: Context)
    : RecyclerView.Adapter<FinancialListItemAdapter.FinancialItemHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var items = emptyList<FinancialListItem>()

    inner class FinancialItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val symbolTextView: TextView = itemView.findViewById(R.id.symbolTextView)
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val priceTextView: TextView = itemView.findViewById(R.id.priceTextView)
        val percentPriceChangeTextView: TextView = itemView.findViewById(R.id.percentageTextView)
        val priceChangeTextView: TextView = itemView.findViewById(R.id.amountChangedTextView)
    }

    internal fun setFinancialItems(financialListItems: List<FinancialListItem>) {
        this.items = financialListItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FinancialItemHolder {
        val itemView = inflater.inflate(R.layout.financial_item_layout, parent, false)
        return FinancialItemHolder(itemView)
    }

    override fun onBindViewHolder(holder: FinancialItemHolder, position: Int) {
        val current = items[position]
        holder.symbolTextView.text = current.symbol
        holder.nameTextView.text = current.name
        holder.priceTextView.text = current.latestPrice.toString()
        holder.percentPriceChangeTextView.text = current.change24HourPercent.roundToInt().toString() + "%"
        holder.priceChangeTextView.text = current.change24Hour.roundToInt().toString()
    }

    override fun getItemCount() = items.size
}