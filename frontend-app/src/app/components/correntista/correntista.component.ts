import { Component, OnInit } from '@angular/core';
import { CorrentistaService } from 'src/app/services/correntista.service';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-correntista',
  templateUrl: './correntista.component.html',
  styleUrls: ['./correntista.component.css']
})

export class CorrentistaComponent implements OnInit {
  correntistas:any;
  id!: string;
  cpf:any;
  nome:any;
  constructor(
    private correntistaService: CorrentistaService,
    private route: ActivatedRoute,
    private router: Router
    ) { }

  ngOnInit(): void {
    this.exibirCorrentistas();
  }

  exibirCorrentistas(): void {
    this.correntistaService.list()
      .subscribe(
        data => {
          this.correntistas = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  save(): void {
    const correntista = {
      cpf:this.cpf,
      nome:this.nome
    };
    console.log(correntista);
    this.correntistaService.create(correntista)
      .subscribe(
        response => {
          console.log(response);
          this.exibirCorrentistas();
        },
        error => {
          console.log(error);
        });
  }

  editarCorrentista():void{
    const correntista = {
      cpf:this.cpf,
      nome:this.nome
    };

    this.correntistaService.update(correntista, '').subscribe(
      data => {
        console.log(data);
      },
      error =>{
        console.log(error);
      }
    )
  }

  delete():void {
    this.correntistaService.delete(this.correntistas.id)
    .subscribe(response => {
      console.log(response);
      this.router.navigate(['/correntistas/']);
    })
  }

  onSubmit() {
    if(this.id){
      this.correntistaService.update(this.correntistas, this.id);
    }else{
      this.correntistaService.create(this.correntistas)
    }
  }



}
