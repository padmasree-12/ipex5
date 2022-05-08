/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Lab_ex4;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;


/**
 *
 * @author 91936
 */
public class Ex_2_WeatherServlet extends HttpServlet {
HashMap<String,Ex_2_Weather> map=new HashMap<>();
    HashMap<String,String> imgMap=new HashMap<>();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Ex_2_Weather weather;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           imgMap.put("Highly Sunny","data:image/jpeg;base64,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");
            imgMap.put("Sunny","data:image/png;base64,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");
            imgMap.put("Partially Cloudy","https://c.neh.tw/thumb/f/720/comvecteezy366724.jpg");
            imgMap.put("Cloudy","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSNtTXsKGGZuMulSwZCbPZhzW27P5RuOhgXYLxhkQTrN0AZcNT3mUQ_ErrNJBw2KO33Lxk&usqp=CAU");
            imgMap.put("Icy","https://cdn5.vectorstock.com/i/1000x1000/52/94/weather-snow-cloud-symbol-blue-color-vector-905294.jpg");
            imgMap.put("Windy","https://us.123rf.com/450wm/anggar3ind/anggar3ind1701/anggar3ind170100593/68545099-cloud-blowing-wind-cartoon.jpg?ver=6");
            imgMap.put("Rainy","https://www.pngitem.com/pimgs/m/480-4808944_stormy-weather-png-heavy-rain-clipart-transparent-png.png");
            
            weather=new Ex_2_Weather("Madurai","36\u00B0C","32\u00B0C","Sunny");
            map.put("Madurai",weather);
            
            weather=new Ex_2_Weather("Chennai","39\u00B0C","36\u00B0C","Sunny");
            map.put("Chennai",weather);
            
            weather=new Ex_2_Weather("Trichy","35\u00B0C","31\u00B0C","Partially Cloudy");
            map.put("Trichy",weather);
            
            weather=new Ex_2_Weather("Coimbatore","28\u00B0C","24\u00B0C","Icy");
            map.put("Coimbatore",weather);
            
            weather=new Ex_2_Weather("Salem","40\u00B0C","36\u00B0C","Highly Sunny");
            map.put("Salem",weather);
            
            weather=new Ex_2_Weather("Vellore","42\u00B0C","38\u00B0C","Highly Sunny");
            map.put("Vellore",weather);
            
            weather=new Ex_2_Weather("Tanjore","41\u00B0C","35\u00B0C","Cloudy");
            map.put("Tanjore",weather);
            
            weather=new Ex_2_Weather("Erode","30\u00B0C","28\u00B0C","Rainy");
            map.put("Erode",weather);
            
            weather=new Ex_2_Weather("Karur","31\u00B0C","29\u00B0C","Windy");
            map.put("Karur",weather);
            
            weather=new Ex_2_Weather("Tirupur","30\u00B0C","28\u00B0C","Rainy");
            map.put("Tirupur",weather);

            String city=request.getParameter("cityname");
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet WeatherReport</title>");            
            out.println("</head>");
            out.println("<body style='background-color:white;'>");
            if(map.containsKey(city))           
            {
                weather=map.get(city);
                out.println("<center><div><h1>Weather Report</h1>");
                out.println("<h2>"+weather.city+"</h2>");
                out.println("<img width='100px' height='100px' style='border:2px groove grey;border-radius:40%;' src='"+imgMap.get(weather.status)+"'/>");
                out.println("<table border=2 width='300px' height='300px' style='cell-padding:2%;text-align:center;background-color:#ffff80;font-size:large;'><tr><td>Status</td><td>"+weather.status+"</td>");
                out.println("<tr><td>High temperature 🌡</td><td>"+weather.maxTemp+"</td>");
                out.println("<tr><td>Low temperature 🌡</td><td>"+weather.minTemp+"</td></table><br>");
                out.println("</div></center>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
