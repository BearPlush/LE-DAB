package com.dwwm.main;

import java.util.*;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		/**
		 ################################################################
		 #						    D A T A                             #
		 ################################################################							
		 */
		int user_code = 0000; // Rentré du code de l'utilisateur
		int code_verif = 3345; // Chiffre dans la base de donnée code verif
		int atm_fund = 10000; // Argent restant dispo dans l'ATM
		int user_fund = 10; // Argent disponnible sur le compte de l'utilisateur
		int atm_ticket = 500; // Nombre de ticket restant dans l'ATM
		int check = 0; // Variable qui va servir de donnée temporaire pour le montant
		int out_u = 0; // nous permettra de stocker si il y a un code erreur
		short cpt = 3; // Compteur de tentative (max 3)
		/**
		 ################################################################
		 #					     P R O G R A M                          #
		 ################################################################							
		 */
		Scanner sc = new Scanner(System.in);				//On dit que l'on voudra que l'utilisateur écris qque chose

		while (cpt > 0) {						//Tant que notre compteur est supérireur a 0
			Sortie.avec_code(Sortie.ok.DEMANDE);				//Appel de la fonction Sortie.avec_code de ma OK.DEMANDE
			try {									//on essaie de faire
				user_code = Integer.parseInt(sc.nextLine());				//Transformé la saisie utilisateur en int que l'on met dans user_code
				if (user_code == code_verif)						//SI le code rentré est le bon 
					break;									//alors on stop ce block de program
			} catch (Exception e) {							//on essaie de voir si il y a une erreur
			} finally {								//Finalement quoi qui ce passe (si le program ne c pas fais arretter)
				cpt -= 1;								//On rajoute +1 a compteur de tentative
			}
			Sortie.avec_code(Sortie.ko.CODE);
			
		}
		if (cpt > 0) {							//Si le compteur est supérieur a 0																							
			try {								//on essaie de faire
				Withdraw.withdraw(						//apelle de la fonction Withdraw
					user_code,
					code_verif,
					atm_fund,
					user_fund,
					atm_ticket,
					check,
					out_u);	
			} catch (InterruptedException e) {				//si il y a une erreur on récupère l'erreur
				// TODO Auto-generated catch block
				e.printStackTrace();						//On affiche l'erreur
			}
		}
	}//Fin static void
}//Fin public class
