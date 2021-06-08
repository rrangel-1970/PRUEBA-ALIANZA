import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { ClienteDTO } from '../model/clienteDTO';
import { Observable } from 'rxjs';
import { ResultDTO } from '../model/resultDTO';


@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  endpoint = `${environment.apiService.protocolo}${environment.apiService.direccionServidor}:${environment.apiService.puerto}/${environment.apiService.aplicación}/${environment.apiService.rutaServicio}`;
  private headers: HttpHeaders;

  constructor(private http: HttpClient) {
    this.headers = new HttpHeaders();
    this.headers.set('Accept', 'application/json');
    this.headers.set('Content-Type', 'application/json');

   }

  obtenerTodos(): Observable<ClienteDTO[]> {
   
    
    return this.http.get<ClienteDTO[]>(this.endpoint)
  }

  obtenerCliente(id:string): Observable<ClienteDTO[]> {
    return this.http.get<ClienteDTO[]>(`${this.endpoint}/${id}`);
  }

  adicionarCliente(cliente:ClienteDTO): Observable<ResultDTO> {
    const httpOptions = {
      headers: new HttpHeaders({ 
        'contentType': 'application/json',
        'charset':'utf-8'
      })
    };

    return this.http.post<ResultDTO>(`${this.endpoint}`,cliente,httpOptions);
  }

}
