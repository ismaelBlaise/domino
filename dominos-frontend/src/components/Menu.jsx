// src/components/Menu.js
import React from 'react';
import { Menu, MenuItem, IconButton } from '@mui/material';
import { AccountCircle, ExitToApp, AttachMoney, PlayCircle } from '@mui/icons-material';

const MenuComponent = ({ anchorEl, open, handleMenuClose, handleMenuItemClick }) => (
  <Menu
    anchorEl={anchorEl}
    open={open}
    onClose={handleMenuClose}
  >
    <MenuItem onClick={() => handleMenuItemClick('startGame')} className="flex items-center">
      <PlayCircle className="mr-2" /> Démarrer une Partie
    </MenuItem>
    <MenuItem onClick={() => handleMenuItemClick('instructions')} className="flex items-center">
      <AttachMoney className="mr-2" /> Instructions
    </MenuItem>
    <MenuItem onClick={handleMenuClose} className="flex items-center">
      <ExitToApp className="mr-2" /> Se déconnecter
    </MenuItem>
  </Menu>
);

export default MenuComponent;
