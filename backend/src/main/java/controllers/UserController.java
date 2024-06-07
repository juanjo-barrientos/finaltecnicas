package controllers;

import Dao.UserDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;

public class UserController {

    private final String FINAL_PATH = "/WEB-INF/classes/users.json";

    public UserController() {
    }

    public void addOneUser(HttpServletRequest request, HttpServletResponse response, ServletContext context) throws ServletException, IOException {

        UserDAO dao = new UserDAO();
        dao.setPath(context.getRealPath(FINAL_PATH));
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        }
        try {
            String body = stringBuilder.toString();
            JsonObject jsonObject = gson.fromJson(body, JsonObject.class);
            UUID uuid = UUID.randomUUID();
            String idUser = uuid.toString();
            String userName = jsonObject.get("userName").toString();
            String password = jsonObject.get("password").toString();

            User user = new User(idUser, userName, password);
            String result = dao.addNewUser(user);
            response.getWriter().write(result);
        } catch (Exception e) {
            response.setStatus(400);
            response.getWriter().write("{\"status\":\"somenting in the fetch failed\"}");
        }

    }

    public void validateUser(HttpServletRequest request, HttpServletResponse response, ServletContext context) throws ServletException, IOException {
        String userName = (String) request.getParameter("userName");
        String password = (String) request.getParameter("password");

        UserDAO dao = new UserDAO();
        dao.setPath(context.getRealPath(FINAL_PATH));
        List<User> users = dao.getLoginUsers();
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        String result = "";
        for (User user : users) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                JsonElement element = gson.toJsonTree(user);
                result = gson.toJson(element);
            } else {
                result = "{\"status\":\"user or password failed\"}";
            }
        }

        response.getWriter().print(result);
    }

    public void getOneUser(HttpServletRequest request, HttpServletResponse response, ServletContext context) throws ServletException, IOException {
        String idUser = (String) request.getParameter("idUser");
        UserDAO dao = new UserDAO();
        dao.setPath(context.getRealPath(FINAL_PATH));
        User user = dao.getOneUser(idUser);
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        JsonElement element = gson.toJsonTree(user);
        String result = gson.toJson(element);
        response.getWriter().print(result);

    }
}
