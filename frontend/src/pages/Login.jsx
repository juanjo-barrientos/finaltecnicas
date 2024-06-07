import { useState } from "react";
import { validateUser } from "../helpers/loginHelper";
import { useNavigate } from "react-router-dom";

export default function Login() {
  const navigate = useNavigate();
  const [user, setUser] = useState({
    userName: "",
    password: "",
  });

  const change = (e) => {
    setUser({
      ...user,
      [e.target.name]: e.target.value,
    });
  };

  const send = async (e) => {
    e.preventDefault();
    let data = await validateUser(user);
    console.log(data);

    if (data?.status === "user or password failed") {
      alert("Usuario o contraseña incorrectos");
    } else {
      localStorage.removeItem("idUser");
      localStorage.removeItem("userName");
      localStorage.removeItem("password");

      localStorage.setItem("idUser", data.idUser);
      localStorage.setItem("userName", data.userName);
      localStorage.setItem("password", data.password);
      navigate("/home");
    }
  };

  return (
    <div className="bg-primary" style={{ height: "100vh" }}>
      <div className="row d-flex justify-content-center">
        <div className="col-md-6 p-4 rounded mt-5 bg-white">
          <h1>Inicio de sesión</h1>
          <form onSubmit={(e) => send(e)}>
            <div className="mb-3">
              <label htmlFor="exampleInputEmail1" className="form-label">
                Nombre de usuario
              </label>
              <input
                type="text"
                className="form-control"
                id="exampleInputEmail1"
                aria-describedby="emailHelp"
                name="userName"
                onChange={(e) => change(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="exampleInputPassword1" className="form-label">
                Contraseña
              </label>
              <input
                type="password"
                className="form-control"
                id="exampleInputPassword1"
                name="password"
                onChange={(e) => change(e)}
              />
            </div>
            <button type="submit" className="btn btn-primary">
              Iniciar sesión
            </button>
          </form>
        </div>
      </div>
    </div>
  );
}
