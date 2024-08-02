// src/components/StartGame.js
import React from 'react';
import { Card, CardContent, Typography, FormControl, RadioGroup, FormControlLabel, Radio, Button } from '@mui/material';
import { People, AttachMoney, PlayCircle, CurrencyExchange, Info } from '@mui/icons-material';

const StartGame = ({ playerCount, betAmount, handlePlayerCountChange, handleBetAmountChange, handleSubmit, balance, onDetailsClick }) => (
  <Card className="flex-1 bg-white p-6 rounded-lg shadow-lg">
    <CardContent>
      <Typography variant="h5" className="mb-6 font-bold text-blue-800">Démarrer une Partie</Typography>
      
      <div className="mb-6">
        <FormControl component="fieldset" className="w-full">
          <Typography variant="subtitle1" className="mb-2 font-semibold text-gray-800">Nombre de Joueurs</Typography>
          <RadioGroup
            value={playerCount}
            onChange={handlePlayerCountChange}
            row
          >
            {[2, 3, 4, 5, 6].map((count) => (
              <FormControlLabel
                key={count}
                value={count}
                control={<Radio icon={<People />} />}
                label={<Typography variant="body1" className="ml-2">{count}</Typography>}
                className="mr-4"
              />
            ))}
          </RadioGroup>
        </FormControl>
      </div>

      <div className="mb-6">
        <FormControl component="fieldset" className="w-full">
          <Typography variant="subtitle1" className="mb-2 font-semibold text-gray-800">Montant de la Mise</Typography>
          <RadioGroup
            value={betAmount}
            onChange={handleBetAmountChange}
            row
          >
            {[100, 200].map((amount) => (
              <FormControlLabel
                key={amount}
                value={amount}
                control={<Radio icon={<AttachMoney />} />}
                label={<Typography variant="body1" className="ml-2">{amount}$</Typography>}
                className="mr-4"
              />
            ))}
          </RadioGroup>
        </FormControl>
      </div>

      <div className="flex flex-col gap-4">
        <Typography variant="body1" className="mb-2 text-gray-700">
          Solde actuel : <CurrencyExchange className="mr-1" /> {balance}$
        </Typography>
        <Button
          variant="contained"
          color="primary"
          onClick={handleSubmit}
          className="w-full py-2 bg-blue-600 hover:bg-blue-800 text-white"
          startIcon={<PlayCircle />}
        >
          Démarrer
        </Button>
        <Button
          variant="outlined"
          color="primary"
          className="w-full"
          startIcon={<Info />}
          onClick={onDetailsClick}
        >
          Voir le règlement
        </Button>
      </div>
    </CardContent>
  </Card>
);

export default StartGame;
