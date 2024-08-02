// src/pages/Accueil.js
import React, { useState } from 'react';
import { useLocation } from 'react-router-dom';
import { Menu, MenuItem, IconButton, Typography, Container, Box } from '@mui/material';
import { AccountCircle, ExitToApp, AttachMoney, CurrencyExchange } from '@mui/icons-material';
import 'tailwindcss/tailwind.css'; // Assurez-vous que Tailwind est bien importé
import StartGame from '../components/StartGame'; // Importez le composant StartGame
import GameDetails from '../components/GameDetails'; // Importez le composant GameDetails
import MenuItemTransactions from '../components/MenuItemTransactions';
import MenuItemAccount from '../components/MenuItemAccount';
import MenuItemLogout from '../components/MenuItemLogout';

const Accueil = () => {
  const location = useLocation();
  const joueur = location.state?.joueur; // Utilisez l'opérateur de chaînage optionnel pour éviter les erreurs si `location.state` est `undefined`



  const [anchorEl, setAnchorEl] = useState(null);
  const [playerCount, setPlayerCount] = useState(2);
  const [betAmount, setBetAmount] = useState(100); // Valeur par défaut à 100$
  const [balance, setBalance] = useState(1000); // Exemple de solde initial
  const [detailsOpen, setDetailsOpen] = useState(false); // État pour gérer l'ouverture du pop-up

  

  const handleMenuClick = (event) => {
    setAnchorEl(event.currentTarget);
  };

  const handleMenuClose = () => {
    setAnchorEl(null);
  };

  const handlePlayerCountChange = (event) => {
    setPlayerCount(event.target.value);
  };

  const handleBetAmountChange = (event) => {
    setBetAmount(event.target.value);
  };

  const handleSubmit = () => {
    // Logic to start the game
    console.log(`Starting game with ${playerCount} players and a bet of ${betAmount}`);
  };

  const handleDetailsClick = () => {
    setDetailsOpen(true);
  };

  const handleDetailsClose = () => {
    setDetailsOpen(false);
  };

  const open = Boolean(anchorEl);

  return (
    <Container className="min-h-screen bg-gray-100 p-4">
      <Box className="flex justify-between items-center mb-4">
        <Typography variant="h4" className="font-bold text-blue-700">Dominos Game</Typography>
        <Box className="flex items-center">
          <Typography variant="h6" className="mr-4">
            Solde : <CurrencyExchange className="mr-1" /> {balance}$
          </Typography>
          <IconButton onClick={handleMenuClick} color="primary">
            <AccountCircle fontSize="large" />
          </IconButton>
          <Menu
            anchorEl={anchorEl}
            open={Boolean(anchorEl)}
            onClose={handleMenuClose}
          >
            <MenuItemTransactions onClick={handleMenuClose} />
            <MenuItemAccount onClick={handleMenuClose} />
            <MenuItemLogout onClick={handleMenuClose} />
          </Menu>
        </Box>
      </Box>

      <Box className="flex flex-col md:flex-row gap-4">
        <StartGame
          playerCount={playerCount}
          betAmount={betAmount}
          handlePlayerCountChange={handlePlayerCountChange}
          handleBetAmountChange={handleBetAmountChange}
          handleSubmit={handleSubmit}
          balance={balance} // Passez le solde au composant StartGame
          onDetailsClick={handleDetailsClick} // Passez la fonction pour ouvrir le pop-up
        />
      </Box>

      <GameDetails open={detailsOpen} onClose={handleDetailsClose} />
    </Container>
  );
};

export default Accueil;
