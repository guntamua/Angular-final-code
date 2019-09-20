import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RulestablesComponent } from './rulestables.component';

describe('RulestablesComponent', () => {
  let component: RulestablesComponent;
  let fixture: ComponentFixture<RulestablesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RulestablesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RulestablesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
