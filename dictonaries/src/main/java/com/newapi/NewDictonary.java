package com.newapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.*;

/**
 * Servlet implementation class NewDictonary
 */

public class NewDictonary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewDictonary() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String language="en-gb";
		String word_id=request.getParameter("firstname");
		/*String fields="";
		String strictMatch="";*/
		/*https://od-api.oxforddictionaries.com/api/v2/entries/en-gb/hello
*/		String urlpath= "https://od-api.oxforddictionaries.com/api/v2/entries/" + language + "/" + word_id;
	try {
	URL url = new URL(urlpath);
	HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
	urlConnection.setRequestProperty("Accept","application/json");
	urlConnection.setRequestProperty("app_id","6ec2fc2b");
	urlConnection.setRequestProperty("app_key","55980453a07a6f007443ffc11e0f88cd");
	urlConnection.setRequestMethod("GET");
	urlConnection.getDoInput();

	// read the output from the server
	BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
	StringBuilder stringBuilder = new StringBuilder();

	String line = null;
	while ((line = reader.readLine()) != null) {
	stringBuilder.append(line + "\n");
	}
	
	
	String data=stringBuilder.toString();

	JSONObject obj=new JSONObject(data);
	JSONArray arr=obj.getJSONArray("results");
	
	JSONObject obj1=arr.getJSONObject(0);
	JSONArray arr1=obj1.getJSONArray("lexicalEntries");
	
	JSONObject obj2=arr1.getJSONObject(0);
	JSONArray arr2=obj2.getJSONArray("entries");

	JSONObject obj3=arr2.getJSONObject(0);
	JSONArray arr3=obj3.getJSONArray("senses");
	
	JSONObject obj4=arr3.getJSONObject(0);
	JSONArray arr4=obj4.getJSONArray("definitions");
	
	
	
	String st=arr4.getString(0);
	
	
	
	PrintWriter out = response.getWriter();
	out.print(word_id +"DEFINITION:"+st);
	}
	catch (Exception e) {
	e.printStackTrace();
	}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
