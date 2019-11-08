# Sarch-Box
create a search box by using oxford dictionary API
// here we used GET method  
1.create html file for entering the input 
2.from html we are mapped our servlet file through web.xml to call our file [<url-pattern>/NewDictonary</url-pattern>]
3.we are taking input from html to servlet through [request.getParameter("firstname")]
4.for url using [java.net.URL] 
5. for HttpsUrlConnection using[javax.net.ssl.HttpsURLConnection]
6.for reading input from that url using bufferedReader and inputStreamStreamReader [java.io.BufferedReader & java.io.InputStreamReader]
7.after sucessfully getting response,parsing response to JSONObject [org.json.*]
8.for getting a particular key value 
9.i am using printwriter for printing the response [java.io.PrintWriter]
