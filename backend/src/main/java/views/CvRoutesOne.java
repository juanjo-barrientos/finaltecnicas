package views;

import java.io.IOException;
import controllers.CvController;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "CvRoutesOne", urlPatterns = {"/api/cv/one"})
public class CvRoutesOne extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        CvController controller = new CvController();
        controller.addCv(request, response);
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        
        String idUser = request.getParameter("idUser");
        String id = request.getParameter("id");
        
        CvController controller = new CvController();

        if(id == null || id.isBlank() || id.isEmpty()){
            controller.getCvs(request, response, idUser);  
        }else{
            controller.getOneCvs(request, response, idUser, id);
        }
        
    }
}
