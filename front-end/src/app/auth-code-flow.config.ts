import { AuthConfig } from "angular-oauth2-oidc";

export const authCodeFlowConfig: AuthConfig = {
    issuer: 'http://localhost:8090/realms/Cricketers-Stats',
    redirectUri: `${window.location.origin}/players`,
    clientId: 'cricketers-stats-web',
    responseType: 'code',
    scope: 'openid profile email offline_access',
    showDebugInformation: true
}