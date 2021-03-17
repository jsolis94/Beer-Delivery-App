package com.chinelaegancho.beerdelivery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_items.view.*

class ItemsAdapter (var clickListener: ClickListener) : RecyclerView.Adapter<ItemsAdapter.ItemsAdapterVH>(){

    var itemsModalList = ArrayList<ItemsModal>();

    fun setData(itemsModalList: ArrayList<ItemsModal>){
        this.itemsModalList = itemsModalList;
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsAdapterVH {
        return ItemsAdapterVH(LayoutInflater.from(parent.context).inflate(R.layout.row_items,parent,false))
    }

    override fun onBindViewHolder(holder: ItemsAdapterVH, position: Int) {

        val itemsModal = itemsModalList[position]
        holder.imagen.setImageResource(itemsModal.imagen)
        holder.producto.text = itemsModal.producto
        holder.descripcion.text = itemsModal.descripcion

        holder.itemView.setOnClickListener {

            clickListener.ClickedItem(itemsModal)
        }
    }

    override fun getItemCount(): Int {
        return itemsModalList.size
    }

    class ItemsAdapterVH(itemView: View) : RecyclerView.ViewHolder(itemView){

        val imagen = itemView.imageview
        val producto = itemView.producto
        val descripcion = itemView.descripcion
    }

    interface ClickListener{
        fun ClickedItem(itemsModal: ItemsModal)
    }
}