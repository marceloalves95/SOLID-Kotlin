package srp.certo

/**
 * @author RubioAlves
 * Created 13/06/2021 at 10:53
 */
class SrpCerto {

    class Pedido(){
        fun calculateTotalSum(){/*...*/}
        fun getItems(){/*...*/}
        fun getItemCount(){/*...*/}
        fun addItem(item:String){/*...*/}
        fun deleteItem(item:String){/*...*/}
    }

    class PedidoRepository(){
        fun load(pedidoID:Int){/*...*/}
        fun save(pedido:Pedido){/*...*/}
        fun update(pedido:Pedido){/*...*/}
        fun delete(pedido:Pedido){/*...*/}
    }

    class PedidoView(){
        fun printOrder(pedido:Pedido){/*...*/}
        fun showOrder(pedido:Pedido){/*...*/}
    }

}