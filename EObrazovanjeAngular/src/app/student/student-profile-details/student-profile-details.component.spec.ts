import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentProfileDetailsComponent } from './student-profile-details.component';

describe('StudentProfileDetailsComponent', () => {
  let component: StudentProfileDetailsComponent;
  let fixture: ComponentFixture<StudentProfileDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StudentProfileDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentProfileDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
