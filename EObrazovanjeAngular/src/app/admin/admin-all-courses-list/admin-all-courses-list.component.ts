import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { switchMap } from 'rxjs/operators';
import { CourseService } from '../../services/course.service';
import { Course } from '../../types/course';

@Component({
  selector: 'app-admin-all-courses-list',
  templateUrl: './admin-all-courses-list.component.html',
  styleUrls: ['./admin-all-courses-list.component.css']
})
export class AdminAllCoursesListComponent implements OnInit, OnDestroy {
  private subscription: Subscription;
  courses: Course[];
  courseId;
  constructor(
    private courseService: CourseService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.courseId = this.route.snapshot.paramMap.get('id');
    this.subscription = this.route.params
    .pipe(
      switchMap((params: Params) =>
        this.courseService.getListOfCourses()
      )
    )
    .subscribe((course) => {
      this.courses = course;
    });
   
  }

  addNewCourse() {
    this.router.navigate(["admin/addCourse"]);
  }
  editCourse(id: Number) {
    this.router.navigate(["admin/addCourse/" + id]);
  }

  removeCourse(courseId: number) {
    this.courses.splice(this.courses.findIndex(x => x.id == courseId), 1);
    this.courseService.removeCourse(courseId);
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

}
