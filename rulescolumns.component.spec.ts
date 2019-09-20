import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RulescolumnsComponent } from './rulescolumns.component';

describe('RulescolumnsComponent', () => {
  let component: RulescolumnsComponent;
  let fixture: ComponentFixture<RulescolumnsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RulescolumnsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RulescolumnsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
