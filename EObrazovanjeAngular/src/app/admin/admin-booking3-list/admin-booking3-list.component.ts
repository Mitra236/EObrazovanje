import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

const mockData = [
  {
    firstName: 'Valentina',
    lastName: 'Mackovic',
    status: 'passed',
    finalGrade: 10
  },
  {
    firstName: 'Ana',
    lastName: 'Anic',
    status: 'passed',
    finalGrade: 10
  }
];

@Component({
  selector: 'app-admin-booking3-list',
  templateUrl: './admin-booking3-list.component.html',
  styleUrls: ['./admin-booking3-list.component.css']
})
export class AdminBooking3ListComponent implements OnInit {
  examBooking;
  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.examBooking = mockData;
  }

}
