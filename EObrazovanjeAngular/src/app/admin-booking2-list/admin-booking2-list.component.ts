import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

const mockData = [
  {
    name: 'Softverske i informacione tehnologije',
    courseCode: 'SF',
    ECTS: 180,
    lectures: 30,
    practicalCLasses: 10
  },
  {
    name: 'Energetika i elektronika', 
    courseCode: 'EE',
    ECTS: 240,
    lectures: 40,
    practicalCLasses: 20
  }
];

@Component({
  selector: 'app-admin-booking2-list',
  templateUrl: './admin-booking2-list.component.html',
  styleUrls: ['./admin-booking2-list.component.css']
})
export class AdminBooking2ListComponent implements OnInit {
  courseBooking;
  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.courseBooking = mockData;
  }

}
