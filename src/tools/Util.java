/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author maria
 */
public class Util {
    //todos herdam do JComponet -> JTextField, JcomboBox, JcheckBox (tudo que tem na tela herdade dele)--> pai de tudo e todos é o object

    public static void habilitar(boolean valor, JComponent... vetComp) { //vetComp é o vetor //escolheu esse porque tem o metodo setEnable //os tres pontinhos é varards - não sei como escreve - pode passar quantos componetes que quiser
        for (int i = 0; i < vetComp.length; i++) {//arry em inglês é vetor
            vetComp[i].setEnabled(valor);
            //colocando o static não precisa instanciar, mas só esta usando ele
        }
        //estatico sabe no tempo de compilação o metodo que vai chamar, mas o dinanimo não sabe até ser chamado.
    }

    public static void limparCampos(JComponent... vetComp) {//colocou o metodo estatico para não precisar instanciar
        //esses dois for são complementares, mas esse é melhor do que o de cima
        //ele vai pegar cada indice do vetor e joga para a variavelcomponete
        //ele joga automatico na variavel sem precisar ter o indice.

        for (JComponent componente : vetComp) {
            if (componente instanceof JTextField) {//aqui esta peguntando se o componete já foi um jTextField (para poder entrar)

                //pelo cast, o jtextfilde que virou um componente se transformou de novo para jtextfild para não erro.
                ((JTextField) componente).setText("");//Não preceisa fazer o JFormattedTextField
            } else if (componente instanceof JComboBox) {
                ((JComboBox) componente).setSelectedIndex(-1);
            } else if (componente instanceof JCheckBox) {
                ((JCheckBox) componente).setSelected(false);
            }

        }
    }

    public static void mensagem(String cadeia) {
        JOptionPane.showMessageDialog(null, cadeia);

    }

    public static boolean perguntar(String cadeia) {
       int resp =  JOptionPane.showConfirmDialog(null, "Deseja excluir o registro",
       "confirmar", JOptionPane.YES_NO_OPTION);
       if (resp == JOptionPane.YES_OPTION){
       return true;
       }else {
       return false;}     
     }
    
    public static int strInt(String cad){
        return Integer.parseInt(cad);
    }
    
    public static String intStr(int num){
        return String.valueOf(num);
    }
    
    public static double strDouble (String cad) {
        return Double.valueOf(cad);
    }
    
    public static String doubleStr (double num) {
        return String.valueOf(num);
    }
    
   public static Date strDate(String cad){
         try {
             SimpleDateFormat formato = new SimpleDateFormat ("dd/MM/yyyy");
             return formato.parse(cad);
         } catch (ParseException ex){
             System.out.println("Erro na conversão da data.");
         }
         return null;
     }
     
     public static String dateStr(Date cad){
         SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
         return formato.format(cad);
     }
    
}
