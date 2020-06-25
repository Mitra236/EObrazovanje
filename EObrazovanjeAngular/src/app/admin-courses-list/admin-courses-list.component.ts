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
  selector: 'app-admin-courses-list',
  templateUrl: './admin-courses-list.component.html',
  styleUrls: ['./admin-courses-list.component.css']
})


export class AdminCoursesListComponent implements OnInit {
  courses;
  constructor(private router: ActivatedRoute) { }

  ngOnInit(): void {
    this.courses = mockData;
  }

}
