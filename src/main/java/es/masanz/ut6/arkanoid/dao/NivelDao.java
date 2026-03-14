package es.masanz.ut6.arkanoid.dao;

import es.masanz.ut6.arkanoid.database.ConnectionManager;
import es.masanz.ut6.arkanoid.model.Nivel;

public class NivelDao {

    public static Nivel obtenerNivel(int id){
        // TODO 01: Buscar y devolver el nivel en caso de existir
        String sql = "SELECT id, filas, columnas, ladrillos, siguiente_nivel FROM nivel WHERE id = ? ";
        Object[] params = {id};
        Object[][] result = ConnectionManager.ejecutarSelectSQL(sql, params);
        Nivel nivel = null;
        if(result!=null && result.length==1){
            nivel = new Nivel();
            nivel.setId((int) result[0][0]);
            nivel.setFilas((int) result[0][1]);
            nivel.setColumnas((int) result[0][2]);
            nivel.generarLadrillosDesdeTexto((String) result[0][3]);
            nivel.setSiguienteNivel((int) result[0][4]);
        }
        return nivel;
    }


}
