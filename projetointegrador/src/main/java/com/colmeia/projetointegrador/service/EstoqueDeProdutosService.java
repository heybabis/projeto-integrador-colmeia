package com.colmeia.projetointegrador.service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colmeia.projetointegrador.entity.Produto;
import com.colmeia.projetointegrador.repository.EstoqueDeProdutosRepository;

public class EstoqueDeProdutosService {

	EstoqueDeProdutosRepository repository;

	public static void adicionarProduto(Produto produto, Integer quantidade) {
		List<Produto> produtos;
		Long id = produto.getId();

		if (produtos.contains(id)) {
			produtos = produto.getId();

			if (produtos.get(0).getNome().equals(produto.getNome())) {
				while (quantidade > 0) {
					produtos.add(produto);
					quantidade--;
				}
			} else {
				System.out.println("ATENÇÃO\tATENÇÃO\tATENÇÃO\tATENÇÃO\tATENÇÃO");
				System.out.println("Produto NÃO foi adicionado pois o codigo '" + produto.getId()
						+ "' possui apenas produtos '" + produtos.get(0).getNome()
						+ "' e voce esta tentando adicionar '" + produto.getNome() + "'");
			}
		} else {
			produtos = new LinkedList<Produto>();

			while (quantidade > 0) {
				produtos.add(produto);
				quantidade--;
			}

			produtos.put(id, produtos);
		}
	}

	public static void removerProduto(Long id, Integer quantidade) {
		List<Produto> produtos;
		boolean removerDoEstoque = false;

		if (produtos.contains(id)) {
			produtos = produto.getId();
			

			double temp = quantidade;
			for (int i = 0; i < quantidade; i++) {
				if (produtos.size() > 0 && temp > 0) {
					produtos.remove(produtos.get(0));
					// System.out.println("Removendo um produto de codigo: " + codigo);
					temp--;
				} else {
					// System.out.println("ATENÇÃO! O estoque desse produto acabou: " +
					// p.getNome());
					removerDoEstoque = true;
					break;
				}
			}
			if (removerDoEstoque) {
				System.out.println("*  ATENÇÃO! O estoque desse produto acabou: " + produtos.get(0).getNome() + "  *");
				produtos.remove(id);
			} else {
				produtos.put(id, produtos);
			}
		} else {
			System.out.println("*  ATENÇÃO! Produto com o código " + id + " não encontrado  *");
		}
		System.out.println();
	}

	
}
