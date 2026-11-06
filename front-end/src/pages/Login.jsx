import { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../services/api";


function Login() {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();

    const handleLogin = async (e) => {  
        e.preventDefault();
        try {
            const response = await api.post("/auth/login", { email, password });
            const { token } = response.data.token;
            localStorage.setItem("token", token);
            navigate("/profile");
        } catch (error) {
            console.error("Login failed:", error);
            alert("Login failed. Please check your credentials and try again.");
        }
    };

    return (
        <div>
            <h2>Connexion</h2>
            <form onSubmit={handleLogin}>
                <div>
                    <label>Email:</label>
                    <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} />
                    <br />
                </div>
                <div>
                    <label >Password:</label>
                    <input type="password"  value={password} onChange={(e) => setPassword(e.target.value)} />
                    <br />
                </div>
               <input type="submit" value="Login" />
            </form>
        </div>
    );
}

export default Login;