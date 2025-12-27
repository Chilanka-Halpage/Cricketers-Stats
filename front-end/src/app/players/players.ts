import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import {MatPaginator, MatPaginatorModule} from '@angular/material/paginator';
import {MatTableDataSource, MatTableModule} from '@angular/material/table';
import { PlayersService } from '../services/players-service';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatTooltip, MatTooltipModule } from "@angular/material/tooltip";
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelect, MatSelectChange, MatSelectModule } from '@angular/material/select';
import { NavigationExtras, Router } from '@angular/router';

@Component({
  selector: 'app-players',
  imports: [MatTableModule, MatPaginatorModule, MatButtonModule, MatIconModule, MatTooltip, MatTooltipModule, MatSelectModule, MatFormFieldModule ],
  templateUrl: './players.html',
  styleUrl: './players.scss'
})
export class Players implements AfterViewInit {
  displayedColumns: string[] = ['position', 'name', 'action'];
  countryList = [
    {id: 1, name: 'Sri Lanka'},
    {id: 2, name: 'India'},
  ]
  palyers: PlayerResponse[] = [];
  dataSource = new MatTableDataSource<PlayerResponse>();

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private playerService: PlayersService, private router: Router){}

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  onSelect(event: MatSelectChange<number>) {
    this.playerService.getPlayers(event.value).subscribe(result => {
      this.palyers = result;
      this.dataSource.data = this.palyers;
    })
  }

  onViewStats(playerId: number, playerName: string) {
    this.router.navigate([`players/${playerId}/stats`], { 
      state: {
        name: playerName
      }
     });
  }
}