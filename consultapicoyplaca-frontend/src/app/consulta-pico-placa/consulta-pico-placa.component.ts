import { Component, OnInit, ViewChild } from '@angular/core';
import { VehicleDateTime } from '../models/vehicledatetime.model';
import { NgForm } from '@angular/forms';
import { AbleCheckVehicleDateTimeService } from '../services/able-check-vehicle-date-time.service';
import { VehicleDateTimeDto } from '../dto-models/vehicledatetime.dtomodel';
import { ActivatedRoute, Router } from '@angular/router';

declare var window: any;

@Component({
  selector: 'app-consulta-pico-placa',
  templateUrl: './consulta-pico-placa.component.html',
  styleUrls: ['./consulta-pico-placa.component.scss']
})

export class ConsultaPicoPlacaComponent implements OnInit{

  // Control for errors on submission
  beenSubmitted = false;

  // Control for validarions comming from Backend
  errorLicensePlate: string | null = null;
  errorDateTime: string | null = null;

  // Control of result
  isAble: boolean | null = null;

  // Result message for display
  resultMessage = "";

  // Model for binding HTML
  vehicleDateTimeFromForm: VehicleDateTime = {
    licensePlate: "",
    date: "",
    time: ""
  };

  // Model to be sent to on API call
  vehicleDateTimeDto: VehicleDateTimeDto = {
    licensePlate: "",
    dateTime: ""
  }

  // Retrieving Form from HTML as Component
  @ViewChild('form', {read: NgForm}) form: any;
  formModal: any;

  constructor(
    private APIService: AbleCheckVehicleDateTimeService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {

  }
  
  ngOnInit() {
    // Retrieving Modal HTML group for dynamic showing/hidding
    this.formModal = new window.bootstrap.Modal(
      document.getElementById("returnMessage")
    );

  }

  // Function to open modal
  openModal() {
    this.formModal.show();
  }

  // Function to dismiss modal
  closeModal() {
    this.formModal.hide();
  }

  // Submission form action: calling API and handling result
  AbleCheckVehicleDateTime() {
    if (this.form.valid) {
      
      let extractedDate = this.vehicleDateTimeFromForm.date;

      let extractedTime = this.vehicleDateTimeFromForm.time;

      // Generation of DTO Model from FORM DATA
      this.vehicleDateTimeDto.licensePlate = this.vehicleDateTimeFromForm.licensePlate;
      this.vehicleDateTimeDto.dateTime = extractedDate + "T" + extractedTime + "Z";

      // API call from Service
      this.APIService.POSTableCheckVehicleTime(this.vehicleDateTimeDto)
      .subscribe(
        {
          next: (response) => {
            // Handling if result is Vehicle IS Able to Run
            if ("isAble" in response) {
              this.resultMessage=response["isAble"];

              this.errorDateTime = null;
              this.errorLicensePlate = null;
              
              this.isAble = true;
              
              this.openModal();
            } 
            // Handling if result is Vehicle NOT Able to RUN
            else if ("isNotAble" in response) {
              this.resultMessage=response["isNotAble"];

              this.errorDateTime = null;
              this.errorLicensePlate = null;
              
              this.isAble = false;

              this.openModal();
            } 
            // Handling License Plate validation from API call
            else if ("LicensePlate" in response) {
              this.errorLicensePlate=response["LicensePlate"];
            } 
            // Handling Date and Time validation from API call
            else if ("DateTime" in response) {
              this.errorDateTime=response["DateTime"];
            }
          },
          error: (error) => {
            this.router.navigate(["/error"], {relativeTo: this.activatedRoute});
          }
        }
      )

    } else {
      // Control over FORMS error
      this.beenSubmitted = true;

    }

  }

}
