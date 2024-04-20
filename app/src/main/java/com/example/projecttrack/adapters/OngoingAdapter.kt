package com.example.projecttrack.adapters

import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projecttrack.R
import com.example.projecttrack.domain.OnGoingDomain

class OngoingAdapter(val items: List<OnGoingDomain>) :
    RecyclerView.Adapter<OngoingAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val date: TextView = itemView.findViewById(R.id.date)
        val progressBarPercent: TextView = itemView.findViewById(R.id.progress_percent)
        val progressText: TextView = itemView.findViewById(R.id.textView6)
        val progressBar: ProgressBar = itemView.findViewById(R.id.progressBar)
        val pic: ImageView = itemView.findViewById(R.id.imageView2)
        val layout: ConstraintLayout = itemView.findViewById(R.id.layout)


        fun setTextColor(colorRes: Int){
            title.setTextColor(itemView.context.getColor(colorRes))
            date.setTextColor(itemView.context.getColor(colorRes))
            progressText.setTextColor(itemView.context.getColor(colorRes))
            progressBarPercent.setTextColor(itemView.context.getColor(colorRes))
            pic.setColorFilter(ContextCompat.getColor(itemView.context, colorRes), PorterDuff.Mode.SRC_IN)
            progressBar.progressTintList = ColorStateList.valueOf(ContextCompat.getColor(itemView.context, colorRes))


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.viewholder_ongoing, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.title.text = item.title
        holder.date.text = item.date
        holder.progressBarPercent.text = item.progressPercent.toString()



        val drawableResource = holder.itemView.context.resources.getIdentifier(
            item.picPath, "drawable", holder.itemView.context.packageName
        )


        Glide.with(holder.itemView.context)
            .load(drawableResource)
            .into(holder.pic)

        holder.pic.setImageResource(drawableResource)
        holder.progressBar.progress = item.progressPercent


        with(holder){
            if(position == 0){
                layout.setBackgroundResource(R.drawable.dark_bg)
                setTextColor(R.color.white)
            }else{
                layout.setBackgroundResource(R.drawable.light_purple_background)
                setTextColor(R.color.dark_purple)

            }
        }

    }
}