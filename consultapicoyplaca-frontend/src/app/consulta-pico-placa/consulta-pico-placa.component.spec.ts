import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultaPicoPlacaComponent } from './consulta-pico-placa.component';

describe('ConsultaPicoPlacaComponent', () => {
  let component: ConsultaPicoPlacaComponent;
  let fixture: ComponentFixture<ConsultaPicoPlacaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ConsultaPicoPlacaComponent]
    });
    fixture = TestBed.createComponent(ConsultaPicoPlacaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
