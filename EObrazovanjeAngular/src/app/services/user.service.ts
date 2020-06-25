import { Injectable } from '@angular/core';

enum EUserRole {
  Student,
  Professor,
  Admin,
}

interface User {
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

  constructor() {}

  setUser(user: User) {
    this.loggedInUser = user;
    this.role = user.role;
  }
}
