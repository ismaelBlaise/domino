// src/components/MenuItemLogout.js
import React from 'react';
import { MenuItem } from '@mui/material';
import { ExitToApp } from '@mui/icons-material';

const MenuItemLogout = ({ onClick }) => (
  <MenuItem onClick={onClick} className="flex items-center">
    <ExitToApp className="mr-2" /> Se déconnecter
  </MenuItem>
);

export default MenuItemLogout;
