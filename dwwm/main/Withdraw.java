package com.dwwm.main;

import java.util.Scanner;

public class Withdraw {
	
	@SuppressWarnings("resource")
	public static void withdraw(
			int user_code,
			int code_verif,
			int atm_fund,
			int user_fund,
			int atm_ticket,
			int check,
			int out_u) throws InterruptedException {
		//Verification bon code
		Sortie.avec_code(Sortie.ok.CODE);													//Appel de la fonction Sortie.avec_code de ma OK.DEMANDE
		Sortie.avec_code(Sortie.ok.VOULUE);													//Appel de la fonction Sortie.avec_code de ma OK.VOULUE
		Scanner sc = new Scanner(System.in);													//On dit que l'on voudra que l'utilisateur écris qque chose
		check = Integer.parseInt(sc.nextLine());												//Transformé la saisie utilisateur en int que l'on met dans check  (cmb il souhaite retirer)
		//choix du montant voulue
		if (check % 10 != 0 || check < 10 || check > 300) {											//SI mon numéro est entier ou est en dessous de 10 ou au dessus de 300
			Sortie.avec_code(Sortie.ko.MONTANT);													//Appel de la fonction Sortie.avec_code de ma KO.MONTANT 
			return;																	//Arrette le block de program (la ca stop tout)
		} 
		//erreur si atm plus assez de sous
		if (atm_fund < check) {															//SI les fonds de l'atm sont inféreieur au retrait voulue
			Sortie.avec_code(Sortie.ko.FONDS);													//Appel de la fonction Sortie.avec_code de ma KO.FONDS
			return;																	//Arrette le block de program (la ca stop tout)
		}
		//erreur si compte bancaire a moins de sous que le retrait voulue
		if (user_fund < check) {														//SI les fonds de l'atm sont inféreieur au retrait voulue
			Sortie.avec_code(Sortie.ko.PAUVRE);													//Appel de la fonction Sortie.avec_code de ma KO.PAUVRE
			return;																	//Arrette le block de program (la ca stop tout)
		}
		//sortie des sous
		Sortie.avec_code(Sortie.ok.TRANSACTION);												//Appel de la fonction Sortie.avec_code de ma OK.TRANSACTION
		user_fund = user_fund - check;															//On retire du compte bancaire les sous que l'utilisateur viens de retiré.
		Sortie.avec_code(Sortie.ok.RESTE);														//Appel de la fonction Sortie.avec_code de ma OK.RESTE
		System.out.println(user_fund);															//Afficher la variable user_fund
		Sortie.avec_code(Sortie.ok.MERCI);														//Appel de la fonction Sortie.avec_code de ma OK.MERCI
		//Manque de ticket ?
		if (atm_ticket < 1) {																//SI le nombre de tocket de l'ATM est inférieur a 1
			Sortie.avec_code(Sortie.ko.TICKET);														//Appel de la fonction Sortie.avec_code de ma KO.TICKET
		} else {																	//SINON
			Sortie.avec_code(Sortie.ok.RETRAIT);														//Appel de la fonction Sortie.avec_code de ma OK.RETRAIT
		}
	}//fin function withdraw
}//fin public class Withdraw
