import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfessorProfileDetailsComponent } from './professor-profile-details.component';

describe('ProfessorProfileDetailsComponent', () => {
  let component: ProfessorProfileDetailsComponent;
  let fixture: ComponentFixture<ProfessorProfileDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfessorProfileDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfessorProfileDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
