
package view;

import bean.MebClientes;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author maria
 */
public class ClientesController extends AbstractTableModel{ // esse controla o carinha do usuarioPesquisar
    
    //Tem esses três métodos porque é um dos poucos requerimentos para criar esse método abstrato
    
    List lista;
    
    public void setList(List lista){
    
       this.lista = lista; //colocar o this porque esta se referindo a lista da classe
       this.fireTableDataChanged();// para atualizar a tabela
    }
    
    public MebClientes getBean(int row){ //pegar a linha do bean
    return (MebClientes) lista.get(row);
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
        
     MebClientes mebClientes = (MebClientes) lista.get(rowIndex); //vai pegar a linha se quiser algo específico, colocar o numero da linha do bd  
        
if ( columnIndex == 0) {
         return mebClientes.getIdMebClientes();   
        }

if ( columnIndex == 1) {
         return mebClientes.getMebNome();   
        }

if ( columnIndex == 2) {
         return mebClientes.getMebSobrenome();   
        }

if ( columnIndex == 3) {
         return mebClientes.getMebEstado();   
        }
return "";
            }
    
  
    
    @Override
    public String getColumnName(int column){
        if ( column == 0) {
         return "id";   
        }
        
        if ( column == 1) {
         return "Nome";   
        }
        
        if ( column == 2) {
         return "Sobrenome";   
        }
        
        if ( column == 3) {
         return "Estado";   
        }
        
        
        return "";
    }
}
