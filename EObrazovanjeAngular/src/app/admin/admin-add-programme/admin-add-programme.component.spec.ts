import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAddProgrammeComponent } from './admin-add-programme.component';

describe('AdminAddProgrammeComponent', () => {
  let component: AdminAddProgrammeComponent;
  let fixture: ComponentFixture<AdminAddProgrammeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminAddProgrammeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminAddProgrammeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
