package beans;

import entity.Book;
import java.util.Collection;
import javax.ejb.Singleton;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
public class LibraryPersistentBean {

    @PersistenceContext(unitName="esa")
    private EntityManager entityManager;

    public Collection<Book> getBooks() {
        return entityManager.createQuery("SELECT c FROM Book c", Book.class).getResultList();
    }
}
