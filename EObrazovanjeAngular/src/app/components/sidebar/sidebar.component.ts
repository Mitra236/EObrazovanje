import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css'],
})
export class SidebarComponent implements OnInit {
  role: string;
  id: number;
  constructor() {}

  ngOnInit(): void {
    this.role = localStorage.getItem("role");
    this.id = +localStorage.getItem("id");
  }
}
