import { Component, OnInit } from '@angular/core';
import { SearchEngine } from 'src/app/model/company.model';
import { CommonService } from 'src/app/shared/common.service';

@Component({
  selector: 'app-company-search-engine',
  templateUrl: './company-search-engine.component.html',
  styleUrls: ['./company-search-engine.component.css']
})
export class CompanySearchEngineComponent implements OnInit {
  data:any;
  filter:SearchEngine= new SearchEngine();
  stats: any = null;
  showStats:boolean=false;
  constructor(private commonService: CommonService) { }

  ngOnInit(): void {
  }

  searchData(){
    if(this.filter.companyCode != null){

      if(this.filter.companyCode !=null && this.filter.fromDate == null && this.filter.toDate ==null){
        this.commonService.findCompanyStock(this.filter.companyCode).subscribe(x=> this.data=x);
      }else if(this.filter.companyCode !=null && this.filter.fromDate != null && this.filter.toDate !=null){
        this.viewStockDetail(this.filter);
        this.commonService.filterCompanyStock(this.filter).subscribe(x=> this.data=x);
      }else{
        alert("Invalid date selected")
      }
    }else{
      alert("Company code is required")
      return;
    }
  }


  viewStockDetail(data: any) {
    this.commonService.getStockStats(data).subscribe((x) => {
      this.stats = x;
      this.showStats = true;
    });
  }

  resetFilter(){
    this.data =null;
    this.stats= null;
    this.showStats = false;
    this.filter =new SearchEngine();
  }
}
