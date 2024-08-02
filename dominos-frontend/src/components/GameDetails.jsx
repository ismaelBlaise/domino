// src/components/GameDetails.js
import React from 'react';
import { Dialog, DialogTitle, DialogContent, IconButton, Typography, List, ListItem, ListItemText } from '@mui/material';
import { Close as CloseIcon } from '@mui/icons-material';

const GameDetails = ({ open, onClose }) => (
  <Dialog open={open} onClose={onClose} maxWidth="md" fullWidth>
    <DialogTitle>
      Détails du Jeu
      <IconButton
        edge="end"
        color="inherit"
        onClick={onClose}
        aria-label="close"
        sx={{ position: 'absolute', right: 8, top: 8 }}
      >
        <CloseIcon />
      </IconButton>
    </DialogTitle>
    <DialogContent>
      <Typography variant="h6" gutterBottom className="font-bold text-gray-800">
        Règlement du Jeu de Dominos
      </Typography>
      <Typography variant="body1" paragraph>
        Le jeu de dominos se joue avec un ensemble de pièces rectangulaires appelées dominos. Chaque domino est divisé en deux parties, chacune portant un nombre de points.
      </Typography>
      <Typography variant="body1" paragraph>
        Voici les règles de base :
      </Typography>
      <List>
        <ListItem>
          <ListItemText
            primary="1. Objectif du Jeu"
            secondary="Le but du jeu est de marquer le plus de points possible en jouant des dominos sur la table selon les règles établies."
          />
        </ListItem>
        <ListItem>
          <ListItemText
            primary="2. Déroulement du Jeu"
            secondary="Les joueurs jouent chacun leur tour en posant un domino qui correspond à un des extrémités des dominos déjà posés sur la table."
          />
        </ListItem>
        <ListItem>
          <ListItemText
            primary="3. Fin de Partie"
            secondary="La partie se termine lorsque l'un des joueurs a posé tous ses dominos ou lorsque personne ne peut jouer. Le joueur avec le moins de points en main gagne."
          />
        </ListItem>
        <ListItem>
          <ListItemText
            primary="4. Points"
            secondary="Les points sont calculés en fonction des valeurs des dominos restants en main des joueurs."
          />
        </ListItem>
      </List>
      <Typography variant="body1" paragraph>
        Assurez-vous de bien comprendre ces règles avant de commencer à jouer. Les règles peuvent varier légèrement en fonction des variantes du jeu.
      </Typography>
    </DialogContent>
  </Dialog>
);

export default GameDetails;
