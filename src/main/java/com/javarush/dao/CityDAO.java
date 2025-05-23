package com.javarush.dao;

import com.javarush.domain.City;
import lombok.AllArgsConstructor;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

@AllArgsConstructor
public class CityDAO {

    private final SessionFactory sessionFactory;

    public List<City> getItems(int offset, int limit) {
        Query<City> query = sessionFactory.getCurrentSession()
                .createQuery("select c from City c", City.class);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    public int getTotalCount() {
        Query<Long> query = sessionFactory.getCurrentSession().createQuery("select count(c) from City c", Long.class);
        return Math.toIntExact(query.uniqueResult());
        // Возвращает значение аргумента long и генерирует исключение, если значение выходит за пределы int.
    }

    public City getById(Integer id) {
        Query<City> query = sessionFactory.getCurrentSession()
                .createQuery("select c from City c join fetch c.country where c.id = :ID", City.class);
        query.setParameter("ID", id);
        return query.getSingleResult();
    }
}
