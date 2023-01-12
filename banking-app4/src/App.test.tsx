import React from 'react';
import { render, screen } from '@testing-library/react';
import App from './App';
import MyComponent from '../components/xyz.js';

test('renders learn react link', () => {
  render(<App />);
  const linkElement = screen.getByText(/learn react/i);