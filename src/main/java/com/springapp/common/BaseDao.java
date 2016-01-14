package com.springapp.common;

/**
 * TODO �˴���д class ��Ϣ
 *
 * @author krisjin
 * @date 2014-1-26����1:39:27
 */

public interface BaseDao<T> {

    Long add(T entity);


    void update(T entity);


    void deleteById(long id);


    T select(long id);


}
