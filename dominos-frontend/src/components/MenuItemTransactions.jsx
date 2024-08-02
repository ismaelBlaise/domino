// src/components/MenuItemTransactions.js
import React from 'react';
import { MenuItem } from '@mui/material';
import { AttachMoney } from '@mui/icons-material';

const MenuItemTransactions = ({ onClick }) => (
  <MenuItem onClick={onClick} className="flex items-center">
    <AttachMoney className="mr-2" /> Transactions
  </MenuItem>
);

export default MenuItemTransactions;
