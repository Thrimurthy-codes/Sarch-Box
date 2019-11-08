package com.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Dictonary
 */

public class Dictonary extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Dictonary() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String language="en-gb";
		String word_id="apple";
		/*String fields="";
		String strictMatch="";*/
		String urlpath= "https://od-api.oxforddictionaries.com/api/v2/words/" + language + "/" + word_id;
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

	System.out.println("hi>>>"+stringBuilder.toString());

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
