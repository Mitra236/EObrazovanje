import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseInsertScreenComponent } from './course-insert-screen.component';

describe('CourseInsertScreenComponent', () => {
  let component: CourseInsertScreenComponent;
  let fixture: ComponentFixture<CourseInsertScreenComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CourseInsertScreenComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CourseInsertScreenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
