package exceptions;

/**
 * Created by augustoccesar on 11/10/16.
 */
public class EntityNotPassedValidation extends RuntimeException {
    public EntityNotPassedValidation(Object entity) {
        super("The entity " + entity.getClass().getName() + " didn't passed the validations.");
    }
}
