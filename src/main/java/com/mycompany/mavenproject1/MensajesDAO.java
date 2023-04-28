/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author carolan
 */
public class MensajesDAO {
    public static void crearMensajeDB(Mensajes mensaje){
        Conexion dbConnect = new Conexion();
        try (Connection conexion = dbConnect.get_connection()){
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO mensajes_app (mensajes, autor_mensaje, fecha_mensaje) VALUES (?,?, CURRENT_DATE())";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutorMensaje());
                ps.executeUpdate();
                System.out.println("Mensaje Creado");
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static void leerMensajesDB(){
        
    }
    public static void borrarMensajeDB(int idMensaje){
        
    }
    public static void actualizarMensajeDB(Mensajes mensaje){
        
    }
}
