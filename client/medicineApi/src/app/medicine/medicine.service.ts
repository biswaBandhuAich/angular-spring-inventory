import {Http, RequestOptions, Headers } from '@angular/http'
import {Injectable } from '@angular/core';
import {Medicine } from './medicine';
import { Observable } from 'rxjs/observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class medicineService{

    constructor(private _httpService:Http){

    }
    getAllMedicines() : Observable<Medicine[]>{
        return this._httpService.get("http://localhost:8080/MedicineStore/api/medicine")
        .map((response : any) => response.json()).catch(this.handleError);
    }
    private handleError(error:Response){
        return Observable.throw(error);
        

    }

    addMedicine(Medicine : Medicine){
        let body=JSON.stringify(Medicine);
        let headers = new Headers({'Content-Type' : 'application/json'});
        let options= new RequestOptions({headers:headers})
        return this._httpService.post("http://localhost:8080/MedicineStore/api/addmedicine",body,options);
         }
    getMedicine(id:String) : Observable<Medicine>{
        return this._httpService.get("http://localhost:8080/MedicineStore/api/medicine/"+id)
        .map((response : any) => response.json()).catch(this.handleError);
    }
    updateMedicine(Medicine : Medicine,id:String){
        let body=JSON.stringify(Medicine);
        let headers = new Headers({'Content-Type' : 'application/json'});
        let options= new RequestOptions({headers:headers})
        return this._httpService.put("http://localhost:8080/MedicineStore/api/updatemedicine/"+id,body,options);
    }
    deleteMedicine(medId : String){
        return this._httpService.delete("http://localhost:8080/MedicineStore/api/deletemedicine/"+medId);
    }
      
}