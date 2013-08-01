package devopsdistilled.operp.client.abstracts;

/**
 * Concrete EntityModelObserver sub-classing this interface should have methods
 * like "updateEntities" as their first method.
 * 
 * Like for "ItemModelObserver", the "updateItems" should be first method
 * declaration. Else "AbstractEntityModel.getUpdateMethod()" requires change in
 * definition
 */
public interface EntityObserver extends Observer {

}
