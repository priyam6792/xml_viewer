package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import folder_class.info;
import xml_reader.xml_reader;

/**
 * Servlet implementation class Xml_viewer
 */
@WebServlet("/Xml_viewer")
public class Xml_viewer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Xml_viewer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String address;
		String name;
		address = request.getParameter("file_path");
		name = request.getParameter("file_name");
		System.out.println("file path is : " + address);
		System.out.println("file name is : "+ name);
		StringBuffer sb = new StringBuffer();
		sb.append(address);
		sb.append('\\');
		sb.append(name);
		System.out.println("String buffer is : "+sb.toString());
		ArrayList<info> list = new ArrayList<info>();
		xml_reader read = new xml_reader();
		list = read.reader(sb.toString());
		for(int i=0; i < list.size(); i++)
		{
			System.out.println("Employee :"+ i);
			System.out.println("First name " +list.get(i).getFirst_name());
		}
		request.setAttribute("list", list);
		RequestDispatcher rd=request.getRequestDispatcher("xml.jsp");
		rd.forward(request, response);
	}

}
