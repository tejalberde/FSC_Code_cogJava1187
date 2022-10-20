import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonService } from 'src/app/shared/common.service';

@Component({
  selector: 'app-company-view',
  templateUrl: './company-view.component.html',
  styleUrls: ['./company-view.component.css']
})
export class CompanyViewComponent implements OnInit {
  data:any;
  id:any;
  constructor(private route: ActivatedRoute,private commonService:CommonService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.commonService.getCompanyData(this.id).subscribe(x=>{
      this.data=x;
    })
  }

}
