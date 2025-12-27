import { Component, OnInit, signal } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { OAuthService } from 'angular-oauth2-oidc';

import { authCodeFlowConfig } from './auth-code-flow.config';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, MatButtonModule],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App implements OnInit {
  protected readonly title = signal('Cricketers Stats');

  constructor(private oauthService: OAuthService, private router: Router) { }

  ngOnInit(): void {
    this.initOAuthCodeFlow();
  }

  initOAuthCodeFlow(): void {
    this.oauthService.configure(authCodeFlowConfig);
    this.oauthService.loadDiscoveryDocumentAndTryLogin().then(() => {
      if (!this.oauthService.hasValidAccessToken()) {
        this.oauthService.initCodeFlow();
      } else {
        this.oauthService.loadUserProfile().then(profile => {
          console.log(profile);
          
        })
      }
    });
  }

  logout(){
    this.oauthService.logOut();
  }

  players(){
    this.router.navigate(['/players']);
  }
}




