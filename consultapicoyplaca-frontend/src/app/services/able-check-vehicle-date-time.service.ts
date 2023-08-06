import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { VehicleDateTimeDto } from '../dto-models/vehicledatetime.dtomodel';

@Injectable({
  providedIn: 'root'
})
export class AbleCheckVehicleDateTimeService {

  // API URL for consuming SpringBoot Backend
  private API_URL: string = "http://localhost:9000/VehicleDateTimeCheck";

  constructor(private http: HttpClient) {

  }

  // POST calling
  POSTableCheckVehicleTime(vehicleDateTimeDto: VehicleDateTimeDto): Observable<any> {
    return this.http.post(this.API_URL, vehicleDateTimeDto);
  }

}
