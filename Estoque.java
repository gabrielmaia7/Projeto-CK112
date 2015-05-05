import java.io.Serializable;
import java.util.*;

class Estoque implements Serializable{
	
	private static final long serialVersionUID = 1L;
	TreeMap<Integer, Produto> stock;

	Estoque(){
		stock = new TreeMap<>();
	}

	void addproduto(Produto produto){
		if (stock.containsKey(produto.codigo)){
			(stock.get(produto.codigo)).quantidade = (stock.get(produto.codigo)).quantidade + produto.quantidade;
		}
		else {
			stock.put(produto.codigo, produto);
		}
	}

	boolean removerproduto(Produto produto){
		if ((stock.containsKey(produto.codigo))&&(produto.quantidade <= (stock.get(produto.codigo)).quantidade)){
			(stock.get(produto.codigo)).quantidade = (stock.get(produto.codigo)).quantidade - produto.quantidade;
			return true;
		}
		else {
			return false;
		}
	}

	Produto buscarproduto(Integer codigo) throws Exception{
		if (stock.containsKey(codigo)){
			return stock.get(codigo);
		}
		else {
			throw new Exception("Não existe tal produto.");
		}
	}
}