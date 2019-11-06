package app.objects.repositories;

import app.exceptions.ValidationException;
import app.interfaces.CrudRepository;
import app.interfaces.Validator;
import app.objects.Entity;

import java.awt.*;
import java.io.IOException;
import java.util.LinkedList;

public abstract class AbstractRepository<ID,E extends Entity<ID>> implements CrudRepository<ID,E> {

    protected LinkedList<E> list;
    protected Validator validator;


    public AbstractRepository(Validator validator) {
        list = new LinkedList<>();
        this.validator = validator;
    }

    @Override
    public E findOne(ID id) {
        if(id == null)
            throw new IllegalArgumentException("The id is null!");

        for(E elem:list){
            if(elem.getId().equals( id))
                return elem;
        }
        return null;
    }

    @Override
    public Iterable<E> findAll() {
        return list;
    }

    @Override
    public E save(E entity) throws ValidationException {
        if(entity == null)
            throw new IllegalArgumentException("The entity is null!");

        validator.validate(entity);
        if(list.contains(entity))
            return entity;

        list.add(entity);
        return null;

    }

    @Override
    public E delete(ID id) {
        if(id == null)
            throw new IllegalArgumentException("The id is null!");

        E removedElem = findOne(id);
        if(removedElem == null)
            return null;

        list.remove(removedElem);
        return removedElem;
    }

    @Override
    public E update(E entity) {
        try{
            if(entity == null)
                throw new IllegalArgumentException("The entity is null!");

            validator.validate(entity);
            for(int i = 0; i< list.size(); i++){
                if(list.get(i).getId().equals(entity.getId())) {
                    list.set(i, entity);
                    return null;
                }
            }

        }catch (ValidationException e){
            System.out.println(e);
            return null;
        }
        return entity;
    }


    public abstract void readFromFile(String file) throws IOException;

    public int size(){
        return list.size();
    }

    public void clearAll(){
        list.clear();
    }
}
