package pbi.supeval.model;

public class jcNav {

    private String g_navegador = "";


    public jcNav() {
        super();
    }


    public String m_TipoNav(String i_datanav) {

        if (i_datanav.indexOf("MSIE") != -1) {
            if (i_datanav.indexOf("MSIE 9") != -1) {
                g_navegador = "ie9";
            } else {
                g_navegador = "ie";
            }
        } else if (i_datanav.indexOf("Opera") != -1) {
            g_navegador = "opera";
        } else if (i_datanav.indexOf("Chrome") != -1) {
            g_navegador = "chrome";
        } else if (i_datanav.indexOf("Safari") != -1) {
            g_navegador = "safari";
        } else if (i_datanav.indexOf("Firefox") != -1) {
            g_navegador = "firefox";
        } else if (i_datanav.indexOf("Mozilla") != -1) {
 
             if (i_datanav.indexOf("Trident/4.0") != -1) {
                g_navegador = "ie8";
            } 
            else if (i_datanav.indexOf("Trident/5.0") != -1) {
                g_navegador = "ie9";
            }
            else if (i_datanav.indexOf("Trident/6.0") != -1) {
                g_navegador = "ie10";
            }
            else if (i_datanav.indexOf("Trident/7.0") != -1) {
                g_navegador = "ie11";
            }
            else {
                g_navegador = "mozilla";
            }               
            
        } else if (i_datanav.indexOf("Netscape") != -1) {
            g_navegador = "netscape";
        } else if (i_datanav.indexOf("Konqueror") != -1) {
            g_navegador = "konqueror";
        } else if (i_datanav.indexOf("Blackberry") != -1) {
            g_navegador = "blackberry";
        } else {
            g_navegador = "desconocido";
        }

        return g_navegador;
    }

}
