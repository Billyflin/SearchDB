package interfaz;

public interface Session<String> {
    boolean access(String rut,String pass);
    int accessLevel(String ID);
    String sessionID(String rut,String pass);
    void register(String rut,String pass,String level,String id);
    void deleteUser(String id);
}
