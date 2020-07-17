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
public class Quejas_Denuncias_M {
   private String c_i_placa;
   private String queja;
   private String tipoestimulo;
   private String actividad;
   
   public Quejas_Denuncias_M(String c_i_placa, String queja){
       this.c_i_placa = c_i_placa;
       this.queja = queja;
   } 
   
    public Quejas_Denuncias_M(String c_i_placa, String tipoestimulo,String actividad){
       this.c_i_placa = c_i_placa;
       this.tipoestimulo = tipoestimulo;
       this.actividad = actividad;
   } 
   
   public boolean InsertQueja(){
        boolean salida;
        Connection conn = new dbConnect().getConnection();   
        JCGlobals jc = new JCGlobals();
        int NumReg = 0;
        try{
            String query = "{call db_pbi_sup_eval.sp_insert_queja(?,?,?)}";
            CallableStatement stmt;
            stmt = conn.prepareCall(query);
            stmt.setInt(1,Integer.parseInt(this.c_i_placa));
            stmt.setString(2,this.queja);/*142 OFICIOS DE COMISION */
            stmt.setInt(3,Integer.parseInt(jc.getNoEmp()));
            boolean hadResults = stmt.execute();
             // print headings            
            System.out.println("========= SUBIENDO QUEJA  =======================");
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
   
   
   public boolean InsertEstimulo(){
        boolean salida;
        Connection conn = new dbConnect().getConnection();   
        JCGlobals jc = new JCGlobals();
        int NumReg = 0;
        try{
            String query = "{call db_pbi_sup_eval.sp_insert_estimulo(?,?,?,?)}";
            CallableStatement stmt;
            stmt = conn.prepareCall(query);
            stmt.setInt(1,Integer.parseInt(this.c_i_placa));
            stmt.setString(2,this.tipoestimulo);
            stmt.setString(3,this.actividad);
            stmt.setInt(4,Integer.parseInt(jc.getNoEmp()));
            boolean hadResults = stmt.execute();
             // print headings            
            System.out.println("========= SUBIENDO ESTIMULO  =======================");
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
   
   
}
