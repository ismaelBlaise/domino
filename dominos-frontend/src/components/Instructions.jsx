// src/components/Instructions.js
import React from 'react';
import { Card, CardContent, Typography } from '@mui/material';

const Instructions = () => (
  <Card className="flex-1 bg-white p-4 rounded-lg shadow-md">
    <CardContent>
      <Typography variant="h6" className="mb-4 font-bold">Instructions</Typography>
      <Typography variant="body1" className="text-gray-700">
        Utilisez le formulaire pour configurer la partie. Vous pouvez choisir le nombre de joueurs (entre 2 et 6) et le montant de la mise (100$ ou 200$) avant de démarrer la partie.
      </Typography>
    </CardContent>
  </Card>
);

export default Instructions;
