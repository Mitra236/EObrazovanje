import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css'],
})
export class SidebarComponent implements OnInit {
  role: string;
  id: number;
  constructor(public router: Router) {}

  ngOnInit(): void {
    this.role = localStorage.getItem('role');
    this.id = +localStorage.getItem('id');
  }

  logout() {
    localStorage.removeItem('id');
    localStorage.removeItem('role');
    this.router.navigate(['']);
  }
}
