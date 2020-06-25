import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentFinancingComponent } from './student-financing.component';

describe('StudentFinancingComponent', () => {
  let component: StudentFinancingComponent;
  let fixture: ComponentFixture<StudentFinancingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StudentFinancingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentFinancingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
