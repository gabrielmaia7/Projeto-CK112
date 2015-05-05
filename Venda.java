import java.util.*;

class Venda {
	ArrayList<Produto> listavenda;
	String vendedor;
	int ano, mes, dia, hora, minuto, segundo;

	Venda(String vendedor1, int ano1, int mes1, int dia1, int hora1, int minuto1, int segundo1){
		vendedor = vendedor1;
		ano = ano1;
		mes = mes1;
		dia = dia1;
		hora = hora1;
		minuto = minuto1;
		segundo = segundo1;
		listavenda= new ArrayList<>();
	}

	void addvenda(int codigo, int quantidade1, Estoque estoque) {
		String nome = ((estoque.stock).get(codigo)).nome;
		Produto p = new Produto(codigo, quantidade1, nome);
		listavenda.add(p);
	}

	void vender(Estoque estoque){
		boolean sucesso = true;
		for (int i = 0; i < listavenda.size(); i ++){
			sucesso = estoque.removerproduto((listavenda).get(i));
			if (sucesso){
				System.out.println("Código: " + (listavenda.get(i)).codigo + "/t Nome do Produto: " + (listavenda.get(i)).nome + "/t Quantidade: " + (listavenda.get(i)).quantidade);
			}
			else{
				System.out.println("Houve um erro na venda do produto " + (listavenda.get(i)).codigo);
			}
		}
	}
	void mostar(){
		for (int i = 0; i < listavenda.size(); i++){
			System.out.println("Código: " + (listavenda.get(i)).codigo + "/t Nome do Produto: " + (listavenda.get(i)).nome + "/t Quantidade: " + (listavenda.get(i)).quantidade);
		}
	}
}