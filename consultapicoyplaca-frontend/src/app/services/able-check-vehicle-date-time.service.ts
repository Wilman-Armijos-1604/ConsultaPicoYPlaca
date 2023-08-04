import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { VehicleDateTimeDto } from '../dto-models/vehicledatetime.dtomodel';

@Injectable({
  providedIn: 'root'
})
export class AbleCheckVehicleDateTimeService {

  private API_URL:string = "http://localhost:8080/VehicleDateTimeCheck";

  constructor(private http: HttpClient) {

  }

  POSTableCheckVehicleTime(vehicleDateTimeDto: VehicleDateTimeDto): Observable<any> {
    return this.http.post(this.API_URL, vehicleDateTimeDto);
  }

}
