/*
 * Fait par : René Gagnon, noDA=1566826
 */
package travail_pratique_1;
import java.util.Scanner;
/**
 *
 * @author Rene Gagnon
 */
public class Travail_pratique_1 {

   
    public static void main(String[] args) {
        
        final double tarifBase = 100.00;
        int ageClient;
        int jourActivite;
        double montantEscompte;
        double montantTaxe;
        double prixFinal;
        double reduction;//réduction tenant compte de l'âge et du jour de l'activité
        final double reduction1 = 0.3; //réduction pour une personne agé de 16 ans et moins ou de 65 ans et plus qui pratique l'activité un lundi, un mardi ou un mercredi.
        final double reduction2 = 0.1;//réduction pour une personne agé de 16 ans et moins ou de 65 ans et plus qui pratique l'activité un autre jour.
        final double reduction3 = 0.2;//réduction pour une personne agé entre 17 et 64 ans qui pratique l'activité un lundi, un mardi, un mercredi ou un jeudi.
        final double taxe = 0.155;
        
        Scanner input = new Scanner (System.in);
        
        System.out.println("Entrez votre âge:");
        ageClient = input.nextInt();
        System.out.println("Entrez le jour de l'activité (entre 1 et 7):");
        jourActivite = input.nextInt();
        
        if(ageClient<=16 || ageClient>=65){
            
            if(jourActivite >=2 && jourActivite<=4){
                reduction=reduction1;
            }
            else{
                reduction=reduction2;
            }    
        }
        else{
            
            if(jourActivite >=2 && jourActivite <=5){
                reduction=reduction3;
            }
            else{
                reduction=0;
            }
        }
        
        montantEscompte = tarifBase*reduction;
        montantTaxe = (tarifBase-montantEscompte)*taxe;
        prixFinal = tarifBase-montantEscompte+montantTaxe;
        
        System.out.println("Le client a "+ageClient+" ans et s'inscrit pour une activité du jour "+jourActivite+".");
        System.out.printf("%nPrix du billet:%10.2f %nEscompte accordée:%7.2f %nTaxes(15,5%%):%12.2f %nPrix à payer:%12.2f $%n" , tarifBase , montantEscompte , montantTaxe , prixFinal );
        
    }
    
}
