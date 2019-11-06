package app.interfaces;

import app.exceptions.ValidationException;

public interface Validator<E> {
    void validate(E entity) throws ValidationException;
}
