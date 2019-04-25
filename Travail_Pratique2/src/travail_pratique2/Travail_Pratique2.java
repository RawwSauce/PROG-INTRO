/*
 * Fait par : René Gagnon
 * noDA=1566826
 * Travail remis à Guylaine péloquin
 * Cégep de Sorel-Tracy
 * 7 décembre 2016
 */
package travail_pratique2;
import java.util.*;
/**
 * @author Rene Gagnon
 */
public class Travail_Pratique2 {
    public static void main(String[] args) {
        String reponse;
        do{
            double montantPlacement = 0;
            double tauxAnnuel =0 ;
            double montantPlacementFinal = 0;
            double tauxAjuste;//Taux du placement ajusté selon le type d'intérêt.
            int periode = 0;
            int choix = 0;//Choix tu type d'intérêt.
            int nbrCalcul = 0; // Nombre de fois qu'on repête la boucle pour calculer le montant du placement final.
            int i;
            
            String typeInterets;

            Scanner input = new Scanner(System.in);

            System.out.println("Calculateur de placements");
            System.out.println("----------------------------------------");       
            //Validaton du montant du placement
            do{
               System.out.println("Montant du placement(100-100000$) :"); 
               montantPlacement = input.nextDouble();
               if(montantPlacement<100 || montantPlacement>100000){
                   System.out.println("Montant du placement invalide.");
               }
            }while(montantPlacement<100 || montantPlacement>100000);
            //Validation du taux d'intérêt annuel.
            do{
                System.out.println("Taux d'intérêt annuel (2,00-22,00%) :");
                tauxAnnuel = input.nextDouble();
                if(tauxAnnuel <2.00 || tauxAnnuel>22.00){
                    System.out.println("Taux d'intérêt annuel invalide.");
                }
            }while(tauxAnnuel <2.00 || tauxAnnuel>22.00);
            //Validation de la période.
            do{
                System.out.println("Période (1-10 ans):");
                periode = input.nextInt();
                if(periode < 1 || periode > 10){
                    System.out.println("Période invalide.");
                }
            }while(periode < 1 || periode > 10);
            //Validation du type d'intérêt.
            do{
                System.out.printf("Type de calcul des intérêts : %n1.Intérêt composé annuellement%n2.Intérêt composé mensuellement %n");
                System.out.println("Votre choix :");
                choix = input.nextInt();
                if(choix!=1 && choix!=2){
                    System.out.println("Choix invalide.");
                }
            }while(choix!=1 && choix!=2);

            montantPlacementFinal = montantPlacement;

            if(choix ==1){
                nbrCalcul = periode;
                typeInterets = "annuel";
                tauxAjuste = tauxAnnuel/100 ;
            }else{
                nbrCalcul = periode*12;
                typeInterets = "mensuel";
                tauxAjuste = (tauxAnnuel/100)/12 ; 
            }
            
            for(i=1;i<=nbrCalcul;i++){
                montantPlacementFinal += montantPlacementFinal*tauxAjuste ; 
            }
            
            System.out.printf("%nPlacement à taux d'intérêt %s %n", typeInterets);
            System.out.println("----------------------------------------");
            System.out.printf("Placement :%23.2f $",montantPlacement);
            System.out.printf("%nTaux d'intérêt :%6.1f %%",tauxAnnuel);
            System.out.printf("%nPériode :%11d ans",periode);
            System.out.printf("%nMontant obtenu :%18.2f $ %n",montantPlacementFinal);
            
            do{
                System.out.println("Faire un autre calcul (O/N)?");
                reponse = input.next();
                if(!reponse.equalsIgnoreCase("O") && !reponse.equalsIgnoreCase("N")){
                   System.out.println("La réponse est invalide");
                }
            }while(!reponse.equalsIgnoreCase("O") && !reponse.equalsIgnoreCase("N"));
        }while(reponse.equalsIgnoreCase("O"));    
    }
    
}
