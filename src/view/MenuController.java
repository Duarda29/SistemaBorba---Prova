/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.MebMenu;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author maria
 */
public class MenuController extends AbstractTableModel {

     private List lista;

    public void setList(List lista) {
         this.lista = lista;//colocar o this porque esta se referindo a lista da classe
       this.fireTableDataChanged();// para atualizar a tabela
    }
    
    public MebMenu getBean(int row) {//pegar a linha do bean
        return (MebMenu) lista.get(row);
    }
    
    @Override
    public int getRowCount() {
        //decidir quantas linhas vai ter
    return lista.size(); //vai mostrar apenas a quantidade de registros que tiver no banco de dados
    }

    @Override
    public int getColumnCount() {
        return 4;
}

    @Override
    public Object getValueAt(int row, int column) { //quantidade e valor
        
      MebMenu mebMenu = (MebMenu) lista.get(row);//vai pegar a linha se quiser algo específico, colocar o numero da linha do bd  
        if (column == 0) {
           return mebMenu.getIdMebMenu();
        } 
        if (column == 1) {
           return mebMenu.getMebPizza();
        } 
        if (column == 2) {
           return mebMenu.getMebBorda();
        } 
        if (column == 3) {
           return mebMenu.getMebTamanhos();
        } 
        return null; 
    }
    
     @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Id";
        }
        if (column == 1) {
            return "Pizza";
        }
        if (column == 2) {
            return "Bordas";
        }
        if (column == 3) {
            return "Tamanhos";
        }
        return "";
    }
    
    
}
