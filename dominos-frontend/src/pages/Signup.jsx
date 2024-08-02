import React, { useState } from 'react';
import axios from 'axios';
import { TextField, Button, Typography, Container, Alert } from '@mui/material';
import { Email as EmailIcon, Lock as LockIcon, Person as PersonIcon, Phone as PhoneIcon } from '@mui/icons-material';
import { Link, useNavigate } from 'react-router-dom';

function Signup() {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [pseudo, setPseudo] = useState('');
    const [contact, setContact] = useState('');
    const [message, setMessage] = useState('');
    const reussite= location.state || "";

    const navigate = useNavigate();

    const handleSignup = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/api/auth/signup', {
                email,
                motDePasse: password,
                pseudo,
                contact,
            });

            setMessage(response.data);
            navigate('/verify', { state: { email , motDePasse:password, pseudo,contact} }); // Redirect to the verify page with email state
            
        } catch (error) {
            setMessage(error.response.data);
        }
    };

    return (
        <Container maxWidth="sm" className="mt-8">
            <Typography variant="h4" component="h2" gutterBottom className="text-center">
                Inscription
            </Typography>
            {message && <Alert variant="outlined" severity="error">{message}</Alert>}
            {reussite && <Alert variant="outlined" severity="success">{reussite}</Alert>}
            <form onSubmit={handleSignup} className="space-y-4">
                <TextField
                    fullWidth
                    label="Pseudo"
                    value={pseudo}
                    onChange={(e) => setPseudo(e.target.value)}
                    margin="normal"
                    InputProps={{
                        startAdornment: <PersonIcon />,
                    }}
                    required
                    className="mb-4"
                />
                <TextField
                    fullWidth
                    label="Contact"
                    value={contact}
                    onChange={(e) => setContact(e.target.value)}
                    margin="normal"
                    InputProps={{
                        startAdornment: <PhoneIcon />,
                    }}
                    required
                    className="mb-4"
                />
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
                    S'inscrire
                </Button>
            </form>
            <p className="mt-4 text-center">
                Déjà inscrit? <Link to="/login" className="text-blue-500">Se connecter</Link>
            </p>
        </Container>
    );
}

export default Signup;
