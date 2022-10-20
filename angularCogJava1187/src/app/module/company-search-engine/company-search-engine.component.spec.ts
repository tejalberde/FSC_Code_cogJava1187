import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompanySearchEngineComponent } from './company-search-engine.component';

describe('CompanySearchEngineComponent', () => {
  let component: CompanySearchEngineComponent;
  let fixture: ComponentFixture<CompanySearchEngineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CompanySearchEngineComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CompanySearchEngineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
