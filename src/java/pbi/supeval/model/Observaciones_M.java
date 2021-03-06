/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbi.supeval.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import pbi.supeval.base.JCGlobals;
import pbi.supeval.base.dbConnect;

/**
 *
 * @author LALO-DOCIZ
 */
public class Observaciones_M {
    private String c_i_placa;
    private String f_d_observacion;
    private String observaciones;
    private int pk_i_observacion;
    
    
    public Observaciones_M( String c_i_placa){
        this.c_i_placa = c_i_placa;
    }
    
    public Observaciones_M( int pk_i_observacion){
        this.pk_i_observacion = pk_i_observacion;
    }
    
    public Observaciones_M( String c_i_placa ,String f_d_observacion, String observaciones){
        this.c_i_placa = c_i_placa;
        this.f_d_observacion = f_d_observacion;
        this.observaciones = observaciones;
    }    
    
    public Observaciones_M( int pk_i_observacion ,String f_d_observacion, String observaciones){
        this.pk_i_observacion = pk_i_observacion;
        this.f_d_observacion = f_d_observacion;
        this.observaciones = observaciones;
    }    
    
    public boolean InsertObservacion () {
        boolean salida = false;
        
        Connection conn = new dbConnect().getConnection();   
        JCGlobals jc = new JCGlobals();
        int NumReg = 0;
        try{
            String query = "{call db_pbi_sup_eval.sp_insert_observacion(?,?,?,?)}";
            CallableStatement stmt;
            stmt = conn.prepareCall(query);
            stmt.setInt(1,Integer.parseInt(this.c_i_placa));
            stmt.setString(2,this.f_d_observacion);
            stmt.setString(3,this.observaciones);
            stmt.setInt(4,Integer.parseInt(jc.getNoEmp()));
            boolean hadResults = stmt.execute();
             // print headings            
            System.out.println("========= SUBIENDO OBSERVACION  =======================");
            while (hadResults) {
                ResultSet rs = stmt.getResultSet();
                while(rs.next()){
                    NumReg = rs.getInt("error");
                    jc.setMsg(rs.getString("msg"));                    
                }                
                hadResults = stmt.getMoreResults();
            } 
            stmt.close();
            conn.close();
        }catch(Exception w){
            System.out.println("¡ ERROR !"+w.getMessage());            
            w.printStackTrace();
        }
        
        if(NumReg > 0)
            salida = false;
        else{
            salida = true;
        }        
        return salida;
    }
    
    public boolean UpdateObservacion () {
        boolean salida = false;
        
        Connection conn = new dbConnect().getConnection();   
        JCGlobals jc = new JCGlobals();
        int NumReg = 0;
        try{
            String query = "{call db_pbi_sup_eval.sp_edit_observacion(?,?,?,?)}";
            CallableStatement stmt;
            stmt = conn.prepareCall(query);
            stmt.setInt(1,this.pk_i_observacion);
            stmt.setString(2,this.f_d_observacion);
            stmt.setString(3,this.observaciones);
            stmt.setInt(4,Integer.parseInt(jc.getNoEmp()));
            boolean hadResults = stmt.execute();
             // print headings            
            System.out.println("========= EDITANDO OBSERVACION  =======================");
            while (hadResults) {
                ResultSet rs = stmt.getResultSet();
                while(rs.next()){
                    NumReg = rs.getInt("error");
                    jc.setMsg(rs.getString("msg"));                    
                }                
                hadResults = stmt.getMoreResults();
            } 
            stmt.close();
            conn.close();
        }catch(Exception w){
            System.out.println("¡ ERROR !"+w.getMessage());            
            w.printStackTrace();
        }
        
        if(NumReg > 0)
            salida = false;
        else{
            salida = true;
        }        
        return salida;
    }
    
    public boolean DeleteObservacion () {
        boolean salida = false;
        
        Connection conn = new dbConnect().getConnection();   
        JCGlobals jc = new JCGlobals();
        int NumReg = 0;
        try{
            String query = "{call db_pbi_sup_eval.sp_delete_obs(?,?)}";
            CallableStatement stmt;
            stmt = conn.prepareCall(query);
            stmt.setInt(1,this.pk_i_observacion);
            stmt.setInt(2,Integer.parseInt(jc.getNoEmp()));
            boolean hadResults = stmt.execute();
             // print headings            
            System.out.println("========= ELIMINANDO OBSERVACION  =======================");
            while (hadResults) {
                ResultSet rs = stmt.getResultSet();
                while(rs.next()){
                    NumReg = rs.getInt("error");
                    jc.setMsg(rs.getString("msg"));                    
                }                
                hadResults = stmt.getMoreResults();
            } 
            stmt.close();
            conn.close();
        }catch(Exception w){
            System.out.println("¡ ERROR !"+w.getMessage());            
            w.printStackTrace();
        }
        
        if(NumReg > 0)
            salida = false;
        else{
            salida = true;
        }        
        return salida;
    }
    
    
    public String SearchObservacion () {
        //boolean salida = false;
        
        Connection conn = new dbConnect().getConnection();   
        JCGlobals jc = new JCGlobals();
        String resultado = "", table = "" ,placaynombre = "";
        int nr = 0;
                
        try{
            String query = "{call db_pbi_sup_eval.sp_search_obs(?)}";
            CallableStatement stmt;
            stmt = conn.prepareCall(query);
            stmt.setInt(1,Integer.parseInt(this.c_i_placa));
            boolean hadResults = stmt.execute();
             // print headings            
            System.out.println("========= OBTENIEDO OBSERVACION  =======================");
            
            while (hadResults) {
                ResultSet rs = stmt.getResultSet();
                
                while(rs.next()){
                    nr++;
                    placaynombre ="<div class='form-control'>"
                                 +     rs.getString("Placa")+" - "+rs.getString("Nombre")                                 
                                 + "</div>";                    
                    table += "<tr><td>"+nr+"</td>"
                            +   "<td>"+rs.getString("d_v_observacion")+"</td>"
                            +   "<td>"+rs.getString("f_d_observacion")+"</td>"
                            +   "<td><button class='btn btn-info' onclick ='CargaDatosEditaObs(this,"+rs.getString("pk_i_observacion")+")' data-toggle=\"modal\" data-target=\"#ModalEditaObservacion\">Editar</button></td>"
                            +   "<td><button class='btn btn-danger' onclick='DeleteObs("+rs.getString("pk_i_observacion")+")'>Eliminar</button></td>"
                            + "</tr>";                    
                }                
                hadResults = stmt.getMoreResults();
            }
            if (nr == 0){
                table ="<tr><td colspan =\"4\" ><center> SIN REGISTROS </center></td></tr>";
            }
            resultado = placaynombre
                      + " <table class='table'>  "
                      + "   <thead>  "
                      + "     <th> </th>"                      
                      + "     <th> Observación </th>"                      
                      + "     <th> Fecha de Observación </th>"                      
                      + "     <th>  </th>"                      
                      + "     <th>  </th>"                      
                      + "   </thead> "
                      + "   <tbody> "
                      + table
                      + "   </tbody> ";
            stmt.close();
            conn.close();
        }catch(Exception w){
            System.out.println("¡ ERROR !"+w.getMessage());            
            w.printStackTrace();
        }
        
        return resultado;
    }
    
}
