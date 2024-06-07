package Dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import models.User;

public class UserDAO {

    private String path;

    public UserDAO() {
    }

    public UserDAO(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public User getOneUser(String idUser) {
        List<User> users = this.getLoginUsers();

        for (User user : users) {
            if (user.getIdUser().equals(idUser)) {
                return user;
            }
        }
        return new User("aaaa", "usuario no existe", "aaa");
    }

    public List<User> getLoginUsers() {
        List<User> users = new ArrayList<User>();
        try {
            Gson gson = new GsonBuilder().create();
            FileReader fileReader = new FileReader(this.getPath());

            java.lang.reflect.Type typeListPerson = new TypeToken<List<User>>() {
            }.getType();

            users = gson.fromJson(fileReader, typeListPerson);

        } catch (IOException e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
        }
        return users;
    }

    public String addNewUser(User user) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File file = new File(this.getPath());

        try (FileReader reader = new FileReader(file)) {

            // Leer el archivo JSON existente
            JsonElement rootElement = JsonParser.parseReader(reader);
            if (rootElement.isJsonArray()) {
                JsonArray jsonArray = rootElement.getAsJsonArray();

                // Crear un nuevo objeto JSON
                JsonObject newUser = new JsonObject();
                newUser.addProperty("userName", user.getUserName());
                newUser.addProperty("password", user.getPassword());
                newUser.addProperty("idUser",user.getIdUser());

                // Agregar el nuevo objeto al array
                jsonArray.add(newUser);

                // Escribir el JSON actualizado de vuelta al archivo
                try (FileWriter writer = new FileWriter(file)) {
                    gson.toJson(jsonArray, writer);
                }
                return "Nuevo usuario agregado exitosamente.";
            } else {
                return "El archivo JSON raíz no es un array.";
            }

        } catch (IOException e) {
            return "Algo fallo al realizar el login";
        }
    }

}
