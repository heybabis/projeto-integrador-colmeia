package com.colmeia.projetointegrador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colmeia.projetointegrador.entity.Item;
import com.colmeia.projetointegrador.entity.Produto;
import com.colmeia.projetointegrador.repository.ItemRepository;
import com.colmeia.projetointegrador.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	double a = 0;
	int posicao = 0; // aramazena a posicao do item dentro do array de lista de desejos

	public Produto addProduto(long idProduto, long idItem) {

		Optional<Produto> produtoExistente = produtoRepository.findById(idProduto);
		Optional<Item> itemExistente = itemRepository.findById(idItem);

		if (produtoExistente.isPresent() && itemExistente.isPresent() && produtoExistente.get().getEstoque() >= 0
				&& !(itemExistente.get().getProdutos().isEmpty())) {

			/* ADICIONA O PRODUTO AO CARRINHO DO USUARIO */
			// produtoExistente.get().getItens().add(itemExistente.get());
			itemExistente.get().getProdutos().add(produtoExistente.get());

			System.out.println("Retorno: " + itemExistente.get().getProdutos().contains(produtoExistente.get()));

			System.out.println("QTD produtos " + itemExistente.get().getProdutos().size());

			/* ARMAZENA A QTD DE PRODUTOS */
			int contador = 0;

			/* ARMAZENA OS IDs DOS PRODUTOS LISTADOS DENTRO DO CARRINHO DO USUARIO */
			long[] vetor = new long[itemExistente.get().getProdutos().size()];

			for (int i = 0; i < itemExistente.get().getProdutos().size(); i++) {

				vetor[i] = itemExistente.get().getProdutos().get(i).getId();

				System.out.println("Posicao do vetor [" + i + "] = " + vetor[i]);
				System.out.println("Produto ID: " + produtoExistente.get().getId());

				if (vetor[i] == produtoExistente.get().getId()) {
					contador++;

				}

			}

			/* COMPENSA ACRESCENTANDO O NOVO PRODUTO AO CARRINHO ==> O ID INFORMADO */
			contador++;
			System.out.println("QTD de produto: " + contador);

			/* INSERE O VALOR DO CONTADOR == QTD DE PRODUTOS POR ID */
			produtoExistente.get().setQtdItemProduto(contador);
			/* DEBITA O ESTOQUE SEMPRE QUE E INSERIDO UM PRODUTO A UM CARRINHO */
			produtoExistente.get().setEstoque(produtoExistente.get().getEstoque() - 1);

			System.out.println("Contador: " + contador);
			System.out.println("QTD Produtos: " + produtoExistente.get().getQtdItemProduto());

			produtoRepository.save(produtoExistente.get());
			itemRepository.save(itemExistente.get());

			return produtoRepository.save(produtoExistente.get());

		} else if (produtoExistente.isPresent() && itemExistente.isPresent()) {
			/* ADICIONA O PRODUTO AO CARRINHO DO USUARIO */
			itemExistente.get().getProdutos().add(produtoExistente.get());

			/* ADICIONA UM PRODUTO AO QTD PRODUTOS DENTRO DE PRODUTO */
			produtoExistente.get().setQtdItemProduto(1);
			/* GERENCIA O ESTOQUE DEBITNADO UM PRODUTO DO ESTOQUE */
			produtoExistente.get().setEstoque(produtoExistente.get().getEstoque() - 1);

			produtoRepository.save(produtoExistente.get());
			itemRepository.save(itemExistente.get());

			return produtoRepository.save(produtoExistente.get());

		}

		return null;
	}

	/* DELETAR OBJETOS DO PRODUTO */
	public void deletarProduto(long idProduto, long idItem) {

		Optional<Produto> produtoExistente = produtoRepository.findById(idProduto);
		Optional<Item> itemExistente = itemRepository.findById(idItem);

		if (itemExistente.get().getProdutos().contains(produtoExistente.get())) {
			/* REMOVE O CARRINHO DO PRODUTO */
			produtoExistente.get().getItens().remove(itemExistente.get());

			/* GERENCIA O ESTOQUE DEBITANDO UM PRODUTO DO ESTOQUE */
			produtoExistente.get().setEstoque(produtoExistente.get().getEstoque() + 1);

			int contador = 0;

			/* ARMAZENA OS IDs DOS PRODUTOS LISTADOS DENTRO DO CARRINHO DO USUARIO */
			long[] vetor = new long[itemExistente.get().getProdutos().size()];

			for (int i = 0; i < itemExistente.get().getProdutos().size(); i++) {

				vetor[i] = itemExistente.get().getProdutos().get(i).getId();

				System.out.println("Posicao do vetor [" + i + "] = " + vetor[i]);
				System.out.println("Produto ID: " + produtoExistente.get().getId());

				if (vetor[i] == produtoExistente.get().getId()) {
					contador++;

				}

			}

			produtoExistente.get().setQtdItemProduto(contador - 1);

			produtoRepository.save(produtoExistente.get());
			itemRepository.save(itemExistente.get());

		}

	}

	/* PESQUISANDO POR PRODUTO ESPECIFICO EM UMA LISTA DE DESEJOS DE PRODUTOS */
	public List<Produto> pesquisaPorProdutoNoCarrinho(long idItem) {
		Optional<Item> itemExistente = itemRepository.findById(idItem);

		if (itemExistente.isPresent()) {
			itemExistente.get().getProdutos();

			return itemRepository.save(itemExistente.get()).getProdutos();

		}

		return null;

	}
}