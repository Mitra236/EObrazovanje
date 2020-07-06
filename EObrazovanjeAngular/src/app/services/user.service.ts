import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { baseUrl } from './url';

enum EUserRole {
  Student,
  Professor,
  Admin,
}

interface User {
  id: number;
  username: string;
  password: string;
  role: EUserRole;
}

@Injectable({
  providedIn: 'root',
})
export class UserService {
  loggedInUser;
  role;
  loginUrl = baseUrl + 'login/';
  constructor(private http: HttpClient) {}

  login(user: User): Observable<User> {
    return this.http.post<User>(this.loginUrl, user);
  }

  setUser(user: User) {
    this.loggedInUser = user;
    this.role = user.role;
  }
}
