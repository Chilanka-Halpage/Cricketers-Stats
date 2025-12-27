import { Routes } from '@angular/router';
import { Players } from './players/players';
import { Stats } from './stats/stats';
import { App } from './app';

export const routes: Routes = [
    {path: 'players', component: Players, pathMatch: 'full'},
    {path: 'players/:id/stats', component: Stats, pathMatch: 'full'}
];
