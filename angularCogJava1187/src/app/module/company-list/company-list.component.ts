import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { CommonService } from 'src/app/shared/common.service';

@Component({
  selector: 'app-company-list',
  templateUrl: './company-list.component.html',
  styleUrls: ['./company-list.component.css'],
})
export class CompanyListComponent implements OnInit {
  companyList: any[] = [];
  showList: boolean = true;
  showStats: boolean = false;
  updateStock: boolean = false;
  companyCode:number;
  price:number;
  constructor(private commonService: CommonService, private router: Router) {}

  ngOnInit(): void {
    this.getAllCompany();
  }

  getAllCompany() {
    this.commonService.getAllCompany().subscribe((x) => {
      this.companyList = [];
      this.companyList = x;
      console.log(x);
    });
  }

  viewCompany(id: any) {
    this.router.navigate(['company-view', id]);
  }
  editStock(id: any) {
    this.companyCode = id;
    this.showList = false;
    this.updateStock =true;
  }

  deleteCompany(id: any) {
    this.commonService.deleteCompany(id).subscribe((x) => {
      alert("Record deleted!")
      this.getAllCompany();
    });
  }
  updateStockData(){
    if(this.price != 0){
      let data = {
        "companyCode":this.companyCode,
        "price": this.price
      }
      this.commonService.updateStock(data).subscribe(x=>{
        this.getAllCompany();
        this.goBack();
      })
    }
  }

  goBack() {
    this.showList = true;
    this.showStats = false;
    this.updateStock = false;
  }
}
