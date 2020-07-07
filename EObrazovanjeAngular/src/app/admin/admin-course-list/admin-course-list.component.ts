import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { switchMap } from 'rxjs/operators';
import { CourseService } from '../../services/course.service';
import { Course } from '../../types/course';

@Component({
  selector: 'app-admin-course-list',
  templateUrl: './admin-course-list.component.html',
  styleUrls: ['./admin-course-list.component.css']
})
export class AdminCourseListComponent implements OnInit, OnDestroy {
  private subscription: Subscription;
  courseId;

  constructor(
    private courseService: CourseService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
   /* this.courseId = this.route.snapshot.paramMap.get('courseId');
    this.subscription = this.route.params
      .pipe(
        switchMap((params: Params) =>
          this.courseService.getCourse(this.courseId)
        )
      )
      .subscribe((studyProgramme) => {
        this.co = studyProgramme;
      });*/
  }


  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

}
