import { ClienteDTO } from "./clienteDTO";

export class ResultDTO {
  msgRespuesta : string;
  lcliente : ClienteDTO[];

  constructor(
    msgRespuesta?:string,
    lcliente?:ClienteDTO[]
  ){

    this.msgRespuesta = msgRespuesta;
    this.lcliente = lcliente;
  }
} 