package controlador;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;

public class Controlar{

   public static void main(String[] args) {
	//Get a hold on JADE runtime
        //DY jade.core.Runtime rt = jade.core.Runtime.instance();
        Runtime rt = Runtime.instance();
        // Create a default profile
        Profile p = new ProfileImpl();
        AgentContainer mainCont = rt.createMainContainer(p);
        try{
            AgentController controlA = mainCont.createNewAgent("Emily Mendez", "jade.tools.rma.rma", null);
            controlA.start();
            String[] agColdBrocker = {"1","2","3","4"};
            Object[][] obj = {
                {"asdf","qwer","ñlkj"},
                {"zxcv","tyui","hjk"},
                {"mnvb","bvxc","dfgh"},
                {"tyui","uygcv","bgre"}
            };
            for(int i=0; i<agColdBrocker.length; i++){
                System.out.println(agColdBrocker[i].toString());
                controlA = mainCont.createNewAgent("Juan Rodriguez", "agentesdy.AgentesDy", obj[i]);
                controlA.start();
            }
            controlA = mainCont.createNewAgent("Jose Juarez", "agentesdy.AgentesDy", null);
        }catch(StaleProxyException e){
            e.printStackTrace();
        }
   }
        
    private static void instance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}