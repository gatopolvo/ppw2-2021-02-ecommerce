package br.edu.iftm.ecommerce.bean;

import br.edu.iftm.ecommerce.logic.ClienteLogic;
import br.edu.iftm.ecommerce.logic.EnderecoLogic;
import br.edu.iftm.ecommerce.logic.ProdutoLogic;
import br.edu.iftm.ecommerce.logic.VendaLogic;
import br.edu.iftm.ecommerce.model.Cliente;
import br.edu.iftm.ecommerce.model.Endereco;
import br.edu.iftm.ecommerce.model.ItemVenda;
import br.edu.iftm.ecommerce.model.Produto;
import br.edu.iftm.ecommerce.model.Venda;
import br.edu.iftm.ecommerce.util.exception.ErroNegocioException;
import br.edu.iftm.ecommerce.util.exception.ErroSistemaException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
@Getter
@Setter
public class VendaBean extends CrudBean<Venda, VendaLogic> {

    @Inject
    private EnderecoLogic enderecoLogic;
    @Inject
    private ClienteLogic clienteLogic;
    @Inject
    private VendaLogic logic;
    @Inject
    private ProdutoLogic produtoLogic;

    private List<Endereco> listaDeEnderecos;
    private List<Cliente> listaDeClientes;
    private List<Produto> listaDeProdutos;

    private Integer frequenciaAtualizacao = 5000;
    private Long ultimaAtualizacao = 0L;
    private Long ultimaAtualizacaoC = 0L;
    private Long ultimaAtualizacaoProduto = 0L;

    private Produto produtoSelecionado;
    private Integer quantidade;
    private List<Produto> produtosSelecionados;
    private ItemVenda itemVenda;

    public VendaBean() {
        super(Venda.class);
    }

    @Override
    public void novo() {
        super.novo();
        getEntidade().setItensVenda(new ArrayList<>());
    }

    public void adicionarProduto() {

        itemVenda = new ItemVenda();
        itemVenda.setProduto(produtoSelecionado);
        itemVenda.setQuantidade(quantidade);
        itemVenda.setValor(produtoSelecionado.getValor());
        boolean jaTem = false;
        ItemVenda v = null;

        getEntidade().getItensVenda().add(itemVenda);
         

    }

    public void cancelarVenda() {
        Venda aux = this.getEntidade();
        this.getEntidade().setDataCancelamento(new Date());
        this.getEntidade().setDescricaoCancelamento("Cancelado pela loja.");
        super.salvar();
        super.remover(aux);
        
    }

    @Override
    public VendaLogic getLogic() {
        return this.logic;
    }

    public List<Venda> listaVendas() {
        try {
            return this.logic.buscar(null);
        } catch (ErroSistemaException ex) {
            addErro(ex);
        } catch (ErroNegocioException ex) {
            addAviso(ex);
        }
        return new ArrayList<>();
    }

    public List<Cliente> getClientes() {
        try {
            long proximaAtualizacao = this.ultimaAtualizacao + this.frequenciaAtualizacao;
            if (proximaAtualizacao < Calendar.getInstance().getTimeInMillis()) {
                this.listaDeClientes = clienteLogic.buscar(null);
                this.ultimaAtualizacao = Calendar.getInstance().getTimeInMillis();
            }
            return this.listaDeClientes;
        } catch (ErroSistemaException ex) {
            addErro(ex);
        } catch (ErroNegocioException ex) {
            addAviso(ex);
        }
        return new ArrayList<>();
    }

    public List<Endereco> getEndereco() {
        try {
            long proximaAtualizacao = this.ultimaAtualizacaoC + this.frequenciaAtualizacao;
            if (proximaAtualizacao < Calendar.getInstance().getTimeInMillis()) {
                this.listaDeEnderecos = enderecoLogic.buscar(null);
                this.ultimaAtualizacaoC = Calendar.getInstance().getTimeInMillis();
            }
            return this.listaDeEnderecos;
        } catch (ErroSistemaException ex) {
            addErro(ex);
        } catch (ErroNegocioException ex) {
            addAviso(ex);
        }
        return new ArrayList<>();
    }

    public List<Produto> getProdutos() {
        try {
            //long proximaAtualizacao = this.ultimaAtualizacaoProduto + this.frequenciaAtualizacao;
            //if (proximaAtualizacao < Calendar.getInstance().getTimeInMillis()) {
            this.listaDeProdutos = this.produtoLogic.buscar(null);
            //  this.ultimaAtualizacaoProduto = Calendar.getInstance().getTimeInMillis();
            // }
            System.out.println("\n\nProdutos:" + this.listaDeProdutos.size() + "\n\n");
            return this.listaDeProdutos;
        } catch (ErroSistemaException ex) {
            addErro(ex);
        } catch (ErroNegocioException ex) {
            addAviso(ex);
        }
        return new ArrayList<>();
    }

    public float total(Venda entidade) {
        float total = 0;
        int i = 0;
        while(i < entidade.getItensVenda().size()){
            System.out.println("quantidade  produto"+entidade.getItensVenda().get(i).getProduto().getNome() +":" + entidade.getItensVenda().get(i).getQuantidade());
            total += entidade.getItensVenda().get(i).getProduto().getValor() * entidade.getItensVenda().get(i).getQuantidade();
       i++;
        }
        System.out.println("Total: " + total);
        return total;
    }

    public void removerProduto(Produto entidade) {

        this.getProdutosSelecionados().remove(entidade);
        addInfo("Removido com sucesso.");
        super.salvar();

    }
}


