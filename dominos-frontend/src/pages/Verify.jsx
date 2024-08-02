import React, { useState } from 'react';
import axios from 'axios';
import { TextField, Button, Typography, Container, Alert } from '@mui/material';
import { useLocation, useNavigate } from 'react-router-dom';

function Verify() {
    const [code, setCode] = useState('');
    const [message, setMessage] = useState('');
    const location = useLocation();
    const navigate = useNavigate();

    // Extract data from location state
    const { email, motDePasse, pseudo, contact } = location.state || { email: '', motDePasse: '', pseudo: '', contact: '' };

    const handleVerify = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/api/auth/verify', {
                email,
                code,
                motDePasse,
                pseudo,
                contact,
            });
            setMessage(response.data);
            navigate('/signup', { state: { reussite: 'Compte créé avec succès' } });
        } catch (error) {
            setMessage(error.response.data);
        }
    };

    return (
        <Container maxWidth="sm" className="mt-8">
            <Typography variant="h4" component="h2" gutterBottom className="text-center">
                Vérification de l'email
            </Typography>
            {message && <Alert variant="outlined" severity="error">{message}</Alert>}
            <form onSubmit={handleVerify} className="space-y-4">
                <TextField
                    fullWidth
                    label="Code de vérification"
                    value={code}
                    onChange={(e) => setCode(e.target.value)}
                    margin="normal"
                    required
                    className="mb-4"
                />
                <Button variant="contained" color="primary" type="submit" fullWidth className="bg-blue-500 hover:bg-blue-700">
                    Vérifier
                </Button>
            </form>
        </Container>
    );
}

export default Verify;
