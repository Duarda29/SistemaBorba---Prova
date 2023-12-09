
package view;

import bean.MebVendasProduto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author maria
 */
public class VendasProdutoController extends AbstractTableModel{ // esse controla o carinha do usuarioPesquisar
    
    //Tem esses três métodos porque é um dos poucos requerimentos para criar esse método abstrato
    
    List lista = new ArrayList();
    
    public void setList(List lista){
       this.lista = lista; //colocar o this porque esta se referindo a lista da classe
       this.fireTableDataChanged();
        
    }
    
    public MebVendasProduto getBean(int index){ //pegar a linha do bean
    return (MebVendasProduto) lista.get(index);
    }
    

    @Override
    public int getRowCount() {//quantidade de linhas
        
        //decidir quantas linhas vai ter
    return lista.size(); //vai mostrar apenas a quantidade de registros que tiver no banco de dados
    }

    
    
    @Override
    public int getColumnCount() {//quantidade de colunas
    return 4; //decidir quantas colunas vai ter
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {//quantidade Valor
        
     MebVendasProduto mebVendasProduto = (MebVendasProduto) lista.get(rowIndex); //vai pegar a linha se quiser algo específico, colocar o numero da linha do bd  
        
if ( columnIndex == 0) {
         return mebVendasProduto.getIdMebVendasProduto();   
        }

if ( columnIndex == 1) {
         return mebVendasProduto.getMebProdutos();   
        }

if ( columnIndex == 2) {
         return mebVendasProduto.getMebQuantidade();   
        }

if ( columnIndex == 3) {
         return mebVendasProduto.getMebValorUni();   
        }



return "";
            }
    
  
    
    @Override
    public String getColumnName(int column){
        if ( column == 0) {
         return "Id";   
        }
        
        if ( column == 1) {
         return "Produto";   
        }
        
        if ( column == 2) {
         return "Quantidade";   
        }
        
        if ( column == 3) {
         return "valor Unitário";   
        }
        
        
        return "";
    }
    
    
     public void addBean(MebVendasProduto mebVendasProduto) {
        lista.add(mebVendasProduto);
        this.fireTableDataChanged();
    }

     public void removeBean(int index) {
        lista.remove(index);
        this.fireTableDataChanged();

       
    }
    public void updateBean(int index, MebVendasProduto mebVendasProduto) {
        lista.set(index, mebVendasProduto);
        this.fireTableDataChanged();
    }
    
}
