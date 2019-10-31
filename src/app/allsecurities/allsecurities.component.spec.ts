import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllsecuritiesComponent } from './allsecurities.component';

describe('AllsecuritiesComponent', () => {
  let component: AllsecuritiesComponent;
  let fixture: ComponentFixture<AllsecuritiesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllsecuritiesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllsecuritiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
