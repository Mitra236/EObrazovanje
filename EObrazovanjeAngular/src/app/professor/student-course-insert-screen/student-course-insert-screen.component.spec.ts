import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentCourseInsertScreenComponent } from './student-course-insert-screen.component';

describe('StudentCourseInsertScreenComponent', () => {
  let component: StudentCourseInsertScreenComponent;
  let fixture: ComponentFixture<StudentCourseInsertScreenComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StudentCourseInsertScreenComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentCourseInsertScreenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
