/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.MebProdutos;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author maria
 */
public class ProdutosController extends AbstractTableModel {
    
     private List lista;

    public void setList(List lista) {
        this.lista = lista;//colocar o this porque esta se referindo a lista da classe
       this.fireTableDataChanged();// para atualizar a tabela
    }
    
    public MebProdutos getBean(int row) { //pegar a linha do bean
        return (MebProdutos) lista.get(row);
    }

    @Override
    public int getRowCount() {//quantidade de linhas
        //decidir quantas linhas vai ter
    return lista.size(); //vai mostrar apenas a quantidade de registros que tiver no banco de dados
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int row, int column) {//quantidade e valor
        
    MebProdutos mebProdutos = (MebProdutos) lista.get(row);//vai pegar a linha se quiser algo específico, colocar o numero da linha do bd  
        if (column == 0) {
           return mebProdutos.getMebValorUnitario();
        } 
        if (column == 1) {
           return mebProdutos.getMebNomeProduto();
        } 
        if (column == 2) {
           return mebProdutos.getMebQuantidade();
        } 
        if (column == 3) {
           return mebProdutos.getMebCategoria();
        } 
        return null;     
    
   }
    
     @Override
     public String getColumnName(int column) {
        if (column == 0) {
            return "Valor";
        }
        if (column == 1) {
            return "Nome";
        }
        if (column == 2) {
            return "Quantidade";
        }
        if (column == 3) {
            return "Categoria";
        }
        return "";
    }
    
}
