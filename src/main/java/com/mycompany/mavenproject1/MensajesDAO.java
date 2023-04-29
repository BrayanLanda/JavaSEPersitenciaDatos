/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
         Conexion dbConnect = new Conexion();
         PreparedStatement ps = null;
         ResultSet rs = null;
        try (Connection conexion = dbConnect.get_connection()){
            String query = "SELECT * FROM mensajes_app";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_mensaje"));
                System.out.println("Mensaje: " + rs.getString("mensajes"));
                System.out.println("Autor: " + rs.getString("autor_mensaje"));
                System.out.println("Fecha: " + rs.getString("fecha_mensaje"));
                System.out.println("");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }
    
    public static void borrarMensajeDB(int idMensaje){
        Conexion dbConnect = new Conexion();
        try (Connection conexion = dbConnect.get_connection()){
            PreparedStatement ps = null;
            try {
                String query = "DELETE FROM mensajes_app WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, idMensaje);
                ps.executeUpdate();
                System.out.println("mensaje borrado");
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static void actualizarMensajeDB(Mensajes mensaje){
        Conexion dbConnect = new Conexion();
        try (Connection conexion = dbConnect.get_connection()){
            PreparedStatement ps = null;
            try {
                String query = "UPDATE mensajes_app SET mensajes = ? WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getIdMensaje());
                ps.executeUpdate();
                System.out.println("mensaje actualizado");
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }catch (SQLException e) {
            System.out.println(e);
        }
    }
}
