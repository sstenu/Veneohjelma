/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.54
 * Generated at: 2021-12-16 16:35:54 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class muutavene_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<script src=\"scripts/main.js\"></script>\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.min.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/tyyli.css\">\r\n");
      out.write("<title>Veneen muuttaminen</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<form id=\"tiedot\">\r\n");
      out.write("		<table>\r\n");
      out.write("			<thead>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<th colspan=\"4\"><span id=\"ilmo\"></span></th>\r\n");
      out.write("					<th colspan=\"2\" class=\"oikealle\"><span id=\"takaisin\">Takaisin listaukseen</span></th>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<th>Nimi</th>\r\n");
      out.write("					<th>Merkki ja malli</th>\r\n");
      out.write("					<th>Pituus</th>\r\n");
      out.write("					<th>Leveys</th>\r\n");
      out.write("					<th>Hinta</th>\r\n");
      out.write("					<th></th>\r\n");
      out.write("				</tr>\r\n");
      out.write("			</thead>\r\n");
      out.write("			<tbody>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td><input type=\"text\" name=\"nimi\" id=\"nimi\"></td>\r\n");
      out.write("					<td><input type=\"text\" name=\"merkkimalli\" id=\"merkkimalli\"></td>\r\n");
      out.write("					<td><input type=\"text\" name=\"pituus\" id=\"pituus\"></td> \r\n");
      out.write("					<td><input type=\"text\" name=\"leveys\" id=\"leveys\"></td>\r\n");
      out.write("					<td><input type=\"text\" name=\"hinta\" id=\"hinta\"></td>\r\n");
      out.write("					<td><input type=\"submit\" id=\"tallenna\" value=\"Hyväksy\"></td>\r\n");
      out.write("				</tr>\r\n");
      out.write("			</tbody>		\r\n");
      out.write("		</table>\r\n");
      out.write("		<input type=\"hidden\" name=\"tunnus\" id=\"tunnus\">\r\n");
      out.write("	</form>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("	$(\"#takaisin\").click(function(){\r\n");
      out.write("		document.location=\"listaaveneet.jsp\";\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("	var tunnus = requestURLParam(\"tunnus\"); //Funktio löytyy scripts/main.js 	\r\n");
      out.write("	$.ajax({url:\"veneet/haeyksi/\"+tunnus, type:\"GET\", dataType:\"json\", success:function(result){\r\n");
      out.write("		$(\"#tunnus\").val(result.tunnus);\r\n");
      out.write("		$(\"#nimi\").val(result.nimi);\r\n");
      out.write("		$(\"#merkkimalli\").val(result.merkkimalli);\r\n");
      out.write("		$(\"#pituus\").val(result.pituus);\r\n");
      out.write("		$(\"#leveys\").val(result.leveys);\r\n");
      out.write("		$(\"#hinta\").val(result.hinta);\r\n");
      out.write("	}});\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	$(\"#tiedot\").validate({						\r\n");
      out.write("		rules: {	\r\n");
      out.write("			nimi:  {\r\n");
      out.write("				required: true,\r\n");
      out.write("				minlength: 2				\r\n");
      out.write("			},\r\n");
      out.write("			merkkimalli:  {\r\n");
      out.write("				required: true,\r\n");
      out.write("				minlength: 2\r\n");
      out.write("			},	\r\n");
      out.write("			pituus:  {\r\n");
      out.write("				required: true,\r\n");
      out.write("				number: true,\r\n");
      out.write("				minlength: 1\r\n");
      out.write("			},\r\n");
      out.write("			leveys: {\r\n");
      out.write("				required: true,\r\n");
      out.write("				number: true,\r\n");
      out.write("				minlength: 1\r\n");
      out.write("			},\r\n");
      out.write("			hinta: {\r\n");
      out.write("				required: true,\r\n");
      out.write("				number: true,\r\n");
      out.write("				minlength: 1\r\n");
      out.write("			}\r\n");
      out.write("		},\r\n");
      out.write("		messages: {\r\n");
      out.write("			nimi: {\r\n");
      out.write("				required: \"Puuttuu\",\r\n");
      out.write("				minlength: \"Liian lyhyt\"\r\n");
      out.write("			},\r\n");
      out.write("			merkkimalli: {\r\n");
      out.write("				required: \"Puuttuu\",\r\n");
      out.write("				minlength: \"Liian lyhyt\"\r\n");
      out.write("			},\r\n");
      out.write("			pituus: {\r\n");
      out.write("				required: \"Puuttuu\",\r\n");
      out.write("				number: \"Ei kelpaa\",\r\n");
      out.write("				minlength: \"Liian lyhyt\"\r\n");
      out.write("			},\r\n");
      out.write("			leveys:{\r\n");
      out.write("				required: \"Puuttuu\",\r\n");
      out.write("				number: \"Ei kelpaa\",\r\n");
      out.write("				minlength: \"Liian lyhyt\"\r\n");
      out.write("			},\r\n");
      out.write("			hinta: {\r\n");
      out.write("				required: \"Puuttuu\",\r\n");
      out.write("				number: \"Ei kelpaa\",\r\n");
      out.write("				minlength: \"Liian lyhyt\"\r\n");
      out.write("			}\r\n");
      out.write("		},\r\n");
      out.write("		submitHandler: function(form) {	\r\n");
      out.write("			paivitaTiedot();\r\n");
      out.write("		}\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("});\r\n");
      out.write("	\r\n");
      out.write("	function paivitaTiedot(){	\r\n");
      out.write("		var formJsonStr = formDataJsonStr($(\"#tiedot\").serializeArray()); //muutetaan lomakkeen tiedot json-stringiksi\r\n");
      out.write("		$.ajax({url:\"veneet\", data:formJsonStr, type:\"PUT\", dataType:\"json\", success:function(result) { //result on joko {\"response:1\"} tai {\"response:0\"}       \r\n");
      out.write("			if(result.response==0){\r\n");
      out.write("	      	$(\"#ilmo\").html(\"Veneen päivittäminen epäonnistui.\");\r\n");
      out.write("	      }else if(result.response==1){			\r\n");
      out.write("	      	$(\"#ilmo\").html(\"Veneen päivittäminen onnistui.\");\r\n");
      out.write("	      	$(\"#nimi\", \"#merkkimalli\", \"#pituus\", \"#leveys\", \"#hinta\").val(\"\");\r\n");
      out.write("			}\r\n");
      out.write("	  }});	\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("</script>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
