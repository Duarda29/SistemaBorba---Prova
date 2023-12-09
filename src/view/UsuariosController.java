
package view;

import bean.MebUsuarios;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author maria
 */
public class UsuariosController extends AbstractTableModel{ // esse controla o carinha do usuarioPesquisar
    
    //Tem esses três métodos porque é um dos poucos requerimentos para criar esse método abstrato
    
    List lista;
    
    public void setList(List lista){
    
       this.lista = lista; //colocar o this porque esta se referindo a lista da classe
       this.fireTableDataChanged();
       
        
    }
    
    public MebUsuarios getBean(int row){ //pegar a linha do bean
    return (MebUsuarios) lista.get(row);
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
        
     MebUsuarios mebUsuarios = (MebUsuarios) lista.get(rowIndex); //vai pegar a linha se quiser algo específico, colocar o numero da linha do bd  
        
if ( columnIndex == 0) {
         return mebUsuarios.getIdMebUsuarios();   
        }

if ( columnIndex == 1) {
         return mebUsuarios.getMebNome();   
        }

if ( columnIndex == 2) {
         return mebUsuarios.getMebApelido();   
        }

if ( columnIndex == 3) {
         return mebUsuarios.getMebCpf();   
        }
if ( columnIndex == 4) {
         return mebUsuarios.getMebNivel();   
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
         return "Apelido";   
        }
        
        if ( column == 3) {
         return "Cpf";   
        }
        if (column == 4) {
            return "Nivel";
        }
        
        return "";
    }
}
