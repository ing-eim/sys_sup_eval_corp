/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbi.supeval.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import pbi.supeval.base.dbConnect;
import pbi.supeval.base.JCGlobals;
/**
 *
 * @author LALO-DOCIZ
 */
public class validation {
    private String Us;
    private String pwd;
    private String ip;
    private String host;
    private String navigator;
    private boolean Session;
    
    public validation(String us, String pwd,String ip, String host,String navigator){
        this.Us = us;
        this.pwd = pwd;        
        this.ip = ip;
        this.host = host;
        this.navigator = navigator;        
        if(ValidaUsuario()){
           this.SetSession(true);
        }else{
               this.SetSession(false);
        }
    }
    public validation(String us, String pwd,String ip){
        this.Us = us;
        this.pwd = pwd;        
        this.ip = ip;
        if(ValidaUsuario()){
           this.SetSession(true);
        }else{
               this.SetSession(false);
        }
    }
    
    private void SetSession(boolean s){
        this.Session = s;
    }
    public boolean getSesion(){
        return this.Session;
    }
    private boolean ValidaUsuario(){
        boolean valido = false;
        Connection conn = new dbConnect().getConnection();
        int Numreg = 0;
        JCGlobals jc = new JCGlobals();
        try{            
            String query = "{call db_pbi_adminsic.SPIniciaSessionWeb(?,?,?,?)}";
            CallableStatement stmt;
            stmt = conn.prepareCall(query);
            stmt.setInt(1,Integer.parseInt(this.Us));
            stmt.setString(2, this.pwd);            
            stmt.setInt(3, 10);/*  APLICATIVO 10 DE ADMISITRACION SIC*/
            stmt.setString(4, this.ip);            
            System.out.println("1.- INICIANDO SESIÓN ... ");
           
            boolean hadResults = stmt.execute();
 
            // print headings            
            System.out.println("================================");
            
            while (hadResults) {
                ResultSet rs = stmt.getResultSet();
                while(rs.next()){                 
                    Numreg = rs.getInt("numreg");//person_exists
                    jc.setid_session(rs.getString("pk_i_sesion"));
                    jc.setpk_i_persona(rs.getString("pk_i_persona"));
                    jc.setNoEmp(rs.getString("c_i_placa"));
                    jc.setNombreC(rs.getString("Nombre"));
                    //jc.setDescAdsc("");
                    if( rs.getString("tIdGrado") == null )
                        jc.setDescPuesto("Grado");                
                    else
                        jc.setDescPuesto("tIdGrado");                
                    jc.setMsg(rs.getString("msg"));
                    //jc.setidAdsc(rs.getString("nIdAdscripcion"));
                }                
                hadResults = stmt.getMoreResults();
            } 
            stmt.close();                        
            conn.close();
        }catch(Exception w){
            System.out.println("¡ ERROR !" + w.getMessage());            
            w.printStackTrace();
        }        
        if(jc.getid_session().equals("")|| jc.getid_session().isEmpty()||jc.getid_session().equals("0")){
            valido = false;
        }else{
            valido = true;
        }
        return valido;
    }
    /*public static void main (String []args){
        dbConnect d =  new dbConnect();        
    }*/
}
