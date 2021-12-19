package interfaz;


public interface CRUD<T> {
    T create(T list);
    T read(T list);
    boolean update(T objet);
    boolean delete();
}
