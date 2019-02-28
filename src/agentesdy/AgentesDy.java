package agentesdy;
/*@author Dulby*/

import jade.core.AID;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.core.Agent;
import jade.domain.FIPAException;

public class AgentesDy extends Agent {
    
//se inicia el agente
    public void setup() {
        try{
            Object[] parametros = getArguments();
            Agent agt = new Agent();
            System.out.println("El Agente ha Iniciado");
            System.out.println("Agente: "+getLocalName());
            System.out.println("Parm1 "+(String)parametros[0].toString()+"Parm2 "+(String)parametros[1].toString()+"Parm3 "+(String)parametros[2].toString());
            System.out.println("Parámetros: "+(String)parametros[1]);
            //String AgentName= getLocalName();
            AID identif = new AID (getLocalName(), AID.ISLOCALNAME);
            System.out.println("ID: "+identif);
            System.out.println("Estado del Agente: "+agt.getAgentState());
            System.out.println("\n");
            DFAgentDescription df = new DFAgentDescription();
            df.setName(identif);
            ServiceDescription sd = new ServiceDescription();
            /* se necesita dos argumentos, el primero será el tipo de servicio
            y el segundo el nombre del servicio, (paquetes turisticos y costo de los paquetes */
            if (parametros != null){
                String tipo = (String)parametros[0]; //Dy: Tengo que ver, cuantos argumentos necesita mi modelo
                String nombre = (String)parametros[1];
                sd.setType(tipo);
                sd.setName(nombre);
                df.addServices(sd);
                try{
                    DFService.register(this, df);
                }catch(Exception fe){
                    fe.printStackTrace();//chequear esto, quiero asignar a msg
                    //System.out.println(e.getMessage());
                }
            }else{
            System.out.println("Error: Se necesitan dos argunmentos. Se finaliza la ejecucion");
            doDelete();// Metodo para destruir el agente
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

//Termina la ejecucion del agente
//Metodo que libera los recursos del agente
    protected void takeDown(){
        System.out.println("Listado realizado Correctamente. El Agente Agencia de Turismo. "+getAID().getLocalName()+" Termina.");
        try{
            DFService.deregister(this, this.getAID());//DESREGISTRA EL AGENTE
        }catch (FIPAException fe){
            System.out.println(fe.getMessage());
            //fe.printStackTrace();
        }
    }
    
}

///////////*
/*
public void setup() {
       System.out.println("Agente Regulador " + getAID().getName() + " esta listo.");

       miGui = new AgenteReguladorGuiImpl();
       miGui.setAgent(this);
       miGui.show();

       DFAgentDescription dfd = new DFAgentDescription();
       dfd.setName(getAID());
       ServiceDescription sd = new ServiceDescription();
       sd.setType("Calentar-Contenedor");
       sd.setName(getLocalName() + "-Calentar-Contenedor");
       dfd.addServices(sd);
       try {
           DFService.register(this, dfd);
       } catch (FIPAException fe) {
           fe.printStackTrace();
       }

   }*/