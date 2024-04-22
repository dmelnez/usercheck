package mipk;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class LoginAuthenticator
 */
public class LoginAuthenticator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String usuvalido = "admin";
	private String pwdvalida = "1357";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAuthenticator() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("./index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * El metodo doPost, realiza un requerimiento de 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		beanDB db = new beanDB(); // Realiza una copia de un Objeto llamado db. El cual contiene todos los metodos de la conexion a la base de datos.
		HttpSession session = request.getSession(); // Realiza una copia de un objeto llamado session. Partiendo de la clase HttpSession, el cual contiene el 
		// resultado del metodo request, el cual devuelve un 1, si la sesion esta iniciada, y una excepcion si la sesion no lo esta.
		
		String usuario=request.getParameter("usuario"); // Crea un string llamado usuario. 
		String pass=request.getParameter("pass"); // Crea un string llamado pass. 
		if (usuario == null) usuario=""; // Se realiza un condicional con la variable usuario, el cual comprueba si su valor es igual a nulo. Y si lo es, la variable usuario, pasara a ser una variable vacia.
		if (pass == null) pass=""; // Se traliza un condicional con la variable pass, el cual comprueba si su valor es igual a nulo, y si lo es, el valor de la variable pass, su valor pasara a ser vacio.
		boolean ok=false; // Asignacion a la variable "ok", de tipo boleano, a falso.
		
		if(usuario.equals(usuvalido) && pass.equals(pwdvalida)) { // Si el "usuario", es igual, a la variable "usuvalido", que contiene el valor del usuario. Y la variable "pass", es igual a "pwdvalida", que contiene la contraseña del usuario. Entra en el if.
			session.setAttribute("attributo2",usuario); // Llamamiento al objeto session, y al metodo setAttribute, pasandole como parametro la variale "usuario".
			session.setAttribute("attributo1","1"); // Llamamiento al objeto session, y al metodo setAttribute, pasandole como parametro attributo1 y 1;
			ok=true;
		}
				
		if (ok) response.sendRedirect("bienvenido.jsp"); // Condicional, si el valor de la variable boleana es true. Manda al usuario a la pagina "bienvenido.jsp".
		else response.sendRedirect("index.jsp"); // Condicional, si el valor de la variable boleana es distinto a true.  Manda al usuario a la pagina "index.jsp".

	}
	
	
	


}
