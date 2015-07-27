package br.com.caelum.casadocodigo.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.casadocodigo.TipoDeCompra;

/**
 * Created by matheus on 27/07/15.
 */
public class Carrinho implements Serializable {

    private List<Item> items;


    public Carrinho() {
        items = new ArrayList<>();
    }

    public void adicionar(Item item){
        items.add(item);
    }

    public void remove(int position){
        items.remove(position);
    }

    public Item  getItem(int position) {
        return items.get(position);
    }

    public List<Item> pegaListaItens(){

        return items;
    }
}
