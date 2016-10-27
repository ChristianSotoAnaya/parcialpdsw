/*
 * Copyright (C) 2016 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.samples.managedbeans;
import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.services.ServiceFacadeException;
import edu.eci.pdsw.samples.services.ServicesFacade;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author hcadavid
 */
@ManagedBean(name="beanReporteRankingPacientesBean")
@SessionScoped
public class ReporteRankingPacientesBean {
    
    static ServicesFacade sf=ServicesFacade.getInstance("applicationconfig.properties");
    
    private int cantidad=0;
    private int periodo=0;
    private List<Paciente> listado =new LinkedList();

    public List<Paciente> getListado() {
        return listado;
    }

    public void setListado(List<Paciente> listado) {
        this.listado = listado;
    }
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }
    
    public void mostrar() throws ServiceFacadeException{
        listado =new LinkedList();
        List<Paciente> temp= sf.topNPacientesPorAnyo(cantidad, periodo);
        if (temp.size()<cantidad){
            listado = temp;
        }
        else{
            int i = 0;
            while (i<cantidad){
                listado.add(temp.get(i));
                i++;
            }
        }


    }
}
