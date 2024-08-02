// src/components/MenuItemAccount.js
import React from 'react';
import { MenuItem } from '@mui/material';
import { AccountCircle } from '@mui/icons-material';

const MenuItemAccount = ({ onClick }) => (
  <MenuItem onClick={onClick} className="flex items-center">
    <AccountCircle className="mr-2" /> Mon compte
  </MenuItem>
);

export default MenuItemAccount;
