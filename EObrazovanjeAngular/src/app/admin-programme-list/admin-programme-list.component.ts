import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Subscription, forkJoin } from 'rxjs';
import { switchMap } from 'rxjs/operators';
import { StudyProgrammeService } from '../services/study.programme.service';
import { StudyProgramme } from 'src/app/types/study.programme';
import { Course } from 'src/app/types/course';
import { Student } from 'src/app/types/student';

@Component({
  selector: 'app-admin-programme-list',
  templateUrl: './admin-programme-list.component.html',
  styleUrls: ['./admin-programme-list.component.css']
})
export class AdminProgrammeListComponent implements OnInit, OnDestroy {
  courses: Course[];
  students: Student[];
  programmeId;
  constructor(private studyProgrammeService: StudyProgrammeService, private route: ActivatedRoute, private router: Router) { 
  }

  ngOnInit(): void {
    this.programmeId = this.route.snapshot.paramMap.get('id');
    forkJoin(this.getCourses(), this.getStudents())
      .subscribe(([courses, students]) => {
        this.courses = courses;
        this.students = students;
      });
  }

  getCourses() {
    return this.studyProgrammeService.getListOfCoursesForProgramme(+this.programmeId);
  }
  getStudents() {
    return this.studyProgrammeService.getListOfStudentsForProgramme(+this.programmeId);
  }

  ngOnDestroy(): void {
  }

}
