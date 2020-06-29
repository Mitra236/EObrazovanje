import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';


const mockData = [
  {
    name: 'SIT'
  },
  {
    name: 'EE'
  },
  {
    name: 'RA'
  }
];

@Component({
  selector: 'app-admin-periods-list',
  templateUrl: './admin-periods-list.component.html',
  styleUrls: ['./admin-periods-list.component.css']
})
export class AdminPeriodsListComponent implements OnInit {
  periods;
  constructor(private router: ActivatedRoute) { }

  ngOnInit(): void {
    this.periods = mockData;
  }

}
