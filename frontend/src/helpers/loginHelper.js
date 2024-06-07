const url = "http://localhost:8080/backend/api/user";

const validateUser = async (user) => {
  let urlSend =
    url + '?userName="' + user.userName + '"&&password="' + user.password + '"';
  try {
    let response = await fetch(urlSend, {
      method: "POST",
      headers: {
        "Access-Control-Allow-Origin": "*",
        "Content-Type": "application/json",
      },
    });

    // Verifica si la respuesta está bien formada
    if (!response.ok) {
      throw new Error(`Network response was not ok: ${response.statusText}`);
    }

    // Asegúrate de que la respuesta no esté vacía
    const text = await response.text();
    if (text.length === 0) {
      throw new Error("Response was empty");
    }

    // Intenta parsear el JSON
    const data = JSON.parse(text);
    return data;
  } catch (error) {
    console.error("Error during fetch:", error);
    return null; // o lanza el error si prefieres manejarlo en otro lugar
  }
};

export { validateUser };
