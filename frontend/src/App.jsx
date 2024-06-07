import { BrowserRouter, Route, Routes } from "react-router-dom";
import Login from "./pages/Login";

function App() {


  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login/>} />
        <Route path="/home" element={"Homepage"} />
      </Routes>
    </BrowserRouter>
  )
}

export default App
