package dao;

import bean.MebClientes;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author maria
 */
public class ClientesDAO extends DAO_Abstract {

    @Override
    public void insert(Object object) {
         session.beginTransaction();// todas as conexão com os bancos de dados precisam de uma.
         session.save(object);
         session.getTransaction().commit();    }

    @Override
    public void update(Object object) {
         session.beginTransaction();
         session.flush();// para limpar o cash do hibernate para não enviar coisas erras
         session.clear();// para limpar o cash do hibernate para não enviar coisas erras
         session.update(object);
         session.getTransaction().commit();  
    }

    @Override
     public void delete(Object object) {
         session.beginTransaction();
         session.flush();
         session.clear();
         session.delete(object);
         session.getTransaction().commit();
    }

    @Override
     public Object list(int id) {
       session.beginTransaction();
        Criteria criteria = session.createCriteria(MebClientes.class); // criteria não é para usar o SELECT * FROM
        criteria.add(Restrictions.eq("id_meb_clientes", id));//metodo estatico, porque é uma classe.// eq é equals // esse id é o parametro da loinha 44
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MebClientes.class); // criteria não é para usar o SELECT * FROM
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    // Método para obter uma lista
     public List listNome(String mebNome){
        session.beginTransaction();// Inicia uma transação do Hibernate
        Criteria crit = session.createCriteria(MebClientes.class);// Cria um critério para a classe 
        crit.add(Restrictions.like("mebNome", mebNome, MatchMode.ANYWHERE));// Adiciona uma restrição para buscar registros
        List lista = crit.list();// Obtém a lista de resultados
        session.getTransaction().commit();// Comita a transação

        return lista;
    }
    
    public List listEstado(int mebEstado){
        session.beginTransaction();
        Criteria crit = session.createCriteria(MebClientes.class);
        crit.add(Restrictions.ge("mebEstado", mebEstado));
        List lista = crit.list();
        session.getTransaction().commit();
        return lista;
    }
    
      public List listNomeEstado(String mebNome, int mebEstado){
        session.beginTransaction();
        Criteria crit = session.createCriteria(MebClientes.class);
        crit.add(Restrictions.like("mebNome", mebNome, MatchMode.ANYWHERE));
        crit.add(Restrictions.ge("mebEstado", mebEstado));
        List lista = crit.list();
        session.getTransaction().commit();
        return lista;
    }

    
    
    
}
