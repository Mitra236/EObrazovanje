import { Location } from '@angular/common';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(public router: Router, private location: Location) {}

  canActivate(e): boolean {
    let urlRole = e.pathFromRoot[1].url[0].path;
    if (!this.isAuthenticated()) {
      this.router.navigate(['']);
      return false;
    }
    if (!this.isAuthorized(urlRole)) {
      this.location.back();
      return false;
    }
    return true;
  }

  isAuthenticated() {
    let id = localStorage.getItem('id');
    return id !== null && id !== '';
  }

  isAuthorized(urlRole: string) {
    let role = localStorage.getItem('role');
    return role !== '' && role !== null && role === urlRole;
  }
}
