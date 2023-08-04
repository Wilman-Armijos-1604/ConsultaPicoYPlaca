import { Component, OnInit, ViewChild } from '@angular/core';
import { VehicleDateTime } from '../models/vehicledatetime.model';
import { NgForm } from '@angular/forms';
import { AbleCheckVehicleDateTimeService } from '../services/able-check-vehicle-date-time.service';
import { VehicleDateTimeDto } from '../dto-models/vehicledatetime.dtomodel';

declare var window: any;

@Component({
  selector: 'app-consulta-pico-placa',
  templateUrl: './consulta-pico-placa.component.html',
  styleUrls: ['./consulta-pico-placa.component.scss']
})

export class ConsultaPicoPlacaComponent implements OnInit{

  beenSubmitted = false;

  isAble = true;

  resultMessage = "SI TEST";

  vehicleDateTimeFromForm: VehicleDateTime = {
    licensePlate: "",
    date: "",
    time: ""
  };

  vehicleDateTimeDto: VehicleDateTimeDto = {
    licensePlate: "",
    dateTime: "2023-08-07T18:22Z"
  }

  @ViewChild('form', {read: NgForm}) form: any;
  formModal: any;

  constructor(
    private APIService: AbleCheckVehicleDateTimeService 
  ) {

  }
  
  ngOnInit() {
    this.formModal = new window.bootstrap.Modal(
      document.getElementById("returnMessage")
    );

  }

  openModal() {
    this.formModal.show();
  }

  closeModal() {
    this.formModal.hide();
  }

  AbleCheckVehicleDateTime() {
    if (this.form.valid) {
      
      let extractedDate = this.vehicleDateTimeFromForm.date;

      let extractedTime = this.vehicleDateTimeFromForm.time;

      this.vehicleDateTimeDto.licensePlate = this.vehicleDateTimeFromForm.licensePlate;
      this.vehicleDateTimeDto.dateTime = extractedDate + "T" + extractedTime + "Z";

      this.APIService.POSTableCheckVehicleTime(this.vehicleDateTimeDto)
      .subscribe(
        {
          next: (response) => {
            if ("isAble" in response) {
              this.resultMessage=response["isAble"];
            } 
            else if ("isNotAble" in response) {
              this.resultMessage=response["isNotAble"];
            }
            this.openModal();
          },
          error: (error) => {
            console.log(error);
          }
        }
      )

    } else {

      this.beenSubmitted = true;

    }

  }

}
