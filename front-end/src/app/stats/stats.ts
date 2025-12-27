import { Component, OnInit, signal } from '@angular/core';
import { StatsService } from '../services/stats-service';
import { ActivatedRoute, Router } from '@angular/router';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatCardModule } from '@angular/material/card';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';

@Component({
  selector: 'app-stats',
  imports: [MatTableModule, MatCardModule, MatProgressSpinnerModule ],
  templateUrl: './stats.html',
  styleUrl: './stats.scss',
})
export class Stats implements OnInit {
  isLoading = signal(true);
  playerId: any;
  playerName: any;
  displayedColumns: string[] = ['format', 'matches', 'innings', 'runs', 'average', 'highestScore', 'fifties', 'hundreds', 'strikeRate'];
  dataSource = new MatTableDataSource<any>();

  constructor(private statsService: StatsService, private route: ActivatedRoute, private router: Router) {
    this.playerId = route.snapshot.paramMap.get('id');
    this.playerName = router.currentNavigation()?.extras.state?.['name'];
    console.log(router.currentNavigation());
  }

  ngOnInit(): void {
    this.statsService.getPlayerStats(this.playerId).subscribe(result => {
      const stats = [];
      stats.push({format: 'Test', ...result.test });
      stats.push({format: 'ODI', ...result.odi });
      stats.push({format: 'T20I', ...result.t20i });
      this.dataSource.data = stats;
      this.isLoading.set(false);
    })
  }

}
