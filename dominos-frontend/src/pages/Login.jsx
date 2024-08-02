import React, { useState } from 'react';
import axios from 'axios';
import { TextField, Button, Typography, Container } from '@mui/material';
import { Email as EmailIcon, Lock as LockIcon } from '@mui/icons-material';
import Alert from '@mui/material/Alert';
import { Link,useNavigate } from 'react-router-dom';
function Login() {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [message, setMessage] = useState('');
    const navigate= useNavigate();
    const handleLogin = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/api/auth/login', {
                email,
                motDePasse: password,
            });
            
           
            navigate('/accueil', { state: { joueur: response.data } });
        } catch (error) {
            setMessage(error.response.data);
        }
    };

    return (
        <Container maxWidth="sm" className="mt-8">
            <Typography variant="h4" component="h2" gutterBottom className="text-center">
                Connexion
            </Typography>
            {message &&  <Alert variant="outlined" severity="error">
                {message}
            </Alert>}
           
            <form onSubmit={handleLogin} className="space-y-4">
                <TextField
                    fullWidth
                    label="Email"
                    type="email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    margin="normal"
                    InputProps={{
                        startAdornment: <EmailIcon />,
                    }}
                    required
                    className="mb-4"
                />
                <TextField
                    fullWidth
                    label="Mot de passe"
                    type="password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    margin="normal"
                    InputProps={{
                        startAdornment: <LockIcon />,
                    }}
                    required
                    className="mb-4"
                />
                <Button variant="contained" color="primary" type="submit" fullWidth className="bg-blue-500 hover:bg-blue-700">
                    Se connecter
                </Button>
            </form>
            <p className="mt-4 text-center">
                Pas encore de compte? <Link to="/signup" className="text-blue-500">Créer un compte</Link>
            </p>
        </Container>
    );
}

export default Login;
