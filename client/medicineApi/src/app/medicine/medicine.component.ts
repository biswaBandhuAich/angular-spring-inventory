import { Component, OnInit } from '@angular/core';
import { Medicine } from './medicine';
import { medicineService } from './medicine.service';



@Component({
  selector: 'app-medicine',
  templateUrl: './medicine.component.html',
  styleUrls: ['./medicine.component.css']
})
export class MedicineComponent implements OnInit {

   _medicine : Medicine[];
   addmedicine = new Medicine();
   editmedicine = new Medicine();
   btn_def= "Add";
   selectedId :String;

  constructor(private _medicineService : medicineService ) { }
   ngOnInit():void{
     this.getMedicine();
   }
   getMedicine() : void{
    this._medicineService.getAllMedicines().subscribe((medicineList)=> {this._medicine = medicineList,
    console.log(medicineList)},
    (error) => {console.log(error)});
}
addMedicine() : void{
  this._medicineService.addMedicine(this.addmedicine).subscribe((response)=>{console.log(response),
  this.getMedicine()},
  (error)=>{console.log(error)}
  );
  this.getMedicine();
  this.resetAll();
}
private resetAll(){
  this.addmedicine.brand=null;
  this.addmedicine.generic=null;
  this.addmedicine.id=null;
  this.addmedicine.quantity=null;
  this.addmedicine.scheduleh=null;
  this.addmedicine.totalprice=null;
  this.addmedicine.unitprice=null;
  this.btn_def="Add";
}
private editMedicine(id : String){
  this.btn_def="Save Changes";
  this.selectedId=id;
  this._medicineService.getMedicine(id).subscribe((medicine)=>{this.editmedicine=medicine,console.log(medicine),
    this.populate(this.editmedicine)},
  (error)=>{console.log(error)});
}
private populate(editmedicine:Medicine){
  console.log("In populate"+this.editmedicine.id);
  this.addmedicine.brand=editmedicine.brand;
  this.addmedicine.generic=editmedicine.generic;
  this.addmedicine.id=editmedicine.id;
  this.addmedicine.quantity=editmedicine.quantity;
  this.addmedicine.scheduleh=editmedicine.scheduleh;
  this.addmedicine.totalprice=editmedicine.totalprice;  
  this.addmedicine.unitprice=editmedicine.unitprice;
}
private generateFunction(value:String){
  console.log("In browser"+value);
  if(value=="Add"){
      this.addMedicine();
  }
  else if(value=="Save Changes"){
    this.saveEditedMedicine();
}

}
private saveEditedMedicine(){
  this._medicineService.updateMedicine(this.addmedicine,this.selectedId).subscribe((response)=>{console.log(response),
    this.getMedicine(),this.resetAll()},
  (error)=>{console.log(error)}
  );
}
delMedicine(medicineId : String){
  this._medicineService.deleteMedicine(medicineId).subscribe((response)=>{console.log(response),
    this.getMedicine(),this.getMedicine()},
  (error)=>{console.log(error)}
  );
}
}



