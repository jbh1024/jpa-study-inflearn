package jpabook.jpashop;

import com.sun.tools.corba.se.idl.constExpr.Or;
import jpabook.jpashop.domain.Book;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory enf = Persistence.createEntityManagerFactory("jpashop");
        EntityManager em = enf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin(); //트렌젝션 시작

        try {

            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("김영한");

            em.persist(book);

            tx.commit(); // 트렌젝션 커밋
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); //엔티티 메매저 닫고
        }
            enf.close(); //엔티티 매니저 펙토리 닫고

        }

}
