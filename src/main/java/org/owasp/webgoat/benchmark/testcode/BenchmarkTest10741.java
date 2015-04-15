package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10741")
public class BenchmarkTest10741 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("foo")[0];
		}
		

		String bar = new Test().doSomething(param);
		
		response.addHeader(bar, "SomeValue");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map21285 = new java.util.HashMap<String,Object>();
		map21285.put("keyA-21285", "a_Value"); // put some stuff in the collection
		map21285.put("keyB-21285", param.toString()); // put it in a collection
		map21285.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map21285.get("keyB-21285"); // get it back out
		bar = (String)map21285.get("keyA-21285"); // get safe value back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass