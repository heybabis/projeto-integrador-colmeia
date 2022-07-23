package com.colmeia.projetointegrador.service;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.colmeia.projetointegrador.entity.Produto;
import com.colmeia.projetointegrador.entity.EstoqueDeProdutosEntity;

public static void adicionarProduto(Produto produto, Integer quantidade){
    List<Produto> produtosDoCodigo;
    Long id = produto.getId();

    //o dia é lindo!!
    if(estoque.containsKey(codigo)){
        produtosDoCodigo = estoque.get(codigo);
    
	if (produtosDoCodigo.get(0).getNomeItem().equals(produto.getNomeItem())) {
                   while (quantidade > 0) {                
                    produtosDoCodigo.add(produto);
                    quantidade--;
                }
	}                            
     	else{
            System.out.println("ATENÇÃO\tATENÇÃO\tATENÇÃO\tATENÇÃO\tATENÇÃO");
            System.out.println("Produto NÃO foi adicionado pois o codigo '" + produto.getCodigo() + "' possui apenas produtos '"
            +produtosDoCodigo.get(0).getNomeItem() + "' e voce esta tentando adicionar '" + produto.getNomeItem() + "'");
            }
    }
    else{
        produtosDoCodigo = new LinkedList<Produto>();
        
        if (produto instanceof ProdutoUnitario) {
            while (quantidade > 0) {                
                produtosDoCodigo.add(produto);
                quantidade--;
            }
        } 
        else if (produto instanceof ProdutoQuilo) {
            produtosDoCodigo.add(produto);
        }
        
        estoque.put(codigo, produtosDoCodigo);
    }
}


public static void removerProduto(Long id, Integer quantidade){
    List<Produto> produtosDoCodigo;
    boolean removerDoEstoque = false;
    
    if(estoque.containsKey(id)){
        produtosDoCodigo = estoque.get(codigo);
        p = produtosDoCodigo.get(0);
        
            double temp = quantidade;
            for (int i = 0; i < quantidade; i++) {
                if(produtosDoCodigo.size() > 0 && temp > 0) {                
                    produtosDoCodigo.remove(produtosDoCodigo.get(0));
                    //System.out.println("Removendo um produto de codigo: " + codigo);
                    temp--;
                }
                else {
                    //System.out.println("ATENÇÃO! O estoque desse produto acabou: " + p.getNome()); 
                    removerDoEstoque = true;
                    break;
                }
            }
        if (removerDoEstoque) {
            System.out.println("*  ATENÇÃO! O estoque desse produto acabou: " + p.getNomeItem() +"  *"); 
            estoque.remove(id);
        }
        else{
            estoque.put(id, produtosDoCodigo);
        }
    }else{
        System.out.println("*  ATENÇÃO! Produto com o código " + id + " não encontrado  *");
    }
    System.out.println();
}

public static void mostrarEstoque(int opcaoDeEstoque){
    Map<String, List<Produto>> estoqueTemp = estoque;
    
    System.out.println("*                    ESTOQUE DE PRODUTOS                        *");
    Iterator listasDeCodigos = estoqueTemp.keySet().iterator();
    int quantidade = 0;
    while (listasDeCodigos.hasNext()) {
        Long id = (String)listasDeCodigos.next();
        if (estoqueTemp.get(id).size() > 0) { // listar apenas se existir produtos
            Iterator produtos = estoqueTemp.get(id).iterator();
            boolean mostrarNomeItem = true;

            while (produtos.hasNext()) {
                p = (Produto)produtos.next();

                if (mostrarNomeItem) {
                    System.out.println("Código: " + id);
                    System.out.println("Produto: " + p.getNomeItem());
                    mostrarNomeProduto = false;
                }
                
                quantidade++;
            }

            System.out.println("Quantidade em estoque = " + quantidade + "\n");
            
            quantidade = 0;
        }
    }
    System.out.println();
}





}


