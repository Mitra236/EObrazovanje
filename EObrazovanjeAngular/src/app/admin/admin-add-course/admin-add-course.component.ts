import { Component, OnInit, Output } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Course } from 'src/app/types/course';
import { CourseService } from '../../services/course.service';
import { EventEmitter } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { forkJoin } from 'rxjs';

@Component({
  selector: 'app-admin-add-course',
  templateUrl: './admin-add-course.component.html',
  styleUrls: ['./admin-add-course.component.css']
})
export class AdminAddCourseComponent implements OnInit {
  @Output()
  saveNewCourse = new EventEmitter<Course>();

  id?: number;
  name: string;
  courseCode: string;
  ECTS?: number;
  lectures?: number;
  practicalClasses?: number;

  constructor(
    private courseService : CourseService,
    private router: Router,
    private fb: FormBuilder,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'] ? 
              this.route.snapshot.params['id'] 
              : 0;

              forkJoin(
                this.fillOutCourse(this.id)
              ).subscribe(
                ([course]) => {
                  if(course != null) {
                    this.name = course.name;
                    this.courseCode = course.courseCode;
                    this.ECTS = course.ECTS; 
                    this.lectures = course.lectures;
                    this.practicalClasses = course.practicalClasses;
                  } else {
                    this.name = '';
                    this.courseCode ='' ;
                    this.ECTS = null; 
                    this.lectures = 0;
                    this.practicalClasses = 0;
                  }

                  console.log(course);
                  
                }
              );
  }

  fillOutCourse(id: number) {
    return this.courseService.getCourse(id);
  }

  saveCourse(){
    if(this.name.length < 3)
    {
      alert("Morate uneti naziv kursa!");
      return;
    }
    let newCourse = {

    } as Course;
    if(this.id != null && this.id > 0) {
      newCourse.id = this.id;
    }
    newCourse.name = this.name;
    newCourse.courseCode = this.courseCode;
    newCourse.ECTS = this.ECTS;
    newCourse.lectures = this.lectures;
    newCourse.practicalClasses = this.practicalClasses;

    if(newCourse.id > 0) {
      this.courseService.editCourse(newCourse);
    } else {
      this.courseService.saveCourse(newCourse);
    }

    this.saveNewCourse.emit(newCourse);
    this.router.navigate(["admin/courses"]);
  }



}
