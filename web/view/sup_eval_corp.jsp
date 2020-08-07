<%-- 
    Document   : sup_eval_corp
    Created on : 9/07/2020, 11:19:24 AM
    Author     : LALO-DOCIZ
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="pbi.supeval.base.JCGlobals;"%>
<%@page import="pbi.supeval.base.JCSession;"%>

<%
    
    
    request.getSession();
    HttpSession misession= (HttpSession) request.getSession();
    if(misession.getAttribute("c_v_session").toString().length() == 0)
    {
%>
<script>
    window.location = 'lg.jsp';
</script>
<%  }else{  %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PBI</title>
        <script src="../js/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="../js/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="../js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="../js/jquery-3.5.0.min.js"></script>
        <script src="../js/Close_Ses.js"></script>
        <script src="../js/Functions_Sup_Eval.js"></script>
        
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="../css/pbi_styles.css">
        <link rel="stylesheet" type="text/css" href="../css/styles.css">
    </head>
    <body>
            <br/>
        <div class="title_sis">
            SUPERVISIÓN
        </div>
        <div id="panelSup">Bienvenido <br/>
            <%
                /*out.println(new JCGlobals().getNoEmp());
                out.println("  |  ");
                out.println(new JCGlobals().getNombreC());
                out.println("( <small><strong>");
                out.println(new JCGlobals().getDescPuesto());
                out.println("</strong></small> )");*/
                %>
        </div>
        <div id="reloj" class='reloj_s'>                    
        </div>
        <div id='session_progress'>            
        </div>
        <br/>
        <br/>
        <nav>
            <div class="nav nav-tabs" id="nav-tab" role="tablist">
                <a class="nav-item nav-link active" id="nav-comision-tab" data-toggle="tab" href="#nav-comision" role="tab" aria-controls="nav-comision" aria-selected="true"> Oficios de Comisión </a>
                <% /*if (new JCGlobals().getDescPuesto().equals("DIRECTOR ADMINISTRATIVO")||new JCGlobals().getDescPuesto().equals("SUBDIRECTOR DE AREA")){*/ %>
                <a class="nav-item nav-link" id="nav-correctivos-tab" data-toggle="tab" href="#nav-correctivos" role="tab" aria-controls="nav-correctivos" aria-selected="false" onclick=""> Correctivos Disciplinarios </a>
                <%/*}*/%>
                <a class="nav-item nav-link" id="nav-quejas-tab" data-toggle="tab" href="#nav-quejas" role="tab" aria-controls="nav-quejas" aria-selected="false" onclick=""> Quejas y Denuncias </a>
                <a class="nav-item nav-link" id="nav-estimulos-tab" data-toggle="tab" href="#nav-estimulos" role="tab" aria-controls="nav-estimulos" aria-selected="false" onclick=""> Estímulos y Condecoraciones  </a>
                <a class="nav-item nav-link" id="nav-observaciones-tab" data-toggle="tab" href="#nav-observaciones" role="tab" aria-controls="nav-observaciones" aria-selected="false" onclick=""> Observaciones  </a>
                <a class="nav-item nav-link" id="nav-close-tab" onclick ="c_s();" data-toggle="tab" href="#" role="tab" aria-controls="nav-contact" aria-selected="false">Cierre Session</a>
            </div>
        </nav>
        <div class="tab-content" id="nav-tabContent">
            <div class="tab-pane fade show active" id="nav-comision" role="tabpanel" aria-labelledby="Escribir Reporte del día">
                <div class="container">
                    <br>
                    <h1> Cargar Oficios de Comisión </h1>
                    <form id="frmfilecomision" type="post" enctype="multipart/form-data"> 
                        <div class="form-row">
                            <div class="form-group">                                
                                <label for="txtc_i_placa"> Placa </label>
                                <input type="text"  class="form-control" id="txtc_i_placa" name = "txtc_i_placa" value = ""/>   
                            </div>                            
                        </div>
                        <div class="form-row">
                            <div class="form-group">                        
                                <label for="txtnumoficio"> No. de Oficio </label>
                                <input type="text" class="form-control" id="txtnumoficio" name = "txtnumoficio" value = ""/>   
                            </div>                            
                        </div>
                        <div class="form-row">
                            <div class="form-group">                            
                                <input type="file" class="form-control" id="in_file" name="in_file" multiple accept=".pdf"/>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group">                            
                            <input type="submit" class="btn btn-info form-control" value="Subir Archivos">
                            </div>
                        </div>
                    </form>                    
                </div>
            </div>
            <!--              PANEL CORRECTIVOS       -->
            <div class="tab-pane fade" id="nav-correctivos" role="tabpanel" aria-labelledby="Cargar Correctivos">
                <div class="container">
                    <br>
                    <h1> Cargar Boleta de Arresto </h1>
                    <form  id="frmfilecorrectivo" type="post" enctype="multipart/form-data">
                        <div class="form-row">
                            <div class="form-group col-md-4">                                
                                <label for="txtc_i_placabol"> Placa </label>
                                <input type="text" class="form-control" id="txtc_i_placabol" name = "txtc_i_placabol" value = ""/>   
                            </div>                            
                        </div>
                        <!--<div class="form-row">
                            <div class="form-group col-md-4">
                                <label for="txtfechaboleta">Fecha</label>
                                <input type="date" id="txtfechaboleta" name="txtfechaboleta" class="form-control">                            
                            </div>                    
                        </div>-->
                        <div class="form-row">
                            <div class="form-group">                            
                                <input type="file" class="form-control" id="in_filebol" name="in_filebol" multiple accept=".pdf"/>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group">                            
                            <input type="submit" class="form-control btn btn-info" value="Subir Archivos">
                            </div>
                        </div>
                    </form>
                </div>                
                
            </div>
            
            <!--              PANEL QUEJAS       -->
            <div class="tab-pane fade" id="nav-quejas" role="tabpanel" aria-labelledby="Quejas y Denuncias">
                <div class="container">
                    <br>
                    <h1> Quejas y Denuncias </h1>                    
                    <div class="form-row">
                        <div class="form-group col-md-4">                            
                            <label for="txtc_i_placabol"> Placa </label>
                            <input type="text" class="form-control" id="txtc_i_placaquejas" name = "txtc_i_placaquejas" value = ""/>   
                        </div>                            
                    </div>
                    <div class="form-row">
                        <div class="form-group col-lg-10">                            
                            <label for="txtqueja"> Queja </label>
                            <textarea class="form-control" id="txtqueja" placeholder="Escriba aqui breve resumen de la queja o denuncia"></textarea>
                        </div>
                    </div>
                    <div class="row col-10">
                        <div class="form-group">                                                       
                            <input type = "button" id="btnGuardaQueja" class="form-control btn btn-success" value="Guardar" onclick ='UploadQueja();'>
                        </div>                        
                    </div>
                </div>
            </div>            
            <!-- ****************************  -->
            <!-- PANEL GENRA REPORTE       -->
            <div class="tab-pane fade" id="nav-estimulos" role="tabpanel" aria-labelledby="Estímulos y Condecoraciones">
                <div class="container">
                    <br>
                    <h1> Estímulos y Condecoraciones </h1>                    
                    <div class="form-row">
                        <div class="form-group col-md-4">                            
                            <label for="txtc_i_placabol"> Placa </label>
                            <input type="text" class="form-control" id="txtc_i_placaescon" name = "txtc_i_placaescon" value = ""/>   
                        </div>                            
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-4">                            
                            <label for="txttipoestimulo"> Tipo de Estímulo o Condecoración </label>
                            <input type="text"  class="form-control" id="txttipoestimulo" name = "txttipoestimulo" value = ""/>   
                        </div>                            
                    </div>
                    <div class="form-row">
                        <div class="form-group col-lg-10">                            
                            <label for="txt"> Actividad </label>
                            <textarea id ='txtmotivo' class="form-control" placeholder="Escriba aqui actividad realizada..."></textarea>
                        </div>
                    </div>
                    <div class="row col-10">
                        <div class="form-group">                                                       
                            <input type = "button" id="btnGuardaEstimulo" class="form-control btn btn-success" value="Guardar" onclick ='UploadEstimulo();'>
                        </div>                        
                    </div>
                </div>
            </div>
    <!------------------    CONTENEDORES OBSERVACIONES   --------------------------------------------------------------------------------------------------------->        
            <!-- ********   CONTENEDOR OBSERVACIONES INSERT   ********************  -->           
            <div class="tab-pane fade" id="nav-observaciones" role="tabpanel" aria-labelledby="Observaciones al personal">
                <div class="container">
                    <br>
                    <h1> Observaciones al Personal </h1>
                    <div class="form-row">
                        <div class="form-group col-md-4">
                            <label for="txtc_i_placabol"> Placa </label>
                            <input type="text" class="form-control" id="txtc_i_placaobs" name = "txtc_i_placaobs" value = ""/><small>Ingrese la Placa y Presione Enter</small>
                        </div>
                    </div>
                    <div class="form-row" id='btnagregaobs' style='display: none;'>
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#ModalNuevaObservacion"> Agregar Observación </button>
                    </div>
                    
                    <div class="form-row">
                        <div class="container" id="tblobservaciones">                           
                        </div>
                    </div>
                    
                    <!-- VENTANA MODAL PARA INSERTAR NUEVA OBSERVACION-->
                    <!-- Button trigger modal -->
                    
                    <!-- Modal -->
                    <div class="modal fade" id="ModalNuevaObservacion" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel"> Agregar Observación </h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <div class="form-row">
                                        <div class="form-group col-md-4">                            
                                            <label for="txtfechaobservacion"> Fecha de Observacion </label>
                                            <input type="date"  class="form-control" id="txtfechaobservacion" name = "txtfechaobservacion" value = ""/>   
                                        </div>                            
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-lg-10">                            
                                            <label for="txtobservaciones"> Observaciones </label>
                                            <textarea id ='txtobservaciones' class="form-control" placeholder="Escriba aqui observaciones realizadas al personal ..."></textarea>
                                        </div>
                                    </div>                                    
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                    <button type="button" class="btn btn-primary" onclick="UploadObservacion();" data-dismiss="modal">Guardar</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- -->
                    <!--MODAL PARA EDICIÓN DE REGISTRO -->
                    <div class="modal fade" id="ModalEditaObservacion" tabindex="-1" role="dialog" aria-labelledby="ModalEditarObsrevacion" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel"> Editar Observación </h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <div class="form-row">
                                        <input type="hidden" id="pk_i_obs" value=""> 
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-4">                            
                                            <label for="txtfechaobservacion_edit"> Fecha de Observacion </label>
                                            <input type="date"  class="form-control" id="txtfechaobservacion_edit" name = "txtfechaobservacion" value = ""/>   
                                        </div>                            
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-lg-10">                            
                                            <label for="txtobservaciones_edit"> Observaciones </label>
                                            <textarea id ='txtobservaciones_edit' class="form-control" placeholder="Escriba aqui observaciones realizadas al personal ..."></textarea>
                                        </div>
                                    </div>                                    
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                    <button type="button" class="btn btn-primary" onclick="UpdateObservacion();" data-dismiss="modal">Guardar</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <!-- CIERRA VENTANA MODAL PARA INSERTAR NUEVA OBSERVACION -->
                    
                </div>
                
                
                
            </div>            
            <!-- *******  CIERRA CONTENEDOR INSERT OBSERVACIONES   ********************* -->
    <!------------------------------------------------------------------------------------------------------------------------->        
        </div>
    </body>
</html>
<%  }  %>