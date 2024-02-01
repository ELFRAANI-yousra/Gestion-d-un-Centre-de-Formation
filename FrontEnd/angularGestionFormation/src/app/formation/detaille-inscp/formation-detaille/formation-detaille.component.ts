import { Component, OnInit } from '@angular/core';
import { FormationDetailServiceService } from '../../liste-formation/formation-detail.service.service';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-formation-detaille',
  templateUrl: './formation-detaille.component.html',
  styleUrls: ['./formation-detaille.component.css']
})

export class FormationDetailleComponent implements OnInit 
{

  constructor(private formationDetailServiceService: FormationDetailServiceService, private fb: FormBuilder) {}
  selectedFormation: any;
  myForm=this.fb.group({code: []  });

 onSubmit() 
 {
     const aa=this.myForm.get('code');
      console.log('Value submitted:',aa);
  }

  ngOnInit()
   {
    this.selectedFormation = this.formationDetailServiceService.getSelectedFormation();
    console.log(this.selectedFormation)
  }

}
