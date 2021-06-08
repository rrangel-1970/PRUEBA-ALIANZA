import { Component, OnInit } from '@angular/core';
import { ClienteDTO } from 'src/app/model/clienteDTO';
import { ResultDTO } from 'src/app/model/resultDTO';
import { ClienteService } from 'src/app/services/cliente.service';
import { ExportToCSV } from "@molteni/export-csv"; 

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})
export class ClienteComponent implements OnInit {

  clientes : ClienteDTO[];
  cliente : ClienteDTO;
  swMostrarExito : boolean;
  strBusqueda : string;

  result : ResultDTO;

  constructor(
    private clienteService:ClienteService,
  ) { 
     this.cliente=new ClienteDTO();
  }

  ngOnInit(): void {
    this.listarTodos();
 
  }

  listarTodos(){
    this.clienteService.obtenerTodos().subscribe((data) => {
      this.clientes = data;
   })
  } 

  adicionar(){
     
    if(this.validarInfo()){

      this.clienteService.adicionarCliente(this.cliente).subscribe((data) => {
        this.result = data;
        this.clientes = this.result.lcliente;
  
        if(this.result.msgRespuesta == 'Cliente Guardado'){
          this.swMostrarExito = true;
        }else{
          this.swMostrarExito = false;
        }
      })
    }
  } 

  buscarCliente(){

    this.clienteService.obtenerCliente(this.strBusqueda).subscribe((data) => {
      this.result = new ResultDTO;
      if (data[0] != null){
        this.swMostrarExito = null;
        this.clientes = data;
      }else{
        this.result.msgRespuesta = "Cliente no encontrado";
        this.swMostrarExito = false;
        this.listarTodos();
      }
    }); 
  }

  exportToCsv(){
    var exporter = new ExportToCSV(); 
    exporter.exportAllToCSV(this.clientes, "clientes.csv"); 
  }

  validarCamposAlpha(event) {
    if (event.charCode >= 65 && event.charCode <= 90) {
      return true;
    }
    if (event.charCode >= 97 && event.charCode <= 122) {
      return true;
    }
    if (event.charCode == 32) {
      return true;
    }
    return false;
  }

  validarCamposNumber(event) {
    if (event.charCode >= 48 && event.charCode <= 57) {
      return true;
    }
    if (event.charCode == 32) {
      return true;
    }
    return false;
  }

  validarCamposEmail(event) {
    if (event.charCode >= 65 && event.charCode <= 90) {
      return true;
    }
    if (event.charCode >= 97 && event.charCode <= 122) {
      return true;
    }

    if (event.charCode >= 48 && event.charCode <= 57) {
      return true;
    }
    if (event.charCode == 45 || event.charCode == 64 || event.charCode == 95 || event.charCode == 46 ) {
      return true;
    }
    return false;
  }

  validarInfo(){
    this.result = new ResultDTO;
    if(this.cliente.name == undefined || this.cliente.phone == undefined || this.cliente.email ==undefined
      || this.cliente.starDate == undefined || this.cliente.endDate == undefined){
       this.result.msgRespuesta = "Existen campos vacios";
       this.swMostrarExito = false;
       return false;
    }else if(this.cliente.endDate < this.cliente.starDate){
        this.result = new ResultDTO;
        this.swMostrarExito = false;
        this.result.msgRespuesta = "EndDate no puede ser inferior a startDate";
        return false;
    }

    return true;
  }

}
