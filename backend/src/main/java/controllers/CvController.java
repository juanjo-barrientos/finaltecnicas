package controllers;

import Dao.CvDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import com.google.gson.JsonObject;
import helpers.CvHelper;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;

public class CvController {

    public CvController() {
    }

    public void getCvs(HttpServletRequest request, HttpServletResponse response, String idUser) throws ServletException, IOException {
        CvDAO dao = new CvDAO();
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        List<Document> cvList = dao.getCvs(idUser);
        String objectReturn = gson.toJson(cvList);
        PrintWriter out = response.getWriter();
        out.print(objectReturn);
        out.flush();
    }

    public void getOneCvs(HttpServletRequest request, HttpServletResponse response, String idUser, String id) throws ServletException, IOException {
        CvDAO dao = new CvDAO();
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        Document cvUnique = dao.getOneCv(idUser, id);
        String objectReturn = gson.toJson(cvUnique);
        PrintWriter out = response.getWriter();
        out.print(objectReturn);
        out.flush();
    }

    public void addCv(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        }
        try {
            String body = stringBuilder.toString();
            Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
            JsonObject jsonObject = gson.fromJson(body, JsonObject.class);
            CvDAO dao = new CvDAO();
            dao.insertCv(new CvHelper().generate(jsonObject));
            response.getWriter().write("{\"status\":\"success\"}");
        } catch (Exception e) {
            response.setStatus(400);
            response.getWriter().write("{\"status\":\"failed\"}");
        }
    }

    public void updateCv(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        }

        try {
            String body = stringBuilder.toString();
            Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
            JsonObject jsonObject = gson.fromJson(body, JsonObject.class);
            CvDAO dao = new CvDAO();
            boolean result = dao.updateOneCv(new CvHelper().generate(jsonObject), request.getParameter("id"));
            if (result) {
                response.getWriter().write("{\"status\":\"element updated\"}");
            } else {
                response.getWriter().write("{\"status\":\"no one updated\"}");
            }
        } catch (Exception e) {
            response.setStatus(400);
            response.getWriter().write("{\"status\":\"failed\"}");
        }
    }

    public void deleteCv(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        CvDAO dao = new CvDAO();
        boolean result = dao.deleteOneCv(id);

        if (result) {
            response.getWriter().write("{\"status\":\"element deleted\"}");
        } else {
            response.getWriter().write("{\"status\":\"no one deleted\"}");
        }
    }

}
