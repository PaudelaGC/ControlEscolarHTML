package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Carreras;

public class Querys{
    
    Connect connect = new Connect();
    Connection con = connect.startConnection();
    ArrayList<Carreras> carreras = new ArrayList<Carreras>();
    Carreras carrera = new Carreras();
    
    public void añadirCarrera(Carreras carrera){
        try {
            String query = "INSERT INTO carreras (nombre) VALUES (?)";
            PreparedStatement st =  con.prepareStatement(query);
            st.setString(1, carrera.getNombre());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizarCarrera(Carreras carrera, Carreras nuevaCarrera){
        try {
            String query = "UPDATE carreras SET nombre = ? WHERE nombre = ?";
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, nuevaCarrera.getNombre());
            st.setString(2, carrera.getNombre());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public List<Carreras> mostrarCarreras(){
        try {
            String query = "SELECT * FROM carreras";
            PreparedStatement st = con.prepareStatement(query);
            ResultSet resultSet;
            resultSet = st.executeQuery();
            
            while(resultSet.next()){
                carrera = new Carreras();
                carrera.setNombre(resultSet.getString("nombre"));
                carreras.add(carrera);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return carreras;
    }
    
    public ArrayList<Carreras> mostrarCarrera(Carreras carrera){
        try {
            String query = "SELECT * FROM carreras WHERE nombre = ?";
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, carrera.getNombre());
            ResultSet resultSet;
            resultSet = st.executeQuery();
            
            while(resultSet.next()){
                carrera = new Carreras();
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return carreras;
    }
    
    public void eliminarCarrera(Carreras carrera){
        try {
            String query = "DELETE FROM carreras WHERE nombre = ?";
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, carrera.getNombre());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
